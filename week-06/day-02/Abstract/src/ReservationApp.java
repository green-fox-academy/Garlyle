import reservation.Reservation;

import java.util.ArrayList;

public class ReservationApp {
  public static void main(String[] args) {
    ArrayList<Reservation> bookings = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      bookings.add(new Reservation());
    }
    for(Reservation r : bookings) {
      System.out.println(r);
    }
  }
}
