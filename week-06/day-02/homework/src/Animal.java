public abstract class Animal {
  String name;
  int age;

  Animal(String name) {
    this.name = name;
    age = 0;
  }

  void greet() {

  }

  public String getName() {
    return name;
  }

  public String wantChild()  {
    return "want a child from an egg!";
  }
}
