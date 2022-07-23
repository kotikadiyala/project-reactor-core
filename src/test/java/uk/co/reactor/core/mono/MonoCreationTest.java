package uk.co.reactor.core.mono;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import uk.co.reactor.core.mono.MonoCreation;

class MonoCreationTest {

    @Test
    public void testGetCompany(){

        StepVerifier.create(MonoCreation.getCompany())
                .expectNext("Infosys")
                .verifyComplete();

    }

    @Test
    public void testGetMonoUsingFlux(){
        StepVerifier.create(MonoCreation.getMonoUsingFlux())
                .expectNext("Tcs")
                .verifyComplete();
    }

    @Test
    public void testGetUpperCaseCompany(){

        StepVerifier.create(MonoCreation.getUpperCaseCompany())
                .expectNext("INFOSYS")
                .verifyComplete();

    }

    @Test
    public void testMonoCreationUsingFrom(){
        StepVerifier.create(MonoCreation.getCompanyUsingFrom())
                .expectNext("Infosys")
                .verifyComplete();
    }

}