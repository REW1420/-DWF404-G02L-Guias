package sv.edu.udb.spring_di.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sv.edu.udb.spring_di.respository.MovieRepository;
import sv.edu.udb.spring_di.respository.domain.Movie;
import sv.edu.udb.spring_di.service.implementation.MovieServiceImpl;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieServiceImpl movieService;
    private MovieRepository movieRepository;

    @Test
    void shouldMovieServiceNotNull_When_SpringContextWorks() {
        assertNotNull(movieService);
    }

    @Test
    void shouldMovieRepositoryNotNul_When_DIWorks() {
        assertNotNull(movieService.getMovieRepository());
    }

    @Test
    void shouldGetAMovie_When_TheMovieIdExists() {
        final Long expectedMovieId = 1L;
        final String expectedMovieName = "Inception";
        final Integer expectedReleaseYear = 2010;
        final Movie actualMovie = movieService.findMovieById(expectedMovieId);
        assertEquals(actualMovie.getId(), expectedMovieId);
        assertEquals(actualMovie.getName(), expectedMovieName);
        assertEquals(actualMovie.getReleaseYear(), expectedReleaseYear);
    }

    @Test
    void shouldThrowNoSuchElementException_When_MovieIdDoesNotExists() {
        final Long fakeId = 4L;
        final String expectedErrorMessage = "Movie doesn't exists";
        final Exception exception = assertThrows(NoSuchElementException.class,
                () -> movieService.findMovieById(fakeId));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    // ✅ Caso 1: Probar que una película se encuentra correctamente
    @Test
    void shouldReturnMovie_WhenMovieExists() {
        Movie expectedMovie = new Movie(1L, "Inception", "Sci-Fi", 2010);
        when(movieRepository.findMovieById(1L)).thenReturn(expectedMovie);

        Movie result = movieService.findMovieById(1L);

        assertEquals("Inception", result.getName()); // 👉 assertEquals
        assertEquals(2010, result.getReleaseYear());
    }

    // ✅ Caso 2: Probar que se devuelve null si no se encuentra la película
    @Test
    void shouldReturnNull_WhenMovieNotFound() {
        when(movieRepository.findMovieById(999L)).thenReturn(null);

        Movie result = movieService.findMovieById(999L);

        assertNull(result); // 👉 assertNull
    }

    // ✅ Caso 3: Probar que el repositorio es el mismo que se inyectó
    @Test
    void shouldUseInjectedMovieRepository() {
        MovieRepository injectedRepository = movieService.getMovieRepository();

        assertSame(movieRepository, injectedRepository); // 👉 assertSame
    }
}
