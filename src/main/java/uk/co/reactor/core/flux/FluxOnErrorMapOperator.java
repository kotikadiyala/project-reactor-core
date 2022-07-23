package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;
import uk.co.reactor.core.exception.InvalidInputException;

import java.util.Arrays;

public class FluxOnErrorMapOperator {

    /*
    onErrorMap()  is used to map 1 exception to another exception
    For example in this method, RuntimeException  is mapped to InvalidInputException
     */
    public static Flux<String> onErrorMap(){

        return Flux.fromIterable(Arrays.asList("Tcs", "Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorMap(RuntimeException.class, e -> new InvalidInputException(e)).log();
    }

    public static Flux<String> onErrorMapUsingPredicateType(){

        return Flux.fromIterable(Arrays.asList("Tcs","Wipro" ,"Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorMap(e -> e instanceof RuntimeException, e -> new InvalidInputException(e)).log();
    }
}
