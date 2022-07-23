package uk.co.reactor.core.mono;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoCancelOperator {

    public static Mono<Integer> cancel(){
        Mono<Integer> cancel = Mono.just(1).log();

        cancel.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                request(3);
                System.out.println(value);
                cancel();
            }
        });

        return cancel;
    }
}
