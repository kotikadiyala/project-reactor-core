package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


class FluxSideOperatorsTest {


    @Test
    public void testDoOnNext(){
        StepVerifier.create(FluxSideOperators.doOnNext())
                .expectNext("Infosys", "Tcs")
                .verifyComplete();
    }

    @Test
    public void testDoOnComplete(){
        StepVerifier.create(FluxSideOperators.doOnComplete())
                .expectNext("Infosys", "Tcs")
                .verifyComplete();
    }

    @Test
    public void testDoOnError(){
        StepVerifier.create(FluxSideOperators.doOnError())
                .verifyError(RuntimeException.class);
    }

    @Test
    public void testDoOnErrorErrorMessage(){
        StepVerifier.create(FluxSideOperators.doOnError())
                .expectErrorMessage("Invalid Company")
                .verify();
    }

}