package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()
/*
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(
                        num -> System.out.println(num),
                        err -> System.out.println(err.getMessage())
                );
*/

        // Print values from intNumbersFluxWithException and print a message when error happens
/*
        ReactiveSources.intNumbersFluxWithException()
                // doOnError führt ein Code aus bevor ein Exception geworfen wird
                .doOnError(err -> System.out.println("Error!!! " + err.getMessage()))
                .subscribe(System.out::println);
*/


        // Print values from intNumbersFluxWithException and continue on errors
/*        ReactiveSources.intNumbersFluxWithException()
                // onErrorContinue führt ein Code aus und Subsctiption läuft weiter
                // So kann iClient so gebaut werden dass nach erste Error nciht Code abbricht
                .onErrorContinue((err, item) -> System.out.println("Error!!! " + err.getMessage() + " , item: " + item))
                .subscribe(System.out::println);*/


        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
