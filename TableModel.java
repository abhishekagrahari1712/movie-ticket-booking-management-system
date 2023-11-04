package com.example.movieticket;

public class TableModel {
    private final String MovieTitle;
    private final String Genre;
    private final String Duration;
    private final String datess;

    public TableModel(String movieTitle, String genre, String duration, String datess) {
        this.MovieTitle=movieTitle;
        this.Genre=genre;
        this.Duration=duration;
        this.datess=datess;
    }


    public String getMovieTitle (){
        return MovieTitle;
    }
    public String getGenre(){
        return Genre;
    }
    public  String getDuration(){
        return  Duration;
    }
    public String getDatess(){

        return  datess;
    }

}
