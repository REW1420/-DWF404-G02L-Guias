package sv.edu.udb.spring_di.service;

import sv.edu.udb.spring_di.respository.domain.Movie;

public interface MovieService {
    Movie findMovieById(Long id);
}
