import java.util.ArrayList;

public class Farm {
  ArrayList<Animal> farmAnimals;
  int slots;

  public Farm()
  {
    slots = 5;
    farmAnimals = new ArrayList<>();
  }

  public void breed()
  {
    if (slots > 0)
    {
      slots--;
      farmAnimals.add(new Animal());
    }
  }

  public void slaughter()
  {
    Animal leastHungryAnimal = farmAnimals.get(0);
    for (Animal animal : farmAnimals)
    {
      if (animal.hunger < leastHungryAnimal.hunger)
        leastHungryAnimal = animal;
    }

    farmAnimals.remove(leastHungryAnimal);
    slots++;
  }

  public static void main(String[] args) {
    Farm myLittleFarm = new Farm();
    myLittleFarm.breed();
    for (Animal animal : myLittleFarm.farmAnimals)
    {
      animal.eat();
    }
    myLittleFarm.breed();
    myLittleFarm.slaughter();

    System.out.println(myLittleFarm.slots);
  }
}
