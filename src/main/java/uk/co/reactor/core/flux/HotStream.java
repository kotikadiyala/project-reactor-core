package uk.co.reactor.core.flux;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class HotStream {

    /*
    HotStreams are realtime streams where data would be continuosly being emited
    and subscribers would be able to get only current emissions.
    If a subscription happens later, it might miss the earlier emited data.

    In Hot Streams data emission would not start immediately after subscribing.
    .connect() method needs to be called or autoConnect() method needs to be called for data flow
     */

    public static void hotStreamAutoConnect() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed to source")).log();

        Flux<Integer> co = source.publish().autoConnect(2);

        co.subscribe(System.out::println, e -> {}, () -> {});
        Thread.sleep(50000);
        co.subscribe(System.out::println, e -> {}, () -> {});

        System.out.println("done subscribing");
        System.out.println("will now connect");
    }

    public static void hotStream() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed to source")).log();

        ConnectableFlux<Integer> co = source.publish();

        co.subscribe(System.out::println, e -> {}, () -> {});
        Thread.sleep(50000);

        co.subscribe(System.out::println, e -> {}, () -> {});

        System.out.println("done subscribing");
        System.out.println("will now connect");

        co.connect();
    }
}
