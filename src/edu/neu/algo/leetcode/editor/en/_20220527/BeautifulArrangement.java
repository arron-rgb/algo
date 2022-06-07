package edu.neu.algo.leetcode.editor.en._20220527;

public class BeautifulArrangement {

  // Suppose you have n integers labeled 1 through n. A permutation of those n
  // integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <=
  // i <= n), either of the following is true:
  //
  //
  // perm[i] is divisible by i.
  // i is divisible by perm[i].
  //
  //
  // Given an integer n, return the number of the beautiful arrangements that you
  // can construct.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 2
  // Output: 2
  // Explanation:
  // The first beautiful arrangement is [1,2]:
  // - perm[1] = 1 is divisible by i = 1
  // - perm[2] = 2 is divisible by i = 2
  // The second beautiful arrangement is [2,1]:
  // - perm[1] = 2 is divisible by i = 1
  // - i = 2 is divisible by perm[2] = 1
  //
  //
  // Example 2:
  //
  //
  // Input: n = 1
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 15
  //
  // Related Topics Array Dynamic Programming Backtracking Bit Manipulation
  // Bitmask 👍 2160 👎 296

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int count = 0;

    public int countArrangement(int n) {
      if (n == 0) {
        return 0;
      }
      dfs(n, 1, new boolean[n + 1]);
      return count;
    }

    void dfs(int n, int index, boolean[] visited) {
      if (index > n) {
        count++;
        return;
      }

      for (int i = 1; i <= n; i++) {
        if (!visited[i] && (i % index == 0 || index % i == 0)) {
          visited[i] = true;
          dfs(n, index + 1, visited);
          visited[i] = false;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public static void main(String[] args) {
    BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
  }

}
