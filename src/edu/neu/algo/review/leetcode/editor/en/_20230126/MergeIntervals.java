package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MergeIntervals {
  // 56
  // Given an array of intervals where intervals[i] = [starti, endi], merge all
  // overlapping intervals, and return an array of the non-overlapping intervals that
  // cover all the intervals in the input.
  //
  //
  // Example 1:
  //
  //
  // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
  // Output: [[1,6],[8,10],[15,18]]
  // Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
  //
  //
  // Example 2:
  //
  //
  // Input: intervals = [[1,4],[4,5]]
  // Output: [[1,5]]
  // Explanation: Intervals [1,4] and [4,5] are considered overlapping.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= intervals.length <= 10⁴
  // intervals[i].length == 2
  // 0 <= starti <= endi <= 10⁴
  //
  //
  // Related Topics Array Sorting 👍 17793 👎 615

  public static void main(String[] args) {
    Solution solution = new MergeIntervals().new Solution();
    String[] data = """
                  [[1,3],[2,6],[8,10],[15,18]]
      [[1,4],[4,5]]
      [[1,2],[3,5],[6,7],[8,10],[12,16],[4,8]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q = solution.merge((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] merge(int[][] intervals) {
      List<int[]> res = new ArrayList<>();
      Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
      for (int[] interval : intervals) {
        if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
          res.add(interval);
        } else {
          int[] last = res.get(res.size() - 1);
          last[1] = Math.max(last[1], interval[1]);
        }
      }
      return res.toArray(new int[][] {});
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
