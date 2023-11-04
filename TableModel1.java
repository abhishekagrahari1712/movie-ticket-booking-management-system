package com.example.movieticket;

public class TableModel1 {
    private final  String customerno;
    private final  String customername;
    private final  String movietickets;
    private final  String MovieTitle;
    private final  String Genre;

    public TableModel1(String customerno, String customername, String movietickets, String movieTitle, String genre) {





        this.customerno=customerno;
        this.customername=customername;
        this.movietickets=movietickets;
        this.MovieTitle=movieTitle;
        this.Genre=genre;
    }

    public String getCustomerno(){
        return customerno;
    }
    public String getCustomername(){
        return customername;
    }
    public String getMovietickets(){
        return movietickets;
    }
    public String getMovieTitle(){
        return MovieTitle;
    }
    public String getGenre(){
        return Genre;
    }
}