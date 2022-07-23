package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
/*
onErrorReturn is used to provide a fall back value when exception happens
 */
public class FluxOnErrorReturnOperator {

    public static Flux<String> onErrorReturn(){

        return Flux.fromIterable(Arrays.asList("Tcs", "Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorReturn("Fallback Company");
    }

    public static Flux<String> withOutErrorReturn(){

        return FluxCreation.getCompanies()
                .map(company -> {
                    if (company.equalsIgnoreCase("Tcs"))
                        throw new RuntimeException("Invalid Company");
                    return company;
                });
    }
}
