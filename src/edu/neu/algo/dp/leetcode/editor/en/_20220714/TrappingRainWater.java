package edu.neu.algo.dp.leetcode.editor.en._20220714;

import java.util.*;
import edu.neu.util.InputUtil;

public class TrappingRainWater {
  // 42
  // Given n non-negative integers representing an elevation map where the width
  // of each bar is 1, compute how much water it can trap after raining.
  //
  //
  // Example 1:
  //
  //
  // Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
  // Output: 6
  // Explanation: The above elevation map (black section) is represented by array [
  // 0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
  // are being trapped.
  //
  //
  // Example 2:
  //
  //
  // Input: height = [4,2,0,3,2,5]
  // Output: 9
  //
  //
  //
  // Constraints:
  //
  //
  // n == height.length
  // 1 <= n <= 2 * 10⁴
  // 0 <= height[i] <= 10⁵
  //
  // Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
  // ? 20088 👎 283

  public static void main(String[] args) {
    Solution solution = new TrappingRainWater().new Solution();
    String[] data = """
          [0,1,0,2,1,0,1,3,2,1,2,1]
      [4,2,0,3,2,5]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.trap((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int trap(int[] height) {
      Deque<Integer> deque = new ArrayDeque<>();
      int n = height.length;
      int res = 0;
      for (int i = 0; i < n; i++) {
        while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
          int pre = deque.pop();
          if (deque.isEmpty()) {
            break;
          }
          int width = i - deque.peek() - 1;
          int depth = Math.min(height[deque.peek()], height[i]) - height[pre];
          res += depth * width;
        }
        deque.push(i);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
