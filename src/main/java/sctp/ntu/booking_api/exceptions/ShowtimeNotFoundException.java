package sctp.ntu.booking_api.exceptions;

public class ShowtimeNotFoundException extends RuntimeException {
  public ShowtimeNotFoundException(int sid) {
    super("Could not find showtime with id: " + sid + ".");
  }
}
