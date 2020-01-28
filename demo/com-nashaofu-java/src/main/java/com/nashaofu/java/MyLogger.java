package com.nashaofu.java;
import java.util.logging.Logger;

public final class MyLogger {
  private Logger logger;
  private String groupId;
  char a = '1';
  public MyLogger(String groupId) {
    this.logger = Logger.getGlobal();
    this.groupId = groupId;
  }

  public void info(String msg) {
    this.logger.info(msg);
  }

  protected void warning(String msg) {
    this.logger.warning(msg);
    logger.fine("ignored.");
    logger.severe("process will be terminated...");
  }
}
