package org.visakha.springappy

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.visakha.springappy.db.MovieRepository
import org.visakha.springappy.db.initMovies
import org.visakha.springappy.db.showMovies

@SpringBootApplication
class SpringAppy {
    @Bean
    fun runner(movieRepo: MovieRepository) = ApplicationRunner {
        initMovies(movieRepo)
        showMovies(movieRepo)
    }

}

fun main(args: Array<String>) {
    runApplication<SpringAppy>(*args)
}

