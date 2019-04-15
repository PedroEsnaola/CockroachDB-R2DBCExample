package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @PostMapping
    Mono<User> save(@RequestBody User user){
        return repo.save(user);
    }

    @GetMapping("/name/{name}")
    Flux<User> findByName(@PathVariable String name){
        return repo.findByNameUsingQueryAnnotation(name);
    }

    @GetMapping()
    Flux<User> findAll(){
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    Mono<Void>  delete(@PathVariable String id){
       return repo.deleteById(id);
    }
}
