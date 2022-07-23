package uk.co.reactor.core.flux;


import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxDelayTest {

    @Test
    public void testDelay(){

        StepVerifier.create(FluxDelay.delay())
                .expectNext("Infosys", "Tcs")
                .verifyComplete();

    }

}