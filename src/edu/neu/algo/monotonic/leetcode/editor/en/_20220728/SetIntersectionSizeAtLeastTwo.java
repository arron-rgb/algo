package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class SetIntersectionSizeAtLeastTwo {
  // 757
  // An integer interval [a, b] (for integers a < b) is a set of all consecutive
  // integers from a to b, including a and b.
  //
  // Find the minimum size of a set S such that for every integer interval A in
  // intervals, the intersection of S with A has a size of at least two.
  //
  //
  // Example 1:
  //
  //
  // Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
  // Output: 3
  // Explanation: Consider the set S = {2, 3, 4}. For each interval, there are at
  // least 2 elements from S in the interval.
  // Also, there isn't a smaller size set that fulfills the above condition.
  // Thus, we output the size of this set, which is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
  // Output: 5
  // Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= intervals.length <= 3000
  // intervals[i].length == 2
  // 0 <= ai < bi <= 10⁸
  //
  // Related Topics Array Greedy Sorting 👍 479 👎 63

  public static void main(String[] args) {
    Solution solution = new SetIntersectionSizeAtLeastTwo().new Solution();
    String[] data = """
          [[1,3],[1,4],[2,5],[3,5]]
      [[1,2],[2,3],[2,4],[4,5]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.intersectionSizeTwo((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int intersectionSizeTwo(int[][] ins) {
      Arrays.sort(ins, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
      int a = -1, b = -1, ans = 0;
      for (int[] i : ins) {
        if (i[0] > b) {
          a = i[1] - 1;
          b = i[1];
          ans += 2;
        } else if (i[0] > a) {
          a = b;
          b = i[1];
          ans++;
        }
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
