package org.visakha.springappy

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import reactor.core.publisher.Flux
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

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


private fun initMovies(movieRepo: MovieRepository) {
    println("\n\n---------- Initialing of Movies Starting -------------")
    val rnd: Random = Random(100)
    val movies = Flux.just("Silence of the Lambdas", "AEon Flux", "Back to the Future")
            .doOnEach {
                println("inserting movie : ${it.get()}");
                movieRepo.save(Movie(id = rnd.nextInt().toString(), title = it.get()))

            }
            .subscribe()
    println("\n\n---------- Initialing of Movies Complete -------------")
}

private fun showMovies(movieRepo: MovieRepository) {
    println("\n\n---------- Showing of the Movies Starting -------------")
    movieRepo.findAll().stream().forEach { println(it) }
    println("\n\n---------- Showing of the Movies Complete -------------")
}


@Entity
data class Movie(@Id var id: String? = null, var title: String? = null)

//data class MovieEvent(var movieId: String? = null, var date: Date? = null)
interface MovieRepository : JpaRepository<Movie, String>

