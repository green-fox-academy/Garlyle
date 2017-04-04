package Garden;

public class Flower extends Plant{
  Flower(String color)
  {
    super(color, 5, 75.f);
  }

  public String getType()
  {
    return "Flower";
  }
}
