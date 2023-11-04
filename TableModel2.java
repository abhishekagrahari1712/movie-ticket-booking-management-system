package com.example.movieticket;

public class TableModel2 {
    private final String MovieTitle ;
    private final String Genre;
    private final String datess ;


    public TableModel2(String movieTitle, String genre,  String datess) {
        this.MovieTitle = movieTitle;
        this.Genre = genre;
        this.datess =datess;
    }
    public String getMovieTitle (){
        return MovieTitle;
    }
    public  String getGenre(){
        return Genre;
    }
    public  String getDatess(){
        return  datess;
    }
}
