package it.esame.cinema.service.impl;

import it.esame.cinema.data.dto.TicketDto;
import it.esame.cinema.data.model.Ticket;
import it.esame.cinema.repository.TicketRepository;
import it.esame.cinema.service.TicketService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;

  public TicketServiceImpl(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @Override
  public TicketDto getById(Integer id) {
    Optional<Ticket> ticket = ticketRepository.findById(id);
    return ticket.map(Ticket::toDto).orElse(null);
  }

  @Override
  public List<TicketDto> getAll() {
    return ticketRepository.findAll().stream().map(Ticket::toDto).collect(Collectors.toList());
  }

  @Override
  public TicketDto save(TicketDto ticketDto) {
    return ticketRepository.save(ticketDto.toModel()).toDto();
  }

  @Override
  public TicketDto update(TicketDto ticketDto) {
    return ticketRepository.save(ticketDto.toModel()).toDto();
  }

  @Override
  public Boolean deleteById(Integer id) {
    ticketRepository.deleteById(id);
    return Boolean.TRUE;
  }

  @Override
  public Boolean deleteAll() {
    ticketRepository.deleteAll();
    return Boolean.TRUE;
  }
}
