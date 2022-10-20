package it.esame.cinema.service;

import it.esame.cinema.data.dto.FilmDto;
import it.esame.cinema.data.model.Film;
import java.util.List;

public interface FilmService {


  public FilmDto getById(Integer id);

  public List<FilmDto> getAll();

  public FilmDto save(FilmDto filmDto);

  public Boolean deleteById(Integer id);

  public Boolean deleteAll();

}
