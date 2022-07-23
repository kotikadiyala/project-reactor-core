package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

public class FluxRequestOperator {

    /*
    In Flux there are 4 0r 5 overloaded subscribe methods are there
    When 1 of those methods are used , request object is accessed and maximum number of elements
    to take at a time are specified.

   ex: request(10) takes 10 elements
     */
   public static Flux<Integer> request() {
       Flux<Integer> request = Flux.range(1, 50).log();

       request.subscribe(
               System.out::println,
               err -> err.printStackTrace(),
               () -> System.out.println("All 50 items have been successfully processed!!!"),
               subscription -> {
                   for (int i = 0; i < 5; i++) {
                       System.out.println("Requesting the next 10 elements!!!");
                       subscription.request(10);
                   }
               }
       );

       return request;
   }

}
