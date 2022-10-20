package it.esame.cinema.data.exception;

public class NoMoreSeats extends Exception{

  public NoMoreSeats(Integer idProjectionRoom) {
    super("No more seats!");
  }
}
