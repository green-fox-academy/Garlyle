package Garden;

public class Tree extends Plant {
  Tree(String color)
  {
    super(color, 10, 40.f);
  }

  public String getType()
  {
    return "Tree";
  }
}
