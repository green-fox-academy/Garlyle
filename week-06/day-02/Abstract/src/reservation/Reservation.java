package reservation;

public class Reservation implements Reservationy {
  String code;
  int dayOfReservation;

  public Reservation() {
    code = new String();
    for (int i = 0; i < 8; i++) {
      code += CHARS.charAt((int)(Math.random() * CHARS.length()));
    }
    dayOfReservation = (int)(Math.random() * DOW.length);
  }

  @Override
  public String getDowBooking() {
    return DOW[dayOfReservation];
  }

  @Override
  public String getCodeBooking() {
    return code;
  }

  @Override
  public String toString() {
    return "Booking# " + getCodeBooking() + " for " + getDowBooking();
  }
}
