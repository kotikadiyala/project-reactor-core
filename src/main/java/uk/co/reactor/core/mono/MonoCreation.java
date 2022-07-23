package uk.co.reactor.core.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
Mono and Flux are non blocking streams.
Mono stream emits 0 to 1 elements , where as
Flux emits 0 to N elements
 */
public class MonoCreation {


    public static Mono<String> getCompany(){
        return Mono.just("Infosys").log();
    }

    public static Mono<String> getCompanyUsingFrom(){
        return Mono.from(Mono.just("Infosys")).log();
    }

    public static Mono<String> getMonoUsingFlux(){
        return Mono.from(Flux.fromIterable(Arrays.asList("Tcs", "Infosys")).next()).log();
    }

    public static Mono<String> getUpperCaseCompany(){
        return Mono.just("Infosys").map(String::toUpperCase).log();
    }

}
