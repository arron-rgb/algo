package edu.neu.algo.review.leetcode.editor.en._20230224;

import edu.neu.util.InputUtil;
import edu.neu.base.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MinimizeDeviationInArray {
  // 1675
  // You are given an array nums of n positive integers.
  //
  // You can perform two types of operations on any element of the array any
  // number of times:
  //
  //
  // If the element is even, divide it by 2.
  //
  //
  //
  // For example, if the array is [1,2,3,4], then you can do this operation on
  // the last element, and the array will be [1,2,3,2].
  //
  //
  // If the element is odd, multiply it by 2.
  //
  // For example, if the array is [1,2,3,4], then you can do this operation on
  // the first element, and the array will be [2,2,3,4].
  //
  //
  //
  //
  // The deviation of the array is the maximum difference between any two
  // elements in the array.
  //
  // Return the minimum deviation the array can have after performing some number
  // of operations.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4]
  // Output: 1
  // Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2],
  // then the deviation will be 3 - 2 = 1.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [4,1,5,20,3]
  // Output: 3
  // Explanation: You can transform the array after two operations to [4,2,5,5,3],
  // then the deviation will be 5 - 2 = 3.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [2,10,8]
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 2 <= n <= 5 * 10⁹
  //
  //
  // Related Topics Array Greedy Heap (Priority Queue) Ordered Set 👍 2454 👎 129

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
      [1,2,3,4]
      [4,1,5,20,3]
      [2,10,8]
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minimumDeviation((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumDeviation(int[] nums) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      int n = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
      for (int i : nums) {
        if (i % 2 == 1)
          i *= 2;
        pq.add(-i);
        mi = Math.min(mi, i);
      }
      while (true) {
        int i = -pq.poll();
        res = Math.min(res, i - mi);
        if (i % 2 == 1)
          break;
        mi = Math.min(mi, i / 2);
        pq.add(-i / 2);
      }

      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
