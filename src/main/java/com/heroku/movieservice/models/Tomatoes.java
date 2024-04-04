package com.heroku.movieservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tomatoes {
    private Viewer viewer;
    private Date lastUpdated;
}
