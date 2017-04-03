public class Animal {
  int hunger;
  int thirst;

  public Animal()
  {
    hunger = thirst = 50;
  }

  public void eat()
  {
    hunger--;
  }

  public void drink()
  {
    thirst--;
  }

  public void play()
  {
    hunger++;
    thirst++;
  }
}
