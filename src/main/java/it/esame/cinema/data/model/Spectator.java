package it.esame.cinema.data.model;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.dto.SpectatorDto;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Spectator")
@Table(name = "spectator")
public class Spectator implements Model {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 64)
  @Column(name = "name", length = 64)
  private String name;

  @Size(max = 64)
  @Column(name = "surname", length = 64)
  private String surname;

  @NotNull
  @Column(name = "date_of_birth", nullable = false)
  private LocalDate dateOfBirth;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_ticket", nullable = false)
  private Ticket idTicket;

  @NotNull
  @Column(name = "age_allowed", nullable = false)
  private Boolean ageAllowed = false;

  @Column(name = "age")
  private Integer age;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "name = " + name + ", " +
        "surname = " + surname + ", " +
        "dateOfBirth = " + dateOfBirth + ", " +
        "ageAllowed = " + ageAllowed + ", " +
        "age = " + age + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Spectator spectator = (Spectator) o;
    return id != null && Objects.equals(id, spectator.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public SpectatorDto toDto() {
    return SpectatorDto.builder().id(id).name(name).surname(surname).dateOfBirth(dateOfBirth)
        .idTicket(idTicket).ageAllowed(ageAllowed).age(age).build();
  }
}