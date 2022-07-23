package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxOnErrorResumeOperatorTest {

    @Test
    public void testErrorResume(){
        StepVerifier.create(FluxOnErrorResumeOperator.onErrorResume())
                .expectNext("Tcs","Wipro" , "Fallback Company")
                .verifyComplete();
    }


    @Test
    public void testErrorResumeUsingExceptionType(){
        StepVerifier.create(FluxOnErrorResumeOperator.onErrorResumeUsingExceptionClass())
                .expectNext("Tcs","Wipro" , "IBM")
                .verifyComplete();
    }

}