import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8Time {
  public static void main(String[] args) {
    LocalDate d = LocalDate.now(); // 当前日期
    LocalTime t = LocalTime.now(); // 当前时间
    LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
    System.out.println(d); // 严格按照ISO 8601格式打印
    System.out.println(t); // 严格按照ISO 8601格式打印
    System.out.println(dt); // 严格按照ISO 8601格式打印


    // 自定义格式化:
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    System.out.println(dtf.format(LocalDateTime.now()));

    // 用自定义格式解析:
    LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
    System.out.println(dt2);

    var time = LocalDateTime.of(2019,12,29, 2,33);
    System.out.println("yyyy与YYYY的bug：");
    System.out.println(DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss").format(time));
    System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(time));

    op();
    FlightTime ft = new FlightTime();
    ft.run();
  }

  public static void op() {
    LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
    System.out.println(dt);
    // 加5天减3小时:
    LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
    System.out.println(dt2); // 2019-10-31T17:30:59
    // 减1月:
    LocalDateTime dt3 = dt2.minusMonths(1);
    System.out.println(dt3); // 2019-09-30T17:30:59
  }
}


class FlightTime {
  public void run() {
    LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
    int hours = 13;
    int minutes = 20;
    LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
    System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
    // test:
    if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
      .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
      System.err.println("测试失败!");
    } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
      .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
      System.err.println("测试失败!");
    }
  }

  public LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
    System.out.print("出发 北京时间：");
    System.out.print(bj);
    System.out.println();
    ZonedDateTime timeInbj = ZonedDateTime.of(bj, ZoneId.of("Asia/Shanghai"));
    ZonedDateTime time = timeInbj.plusHours(h).plusMinutes(m).withZoneSameInstant(ZoneId.of("America/New_York"));
    System.out.print("到达 纽约时间：");
    System.out.print(time.toLocalDateTime());
    System.out.println();
    return time.toLocalDateTime();
  }
}
