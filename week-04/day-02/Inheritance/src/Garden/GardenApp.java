package Garden;

public class GardenApp {
  public static void main(String[] args) {
    Garden myGarden = new Garden();

    myGarden.addPlant(new Flower("yellow"));
    myGarden.addPlant(new Flower("blue"));
    myGarden.addPlant(new Tree("purple"));
    myGarden.addPlant(new Tree("orange"));

    myGarden.printState();
    myGarden.waterGarden(40);
    myGarden.waterGarden(70);
  }
}
