package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Director;
import com.codeup.fortran_movies_api.data.DirectorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/directors", headers = "Accept=application/json")
public class DirectorsController {

    private final DirectorRepository directorRepository;


    public DirectorsController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    //allows the user to enter into the database a new director
    @PostMapping("post")
    public void create(@RequestBody Director newDirector) {
        directorRepository.save(newDirector);

    }

    //allows the user to search through the database for a specific director
    @GetMapping("search")
    public List<Director> getByTitle(@RequestParam("name") String name) {
        return directorRepository.findByName(name);
    }





}
