package edu.neu.algo.leetcode.editor.en._20220707;

import edu.neu.util.InputUtil;

public class MinimumCostToMoveChipsToTheSamePosition {
  // 1217
  // We have n chips, where the position of the iᵗʰ chip is position[i].
  //
  // We need to move all the chips to the same position. In one step, we can
  // change the position of the iᵗʰ chip from position[i] to:
  //
  //
  // position[i] + 2 or position[i] - 2 with cost = 0.
  // position[i] + 1 or position[i] - 1 with cost = 1.
  //
  //
  // Return the minimum cost needed to move all the chips to the same position.
  //
  //
  // Example 1:
  //
  //
  // Input: position = [1,2,3]
  // Output: 1
  // Explanation: First step: Move the chip at position 3 to position 1 with cost =
  // 0.
  // Second step: Move the chip at position 2 to position 1 with cost = 1.
  // Total cost is 1.
  //
  //
  // Example 2:
  //
  //
  // Input: position = [2,2,2,3,3]
  // Output: 2
  // Explanation: We can move the two chips at position 3 to position 2. Each
  // move has cost = 1. The total cost = 2.
  //
  //
  // Example 3:
  //
  //
  // Input: position = [1,1000000000]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= position.length <= 100
  // 1 <= position[i] <= 10^9
  //
  // Related Topics Array Math Greedy 👍 1580 👎 206

  public static void main(String[] args) {
    Solution solution = new MinimumCostToMoveChipsToTheSamePosition().new Solution();
    String[] data = """
          [1,2,3]
      [2,2,2,3,3]
      [1,1000000000]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minCostToMoveChips((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minCostToMoveChips(int[] position) {
      int even_cnt = 0;
      int odd_cnt = 0;
      for (int i : position) {
        if (i % 2 == 0) {
          even_cnt++;
        } else {
          odd_cnt++;
        }
      }
      return Math.min(odd_cnt, even_cnt);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
