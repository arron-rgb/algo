package edu.neu.algo.monotonic.leetcode.editor.en._20220724;

import java.util.*;
import edu.neu.util.InputUtil;

public class LargestRectangleInHistogram {
  // 84
  // Given an array of integers heights representing the histogram's bar height
  // where the width of each bar is 1, return the area of the largest rectangle in the
  // histogram.
  //
  //
  // Example 1:
  //
  //
  // Input: heights = [2,1,5,6,2,3]
  // Output: 10
  // Explanation: The above is a histogram where width of each bar is 1.
  // The largest rectangle is shown in the red area, which has an area = 10 units.
  //
  //
  // Example 2:
  //
  //
  // Input: heights = [2,4]
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= heights.length <= 10⁵
  // 0 <= heights[i] <= 10⁴
  //
  // Related Topics Array Stack Monotonic Stack 👍 11150 👎 157

  public static void main(String[] args) {
    Solution solution = new LargestRectangleInHistogram().new Solution();
    String[] data = """
          [2,1,5,6,2,3]
      [2,4]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.largestRectangleArea((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int largestRectangleArea(int[] heights) {
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
