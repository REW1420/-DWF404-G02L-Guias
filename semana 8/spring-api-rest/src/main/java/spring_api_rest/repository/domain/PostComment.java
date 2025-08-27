package spring_api_rest.repository.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class PostComment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Generacion automatica de id 
}
