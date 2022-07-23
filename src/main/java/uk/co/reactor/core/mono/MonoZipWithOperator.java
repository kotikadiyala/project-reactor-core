package uk.co.reactor.core.mono;

import reactor.core.publisher.Mono;

public class MonoZipWithOperator {

    public static Mono<String> getCompaniesUsingZipWith(){
        return Mono.just("Infosys").zipWith(Mono.just("Tcs"), (t1, t2)-> t1+t2).log();
    }
}
