package com.maverickbyte.algo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0146M_LRUCache1 extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  public N0146M_LRUCache1(int initialCapacity, int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }
}
