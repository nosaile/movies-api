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
        return sampleMovies.get(1);
    }

    @GetMapping("all")
    public List<Movie> getAll() {

        return sampleMovies;
    }

    private List<Movie> setMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "pulp fiction",
                "1994", "quentin tarantino",
                "samuel l jackson, bruce willis, john travolta", "10", "drama, crime, suspense",
                "crime hit-man stuff"));
        movies.add(new Movie(2, "The dude",
                "1995", "Cohen Bros", "Jeff B",
                "idk man", "comedy",
                "the dude abides"));
        movies.add(new Movie(3, "Jurassic Park",
                "1993",
                "Steven Spielberg",
                "Jeff Goldblum, Sam Niell, Laura Dern", "234",
                "dino-horror", "A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose."));


        return movies;
    }

    @GetMapping("{id}")
    public Movie getByID(@PathVariable Long  id){
return sampleMovies.stream().filter((movie) -> {
    return movie.getId() == id;

    })
        .findFirst()
        .orElse(null);

}
    @PostMapping
    public void create(@RequestBody Movie newMovie){
        newMovie.setId(4);
        newMovie.setTitle("The Batman");
        newMovie.setYear("2022");
        newMovie.setDirector("Matt Reeves");
        newMovie.setActors("Robert Pattinson, Zoe Kravitz, Jeffrey Wright, Colin Farrell, Paul Dano");
        newMovie.setImdbId("123");
        newMovie.setGenre("Crime, Thriller, Drama");
        newMovie.setPlot("Batman ventures into Gotham City's underworld when a sadistic killer leaves behind a trail of cryptic clues. As the evidence begins to lead closer to home and the scale of the perpetrator's plans become clear, he must forge new relationships, unmask the culprit and bring justice to the abuse of power and corruption that has long plagued the metropolis.");
        System.out.println(newMovie);
    }
}