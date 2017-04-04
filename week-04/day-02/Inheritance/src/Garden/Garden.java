package Garden;

import java.util.ArrayList;

class Garden {
  private ArrayList<Plant> plantsInGarden;

  Garden()
  {
    plantsInGarden = new ArrayList<Plant>();
  }

  void addPlant(Plant plant)
  {
    plantsInGarden.add(plant);
  }

  void waterGarden(double waterAmount)
  {
    System.out.println("Watering with " + (int)waterAmount);

    int count = 0;
    for (Plant plant : plantsInGarden)
    {
      if (plant.needsWater())
        count++;
    }
    waterAmount /= count;

    for (Plant plant : plantsInGarden)
    {
      if (plant.needsWater())
        plant.absorbWater(waterAmount);
    }
    printState();
  }

  void printState()
  {
    for (Plant plant : plantsInGarden)
    {
      plant.info();
    }
    System.out.println();
  }
}
