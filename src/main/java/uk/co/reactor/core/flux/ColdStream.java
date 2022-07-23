package uk.co.reactor.core.flux;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class ColdStream {

    /*
    In ColdStream fixed set of static values are always emitted for each subscriber same way.
    So that means if n subcribers are there for cold stream, all of those get same values each time when they subscibe

    In cold streams data emission would start only after subscribing
     */

    public static void coldStream(){
      Flux<Integer> flux =   Flux.range(1, 5).log();

      flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
    }


}
