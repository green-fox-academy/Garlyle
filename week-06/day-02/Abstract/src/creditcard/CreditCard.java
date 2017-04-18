package creditcard;

public class CreditCard implements CreditCardy {
  String cc;
  String owner;

  public CreditCard(String name) {
    owner = name;
    cc = new String();
    for (int i = 0; i < 16; i++) {
      cc += (int)(Math.random() * 10);
    }
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

  @Override
  public String toString() {
    return "Name=" + getNameCardholder() + " CC#=" + getCodeAccount() + " CVV=" + getSumCVV();
  }
}
