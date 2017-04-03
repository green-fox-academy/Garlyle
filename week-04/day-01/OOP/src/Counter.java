/**
 * Created by Milan Kovacs on 2017. 04. 03..
 */
public class Counter {
  int count;
  int initialValue;

  public Counter()
  {
    count = initialValue = 0;
  }

  public Counter(int number)
  {
    count = initialValue = number;
  }

  public void add(int number)
  {
    count += number;
  }

  public void add()
  {
    count++;
  }

  public int get()
  {
    return count;
  }

  public void reset()
  {
    count = initialValue;
  }
}
