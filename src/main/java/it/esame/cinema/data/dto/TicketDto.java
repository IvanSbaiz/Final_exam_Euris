package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.model.Ticket;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto implements Dto {

  private Integer id;
  @NotNull
  private Double price;
  @NotNull
  private Double discountElderly;
  @NotNull
  private Double discountChildren;
  @Size(max = 128)
  @NotNull
  private String seatPosition;
  @NotNull
  private FilmDto idFilm;
  @NotNull
  private ProjectionRoomDto idProjectionRoom;

  @Override
  public Ticket toModel() {
    return Ticket.builder().id(id).price(price).discountElderly(discountElderly)
        .discountChildren(discountChildren).seatPosition(seatPosition).idFilm(idFilm.toModel())
        .idProjectionRoom(idProjectionRoom.toModel()).build();
  }
}