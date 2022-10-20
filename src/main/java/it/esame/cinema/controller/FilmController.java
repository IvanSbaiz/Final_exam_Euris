package it.esame.cinema.controller;

import it.esame.cinema.data.dto.FilmDto;
import it.esame.cinema.service.FilmService;
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
@RequestMapping("/film")
public class FilmController {

  private final FilmService filmService;

  public FilmController(FilmService filmService) {
    this.filmService = filmService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<FilmDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(filmService.getById(id), HttpStatus.ACCEPTED);
  }

  @GetMapping
  public ResponseEntity<List<FilmDto>> getAll() {
    List<FilmDto> filmDtoList = new ArrayList<>(filmService.getAll());
    return new ResponseEntity<>(filmDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<FilmDto> save(@RequestBody FilmDto filmDto) {
    return new ResponseEntity<>(filmService.save(filmDto), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
    return new ResponseEntity<>(filmService.deleteById(id), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Boolean> deleteAll() {
    return new ResponseEntity<>(filmService.deleteAll(), HttpStatus.OK);
  }

}
