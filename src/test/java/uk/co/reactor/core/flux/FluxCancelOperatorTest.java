package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxCancelOperatorTest {


    @Test
    public void testCancel(){

        StepVerifier.create(FluxCancelOperator.cancel())
                .expectNext(1, 2, 3)
                .thenCancel()
                .verify();

    }


}