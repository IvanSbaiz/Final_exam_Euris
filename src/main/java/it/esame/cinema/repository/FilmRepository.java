package it.esame.cinema.repository;

import it.esame.cinema.data.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}