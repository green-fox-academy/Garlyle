public class Station {
  int gasAmount;

  public void refill(Car car)
  {
    int refillAmount = car.capacity - car.gasAmount;
    if (this.gasAmount < refillAmount) refillAmount = this.gasAmount;

    car.gasAmount += refillAmount;
  }

  public static void main(String[] args) {
    Station station = new Station();
    station.gasAmount = 42;

    Car car = new Car();
    station.refill(car);
    System.out.println(car.gasAmount);
  }
}
