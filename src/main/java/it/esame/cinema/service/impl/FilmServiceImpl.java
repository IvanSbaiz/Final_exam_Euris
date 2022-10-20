package it.esame.cinema.service.impl;

import it.esame.cinema.data.dto.FilmDto;
import it.esame.cinema.data.model.Film;
import it.esame.cinema.repository.FilmRepository;
import it.esame.cinema.service.FilmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;

  public FilmServiceImpl(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @Override
  public FilmDto getById(Integer id) {
    Optional<Film> film = filmRepository.findById(id);
    return film.map(Film::toDto).orElse(null);
  }

  @Override
  public List<FilmDto> getAll() {
    return filmRepository.findAll().stream().map(Film::toDto).collect(Collectors.toList());
  }

  @Override
  public FilmDto save(FilmDto filmDto) {
    return filmRepository.save(filmDto.toModel()).toDto();
  }

  @Override
  public Boolean deleteById(Integer id) {
    filmRepository.deleteById(id);
    return Boolean.TRUE;
  }

  @Override
  public Boolean deleteAll() {
    filmRepository.deleteAll();
    return Boolean.TRUE;
  }
}
