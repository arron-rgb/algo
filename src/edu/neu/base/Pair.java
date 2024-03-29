package edu.neu.base;

/**
 * @author arronshentu
 */
public class Pair<K, V> {
  K key;
  V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Pair{" + "key=" + key + ", value=" + value + '}';
  }
}
