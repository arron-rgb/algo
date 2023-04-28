package edu.neu.algo.review.leetcode.editor.en._20230119;

import edu.neu.util.InputUtil;
import java.util.*;

public class MaxConsecutiveOnesIII {

  // Given a binary array nums and an integer k, return the maximum number of
  // consecutive 1's in the array if you can flip at most k 0's.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
  // Output: 6
  // Explanation: [1,1,1,0,0,1,1,1,1,1,1]
  // Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
  //
  // Example 2:
  //
  //
  // Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
  // Output: 10
  // Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
  // Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // nums[i] is either 0 or 1.
  // 0 <= k <= nums.length
  //
  //
  // Related Topics Array Binary Search Sliding Window Prefix Sum 👍 5799 👎 68

  public static void main(String[] args) {
    Solution solution = new MaxConsecutiveOnesIII().new Solution();
    String[] data = """
                  [1,1,1,0,0,0,1,1,1,1,0]
      2
      [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
      3
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("${question.paramTypes}");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {

    // }
    int i = solution.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    System.out.println(i);
    i = solution.longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestOnes(int[] nums, int k) {
      int left = k, right = nums.length;
      int res = 0;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (check(nums, mid, k)) {
          res = Math.max(res, mid);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return res;
    }

    boolean check(int[] nums, int mid, int k) {
      // 检查改k个能否达到长度为mid
      // 也就是长度为mid的array里能否做到 <= k个0
      int count = 0;
      for (int i = 0; i < mid; i++) {
        if (nums[i] == 0) {
          count++;
        }
      }
      if (count <= k) {
        return true;
      }
      int i = 1, j = mid;
      while (j < nums.length) {
        if (nums[j] == 0) {
          count++;
        }
        if (nums[i - 1] == 0) {
          count--;
        }
        if (count <= k) {
          return true;
        }
        i++;
        j++;
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
