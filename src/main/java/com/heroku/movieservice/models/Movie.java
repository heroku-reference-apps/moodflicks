package com.heroku.movieservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @BsonProperty("_id")
    private ObjectId Id;
    private String title;
    private int year;
    private int runtime;
    private Date released;
    private String poster;
    private String plot;
    private String fullplot;
    private String lastupdated;
    private String type;
    private List<String> directors;
    private Imdb imdb;
    private List<String> cast;
    private List<String> countries;
    private List<String> genres;
    private Tomatoes tomatoes;
    private int num_mflix_comments;
    private String plot_embeddings;
}
