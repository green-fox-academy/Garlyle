import java.awt.*;
import java.util.ArrayList;

public class TreesWithClasses {
  String type;
  Color color;
  int age;
  String sex;

  public TreesWithClasses(String type, Color color, int age, String sex)
  {
    this.type = type;
    this.color = color;
    this.age = age;
    this.sex = sex;
  }

  public static void main(String[] args) {
    ArrayList<TreesWithClasses> trees = new ArrayList<>();

    trees.add(new TreesWithClasses("tannenbaum", Color.green, 42, "female"));
    trees.add(new TreesWithClasses("lemon", Color.yellow, 22, "male"));
    trees.add(new TreesWithClasses("sherman", Color.red, 2000, "mixed"));
    trees.add(new TreesWithClasses("austinus", Color.blue, 20, "yes, please"));
    trees.add(new TreesWithClasses("burned", Color.black, 200, "mutating"));

    for (TreesWithClasses tree : trees)
    {
      System.out.println("[" + tree.type + ", " + tree.age + ", " + tree.sex + "]");
    }

  }
}
