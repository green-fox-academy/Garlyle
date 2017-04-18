public class CharOperations implements CharSequence {
  String forwardString;
  public static void main(String[] args) {
    CharOperations line = new CharOperations("ymedacA xofneerG");
    System.out.println(line);
    System.out.println(line.subSequence(5,7));
  }

  CharOperations(String line) {
    forwardString = line;
  }

  @Override
  public int length() {
    return forwardString.length();
  }

  @Override
  public char charAt(int index) {
    return forwardString.charAt(forwardString.length() - (index + 1));
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    String s = new String();
    for (int i = start; i <= end; i++) {
      s += charAt(i);
    }
    return s;
  }

  @Override
  public String toString() {
    return subSequence(0, forwardString.length() - 1).toString();
  }
}
