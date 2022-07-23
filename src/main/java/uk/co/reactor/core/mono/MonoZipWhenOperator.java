package uk.co.reactor.core.mono;

import reactor.core.publisher.Mono;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MonoZipWhenOperator {

    public static Mono<String> getCompaniesUsingZipWhen(){

        Function<String, Mono<? extends String>> function = t -> {
            if (t.equalsIgnoreCase("Infosys")){
                return Mono.just("Tcs");
            }
            return Mono.just(t);
        };

        BiFunction<String, String, String> biFunction = (t1, t2) -> t1+t2;
        return Mono.just("Infosys").zipWhen(function , biFunction).log();
    }
}
