package com.heroku.movieservice.services;

import com.heroku.movieservice.models.Movie;
import com.heroku.movieservice.repositories.MoviesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MoviesService {
    private final OpenAIService openAIService;
    private final MoviesRepository moviesRepository;

    public Mono<List<Movie>> getMoviesByMood(String mood, int limit) {
        MoviesService.log.info("Getting movies for mood: {}", mood);
        return openAIService.createEmbedding(mood)
                .flatMapMany(embeddings -> moviesRepository.findMoviesByVector(embeddings, limit))
                .collectList();
    }
}
