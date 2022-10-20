package it.esame.cinema.service;

import it.esame.cinema.data.dto.ProjectionRoomDto;
import it.esame.cinema.data.exception.MovieNotAllowed;
import it.esame.cinema.data.exception.NoMoreSeats;
import java.util.List;

public interface ProjectionRoomService {


  public ProjectionRoomDto getById(Integer id);

  public List<ProjectionRoomDto> getAll();

  public ProjectionRoomDto save(ProjectionRoomDto projectionRoomDto);

  public ProjectionRoomDto update(ProjectionRoomDto projectionRoomDto);

  public ProjectionRoomDto allowVisionToSpectator(Integer idSpectator)
      throws MovieNotAllowed, NoMoreSeats;

  public ProjectionRoomDto totalGained(Integer idProjectionRoom);

  public Boolean deleteById(Integer id);

  public Boolean deleteAll();

}
