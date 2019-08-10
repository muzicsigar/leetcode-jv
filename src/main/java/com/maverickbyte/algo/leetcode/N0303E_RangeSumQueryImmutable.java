package com.maverickbyte.algo.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javafx.util.Pair;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0303E_RangeSumQueryImmutable {


}

class NumArray1 {

  private int[] nums;

  public NumArray1(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum += this.nums[k];
    }
    return sum;
  }
}

class NumArray2 {

  private static final Map<Map.Entry<Integer, Integer>, Integer> map = new HashMap<>();

  static class Key<K, V> implements Map.Entry<K, V> {

    private K k;
    private V v;

    private Key(K k, V v) {
      this.k = k;
      this.v = v;
    }

    static <K, V> Key<K, V> of(K k, V v) {
      return new Key<>(k, v);
    }
    @Override
    public K getKey() {
      return k;
    }

    @Override
    public V getValue() {
      return v;
    }

    @Override
    public V setValue(V value) {
      V old = this.v;
      this.v = value;
      return old;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Key<?, ?> key = (Key<?, ?>) o;
      return Objects.equals(k, key.k) &&
        Objects.equals(v, key.v);
    }

    @Override
    public int hashCode() {
      return Objects.hash(k, v);
    }
  }

  public NumArray2(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        map.put(Key.of(i, j), sum);
      }
    }
  }

  public int sumRange(int i, int j) {
    return map.get(Key.of(i, j));
  }
}

class NumArray3 {
  private int[] nums;

  public NumArray3(int[] nums) {
    this.nums = nums;
    for (int i = 1; i < this.nums.length; i++) {
      nums[i] += nums[i - 1];
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return nums[j];
    }
    return nums[j] - nums[i - 1];
  }

}
