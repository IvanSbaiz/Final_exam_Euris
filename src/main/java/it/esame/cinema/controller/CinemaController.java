package it.esame.cinema.controller;

import it.esame.cinema.data.dto.CinemaDto;
import it.esame.cinema.service.CinemaService;
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
@RequestMapping("/cinema")
public class CinemaController {

  private final CinemaService cinemaService;

  public CinemaController(CinemaService cinemaService) {
    this.cinemaService = cinemaService;
  }


  @GetMapping("/{id}")
  public ResponseEntity<CinemaDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(cinemaService.getById(id), HttpStatus.ACCEPTED);
  }

  @GetMapping
  public ResponseEntity<List<CinemaDto>> getAll() {
    List<CinemaDto> cinemaDtoList = new ArrayList<>(cinemaService.getAll());
    return new ResponseEntity<>(cinemaDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CinemaDto> save(@RequestBody CinemaDto CinemaDto) {
    return new ResponseEntity<>(cinemaService.save(CinemaDto), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
    return new ResponseEntity<>(cinemaService.deleteById(id), HttpStatus.ACCEPTED);
  }

}
