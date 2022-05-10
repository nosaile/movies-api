package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {


    private final List<Movie> sampleMovies = setMovies();

    @GetMapping
    public Movie one() {
        return sampleMovies.get(0);
    }

    @GetMapping("all")
    public List<Movie> getAll() {

        return sampleMovies;
    }

    private List<Movie> setMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "pulp fiction",
                "1994", "quentin tarantino",
                "samuel l jackson, bruce willis, john travolta", "drama, crime, suspense",
                "crime hit-man stuff"));
        movies.add(new Movie(2, "The dude",
                "1995", "Cohen Bros", "Jeff B", "comedy",
                "the dude abides"));
        movies.add(new Movie(3, "Jurassic Park",
                "1993",
                "Steven Spielberg",
                "Jeff Goldblum, Sam Niell, Laura Dern",
                "dino-horror", "A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose."));


        return movies;
    }

    @GetMapping("search/{title}")
    public Movie getByTitle(@PathVariable String title){
        Movie movieToReturn = null;
        for (Movie movie : sampleMovies){
            if(movie.getTitle().contains(title)){
                movieToReturn = movie;
            }
        }
        return movieToReturn;
    }

    @GetMapping("{id}")
    public Movie getByID(@PathVariable Long id) {
        return sampleMovies.stream().filter((movie) -> {
                    return movie.getId() == id;

                })
                .findFirst()
                .orElse(null);

    }

    @PostMapping
    public void create(@RequestBody Movie newMovie) {
        sampleMovies.add(newMovie);
    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> newMovies) { //dont forget to add @RequstBody, @Pathvariable, etc...
        sampleMovies.addAll(newMovies);//adAll on the collection object allows us to add all the elements from one collection to another in a single line
    }





}