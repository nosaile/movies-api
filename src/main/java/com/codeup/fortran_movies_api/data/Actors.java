package com.codeup.fortran_movies_api.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="actors")
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_actors",
            joinColumns =
            @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Movie> movies;

    public Actors(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Actors(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
