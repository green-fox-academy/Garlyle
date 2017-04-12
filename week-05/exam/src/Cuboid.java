public class Cuboid {
  // Create a class that represents a cuboid:
  // It should take its three dimensions as constructor parameters (numbers)
  // It should have a method called `getSurface` that returns the cuboid's surface
  // It should have a method called `getVolume` that returns the cuboid's volume
  int width, height, length;

  public Cuboid(int width, int height, int length) {
    this.width = width;
    this.height = height;
    this.length = length;
  }

  public int getSurface() {
    return 2 * (width * length + length * height + height * width);
  }

  public int getVolume() {
    return width * length * height;
  }

  public static void main(String[] args) {
    Cuboid testCuboid = new Cuboid(4, 5, 10);

    System.out.println("Surface: " + testCuboid.getSurface());
    System.out.println("Volume: " + testCuboid.getVolume());
  }
}
