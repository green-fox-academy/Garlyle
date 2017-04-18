import java.util.ArrayList;

public class CreditCardReservationApp {
  public static void main(String[] args) {
    ArrayList<CreditCardReservation> reservations = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      reservations.add(new CreditCardReservation("DEF" + i));
    }
    for (CreditCardReservation reservation : reservations) {
      System.out.println(reservation);
    }
  }
}
