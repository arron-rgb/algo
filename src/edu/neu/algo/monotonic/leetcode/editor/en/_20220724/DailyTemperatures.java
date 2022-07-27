package edu.neu.algo.monotonic.leetcode.editor.en._20220724;

import java.util.*;
import edu.neu.util.InputUtil;

public class DailyTemperatures {
  // 739
  // Given an array of integers temperatures represents the daily temperatures,
  // return an array answer such that answer[i] is the number of days you have to wait
  // after the iᵗʰ day to get a warmer temperature. If there is no future day for
  // which this is possible, keep answer[i] == 0 instead.
  //
  //
  // Example 1:
  // Input: temperatures = [73,74,75,71,69,72,76,73]
  // Output: [1,1,4,2,1,1,0,0]
  // Example 2:
  // Input: temperatures = [30,40,50,60]
  // Output: [1,1,1,0]
  // Example 3:
  // Input: temperatures = [30,60,90]
  // Output: [1,1,0]
  //
  //
  // Constraints:
  //
  //
  // 1 <= temperatures.length <= 10⁵
  // 30 <= temperatures[i] <= 100
  //
  // Related Topics Array Stack Monotonic Stack 👍 7638 👎 169

  public static void main(String[] args) {
    Solution solution = new DailyTemperatures().new Solution();
    String[] data = """
          [73,74,75,71,69,72,76,73]
      [30,40,50,60]
      [30,60,90]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.dailyTemperatures((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
