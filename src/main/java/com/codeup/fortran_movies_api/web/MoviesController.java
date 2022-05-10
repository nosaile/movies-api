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

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    //single entry
    @PostMapping("post")
    public void create(@RequestBody Movie newMovie) {
        moviesRepository.save(newMovie);
    }

    //multiple entries
    @PostMapping("post/all")
    public void createAll(@RequestBody List<Movie> newMovies) {
        moviesRepository.saveAll(newMovies);
    }

    //return full list of movie objects
    @GetMapping("all")
    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }

    //allows us to filter through by title
    @GetMapping("search/title")
    public List<Movie> getByTitle(@RequestParam("title") String title) {
        return moviesRepository.findByTitle(title);
    }

    //allows us to filter through by id
    @GetMapping("search/id")
    public List<Movie> getById(@RequestParam("id") int id) {
        return moviesRepository.findById(id);
    }

//allows us to filter through by year in a range of years
    @GetMapping("search/year_range")
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear){
        return moviesRepository.findByYearRange(startYear, endYear);
    }


}