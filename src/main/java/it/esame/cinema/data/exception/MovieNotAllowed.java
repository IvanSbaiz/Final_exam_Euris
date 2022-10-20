package it.esame.cinema.data.exception;

public class MovieNotAllowed extends Exception {

  public MovieNotAllowed(Integer idFilm) {
    super("Movie not allowed");
  }

}
