package edu.neu.base;

import java.util.*;
import java.util.function.*;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int i = main.maxConsecutive(6, 8, new int[] {6, 7, 8});
    System.out.println(i);
    System.out.println(main.largestCombination(new int[] {2, 3, 4}));
  }

  public List<Integer> replaceNonCoprimes(int[] nums) {
    LinkedList<Integer> res = new LinkedList<>();
    for (int a : nums) {
      while (true) {
        int last = res.isEmpty() ? 1 : res.getLast();
        int x = gcd(last, a);
        if (x == 1)
          break; // co-prime
        a *= res.removeLast() / x;
      }
      res.add(a);
    }
    return res;
  }

  private int gcd(int a, int b) {
    return b > 0 ? gcd(b, a % b) : a;
  }

  public int maxConsecutive(int bottom, int top, int[] special) {
    int pre = bottom;
    int n = special.length;
    int max = Math.max(special[0] - bottom, top - special[n - 1]);
    // bottom [n1, n2, ..., nn] top
    Arrays.sort(special);
    for (int j : special) {
      max = Math.max(j - pre - 1, max);
      pre = j;
    }
    return max;
  }

  public int largestCombination(int[] candidates) {
    int[] count = new int[32];
    for (int n : candidates) {
      for (int i = 0; i < 32 && n != 0; i++) {
        count[i] += n & 1;
        n = n >> 1;
      }
    }
    int largest = 0;
    for (int m : count) {
      largest = Math.max(largest, m);
    }
    BinaryOperator<String> compare = BinaryOperator.maxBy(Comparator.comparingInt(String::length));
    String apply = compare.apply("123", "2");
    System.out.println(apply);
    BiPredicate<String, String> predict = (String s1, String s2) -> true;
    BiFunction<String, String, Boolean> function = (String s1, String s2) -> true;
    BinaryOperator<Integer> sum = (a, b) -> a + b;
    BooleanSupplier a = () -> false;
    return largest;
  }

  class CountIntervals {

    // key, value = left, right
    TreeMap<Integer, Integer> tm;
    int cnt = 0;

    public CountIntervals() {
      tm = new TreeMap<>();
    }

    public void add(int left, int right) {

      int l = left;
      int r = right;
      while (!(tm.floorKey(r) == null || tm.get(tm.floorKey(r)) < l)) {
        // find overlay
        int preL = tm.floorKey(r);
        int preR = tm.get(preL);
        cnt -= (preR - preL + 1);
        tm.remove(preL);
        // merge
        l = Math.min(l, preL);
        r = Math.max(r, preR);
      }
      tm.put(l, r);
      cnt += (r - l + 1);
    }

    public int count() {
      return cnt;
    }
  }
}
