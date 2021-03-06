package com.codeup.fortran_movies_api.web;


import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {

    private final MoviesRepository moviesRepository;


    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    //allows the user to input a single movie into the database
    @PostMapping("post")
    public void create(@RequestBody Movie newMovie) {
        moviesRepository.save(newMovie);
    }

    //multiple entries of movies to the database
    @PostMapping("post/all")
    public void createAll(@RequestBody List<Movie> newMovies) {
        moviesRepository.saveAll(newMovies);
    }

    //allows us to search all movies by a certain director
    @GetMapping("search/director")
    public List<Movie> getByDirector(@RequestParam("director") String directorName) {
        return moviesRepository.findByDirectorName(directorName);
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
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    //allows the user to delete a specific movie by its movie id
    @DeleteMapping("delete/{id}")
    public void deletById(@PathVariable int id) {
        moviesRepository.deleteById(id);
    }


}