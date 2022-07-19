package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;
import edu.neu.util.InputUtil;

public class MaxConsecutiveOnesIII {
  // 1004
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
  // Related Topics Array Binary Search Sliding Window Prefix Sum 👍 4760 👎 64

  public static void main(String[] args) {
    Solution solution = new MaxConsecutiveOnesIII().new Solution();
    String[] data = """
          [1,1,1,0,0,0,1,1,1,1,0]
      2
      [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.longestOnes((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestOnes(int[] nums, int k) {
      int l = 0, r = 0;
      while (r < nums.length) {
        if (nums[r++] == 0) {
          k--;
        }
        if (k < 0 && nums[l++] == 0) {
          k++;
        }
      }
      return r - l;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
  // 是的，这个写法维护的是一个只能单调变长的窗口。这种窗口经常出现在寻求”最大窗口“的问题中：因为要求的是”最大“，所以我们没有必要缩短窗口，于是代码就少了缩短窗口的部分；从另一个角度讲，本题里的K是消耗品，一旦透支，窗口就不能再增长了（也意味着如果K
  // == 0还是有可能增长的）。所以K所代表的”资源“，通常是滑窗维护逻辑的核心，能这么写有两个先决条件：
  //
  // 固定一个左端点，K随窗口增大是单调变化的。据此我们可以推知长度为n的窗口如若已经”透支“（K < 0）了，那么长度大于n的也一定不符合条件；
  // K的变化与数组元素有简单的算术关系。向窗口纳入（A[r++]）或移除（A[l++]）一个数组元素，可以在O(1)内更新K。
  // 虽说有条件，但仔细排查会发现许多滑窗问题都可以满足。
}
