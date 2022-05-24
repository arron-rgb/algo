package edu.neu.algo.leetcode.editor.en._20220517;

public class KthSmallestNumberInMultiplicationTable {

  // Nearly everyone has used the Multiplication Table. The multiplication table
  // of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
  //
  // Given three integers m, n, and k, return the kᵗʰ smallest element in the m x
  // n multiplication table.
  //
  //
  // Example 1:
  //
  //
  // Input: m = 3, n = 3, k = 5
  // Output: 3
  // Explanation: The 5ᵗʰ smallest number is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: m = 2, n = 3, k = 6
  // Output: 6
  // Explanation: The 6ᵗʰ smallest number is 6.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= m, n <= 3 * 10⁴
  // 1 <= k <= m * n
  //
  // Related Topics Binary Search 👍 1606 👎 46

  public static void main(String[] args) {
    Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findKthNumber(int m, int n, int k) {
      int low = 1, high = m * n + 1;

      while (low < high) {
        int mid = low + (high - low) / 2;
        int c = count(mid, m, n);
        if (c >= k) {
          high = mid;
        } else {
          low = mid + 1;
        }
      }
      return high;
    }

    private int count(int v, int m, int n) {
      int count = 0;
      for (int i = 1; i <= m; i++) {
        count += Math.min(v / i, n);
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
