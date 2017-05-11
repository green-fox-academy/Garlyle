import java.util.ArrayList;
import java.util.List;

public class Potter {
  public final static double PRICE = 8.0;
  public final static double[] DISCOUNT = {0.0, 5.0, 10.0, 20.0, 25.0};

  public static double getPriceTag(List<Integer> shoppingCart) {
    List<Integer> bookTypes = new ArrayList<>();
    int uniqueBooks = 0;
    for (Integer i :shoppingCart) {
      if (!bookTypes.contains(i)) {
        bookTypes.add(i);
      } else {
        uniqueBooks++;
      }
    }
    double discount = DISCOUNT[bookTypes.size() - 1];

    return PRICE * (shoppingCart.size() - uniqueBooks) * (100.0 - discount) / 100.0 + uniqueBooks * PRICE;
  }
}
