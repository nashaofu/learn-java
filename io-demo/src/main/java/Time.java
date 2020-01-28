import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Time {
  public static void main(String[] args) {
    // 获取当前时间:
    Date date = new Date();
    System.out.println(date.getYear() + 1900); // 必须加上1900
    System.out.println(date.getMonth() + 1); // 0~11，必须加上1
    System.out.println(date.getDate()); // 1~31，不能加1
    // 转换为String:
    System.out.println(date.toString());
    // 转换为GMT时区:
    System.out.println(date.toGMTString());
    // 转换为本地时区:
    System.out.println(date.toLocaleString());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    System.out.println(sdf.format(date));

    // 获取当前时间:
    Calendar c = Calendar.getInstance();
    int y = c.get(Calendar.YEAR);
    int m = 1 + c.get(Calendar.MONTH);
    int d = c.get(Calendar.DAY_OF_MONTH);
    int w = c.get(Calendar.DAY_OF_WEEK);
    int hh = c.get(Calendar.HOUR_OF_DAY);
    int mm = c.get(Calendar.MINUTE);
    int ss = c.get(Calendar.SECOND);
    int ms = c.get(Calendar.MILLISECOND);
    System.out.println(y + "/" + m + "/" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

    String[] timeIds = TimeZone.getAvailableIDs();

    System.out.println(timeIds.length);
  }
}
