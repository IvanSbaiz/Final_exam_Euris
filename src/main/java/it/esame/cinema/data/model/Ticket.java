package it.esame.cinema.data.model;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.dto.TicketDto;
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
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket implements Model {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "price", nullable = false)
  private Double price;

  @NotNull
  @Column(name = "discount_elderly", nullable = false)
  private Double discountElderly;

  @NotNull
  @Column(name = "discount_children", nullable = false)
  private Double discountChildren;

  @Size(max = 128)
  @NotNull
  @Column(name = "seat_position", nullable = false, length = 128)
  private String seatPosition;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_film", nullable = false)
  private Film idFilm;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_projection_room", nullable = false)
  private ProjectionRoom idProjectionRoom;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "price = " + price + ", " +
        "discountElderly = " + discountElderly + ", " +
        "discountChildren = " + discountChildren + ", " +
        "seatPosition = " + seatPosition + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return id != null && Objects.equals(id, ticket.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }


  @Override
  public TicketDto toDto() {
    return TicketDto.builder().id(id).price(price).discountElderly(discountElderly)
        .discountChildren(discountChildren).seatPosition(seatPosition).idFilm(idFilm.toDto())
        .idProjectionRoom(idProjectionRoom.toDto()).build();
  }
}