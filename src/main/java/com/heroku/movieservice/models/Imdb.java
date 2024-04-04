package com.heroku.movieservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Imdb {
    private double rating;
    private int votes;
    private int id;
}
