package edu.neu.algo.review.leetcode.editor.en._20230119;

import edu.neu.util.InputUtil;
import java.util.*;

public class IntervalListIntersections {

  // You are given two lists of closed intervals, firstList and secondList, where
  // firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of
  // intervals is pairwise disjoint and in sorted order.
  //
  // Return the intersection of these two interval lists.
  //
  // A closed interval [a, b] (with a <= b) denotes the set of real numbers x
  // with a <= x <= b.
  //
  // The intersection of two closed intervals is a set of real numbers that are
  // either empty or represented as a closed interval. For example, the intersection
  // of [1, 3] and [2, 4] is [2, 3].
  //
  //
  // Example 1:
  //
  //
  // Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],
  // [15,24],[25,26]]
  // Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
  //
  //
  // Example 2:
  //
  //
  // Input: firstList = [[1,3],[5,9]], secondList = []
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= firstList.length, secondList.length <= 1000
  // firstList.length + secondList.length >= 1
  // 0 <= starti < endi <= 10⁹
  // endi < starti+1
  // 0 <= startj < endj <= 10⁹
  // endj < startj+1
  //
  //
  // Related Topics Array Two Pointers 👍 4909 👎 96

  public static void main(String[] args) {
    Solution solution = new IntervalListIntersections().new Solution();
    String[] data = """
                  [[0,2],[5,10],[13,23],[24,25]]
      [[1,5],[8,12],[15,24],[25,26]]
      [[1,3],[5,9]]
      []
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("${question.paramTypes}");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
      List<int[]> ans = new ArrayList();
      int i = 0, j = 0;

      while (i < A.length && j < B.length) {
        // Let's check if A[i] intersects B[j].
        // lo - the startpoint of the intersection
        // hi - the endpoint of the intersection
        int lo = Math.max(A[i][0], B[j][0]);
        int hi = Math.min(A[i][1], B[j][1]);
        if (lo <= hi)
          ans.add(new int[] {lo, hi});

        // Remove the interval with the smallest endpoint
        if (A[i][1] < B[j][1])
          i++;
        else
          j++;
      }

      return ans.toArray(new int[ans.size()][]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
