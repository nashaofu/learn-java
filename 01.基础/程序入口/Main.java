package main;
import java.util.Arrays;
import java.lang.Integer;
import java.util.Random;
import java.security.SecureRandom;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {
  public static void main(String[] args) {
    String s = new String("hello2你好");
    try {
      System.out.println(Arrays.toString(s.getBytes("gbk")));
    } catch (UnsupportedEncodingException e) {
      System.out.println("报错了");
    } finally {
      System.out.println("finally");
    }
    System.out.println(s);
    s = s.toUpperCase();
    System.out.println(s);
    System.out.println("hello world");
    Main.scores();

    int i = 100;
    // 通过静态方法valueOf(int)创建Integer实例:
    Integer n2 = Integer.valueOf(i);
    // 通过静态方法valueOf(String)创建Integer实例:
    Integer n3 = Integer.valueOf("100");
    System.out.println(n3.intValue());

    random();

  }

  static void scores() {
    int[] scores = new int[] { 88, 77, 51, 66 };
    Score s = new Score(scores);
    s.printScores();
    scores[2] = 99;
    s.printScores();
  }

  static void random () {
    Random r = new Random(12345);
    int[] arr = new int[10];
    for (int i = 0; i < 10; i++) {
        arr[i] = r.nextInt(100);
    }
    System.out.println(Arrays.toString(arr));

    SecureRandom sr = null;
    try {
        sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
    } catch (NoSuchAlgorithmException e) {
        sr = new SecureRandom(); // 获取普通的安全随机数生成器
    }
    byte[] buffer = new byte[16];
    sr.nextBytes(buffer); // 用安全随机数填充buffer
    System.out.println(Arrays.toString(buffer));

  }
}

class Score {
  private int[] scores;
  public Score(int[] scores) {
    this.scores = Arrays.copyOf(scores, scores.length);
  }

  public void printScores() {
    System.out.println(Arrays.toString(scores));
  }
}
