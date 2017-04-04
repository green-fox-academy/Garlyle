package AircraftCarrier;


public class AircraftCarrierApp {
  public static void main(String[] args) {
    Aircraft first = new F16();
    Aircraft second = new F35();
    first.refill(10);
    second.refill(10);
    System.out.println(first.getStatus());
    System.out.println(second.getStatus());
  }
}
