package uk.co.reactor.core.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxRequestOperatorTest {
    @Test
    public void testRequest(){
     StepVerifier.create(FluxRequestOperator.request())
             .expectSubscription()
             .thenRequest(10)
             .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
             .thenRequest(10)
             .expectNext(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
             .thenRequest(10)
             .expectNext(21, 22, 23, 24, 25, 26, 27 , 28, 29 ,30)
             .thenRequest(10)
             .expectNext(31, 32, 33, 34, 35, 36, 37 , 38, 39 ,40)
             .thenRequest(10)
             .expectNext(41, 42, 43, 44, 45, 46, 47 , 48, 49 ,50)
             .verifyComplete();


    }



}