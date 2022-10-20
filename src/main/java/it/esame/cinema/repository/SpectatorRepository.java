package it.esame.cinema.repository;

import it.esame.cinema.data.model.Spectator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpectatorRepository extends JpaRepository<Spectator, Integer> {

}