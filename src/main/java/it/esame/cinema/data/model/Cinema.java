package it.esame.cinema.data.model;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
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
@Entity(name = "Cinema")
@Table(name = "cinema")
public class Cinema implements Model {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_projection_room", nullable = false)
  private ProjectionRoom idProjectionRoom;

  @NotNull
  @Column(name = "total_incoming", nullable = false)
  private Double totalIncoming;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "totalIncoming = " + totalIncoming + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Cinema cinema = (Cinema) o;
    return id != null && Objects.equals(id, cinema.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public Dto toDto() {
    return null;
  }
}