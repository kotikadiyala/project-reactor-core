package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

import java.util.Arrays;

/*
Mono and Flux are non blocking streams.
Mono stream emits 0 to 1 elements , where as
Flux emits 0 to N elements
 */
public class FluxCreation {

    /*
    Flux.fromIterable  is 1 of the ways to create a flux
     */
    public static Flux<String> getCompanies(){

        //  Flux.fromIterable  is 1 of the ways to create a flux
        // .log() method is very handy and it prints all the internal sequence of events of non blocking stream
        return Flux.fromIterable(Arrays.asList("Infosys", "Tcs")).log();
    }

    public static Flux<String> getCompaniesUsingJust(){

        // Flux.just is another way of creating non blocking flux Stream
        return Flux.just("Infosys", "Tcs").log();
    }

    public static Flux<String> getFounders(){
       return Flux.fromIterable(Arrays.asList("Narayana Murthy", "Rathan Tata")).log();
    }

}
