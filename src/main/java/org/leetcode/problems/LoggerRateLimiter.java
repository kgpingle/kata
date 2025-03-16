package org.leetcode.problems;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoggerRateLimiter {

  Map<String, Integer> messageTimestamp = new ConcurrentHashMap<>();
  ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public LoggerRateLimiter() {
    scheduler.scheduleAtFixedRate(() -> {
      if (messageTimestamp.isEmpty()) {
        return;
      }
      messageTimestamp.entrySet()
          .removeIf(entry -> Instant.now().getEpochSecond() - entry.getValue() > 10);

    }, 10, 10, TimeUnit.SECONDS); // Runs every 10 seconds
  }

  public boolean rateLimit(int timestamp, String message) {
    if (timestamp - messageTimestamp.getOrDefault(message, -10) < 10) {
      return false;
    }
    System.out.println(message);
    messageTimestamp.put(message, timestamp);
    return true;

  }

  public void shutdown() {
    scheduler.shutdown();
  }

  public static void main(String[] args) {
    LoggerRateLimiter limiter = new LoggerRateLimiter();
    // call messages here.
    limiter.shutdown();
  }
}
