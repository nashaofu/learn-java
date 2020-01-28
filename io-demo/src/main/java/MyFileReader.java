import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Locale;

public class MyFileReader {
  public static void main(String[] args) {
    try {
      readFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringWriter buffer = new StringWriter();
    try (PrintWriter pw = new PrintWriter(buffer)) {
      pw.println("Hello");
      pw.println(12345);
      pw.println(true);
    }
    System.out.println(buffer.toString());

    int n = 123400;
    // 123400
    System.out.println(n);
    // 1e208
    System.out.println(Integer.toHexString(n));
    // $123,400.00
    System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
    System.out.println(System.currentTimeMillis());
  }

  public static void readFile() throws IOException {
    try (Reader reader = new FileReader("./pom.xml", StandardCharsets.UTF_8)) {
      char[] buffer = new char[1000];
      int n;
      while ((n = reader.read(buffer)) != -1) {
        System.out.println("read " + n + " chars.");
      }
    }
  }
}
