package org.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {

  ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  List<Integer> values = new ArrayList<>();
  Map<Integer, Integer> valuesToIndex = new HashMap<>();

  public void insert(int val) {
    lock.writeLock().lock();
    try {
      values.add(val);
      valuesToIndex.put(val, values.size() - 1);
    } finally {
      lock.writeLock().unlock();
    }
  }

  public void remove(int val) {
    lock.writeLock().lock();
    try {
      if (values.isEmpty()) {
        return;
      }
      Integer indexToRemove = valuesToIndex.get(val);
      if (indexToRemove == null) {
        return;
      }
      Integer last = values.getLast();
      values.set(indexToRemove, last);
      values.removeLast();
      valuesToIndex.put(last, indexToRemove);
      valuesToIndex.remove(val);
    } finally {
      lock.writeLock().unlock();
    }
  }

  public int getRandom() {
    lock.readLock().lock();
    try {
      if (values.isEmpty()) {
        return -1;
      }
      Random random = new Random();
      return values.get(random.nextInt(values.size()));
    } finally {
      lock.readLock().unlock();
    }
  }
}
