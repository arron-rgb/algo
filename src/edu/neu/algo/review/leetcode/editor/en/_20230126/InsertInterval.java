package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class InsertInterval {
  // 57
  // You are given an array of non-overlapping intervals intervals where intervals[
  // i] = [starti, endi] represent the start and the end of the iᵗʰ interval and
  // intervals is sorted in ascending order by starti. You are also given an interval
  // newInterval = [start, end] that represents the start and end of another interval.
  //
  // Insert newInterval into intervals such that intervals is still sorted in
  // ascending order by starti and intervals still does not have any overlapping
  // intervals (merge overlapping intervals if necessary).
  //
  // Return intervals after the insertion.
  //
  //
  // Example 1:
  //
  //
  // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  // Output: [[1,5],[6,9]]
  //
  //
  // Example 2:
  //
  //
  // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
  // Output: [[1,2],[3,10],[12,16]]
  // Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= intervals.length <= 10⁴
  // intervals[i].length == 2
  // 0 <= starti <= endi <= 10⁵
  // intervals is sorted by starti in ascending order.
  // newInterval.length == 2
  // 0 <= start <= end <= 10⁵
  //
  //
  // Related Topics Array 👍 7855 👎 539

  public static void main(String[] args) {
    Solution solution = new InsertInterval().new Solution();
    String[] data = """
                  [[1,3],[6,9]]
      [2,5]
      [[1,2],[3,5],[6,7],[8,10],[12,16]]
      [4,8]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q =
        solution.insert((int[][])params[1 - 1 + i * paramTypes.length], (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] insert(int[][] intervals, int[] insert) {
      List<int[]> list = new ArrayList<>();
      for (int[] i : intervals) {
        if (insert == null || i[1] < insert[0]) {
          list.add(i);
        } else if (i[0] > insert[1]) {
          list.add(insert);
          list.add(i);
          insert = null;
        } else {
          insert[0] = Math.min(insert[0], i[0]);
          insert[1] = Math.max(insert[1], i[1]);
        }
      }
      if (insert != null) {
        list.add(insert);
      }
      return list.toArray(new int[][] {});
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
