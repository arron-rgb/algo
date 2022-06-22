package edu.neu.algo.leetcode.editor.en._20220620;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import edu.neu.util.InputUtil;

public class NextGreaterElementII {

  // Given a circular integer array nums (i.e., the next element of nums[nums.
  // length - 1] is nums[0]), return the next greater number for every element in nums.
  //
  // The next greater number of a number x is the first greater number to its
  // traversing-order next in the array, which means you could search circularly to find
  // its next greater number. If it doesn't exist, return -1 for this number.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,1]
  // Output: [2,-1,2]
  // Explanation: The first 1's next greater number is 2;
  // The number 2 can't find next greater number.
  // The second 1's next greater number needs to search circularly, which is also 2
  // .
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4,3]
  // Output: [2,3,4,-1,4]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁹ <= nums[i] <= 10⁹
  //
  // Related Topics Array Stack Monotonic Stack 👍 4761 👎 138

  public static void main(String[] args) {
    Solution solution = new NextGreaterElementII().new Solution();
    String[] data = """
          [1,2,1]
      [1,2,3,4,3]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.nextGreaterElements((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] nextGreaterElements(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      Arrays.fill(res, -1);
      Deque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < n * 2 - 1; i++) {
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i % n]) {
          res[deque.pollLast()] = nums[i % n];
        }
        deque.offerLast(i % n);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
