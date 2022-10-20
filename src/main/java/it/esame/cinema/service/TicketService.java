package it.esame.cinema.service;

import it.esame.cinema.data.dto.TicketDto;
import java.util.List;

public interface TicketService {

  public TicketDto getById(Integer id);

  public List<TicketDto> getAll();

  public TicketDto save(TicketDto ticketDto);

  public TicketDto update(TicketDto ticketDto);

  public Boolean deleteById(Integer id);

  public Boolean deleteAll();

}
