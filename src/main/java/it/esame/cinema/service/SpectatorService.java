package it.esame.cinema.service;

import it.esame.cinema.data.dto.SpectatorDto;
import java.util.List;

public interface SpectatorService {

  public SpectatorDto getById(Integer id);

  public List<SpectatorDto> getAll();

  public SpectatorDto save(SpectatorDto spectatorDto);

  public SpectatorDto update(SpectatorDto spectatorDto);

  public Boolean deleteById(Integer id);

  public Boolean deleteAll();

}
