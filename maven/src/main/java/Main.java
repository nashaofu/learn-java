public class Main {
  public static void main(String[] args) {
    System.out.println("hello");
  }
  public static long fact(long n) {
    long val=1;
    while (n > 1) {
      val*=n;
      n--;
    }
    return val;
  }
}
