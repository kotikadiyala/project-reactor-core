package uk.co.reactor.core.flux;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;
import uk.co.reactor.core.exception.InvalidInputException;

import java.time.Duration;
import java.util.Arrays;

public class FluxRetry {

    /*
    retry() operator is used, to retry infinitely when exception occurs.
     */
    public static Flux<String> retryInfinitely(){

        return Flux.fromIterable(Arrays.asList("Tcs", "Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorMap(RuntimeException.class, e -> new InvalidInputException(e))
                .retry().log();
    }

    /*
  retry(long n) operator is used, to retry n number of times when exception occurs.
   */
    public static Flux<String> retryNTimes(){

        return Flux.fromIterable(Arrays.asList("Tcs", "Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorMap(RuntimeException.class, e -> new InvalidInputException(e))
                .retry(2).log();
    }

      /*
  retryWhen(Retry retry) operator is used to specify number of retry attempts and duration.
   */
    public static Flux<String> retryWhen(){

        Retry retry = Retry.backoff(2, Duration.ofSeconds(10));

        return Flux.fromIterable(Arrays.asList("Tcs", "Infosys"))
                .map(company -> {
                    if (company.equalsIgnoreCase("Infosys")){
                        throw new RuntimeException("Invalid Company");
                    }
                    return company;
                }).onErrorMap(RuntimeException.class, e -> new InvalidInputException(e))
                .retryWhen(retry).log();
    }
}
