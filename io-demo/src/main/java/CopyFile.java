import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
  public static void main(String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException();
    }
    String source = args[0];
    String target = args[1];
    copy(source, target);
    System.out.println("文件【" + source + "】成功拷贝到【" + target + "】");
  }

  public static void copy(String source, String target) {
    try (OutputStream output = new FileOutputStream(target)) {
      // 编译器在此自动为我们写入finally并调用close()
      try (InputStream input = new FileInputStream(source)) {
        byte[] buffer = new byte[100];
        int n;
        while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
          System.out.println(n + ":" + buffer.length);
          output.write(buffer, 0, n);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
