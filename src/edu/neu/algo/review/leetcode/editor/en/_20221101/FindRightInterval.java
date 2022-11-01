package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindRightInterval {
  // 436
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
  // Related Topics Array Binary Search Sorting 👍 1474 👎 276

  public static void main(String[] args) {
    Solution solution = new FindRightInterval().new Solution();
    String[] data = """
          [[1,2]]
      [[3,4],[2,3],[1,2]]
      [[1,4],[2,3],[3,4]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.findRightInterval((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] findRightInterval(int[][] intervals) {
      // TreeMap时间复杂度 put：O(logn) get: O(logn) 总的时间复杂度为O(n*logn) 空间复杂度 O（n）
      int n = intervals.length;
      int[] ans = new int[n];
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        map.put(intervals[i][0], i);
      }
      for (int i = 0; i < n; i++) {
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
        ans[i] = entry == null ? -1 : entry.getValue();
      }
      return ans;
    }

    private int[] binarySearch(int[][] intervals) {
      int n = intervals.length;
      int[][] index = new int[n][2];
      for (int i = 0; i < n; i++) {
        // index: {startI, i}
        index[i] = new int[] {intervals[i][0], i};
      }
      // 根据start排序index
      Arrays.sort(index, Comparator.comparingInt(a -> a[0]));
      int[] ans = new int[n];
      for (int i = 0; i < n; i++) {
        int left = 0, right = n - 1;
        while (left < right) {
          int mid = left + right >> 1;
          // 找到某个interval的start >= 第i个interval的end
          // 为什么可以二分？
          // index数组里 start是unique，且已排序
          if (index[mid][0] >= intervals[i][1]) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        ans[i] = index[right][0] >= intervals[i][1] ? index[right][1] : -1;
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
