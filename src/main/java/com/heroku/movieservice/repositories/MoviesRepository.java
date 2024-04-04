package com.heroku.movieservice.repositories;

import com.heroku.movieservice.models.Movie;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.search.SearchPath;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import lombok.RequiredArgsConstructor;

import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MoviesRepository {
    private final MongoDatabase mongoDatabase;

    private MongoCollection<Movie> getMovieCollection() {
        return mongoDatabase.getCollection("embedded_movies", Movie.class);
    }

    public Flux<Movie> findMoviesByVector(List<Double> embedding, int limit) {
        String indexName = "PlotVectorSearch";
        int numCandidates = 100;

        List<Bson> pipeline = List.of(
                Aggregates.vectorSearch(
                        SearchPath.fieldPath("plot_embedding"),
                        embedding,
                        indexName,
                        numCandidates,
                        limit));

        return Flux.from(getMovieCollection().aggregate(pipeline, Movie.class));
    }
}
