public class Factorial {
  public static void main(String[] args) {
    long val = fact(10);
    System.out.println(val);
  }
  public static long fact(long n) {
    long val = 1;
    while (n > 1) {
      val *= n;
      n--;
    }
    return val;
  }
}
