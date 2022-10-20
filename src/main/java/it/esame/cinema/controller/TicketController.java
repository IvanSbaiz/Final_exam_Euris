package it.esame.cinema.controller;

import it.esame.cinema.data.dto.TicketDto;
import it.esame.cinema.service.TicketService;
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
@RequestMapping("/ticket")
public class TicketController {

  private TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<TicketDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(ticketService.getById(id), HttpStatus.ACCEPTED);
  }

  @GetMapping
  public ResponseEntity<List<TicketDto>> getAll() {
    List<TicketDto> ticketDtoList = new ArrayList<>(ticketService.getAll());
    return new ResponseEntity<>(ticketDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TicketDto> save(@RequestBody TicketDto ticketDto) {
    return new ResponseEntity<>(ticketService.save(ticketDto), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
    return new ResponseEntity<>(ticketService.deleteById(id), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Boolean> deleteAll() {
    return new ResponseEntity<>(ticketService.deleteAll(), HttpStatus.OK);
  }

}
