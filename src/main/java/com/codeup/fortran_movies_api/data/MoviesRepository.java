package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Integer> {


    List<Movie> findByTitle(String title);

    List<Movie> findById(int id);

    List<Movie> findByDirectorName(String directorName);


    @Query(nativeQuery = true, value = "SELECT * FROM movies m WHERE m.year  >= :startYear AND m.year <= :endYear")
    List<Movie> findByYearRange(int startYear, int endYear);


}
