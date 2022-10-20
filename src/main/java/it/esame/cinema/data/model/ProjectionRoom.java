package it.esame.cinema.data.model;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.dto.ProjectionRoomDto;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
@Entity(name = "ProjectionRoom")
@Table(name = "projection_room")
public class ProjectionRoom implements Model {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "seats", nullable = false)
  private Integer seats;

  @NotNull
  @Column(name = "price", nullable = false)
  private Double price;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_film", nullable = false)
  private Film idFilm;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "seats = " + seats + ", " +
        "price = " + price + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ProjectionRoom that = (ProjectionRoom) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public ProjectionRoomDto toDto() {
    return ProjectionRoomDto.builder().id(id).seats(seats).price(price).idFilm(idFilm.toDto())
        .build();
  }
}