package edu.neu.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author arronshentu
 */
public class MonotonicQueue {

  public static void main(String[] args) {
    MonotonicQueue monotonicQueue = new MonotonicQueue();
    int[] test = monotonicQueue.test(new int[] {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}, 3);
    System.out.println(Arrays.toString(test));
  }

  int[] test(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int n = nums.length;
    int[] res = new int[n - k + 1];
    for (int i = 0; i < n; i++) {
      // 左边出，保证窗口大小为k
      while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
        deque.pollFirst();
      }
      // 右边出，保证新元素进入后队列仍有序
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      res[i] = deque.peekFirst();
    }
    return res;
  }
}
