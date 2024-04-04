package com.heroku.movieservice.controllers;

import com.heroku.movieservice.models.Movie;
import com.heroku.movieservice.services.MoviesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Tag(name = "Movies")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class MoviesController {
    private final MoviesService moviesService;

    @GetMapping(value = "/movies")
    public Mono<List<Movie>> getMoviesByMood(@RequestParam(value = "mood") String mood, @RequestParam(value = "limit", required = false, defaultValue = "5") int limit) {
        if (limit > 50) {
            limit = 50;
        }

        return moviesService.getMoviesByMood(mood, limit);
    }
}
