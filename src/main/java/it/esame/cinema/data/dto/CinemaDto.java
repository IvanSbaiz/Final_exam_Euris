package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.model.Cinema;
import it.esame.cinema.data.model.ProjectionRoom;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
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
public class CinemaDto implements Dto {

  private Integer id;
  @NotNull
  private ProjectionRoom idProjectionRoom;
  @NotNull
  private Double totalIncoming;

  @Override
  public Cinema toModel() {
    return Cinema.builder().id(id).idProjectionRoom(idProjectionRoom).totalIncoming(totalIncoming)
        .build();
  }
}