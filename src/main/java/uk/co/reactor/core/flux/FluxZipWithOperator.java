package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;

public class FluxZipWithOperator {

    /*
    When an operation needs to be performed on 2 streams and in combination then
    zipWith / zip operator is used.

    If 2 complete independent streams needs to be processed, then using mergeWith / merge operator is better
     */
    public static Flux<String> zipWith(){

       return Flux.from(FluxCreation.getCompanies())
               .zipWith(FluxCreation.getFounders(), (company, founder)-> company + " founder is: "+founder)
               .log();

    }



}
