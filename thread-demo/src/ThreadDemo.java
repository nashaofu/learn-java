public class ThreadDemo {
  public static void main(String[] args) {
    System.out.println("main start...");
    Thread t = new Thread() {
      public void run() {
        System.out.println("thread run...");
        System.out.println("thread end.");
      }
    };
    t.start();
    System.out.println("main end...");

    sleep();
  }

  public static void sleep() {
    System.out.println("main start...");
    Thread t = new Thread() {
      public void run() {
        System.out.println("thread run...");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("thread end.");
      }
    };
    t.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
    System.out.println("main end...");
  }
}
