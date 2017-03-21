// Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000

public class Cuboid {
    public static void main(String[] args)
    {
        double x = 3.;
        double y = 4.;
        double z = 5.;

        double surfaceArea = ( x * y + x * z + y * z) * 2;
        double volume = x * y * z;

        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }
}
