package edu.neu.algo.review.leetcode.editor.en._20230214;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class ContainerWithMostWater {
  // 11
  // You are given an integer array height of length n. There are n vertical lines
  // drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
  //
  //
  // Find two lines that together with the x-axis form a container, such that the
  // container contains the most water.
  //
  // Return the maximum amount of water a container can store.
  //
  // Notice that you may not slant the container.
  //
  //
  // Example 1:
  //
  //
  // Input: height = [1,8,6,2,5,4,8,3,7]
  // Output: 49
  // Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
  // 3,7]. In this case, the max area of water (blue section) the container can
  // contain is 49.
  //
  //
  // Example 2:
  //
  //
  // Input: height = [1,1]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // n == height.length
  // 2 <= n <= 10⁵
  // 0 <= height[i] <= 10⁴
  //
  //
  // Related Topics Array Two Pointers Greedy 👍 22734 👎 1212

  public static void main(String[] args) {
    Solution solution = new ContainerWithMostWater().new Solution();
    String[] data = """
                  [1,8,6,2,5,4,8,3,7]
      [1,1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxArea((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxArea(int[] height) {
      int left = 0, right = height.length - 1;
      int max = Integer.MIN_VALUE;
      while (left < right) {
        int h = Math.min(height[left], height[right]);
        max = Math.max(max, (right - left) * h);
        if (height[left] < height[right]) {
          left++;
        } else {
          right--;
        }
      }
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
