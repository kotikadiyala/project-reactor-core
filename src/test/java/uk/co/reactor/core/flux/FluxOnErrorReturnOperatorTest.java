package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxOnErrorReturnOperatorTest {

    @Test
    public void testonErrorReturn(){

        StepVerifier.create(FluxOnErrorReturnOperator.onErrorReturn())
                .expectNext("Tcs","Fallback Company")
                .verifyComplete();

    }

    @Test
    public void testWithOutErrorReturn(){
        StepVerifier.create(FluxOnErrorReturnOperator.withOutErrorReturn())
                .expectNext("Infosys")
                .verifyError(RuntimeException.class);
    }

    @Test
    public void testErrorMessage(){
        StepVerifier.create(FluxOnErrorReturnOperator.withOutErrorReturn())
                .expectNext("Infosys")
                .expectErrorMessage("Invalid Company")
                .verify();
    }

}