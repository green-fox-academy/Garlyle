package Garden;

class Plant {
  private double waterRequirement;
  private double waterAmount;
  private double absorbPercentage;

  private String color;

  Plant(String color, double waterRequirement, double absorbPercentage)
  {
    this.color = color;
    this.waterRequirement = waterRequirement;
    this.absorbPercentage = absorbPercentage;
    this.waterAmount = 0.f;
  }

  boolean needsWater()
  {
    return waterAmount < waterRequirement;
  }

  void absorbWater(double water)
  {
    waterAmount += water * absorbPercentage / 100;
  }

  String getType()
  {
    return "Plant";
  }

  void info()
  {
    System.out.println("The " + color + " " + getType() + (needsWater()? "" : " doesnt") + " need water");
  }
}
