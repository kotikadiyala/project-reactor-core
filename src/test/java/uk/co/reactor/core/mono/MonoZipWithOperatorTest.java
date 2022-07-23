package uk.co.reactor.core.mono;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


class MonoZipWithOperatorTest {

    @Test
    public void testGetCompaniesUsingZipWith(){
        StepVerifier.create(MonoZipWithOperator.getCompaniesUsingZipWith())
                .expectNext("InfosysTcs")
                .verifyComplete();
    }

}