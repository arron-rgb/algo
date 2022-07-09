package edu.neu.algo.leetcode.editor.en._20220708;

import java.util.HashMap;
import java.util.Map;

import edu.neu.util.InputUtil;

public class LengthOfLongestFibonacciSubsequence {
  // 873
  // A sequence x1, x2, ..., xn is Fibonacci-like if:
  //
  //
  // n >= 3
  // xi + xi+1 == xi+2 for all i + 2 <= n
  //
  //
  // Given a strictly increasing array arr of positive integers forming a
  // sequence, return the length of the longest Fibonacci-like subsequence of arr. If one
  // does not exist, return 0.
  //
  // A subsequence is derived from another sequence arr by deleting any number of
  // elements (including none) from arr, without changing the order of the remaining
  // elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
  //
  //
  // Example 1:
  //
  //
  // Input: arr = [1,2,3,4,5,6,7,8]
  // Output: 5
  // Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
  //
  // Example 2:
  //
  //
  // Input: arr = [1,3,7,11,12,14,18]
  // Output: 3
  // Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,
  // 14] or [7,11,18].
  //
  //
  // Constraints:
  //
  //
  // 3 <= arr.length <= 1000
  // 1 <= arr[i] < arr[i + 1] <= 10⁹
  //
  // Related Topics Array Hash Table Dynamic Programming 👍 1541 👎 56

  public static void main(String[] args) {
    Solution solution = new LengthOfLongestFibonacciSubsequence().new Solution();
    String[] data = """
          [1,2,3,4,5,6,7,8]
      [1,3,7,11,12,14,18]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.lenLongestFibSubseq((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lenLongestFibSubseq(int[] arr) {
      Map<Integer, Integer> indices = new HashMap<>();
      int n = arr.length;
      for (int i = 0; i < n; i++) {
        indices.put(arr[i], i);
      }
      int[][] dp = new int[n][n];
      int ans = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
          int k = indices.getOrDefault(arr[i] - arr[j], -1);
          if (k >= 0) {
            dp[j][i] = Math.max(dp[k][j] + 1, 3);
          }
          ans = Math.max(ans, dp[j][i]);
        }
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
