package it.esame.cinema.controller;

import it.esame.cinema.data.dto.ProjectionRoomDto;
import it.esame.cinema.service.ProjectionRoomService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projection_room")
public class ProjectionRoomController {

  private final ProjectionRoomService projectionRoomService;

  public ProjectionRoomController(ProjectionRoomService projectionRoomService) {
    this.projectionRoomService = projectionRoomService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjectionRoomDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(projectionRoomService.getById(id), HttpStatus.ACCEPTED);
  }

  @GetMapping
  public ResponseEntity<List<ProjectionRoomDto>> getAll() {
    List<ProjectionRoomDto> projectionRoomDtoList = new ArrayList<>(projectionRoomService.getAll());
    return new ResponseEntity<>(projectionRoomDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProjectionRoomDto> save(@RequestBody ProjectionRoomDto projectionRoomDto) {
    return new ResponseEntity<>(projectionRoomService.save(projectionRoomDto), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
    return new ResponseEntity<>(projectionRoomService.deleteById(id), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Boolean> deleteAll() {
    return new ResponseEntity<>(projectionRoomService.deleteAll(), HttpStatus.OK);
  }
}
