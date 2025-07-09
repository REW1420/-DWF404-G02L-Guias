package sv.edu.udb.spring_di.service.implementation;

import lombok.Getter;
import sv.edu.udb.spring_di.respository.MovieRepository;
import sv.edu.udb.spring_di.respository.domain.Movie;
import sv.edu.udb.spring_di.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(final MovieRepository movieRepository) {
        this.movieRepository = Objects.requireNonNull(movieRepository);
    }

    @Override
    public Movie findMovieById(final Long id) {
        return movieRepository.findMovieById(id);
    }
}