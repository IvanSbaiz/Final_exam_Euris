package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.model.Ticket;
import java.io.Serializable;
import java.time.LocalDate;
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
public class SpectatorDto implements Dto {

  private Integer id;
  @Size(max = 64)
  private String name;
  @Size(max = 64)
  private String surname;
  @NotNull
  private LocalDate dateOfBirth;
  @NotNull
  private Ticket idTicket;
  @NotNull
  private Boolean ageAllowed = false;
  private Integer age;

  @Override
  public Model toModel() {
    return null;
  }
}