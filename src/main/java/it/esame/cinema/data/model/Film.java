package it.esame.cinema.data.model;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.archetype.Model;
import it.esame.cinema.data.dto.FilmDto;
import it.esame.cinema.data.enums.Genre;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "Film")
@Table(name = "film")
public class Film implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 64)
  @Column(name = "title", length = 64)
  private String title;

  @Size(max = 64)
  @Column(name = "author", length = 64)
  private String author;

  @Size(max = 64)
  @Column(name = "producer", length = 64)
  private String producer;

  @NotNull
  @Column(name = "min_age", nullable = false)
  private Integer minAge;

  @NotNull
  @Column(name = "max_age", nullable = false)
  private Integer maxAge;

  @Column(name = "film_length")
  private Double filmLength;

  @Column(name = "genre")
  private Genre genre;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "title = " + title + ", " +
        "author = " + author + ", " +
        "producer = " + producer + ", " +
        "minAge = " + minAge + ", " +
        "maxAge = " + maxAge + ", " +
        "filmLength = " + filmLength + ", " +
        "genre = " + genre + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Film film = (Film) o;
    return id != null && Objects.equals(id, film.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public FilmDto toDto() {
    return FilmDto.builder().id(id).title(title).author(author).producer(producer).minAge(minAge).maxAge(maxAge).filmLength(filmLength).genre(genre).build();
  }
}