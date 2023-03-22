package edu.neu.base;

import edu.neu.util.InputUtil;

import java.util.*;

/**
 * @author arronshentu
 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void print() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    if (hasCycle()) {
      return "List has cycle";
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(val);
    ListNode index = next;
    while (index != null) {
      stringBuilder.append(" -> ").append(index.val);
      index = index.next;
    }
    return stringBuilder.toString();
  }

  private boolean hasCycle() {
    ListNode fast = this, slow = this;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static ListNode empty() {
    return null;
  }

  class Solution {

    public int beautifulSubsets(int[] nums, int k) {
      Arrays.sort(nums);
      int n = nums.length;
      int[][] dp = new int[n + 1][1 << n];
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < (1 << n); j++) {
          dp[i][j] = dp[i - 1][j];
          if ((j & (1 << (i - 1))) != 0) { // 如果 j 的第 i 位为 1，则选择 nums[i-1]
            int mask = j ^ (1 << (i - 1)); // 得到除了第 i 位为 1 的二进制状态
            for (int k1 = mask; k1 > 0; k1 = (k1 - 1) & mask) { // 枚举所有合法的状态 k1
              int num = getSelectedNum(nums, k1); // 得到 k1 对应的数的集合
              if (num != 0 && Math.abs(nums[i - 1] - num) == k) {
                continue; // 如果 nums[i-1] 和 num 的绝对差为 k，则不合法，跳过
              }
              dp[i][j] += dp[i - 1][k1];
            }
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));
      return Arrays.stream(dp[n]).sum();
    }

    private int getSelectedNum(int[] nums, int state) {
      int num = 0;
      for (int i = 0; i < nums.length; i++) {
        if ((state & (1 << i)) != 0) {
          if (num == 0) {
            num = nums[i];
          } else {
            return 0; // 如果 state 中选择了多个数，则不合法，返回 0
          }
        }
      }
      return num;
    }
  }

  public static void main(String[] args) {
    Solution solution = new ListNode().new Solution();

    System.out.println(solution.beautifulSubsets(new int[] {2, 4, 6}, 2));
    System.out.println(solution.beautifulSubsets(new int[] {2, 4, 6, 8}, 2));
    System.out.println(solution.beautifulSubsets(new int[] {1}, 1));
    System.out.println(solution.beautifulSubsets(new int[] {4, 2, 5, 9, 10, 3}, 1));// 23
  }

}
