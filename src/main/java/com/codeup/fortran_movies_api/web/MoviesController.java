package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {



    private final MoviesRepository moviesRepository;


    public MoviesController(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }


    @GetMapping("all")
    public List<Movie> getAll() {

        return moviesRepository.findAll();
    }


    @GetMapping("search/{title}")
    public Movie getByTitle(@PathVariable String title){
        Movie movieToReturn = null;
        for (Movie movie : moviesRepository.findAll()){
            if(movie.getTitle().contains(title)){
                movieToReturn = movie;
            }
        }
        return movieToReturn;
    }

    @GetMapping("{id}")
    public Movie getByID(@PathVariable Long id) {
        return moviesRepository.findAll().stream().filter((movie) -> {
                    return movie.getId() == id;

                })
                .findFirst()
                .orElse(null);

    }

    @PostMapping
    public void create(@RequestBody Movie newMovie) {
        moviesRepository.save(newMovie);
    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> newMovies) { //dont forget to add @RequstBody, @Pathvariable, etc...
        moviesRepository.saveAll(newMovies);
    }





}