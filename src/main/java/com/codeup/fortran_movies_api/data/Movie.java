package com.codeup.fortran_movies_api.data;


import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;
    @ManyToOne
    private Director director;
//    private String actors;
//    private String genre;
    private String plot;

    public Movie(int id, String title, String year, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
    }

    public Movie() {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", plot='" + plot + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
