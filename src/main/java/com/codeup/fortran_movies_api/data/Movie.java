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
//    private String director;
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


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
