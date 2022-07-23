package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxDelay {

    /*
    If some delay needs to be observed between each set of events, delayElements  is used
     */
    public static Flux<String> delay(){

        return FluxCreation.getCompanies().delayElements(Duration.ofSeconds(5)).log();

    }
}
