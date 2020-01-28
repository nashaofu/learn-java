import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {
  public static void main(String[] args) throws IOException {
    writeFile();
    writeFile2();
  }
  public static void writeFile() throws IOException {
    OutputStream output = new FileOutputStream("readme.txt");
    output.write(72); // H
    output.write(101); // e
    output.write(108); // l
    output.write(108); // l
    output.write(111); // o
    output.close();
  }

  public static void writeFile2() throws IOException {
    try (OutputStream output = new FileOutputStream("readme2.txt")) {
      output.write("Hello".getBytes("UTF-8")); // Hello
    } // 编译器在此自动为我们写入finally并调用close()
  }
}
