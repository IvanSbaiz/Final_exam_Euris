package it.esame.cinema.service;

import it.esame.cinema.data.dto.CinemaDto;
import it.esame.cinema.data.model.Cinema;
import java.util.List;

public interface CinemaService {

  public CinemaDto getById(Integer id);

  public List<CinemaDto> getAll();

  public CinemaDto save(CinemaDto cinemaDto);

  public Boolean deleteById(Integer id);

}
