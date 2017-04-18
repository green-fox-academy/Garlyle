import creditcard.*;
import reservation.*;

public class CreditCardReservation implements CreditCardy, Reservationy{
  String code;
  int dayOfReservation;
  String cc;
  String owner;

  public CreditCardReservation(String name) {
    code = new String();
    for (int i = 0; i < 8; i++) {
      code += CHARS.charAt((int)(Math.random() * CHARS.length()));
    }
    dayOfReservation = (int)(Math.random() * DOW.length);
    owner = name;
    cc = new String();
    for (int i = 0; i < 16; i++) {
      cc += (int)(Math.random() * 10);
    }
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
    return "Booking# " + getCodeBooking() + " for " + getDowBooking() + " paid by Name=" +
        getNameCardholder() + " CC#=" + getCodeAccount() + " CVV=" + getSumCVV();
  }

  @Override
  public int getSumCVV() {
    int cvv = 0;
    for (int i = 0; i < cc.length(); i++) {
      cvv += (int)cc.charAt(i) - '0';
    }
    return cvv;
  }

  @Override
  public String getNameCardholder() {
    return owner;
  }

  @Override
  public String getCodeAccount() {
    return cc;
  }

  @Override
  public int cumeSumCVV(String codeAccount) {
    return 0;
  }
}
