package it.esame.cinema.data.dto;

import it.esame.cinema.data.archetype.Dto;
import it.esame.cinema.data.enums.Genre;
import it.esame.cinema.data.model.Film;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private Genre genre;


  @Override
  public Film toModel() {
    return Film.builder().id(id).title(title).author(author).producer(producer).minAge(minAge)
        .maxAge(maxAge).filmLength(filmLength).genre(genre).build();
  }
}