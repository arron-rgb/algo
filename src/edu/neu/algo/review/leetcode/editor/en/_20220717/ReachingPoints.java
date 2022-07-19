package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReachingPoints {
  // 780
  // Given four integers sx, sy, tx, and ty, return true if it is possible to
  // convert the point (sx, sy) to the point (tx, ty) through some operations, or false
  // otherwise.
  //
  // The allowed operation on some point (x, y) is to convert it to either (x, x +
  // y) or (x + y, y).
  //
  //
  // Example 1:
  //
  //
  // Input: sx = 1, sy = 1, tx = 3, ty = 5
  // Output: true
  // Explanation:
  // One series of moves that transforms the starting point to the target is:
  // (1, 1) -> (1, 2)
  // (1, 2) -> (3, 2)
  // (3, 2) -> (3, 5)
  //
  //
  // Example 2:
  //
  //
  // Input: sx = 1, sy = 1, tx = 2, ty = 2
  // Output: false
  //
  //
  // Example 3:
  //
  //
  // Input: sx = 1, sy = 1, tx = 1, ty = 1
  // Output: true
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= sx, sy, tx, ty <= 10⁹
  //
  // Related Topics Math 👍 1015 👎 168

  public static void main(String[] args) {
    Solution solution = new ReachingPoints().new Solution();
    String[] data = """
          1
      1
      3
      5
      1
      1
      2
      2
      1
      1
      1
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q =
        solution.reachingPoints((int)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1],
          (int)params[3 + i * paramTypes.length - 1], (int)params[4 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
      while (tx > sx && ty > sy && tx != ty) {
        if (tx > ty) {
          tx %= ty;
        } else {
          ty %= tx;
        }
      }
      if (tx == sx && ty == sy) {
        return true;
      } else if (tx == sx) {
        return ty > sy && (ty - sy) % tx == 0;
      } else if (ty == sy) {
        return tx > sx && (tx - sx) % ty == 0;
      } else {
        return false;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
