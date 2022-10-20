package it.esame.cinema.controller;

import it.esame.cinema.data.dto.SpectatorDto;
import it.esame.cinema.service.SpectatorService;
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
@RequestMapping("/spectator")
public class SpectatorController {

  private final SpectatorService spectatorService;

  public SpectatorController(SpectatorService spectatorService) {
    this.spectatorService = spectatorService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<SpectatorDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(spectatorService.getById(id), HttpStatus.ACCEPTED);
  }

  @GetMapping
  public ResponseEntity<List<SpectatorDto>> getAll() {
    List<SpectatorDto> spectatorDtoList = new ArrayList<>(spectatorService.getAll());
    return new ResponseEntity<>(spectatorDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<SpectatorDto> save(@RequestBody SpectatorDto spectatorDto) {
    return new ResponseEntity<>(spectatorService.save(spectatorDto), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
    return new ResponseEntity<>(spectatorService.deleteById(id), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Boolean> deleteAll() {
    return new ResponseEntity<>(spectatorService.deleteAll(), HttpStatus.OK);
  }

}
