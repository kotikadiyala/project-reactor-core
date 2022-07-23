package uk.co.reactor.core.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import uk.co.reactor.core.flux.FluxCancelOperator;

import static org.junit.jupiter.api.Assertions.*;

class MonoCancelOperatorTest {


    @Test
    public void testCancel(){

        StepVerifier.create(MonoCancelOperator.cancel())
                .expectNext(1)
                .thenCancel()
                .verify();

    }

}