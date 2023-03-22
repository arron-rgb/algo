package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;

import java.io.IOException;
import java.util.*;

public class BrokenCalculator {
  // 991
  // There is a broken calculator that has the integer startValue on its display
  // initially. In one operation, you can:
  //
  //
  // multiply the number on display by 2, or
  // subtract 1 from the number on display.
  //
  //
  // Given two integers startValue and target, return the minimum number of
  // operations needed to display target on the calculator.
  //
  //
  // Example 1:
  //
  //
  // Input: startValue = 2, target = 3
  // Output: 2
  // Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
  //
  //
  // Example 2:
  //
  //
  // Input: startValue = 5, target = 8
  // Output: 2
  // Explanation: Use decrement and then double {5 -> 4 -> 8}.
  //
  //
  // Example 3:
  //
  //
  // Input: startValue = 3, target = 10
  // Output: 3
  // Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= startValue, target <= 10⁹
  //
  //
  // Related Topics Math Greedy 👍 2457 👎 198

  public static void main(String[] args) {
    Solution solution = new BrokenCalculator().new Solution();
    String[] data = """
                  2
      3
      5
      8
      3
      10
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.brokenCalc((int)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int brokenCalc(int startValue, int target) {
      int res = 0;
      while (target > startValue) {
        res++;
        if (target % 2 == 1) {
          target++;
        } else {
          target /= 2;
        }
      }
      return res + startValue - target;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}
