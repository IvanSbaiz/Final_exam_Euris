package it.esame.cinema.service.impl;

import it.esame.cinema.data.dto.SpectatorDto;
import it.esame.cinema.data.model.Spectator;
import it.esame.cinema.repository.SpectatorRepository;
import it.esame.cinema.service.SpectatorService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SpectatorServiceImpl implements SpectatorService {

  private final SpectatorRepository spectatorRepository;

  public SpectatorServiceImpl(SpectatorRepository spectatorRepository) {
    this.spectatorRepository = spectatorRepository;
  }

  @Override
  public SpectatorDto getById(Integer id) {
    Optional<Spectator> spectator = spectatorRepository.findById(id);
    return spectator.map(Spectator::toDto).orElse(null);
  }

  @Override
  public List<SpectatorDto> getAll() {
    return spectatorRepository.findAll().stream().map(Spectator::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public SpectatorDto save(SpectatorDto spectatorDto) {
    return spectatorRepository.save(spectatorDto.toModel()).toDto();
  }

  @Override
  public SpectatorDto update(SpectatorDto spectatorDto) {
    return spectatorRepository.save(spectatorDto.toModel()).toDto();
  }

  @Override
  public Boolean deleteById(Integer id) {
    spectatorRepository.deleteById(id);
    return Boolean.TRUE;
  }

  @Override
  public Boolean deleteAll() {
    spectatorRepository.deleteAll();
    return Boolean.TRUE;
  }
}
