package com.example.movieticket;

public class TableModel3 {
    private final String MovieTitles;
    private final String Genres;
    private final String Durations ;
    private final String datess;

    public TableModel3(String movieTitle, String genre, String duration, String datess) {
        this.MovieTitles=movieTitle;
        this.Genres=genre;
        this.Durations=duration;
        this.datess=datess;

    }

    public String getMovieTitles(){
        return MovieTitles;
    }
    public String getGenres(){
        return Genres;
    }
    public String getDurations(){
        return Durations;
    }
    public String getDatess(){
        return datess;

    }
}
