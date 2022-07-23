package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxZipWithOperatorTest {

    @Test
    public void testZipWith(){

        StepVerifier.create(FluxZipWithOperator.zipWith())
                .expectNext("Infosys founder is: Narayana Murthy", "Tcs founder is: Rathan Tata")
                .verifyComplete();
    }

}