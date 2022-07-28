package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class FirstMissingPositive {
  // 41
  // Given an unsorted integer array nums, return the smallest missing positive
  // integer.
  //
  // You must implement an algorithm that runs in O(n) time and uses constant
  // extra space.
  //
  //
  // Example 1:
  // Input: nums = [1,2,0]
  // Output: 3
  // Example 2:
  // Input: nums = [3,4,-1,1]
  // Output: 2
  // Example 3:
  // Input: nums = [7,8,9,11,12]
  // Output: 1
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 5 * 10⁵
  // -2³¹ <= nums[i] <= 2³¹ - 1
  //
  // Related Topics Array Hash Table 👍 10718 👎 1402

  public static void main(String[] args) {
    Solution solution = new FirstMissingPositive().new Solution();
    String[] data = """
          [1,2,0]
      [3,4,-1,1]
      [7,8,9,11,12]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.firstMissingPositive((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int firstMissingPositive(int[] nums) {
      int n = nums.length;
      // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
      // (we can ignore those because if all number are > n then we'll simply return 1)
      for (int i = 0; i < n; i++) {
        if (nums[i] <= 0 || nums[i] > n) {
          nums[i] = n + 1;
        }
      }
      // note: all number in the array are now positive, and on the range 1..n+1
      // 2. mark each cell appearing in the array, by converting the index for that number to negative
      for (int i = 0; i < n; i++) {
        int num = Math.abs(nums[i]);
        if (num > n) {
          continue;
        }
        num--; // -1 for zero index based array (so the number 1 will be at pos 0)
        if (nums[num] > 0) { // prevents double negative operations
          nums[num] = -1 * nums[num];
        }
      }
      // 3. find the first cell which isn't negative (doesn't appear in the array)
      for (int i = 0; i < n; i++) {
        if (nums[i] >= 0) {
          return i + 1;
        }
      }
      // 4. no positive numbers were found, which means the array contains all numbers 1..n
      return n + 1;
    }
  }
  // runtime:3 ms
  // memory:99.6 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
