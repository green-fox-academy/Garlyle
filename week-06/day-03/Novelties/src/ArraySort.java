import java.util.Arrays;

public class ArraySort {
  public static void main(String[] args) {
    Integer[] integers = {4, 3, 6, 2, 5, 1};
    Double[] doubles = {4.0, 3.0, 2.0, 5.0, 1.0};
    sortArray(integers);
    sortArray(doubles);
  }

  public static <T extends Number> void sortArray(T[] list) {
    Arrays.sort(list);
    for (int i = 0; i < list.length / 2; i++) {
      T temp = list[i];
      list[i] = list[list.length - (i + 1)];
      list[list.length - (i + 1)] = temp;
    }
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
