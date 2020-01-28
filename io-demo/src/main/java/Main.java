import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Path path = Paths.get(".");
    System.out.println(path.toAbsolutePath().normalize());
    for (Path p : Paths.get(".").toAbsolutePath()) { // 可以直接遍历Path
      System.out.println("  " + p);
    }
    print("./src");
  }

  private static void print(String path) {
    Path p = Paths.get(path);
    File file = p.toFile();
    dir(file, 0);
  }

  private static void print() {
    print(".");
  }

  private static void dir(File file, int indent) {
    String s = "";
    int indent2 = indent;
    while (indent2 > 0) {
      indent2--;
      s += " ";
    }
    System.out.println(s + file.getName() + "/");
    File[] files = file.listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.isDirectory()) {
          dir(f, indent + 2);
        } else {
          System.out.println(s + "  " + f.getName());
        }
      }
    }
  }
}
