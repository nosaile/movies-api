package com.codeup.fortran_movies_api.web;

public class MoviesDto {


    private int id;
    private String title;
    private String rating;
    private String year;
    private String genre;
    private String actors;
    private String director;
    private String plot;


    public MoviesDto(int id, String title, String director, String rating, String year, String genre, String actors, String plot) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
        this.plot = plot;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
//
//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rating='" + rating + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
