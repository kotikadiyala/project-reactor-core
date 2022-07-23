package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxCreationTest {

    @Test
    public void testGetCompanies(){

        StepVerifier.create(FluxCreation.getCompanies())
                .expectNext("Infosys")
                .expectNext("Tcs")
                .verifyComplete();

    }

    @Test
    public void testGetCompaniesUsingJust(){

        StepVerifier.create(FluxCreation.getCompaniesUsingJust())
                .expectNext("Infosys")
                .expectNext("Tcs")
                .verifyComplete();

    }


}