package AircraftCarrier;


public class AircraftCarrierApp {
  public static void main(String[] args)
  {
    Carrier bigCarrier = new Carrier(60);

    bigCarrier.addAircraft("F35");
    bigCarrier.addAircraft("F16");
    bigCarrier.addAircraft("F16");
    bigCarrier.addAircraft("F35");
    bigCarrier.addAircraft("F16");
    bigCarrier.addAircraft("F35");
    bigCarrier.addAircraft("F35");
    bigCarrier.addAircraft("F16");

    bigCarrier.fill();
    bigCarrier.getStatus();
  }
}
