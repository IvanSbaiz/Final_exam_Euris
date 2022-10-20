package it.esame.cinema.service.impl;

import it.esame.cinema.data.dto.ProjectionRoomDto;
import it.esame.cinema.data.exception.MovieNotAllowed;
import it.esame.cinema.data.exception.NoMoreSeats;
import it.esame.cinema.data.model.ProjectionRoom;
import it.esame.cinema.repository.ProjectionRoomRepository;
import it.esame.cinema.service.ProjectionRoomService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProjectionRoomServiceImpl implements ProjectionRoomService {

  private final ProjectionRoomRepository projectionRoomRepository;

  public ProjectionRoomServiceImpl(ProjectionRoomRepository projectionRoomRepository) {
    this.projectionRoomRepository = projectionRoomRepository;
  }

  @Override
  public ProjectionRoomDto getById(Integer id) {
    Optional<ProjectionRoom> projectionRoom = projectionRoomRepository.findById(id);
    return projectionRoom.map(ProjectionRoom::toDto).orElse(null);
  }

  @Override
  public List<ProjectionRoomDto> getAll() {
    return projectionRoomRepository.findAll().stream().map(ProjectionRoom::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public ProjectionRoomDto save(ProjectionRoomDto projectionRoomDto) {
    return projectionRoomRepository.save(projectionRoomDto.toModel()).toDto();
  }

  @Override
  public ProjectionRoomDto update(ProjectionRoomDto projectionRoomDto) {
    return projectionRoomRepository.save(projectionRoomDto.toModel()).toDto();
  }

  @Override
  public ProjectionRoomDto allowVisionToSpectator(Integer idSpectator)
      throws MovieNotAllowed, NoMoreSeats {
    return null;
  }

  @Override
  public ProjectionRoomDto totalGained(Integer idProjectionRoom) {
    return null;
  }

  @Override
  public Boolean deleteById(Integer id) {
    projectionRoomRepository.deleteById(id);
    return Boolean.TRUE;
  }

  @Override
  public Boolean deleteAll() {
    projectionRoomRepository.deleteAll();
    return Boolean.TRUE;
  }
}
