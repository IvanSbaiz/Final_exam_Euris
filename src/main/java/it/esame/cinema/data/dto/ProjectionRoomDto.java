package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
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
public class ProjectionRoomDto implements Dto {

  private Integer id;
  @NotNull
  private Integer seats;
  @NotNull
  private Double price;
  @NotNull
  private FilmDto idFilm;

  @Override
  public Model toModel() {
    return null;
  }
}