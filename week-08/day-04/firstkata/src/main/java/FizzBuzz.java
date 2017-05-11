public class FizzBuzz {
  public static String doFizzBuzz(int num) {
    if (num == 0) {
      return "0";
    }
    return (num % 5 == 0 && num % 3 == 0)? "FizzBuzz" :
          (num % 5 == 0)? "Buzz" :
          (num % 3 == 0)? "Fizz" : new Integer(num).toString();
  }
}
