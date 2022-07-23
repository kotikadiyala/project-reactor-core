package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import uk.co.reactor.core.exception.InvalidInputException;

class FluxOnErrorMapOperatorTest {


    @Test
    public void testErrorMap(){
        StepVerifier.create(FluxOnErrorMapOperator.onErrorMap())
                .expectNext("Tcs")
                .verifyError(InvalidInputException.class);
    }

    @Test
    public void testErrorMapPredicate(){
        StepVerifier.create(FluxOnErrorMapOperator.onErrorMapUsingPredicateType())
                .expectNext("Tcs")
                .expectNext("Wipro")
                .verifyError(InvalidInputException.class);
    }

}