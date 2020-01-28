import java.util.List;

public class RegExDemo {
  public static void main(String[] args) {
    String re = "\\d{3,4}-\\d{7,8}";
    for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
      if (!s.matches(re)) {
        System.out.println("测试失败: " + s);
        return;
      }
    }
    for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
      if (s.matches(re)) {
        System.out.println("测试失败: " + s);
        return;
      }
    }
    System.out.println("测试成功!");
    System.out.println("AaAaAa".hashCode()); // 0x7460e8c0
    System.out.println("BBAaBB".hashCode()); // 0x7460e8c0
  }
}
