package edu.neu.algo.leetcode.editor.en._20220519;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

  // You are given an array of intervals, where intervals[i] = [starti, endi] and
  // each starti is unique.
  //
  // The right interval for an interval i is an interval j such that startj >=
  // endi and startj is minimized. Note that i may equal j.
  //
  // Return an array of right interval indices for each interval i. If no right
  // interval exists for interval i, then put -1 at index i.
  //
  //
  // Example 1:
  //
  //
  // Input: intervals = [[1,2]]
  // Output: [-1]
  // Explanation: There is only one interval in the collection, so it outputs -1.
  //
  //
  // Example 2:
  //
  //
  // Input: intervals = [[3,4],[2,3],[1,2]]
  // Output: [-1,0,1]
  // Explanation: There is no right interval for [3,4].
  // The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start
  // that is >= end1 = 3.
  // The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start
  // that is >= end2 = 2.
  //
  //
  // Example 3:
  //
  //
  // Input: intervals = [[1,4],[2,3],[3,4]]
  // Output: [-1,2,-1]
  // Explanation: There is no right interval for [1,4] and [3,4].
  // The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start
  // that is >= end1 = 3.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= intervals.length <= 2 * 10⁴
  // intervals[i].length == 2
  // -10⁶ <= starti <= endi <= 10⁶
  // The start point of each interval is unique.
  //
  // Related Topics Array Binary Search Sorting 👍 1212 👎 252

  public static void main(String[] args) {
    Solution solution = new FindRightInterval().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] findRightInterval(int[][] intervals) {
      int n = intervals.length;
      int[][] startIntervals = new int[n][2];
      for (int i = 0; i < n; i++) {
        startIntervals[i][0] = intervals[i][0];
        startIntervals[i][1] = i;
      }
      Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));

      int[] ans = new int[n];
      for (int i = 0; i < n; i++) {
        int left = 0;
        int right = n - 1;
        int target = -1;
        while (left <= right) {
          int mid = (left + right) / 2;
          if (startIntervals[mid][0] >= intervals[i][1]) {
            target = startIntervals[mid][1];
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
        ans[i] = target;
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
