package uk.co.reactor.core.flux;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class FluxCancelOperator {

    public static Flux<Integer> cancel(){
        Flux<Integer> cancel = Flux.range(1, 10).log();

        cancel.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                request(3);
                System.out.println(value);

                // if cancel() operator is invoked, stream is closed and no further data is received.
                cancel();
            }
        });

        return cancel;
    }

}
