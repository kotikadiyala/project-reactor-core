package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/*
Whenever exception happens, if a fall back publisher needs to be returned then
onErrorResume operator is used
 */
public class FluxOnErrorResumeOperator {



    public static Flux<String> onErrorResume(){

        Flux<String> companies =  Flux.fromIterable(Arrays.asList("Tcs","Wipro" ,"Infosys"));


        return companies
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorResume(e -> e instanceof RuntimeException, e -> Mono.just("Fallback Company")).log();
    }

    public static Flux<String> onErrorResumeUsingExceptionClass(){

        Flux<String> companies =  Flux.fromIterable(Arrays.asList("Tcs","Wipro" ,"Infosys"));


        return companies
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorResume( RuntimeException.class, e -> Mono.just("IBM")).log();
    }
}
