import java.util.ArrayList;

public class SharpieSet {
  ArrayList<Sharpie> sharpieSet;

  public SharpieSet()
  {
    sharpieSet = new ArrayList<>();
  }

  public void add(Sharpie sharpie)
  {
    sharpieSet.add(sharpie);
  }

  public int countUsable()
  {
    int count = 0;
    for (Sharpie sharpie : this.sharpieSet)
    {
      if (sharpie.inkAmount > 0.f)
        count++;
    }
    return count;
  }

  public void removeTrash()
  {
    int i = 0;
    while (i < sharpieSet.size())
    {
      if (sharpieSet.get(i).inkAmount <= 0.f)
      {
        sharpieSet.remove(i);
      }
      else
      {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    SharpieSet sharpies = new SharpieSet();

    Sharpie emptySharpie = new Sharpie("Green", 16.f);
    emptySharpie.inkAmount = 1.f;
    emptySharpie.use();

    sharpies.add(new Sharpie("blue", 3.f));
    sharpies.add(emptySharpie);
    sharpies.add(emptySharpie);
    sharpies.add(new Sharpie("Blue. No, yel...", 5.f));
    sharpies.add(emptySharpie);

    System.out.println(sharpies.countUsable() + " " + sharpies.sharpieSet.size());
    sharpies.removeTrash();
    System.out.println(sharpies.countUsable() + " " + sharpies.sharpieSet.size());
  }
}
