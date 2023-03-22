package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MaximizeWinFromTwoSegments {
  // 2555
  // There are some prizes on the X-axis. You are given an integer array
  // prizePositions that is sorted in non-decreasing order, where prizePositions[i] is the
  // position of the iᵗʰ prize. There could be different prizes at the same position on
  // the line. You are also given an integer k.
  //
  // You are allowed to select two segments with integer endpoints. The length of
  // each segment must be k. You will collect all prizes whose position falls within
  // at least one of the two selected segments (including the endpoints of the
  // segments). The two selected segments may intersect.
  //
  //
  // For example if k = 2, you can choose segments [1, 3] and [2, 4], and you
  // will win any prize i that satisfies 1 <= prizePositions[i] <= 3 or 2 <=
  // prizePositions[i] <= 4.
  //
  //
  // Return the maximum number of prizes you can win if you choose the two
  // segments optimally.
  //
  //
  // Example 1:
  //
  //
  // Input: prizePositions = [1,1,2,2,3,3,5], k = 2
  // Output: 7
  // Explanation: In this example, you can win all 7 prizes by selecting two
  // segments [1, 3] and [3, 5].
  //
  //
  // Example 2:
  //
  //
  // Input: prizePositions = [1,2,3,4], k = 0
  // Output: 2
  // Explanation: For this example, one choice for the segments is [3, 3] and [4, 4
  // ], and you will be able to get 2 prizes.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= prizePositions.length <= 10⁵
  // 1 <= prizePositions[i] <= 10⁹
  // 0 <= k <= 10⁹
  // prizePositions is sorted in non-decreasing order.
  //
  //
  //
  //
  //
  // Related Topics Array Binary Search Sliding Window 👍 254 👎 11

  public static void main(String[] args) {
    Solution solution = new MaximizeWinFromTwoSegments().new Solution();
    String[] data = """
                  [1,1,2,2,3,3,5]
      2
      [1,2,3,4]
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.maximizeWin((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
      int n = prizePositions.length;
      int right = 0;
      int left = 0;
      int res = 0;
      int[] dp = new int[n + 1];
      while (right < n) {
        while (prizePositions[right] - prizePositions[left] > k) {
          left++;
        }
        res = Math.max(res, right - left + 1 + dp[left]);
        dp[right + 1] = Math.max(dp[right], right - left + 1);
        right++;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
