package edu.neu.algo.dp.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class OnesAndZeroes {

  // You are given an array of binary strings strs and two integers m and n.
  //
  // Return the size of the largest subset of strs such that there are at most m 0
  // 's and n 1's in the subset.
  //
  // A set x is a subset of a set y if all elements of x are also elements of y.
  //
  //
  // Example 1:
  //
  //
  // Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
  // Output: 4
  // Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
  // "1", "0"}, so the answer is 4.
  // Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
  // {"111001"} is an invalid subset because it contains 4 1's, greater than the
  // maximum of 3.
  //
  //
  // Example 2:
  //
  //
  // Input: strs = ["10","0","1"], m = 1, n = 1
  // Output: 2
  // Explanation: The largest subset is {"0", "1"}, so the answer is 2.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= strs.length <= 600
  // 1 <= strs[i].length <= 100
  // strs[i] consists only of digits '0' and '1'.
  // 1 <= m, n <= 100
  //
  // Related Topics Array String Dynamic Programming 👍 4018 👎 394

  public static void main(String[] args) {
    Solution solution = new OnesAndZeroes().new Solution();
    String[] data = """
          ["10","0001","111001","1","0"]
      5
      3
      ["10","0","1"]
      1
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findMaxForm((String[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
      // dp[i][j]表示i个0和j个1时的最大子集
      int[][] dp = new int[m + 1][n + 1];
      int oneNum, zeroNum;
      for (String str : strs) {
        oneNum = 0;
        zeroNum = 0;
        for (char ch : str.toCharArray()) {
          if (ch == '0') {
            zeroNum++;
          } else {
            oneNum++;
          }
        }
        // 倒序遍历
        for (int i = m; i >= zeroNum; i--) {
          for (int j = n; j >= oneNum; j--) {
            dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
          }
        }
      }
      return dp[m][n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
