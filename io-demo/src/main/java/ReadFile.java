import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadFile {
  public static void main(String[] args) {
    Rf rf = new Rf();
    rf.readFile(new File("./io-demo.iml"));
    rf.readFileToBuffer("./io-demo.iml");
  }
}

class Rf {
  public void readFile(File file) {
    try (InputStream input = new FileInputStream(file)) {
      int n;
      while ((n = input.read()) != -1) {
        System.out.println(n);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void readFileToBuffer(String path) {
    try (InputStream input = new FileInputStream(path)) {
      // 定义1000个字节大小的缓冲区:
      byte[] buffer = new byte[10];
      int n;
      while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
        System.out.println("read " + n + " bytes.");
        System.out.println(new String(buffer, StandardCharsets.UTF_8));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
