package org.visakha.springappy

import org.junit.Test
import reactor.core.publisher.Flux

class GenericKotlinTests {

    @Test
    fun T1(){
        assert(true)
    }

    @Test
    fun simpleFlux(){
        val movies = Flux.just("Silence of the Lambdas", "AEon Flux", "Back to the Future")
                .doOnEach { println("WOA ....") }
        assert(true)

    }
}