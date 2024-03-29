package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;

import edu.neu.base.Pair;
import edu.neu.util.InputUtil;

public class NumberOfSubmatricesThatSumToTarget {
  // 1074
  // Given a matrix and a target, return the number of non-empty submatrices that
  // sum to target.
  //
  // A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
  // <= x2 and y1 <= y <= y2.
  //
  // Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
  // they have some coordinate that is different: for example, if x1 != x1'.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
  // Output: 4
  // Explanation: The four 1x1 submatrices that only contain 0.
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[1,-1],[-1,1]], target = 0
  // Output: 5
  // Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2
  // x2 submatrix.
  //
  //
  // Example 3:
  //
  //
  // Input: matrix = [[904]], target = 0
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= matrix.length <= 100
  // 1 <= matrix[0].length <= 100
  // -1000 <= matrix[i] <= 1000
  // -10^8 <= target <= 10^8
  //
  // Related Topics Array Hash Table Matrix Prefix Sum 👍 1627 👎 38

  public static void main(String[] args) {
    Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
    String[] data = """
          [[0,1,0],[1,1,1],[0,1,0]]
      0
      [[1,-1],[-1,1]]
      0
      [[904]]
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numSubmatrixSumTarget((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSubmatrixSumTarget(int[][] nums, int target) {
      int res = 0, m = nums.length, n = nums[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 1; j < n; j++) {
          nums[i][j] += nums[i][j - 1];
        }
      }
      System.out.println(Arrays.deepToString(nums));
      Map<Integer, Integer> counter = new HashMap<>();
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          counter.clear();
          counter.put(0, 1);
          int cur = 0;
          for (int[] ints : nums) {
            cur += ints[j] - (i > 0 ? ints[i - 1] : 0);
            res += counter.getOrDefault(cur - target, 0);
            counter.put(cur, counter.getOrDefault(cur, 0) + 1);
          }
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public int getLengthOfOptimalCompression(String s, int k) {
    // dp[i][k]: the minimum length for s[:i] with at most k deletion.
    int n = s.length();
    int[][] dp = new int[110][110];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = 9999;
      }
    }
    // for (int[] i : dp) Arrays.fill(i, n); // this is a bit slower (100ms)
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        int cnt = 0, del = 0;
        for (int l = i; l >= 1; l--) { // keep s[i], concat the same, remove the different
          if (s.charAt(l - 1) == s.charAt(i - 1)) {
            cnt++;
          } else {
            del++;
          }
          if (j - del >= 0) {
            dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
          }
        }
        if (j > 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        }
      }
    }
    return dp[n][k];
  }

}
