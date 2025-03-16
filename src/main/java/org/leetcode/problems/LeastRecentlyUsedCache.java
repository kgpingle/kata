package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

  public static void main(String[] args) {
    LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache();
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    cache.put(4, 40);
    cache.put(5, 50);
    System.out.println(cache.get(1)); // ✅ Should return 10
    cache.put(1, 100); // ✅ Should update, NOT evict anything
    cache.put(6, 60); // ✅ Evicts key=2
    System.out.println(cache.get(2)); // ✅ Should return -1 (evicted)
  }
  
  Map<Integer, Node> cache;
  Node head, tail;
  int capacity;
  int MAX_CAPACITY = 5;

  static class Node {

    int key, value;
    Node prev, next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public LeastRecentlyUsedCache() {
    this.cache = new HashMap<>();
    this.capacity = MAX_CAPACITY;
    this.head = new Node(-1, -1); // Dummy head
    this.tail = new Node(-1, -1); // Dummy tail
    head.next = tail;
    tail.prev = head;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      // Update existing value and move to tail
      Node node = cache.get(key);
      node.value = value;
      moveToTail(node);
      return;
    }
    if (cache.size() >= capacity) {
      evict();
    }
    // add in cache
    Node node = new Node(key, value);
    cache.put(key, node);
    addToTail(node);
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    Node node = cache.get(key);
    moveToTail(node);
    return node.value;
  }

  private void moveToTail(Node node) {
    removeNode(node);
    addToTail(node);
  }

  private void addToTail(Node node) {
    Node prev = tail.prev;
    prev.next = node;
    node.prev = prev;
    node.next = tail;
    tail.prev = node;
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void evict() {

    if (cache.isEmpty()) {
      return;
    }
    Node lruNode = head.next; // First node after dummy head is least recently used
    removeNode(lruNode);
    cache.remove(lruNode.key);
  }
}
