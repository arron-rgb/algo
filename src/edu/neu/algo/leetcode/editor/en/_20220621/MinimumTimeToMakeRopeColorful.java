package edu.neu.algo.leetcode.editor.en._20220621;

import edu.neu.util.InputUtil;

public class MinimumTimeToMakeRopeColorful {

  // Alice has n balloons arranged on a rope. You are given a 0-indexed string
  // colors where colors[i] is the color of the iᵗʰ balloon.
  //
  // Alice wants the rope to be colorful. She does not want two consecutive
  // balloons to be of the same color, so she asks Bob for help. Bob can remove some
  // balloons from the rope to make it colorful. You are given a 0-indexed integer array
  // neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove
  // the iᵗʰ balloon from the rope.
  //
  // Return the minimum time Bob needs to make the rope colorful.
  //
  //
  // Example 1:
  //
  //
  // Input: colors = "abaac", neededTime = [1,2,3,4,5]
  // Output: 3
  // Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
  // Bob can remove the blue balloon at index 2. This takes 3 seconds.
  // There are no longer two consecutive balloons of the same color. Total time = 3
  // .
  //
  // Example 2:
  //
  //
  // Input: colors = "abc", neededTime = [1,2,3]
  // Output: 0
  // Explanation: The rope is already colorful. Bob does not need to remove any
  // balloons from the rope.
  //
  //
  // Example 3:
  //
  //
  // Input: colors = "aabaa", neededTime = [1,2,3,4,1]
  // Output: 2
  // Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon
  // takes 1 second to remove.
  // There are no longer two consecutive balloons of the same color. Total time = 1
  // + 1 = 2.
  //
  //
  //
  // Constraints:
  //
  //
  // n == colors.length == neededTime.length
  // 1 <= n <= 10⁵
  // 1 <= neededTime[i] <= 10⁴
  // colors contains only lowercase English letters.
  //
  // Related Topics Array String Dynamic Programming Greedy 👍 1067 👎 43

  public static void main(String[] args) {
    Solution solution = new MinimumTimeToMakeRopeColorful().new Solution();
    String[] data = """
          "abaac"
      [1,2,3,4,5]
      "abc"
      [1,2,3]
      "aabaa"
      [1,2,3,4,1]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.minCost((String)params[1 - 1 + i * paramTypes.length], (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minCost(String colors, int[] neededTime) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
