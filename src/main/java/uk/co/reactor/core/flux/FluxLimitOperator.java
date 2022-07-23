package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

public class FluxLimitOperator {

    public static Flux<Integer> limit(){
        Flux<Integer> limit = Flux.range(1, 25);

        // Here limit is 10, that means for each request maximum 10 elements are received
        limit.limitRate(10);
        limit.subscribe(
                value -> System.out.println(value),
                err -> err.printStackTrace(),
                () -> System.out.println("Finished!!"),
                subscription -> subscription.request(15)
        );

        return limit;
    }
}
