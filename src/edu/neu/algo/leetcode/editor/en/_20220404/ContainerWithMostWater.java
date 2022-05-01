package edu.neu.algo.leetcode.editor.en._20220404;

import java.util.Arrays;

public class ContainerWithMostWater {

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
  // Related Topics Array Two Pointers Greedy 👍 15331 👎 905

  public static void main(String[] args) {

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxArea(int[] height) {
      int l = height.length;
      int[] left = new int[l];
      int[] right = new int[l];

      Arrays.fill(left, Integer.MIN_VALUE);
      Arrays.fill(right, Integer.MIN_VALUE);

      for (int i = 0; i < l; i++) {
        left[i] = Math.max(left[i], height[i]);
      }
      for (int i = l - 1; i >= 0; i--) {
        right[i] = Math.max(right[i], height[i]);
      }

      for (int i = 0; i < l; i++) {
        height[i] = Math.min(left[i], right[i]);
      }

      int pr = 0;
      int a = 0, b = l - 1;
      while (a < b) {
        int temp = Math.min(height[a], height[b]) * (b - a);
        pr = Math.max(pr, temp);
        if (height[a] > height[b]) {
          b--;
        } else {
          a++;
        }
      }
      return pr;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
