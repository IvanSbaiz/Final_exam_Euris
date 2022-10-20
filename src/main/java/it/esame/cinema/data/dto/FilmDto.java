package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
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
public class FilmDto implements Dto {

  private Integer id;
  @Size(max = 64)
  private String title;
  @Size(max = 64)
  private String author;
  @Size(max = 64)
  private String producer;
  @NotNull
  private Integer minAge;
  @NotNull
  private Integer maxAge;
  private Double filmLength;

  @Override
  public Model toModel() {
    return null;
  }
}