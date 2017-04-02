import java.awt.*;
import java.util.*;

public class TreesHomework {
  public static void main(String[] args) {
    ArrayList<HashMap<String, Object>> treesMap = new ArrayList<HashMap<String, Object>>();

    treesMap.add(createTree("tannenbaum", Color.green, 42, "female"));
    treesMap.add(createTree("lemon", Color.yellow, 22, "male"));
    treesMap.add(createTree("sherman", Color.red, 2000, "mixed"));
    treesMap.add(createTree("austinus", Color.blue, 20, "yes, please"));
    treesMap.add(createTree("burned", Color.black, 200, "mutating"));

    System.out.println(treesMap);
  }

  private static HashMap<String,Object> createTree(String type, Color color, int age, String sex) {
    HashMap<String, Object> newTree = new HashMap<String, Object>();

    newTree.put("type", type);
    newTree.put("leaf color", color);
    newTree.put("age", age);
    newTree.put("sex", sex);

    return newTree;
  }
}
