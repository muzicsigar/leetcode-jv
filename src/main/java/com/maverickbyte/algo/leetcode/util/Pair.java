package com.maverickbyte.algo.leetcode.util;

import java.util.Map;
import java.util.Objects;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Pair<K, V> implements Map.Entry<K, V> {

  private K k;
  private V v;

  private Pair(K k, V v) {
    this.k = k;
    this.v = v;
  }

  public static <K, V> Pair<K, V> of(K k, V v) {
    return new Pair<>(k, v);
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

  public void setKey(K key) {
    this.k = key;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(k, pair.k) &&
      Objects.equals(v, pair.v);
  }

  @Override
  public int hashCode() {
    return Objects.hash(k, v);
  }
}
