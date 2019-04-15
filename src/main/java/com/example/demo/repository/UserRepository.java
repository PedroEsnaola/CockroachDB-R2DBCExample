package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {

    @Query("Select * from database_user where name=$1")
    Flux<User> findByNameUsingQueryAnnotation(String name);
}
