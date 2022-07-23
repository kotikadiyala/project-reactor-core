package uk.co.reactor.core.mono;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MonoZipWhenOperatorTest {

    @Test
    public void testGetCompaniesUsingZipWhen(){
        StepVerifier.create(MonoZipWhenOperator.getCompaniesUsingZipWhen())
                .expectNext("InfosysTcs")
                .verifyComplete();
    }

}