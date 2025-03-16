package org.leetcode.problems;

import java.time.Instant;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class SlidingWindowRateLimiter {

  private int maxRequests;
  private Long timeWindowInSeconds;
  Map<UUID, Deque<Long>> requestLog;

  public SlidingWindowRateLimiter(int maxRequests, Long timeWindowInSeconds) {
    this.maxRequests = maxRequests;
    this.timeWindowInSeconds = timeWindowInSeconds;
    this.requestLog = new HashMap<>();
  }

  public boolean allowRequest(UUID userId) {
    requestLog.putIfAbsent(userId, new LinkedList<>());
    Deque<Long> userRequestLogs = requestLog.get(userId);
    long nowInSeconds = Instant.now().getEpochSecond();
    while (!userRequestLogs.isEmpty() && userRequestLogs.peekFirst() < (nowInSeconds
        - timeWindowInSeconds)) {
      userRequestLogs.pollFirst();
    }

    if (userRequestLogs.size() > maxRequests) {
      return false;
    }
    userRequestLogs.offerLast(nowInSeconds);
    return true;
  }

  public static void main(String[] args) {
    SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(3,
        2L); // 3 requests per 10 seconds
    UUID userId = UUID.randomUUID();
    assert rateLimiter.allowRequest(userId); // true
    assert rateLimiter.allowRequest(userId); // true
    assert rateLimiter.allowRequest(userId); // true
    assert !rateLimiter.allowRequest(userId); // false (Rate limit exceeded)
    try {
      Thread.sleep(3000); // Wait 3 seconds
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assert rateLimiter.allowRequest(userId); // true
  }
}
