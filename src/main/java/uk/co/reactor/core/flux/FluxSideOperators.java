package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

/*
ALl the operator that start with do are generally referred as Side operators, meaning they cann't change the output,
but they are used to perform some side / extra operatoions like logging
 */
public class FluxSideOperators {

    public static Flux<String> doOnNext(){
       return FluxCreation.getCompanies().doOnNext(System.out::println);
    }

    public static Flux<String> doOnComplete(){
        return FluxCreation.getCompanies().doOnComplete(() -> System.out.println("doOnComplete  is getting executed"));
    }

    public static Flux<String> doOnError(){
        return FluxCreation.getCompanies().map(company -> {
            if (company.equalsIgnoreCase("Infosys")){
                throw new RuntimeException("Invalid Company");
            }
            return company;
        }).doOnError(RuntimeException.class, (e) -> System.out.println("doOnError  is getting executed "+e.getMessage()));
    }
}
