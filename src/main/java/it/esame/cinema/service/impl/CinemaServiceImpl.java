package it.esame.cinema.service.impl;

import it.esame.cinema.data.dto.CinemaDto;
import it.esame.cinema.data.model.Cinema;
import it.esame.cinema.repository.CinemaRepository;
import it.esame.cinema.service.CinemaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

  private final CinemaRepository cinemaRepository;

  public CinemaServiceImpl(CinemaRepository cinemaRepository) {
    this.cinemaRepository = cinemaRepository;
  }

  @Override
  public CinemaDto getById(Integer id) {
    Optional<Cinema> cinema = cinemaRepository.findById(id);
    return cinema.map(Cinema::toDto).orElse(null);
  }

  @Override
  public List<CinemaDto> getAll() {
    return cinemaRepository.findAll().stream().map(Cinema::toDto).collect(Collectors.toList());
  }

  @Override
  public CinemaDto save(CinemaDto cinemaDto) {
    return cinemaRepository.save(cinemaDto.toModel()).toDto();
  }

  @Override
  public Boolean deleteById(Integer id) {
    cinemaRepository.deleteById(id);
    return Boolean.TRUE;
  }
}
