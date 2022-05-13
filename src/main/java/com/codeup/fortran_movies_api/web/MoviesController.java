package com.codeup.fortran_movies_api.web;



import com.codeup.fortran_movies_api.data.*;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "api/movies", headers = "Accept=application/json")
public class MoviesController {

    private final MoviesRepository moviesRepository;
    private final DirectorRepository directorRepository;



    public MoviesController(MoviesRepository moviesRepository, DirectorRepository directorRepository) {
        this.moviesRepository = moviesRepository;
        this.directorRepository = directorRepository;
    }

    //allows the user to input a single movie into the database
//    @PostMapping("post")
//    public void create(@RequestBody Movie newMovie) {
//         moviesRepository.save(newMovie);
//
//    }
    @PostMapping ("post")
    public void create(@RequestBody MoviesDto movieDto) {
        Movie movieToAdd = new Movie(
                movieDto.getTitle(),
                movieDto.getYear(),
                movieDto.getPlot(),
                movieDto.getRating()

        );

        List<Director> directorsInDb = directorRepository.findByName(movieDto.getDirector());
        if (directorsInDb.isEmpty()) {
            Director newDirector = new Director(movieDto.getDirector());
            movieToAdd.setDirector(directorRepository.save(newDirector));
        } else {
            movieToAdd.setDirector(directorsInDb.get(0));
        }

//        String[] genres = movieDto.getGenre().split(", ");
//        List<Genre> movieGenres = new ArrayList<>();
//        for (String genre : genres) {
//            Genre genreInDb = genresRepository.findGenreByName(genre);
//            System.out.println(genreInDb);
//            if (genreInDb == null) {
//                Genre newGenre = new Genre(genre);
//                movieGenres.add(genresRepository.save(newGenre));
//            } else {
//                movieGenres.add(genreInDb);
//            }
//        }

//        movieToAdd.setGenres(movieGenres);

        moviesRepository.save(movieToAdd);
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
    public List<MoviesDto> getAll() {
        List<Movie> movieEntities = moviesRepository.findAll();
        List<MoviesDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieEntities) {
            movieDtos.add(new MoviesDto(movie.getId(),
                    movie.getTitle(),
                    movie.getDirector().getName(),
                    movie.getRating(),
                    movie.getYear(),
                    movie.getGenres()
                            .stream()
                            .map(Genre::getName)
                            .collect(Collectors.joining(", ")),
                    movie.getActors()
                            .stream()
                            .map(Actors::getName)
                            .collect(Collectors.joining(", ")),
                    movie.getPlot()))
                    ;
        }
        System.out.println(movieDtos);
        return movieDtos;
    }



    //allows us to filter through by title
    @GetMapping("search/title")
    public List<Movie> getByTitle(@RequestParam("title") String title) {
        return moviesRepository.findByTitle(title);
    }

    //allows us to filter through by id
//    @GetMapping("search/id")
//    public List<Movie> getById(@RequestParam("id") int id) {
//        return moviesRepository.findById(id);
//    }

    //allows us to filter through by year in a range of years
    @GetMapping("search/year_range")
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    //allows the user to delete a specific movie by its movie id
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable int id) {
        moviesRepository.deleteById(id);
    }


}