package it.esame.cinema.repository;

import it.esame.cinema.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}