package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Director;
import com.codeup.fortran_movies_api.data.DirectorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/director", headers = "Accept=application/json")
public class DirectorsController {

    private final DirectorRepository directorRepository;


    public DirectorsController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @PostMapping("post")
    public void create(@RequestBody Director newDirector) {
        directorRepository.save(newDirector);

    }

    @GetMapping("search")
    public List<Director> getByTitle(@RequestParam("name") String name) {
        return directorRepository.findByName(name);
    }
}
