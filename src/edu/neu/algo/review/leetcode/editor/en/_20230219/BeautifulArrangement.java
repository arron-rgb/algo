package edu.neu.algo.review.leetcode.editor.en._20230219;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class BeautifulArrangement {
  // 526
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
  //
  // Related Topics Array Dynamic Programming Backtracking Bit Manipulation
  // Bitmask 👍 2722 👎 334

  public static void main(String[] args) {
    Solution solution = new BeautifulArrangement().new Solution();
    String[] data = """
                  2
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.countArrangement((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int count = 0;

    public int countArrangement(int n) {
      // 有 [1,n] 个数
      // 计算 能够满足 perm[i] % i == 0 || i % perm[i] == 0 的个数
      // n: [1,15]
      // 15个数排列有多大
      // if (n == 0) {
      // return 0;
      // }
      // dfs(n, 1, new boolean[n + 1]);
      // return count;
      int mask = 1 << n;
      int[][] dp = new int[n + 1][mask];
      dp[0][0] = 1;
      // dp[i][j] 表示考虑到第i个数的时候，j这种状态下的有多少种可能性满足
      // j的二进制表示
      // 如果某位为0，表示未被使用
      // 为1，表示已被使用
      // 计算某个数的时候，这个state需要**已经考虑到这个数**才可以计算
      // 即 ((state >> (k-1)) & 1) == 1

      for (int i = 1; i <= n; i++) {
        // 考虑每一个数
        for (int state = 0; state < mask; state++) {
          // 考虑每一个状态
          for (int k = 1; k <= n; k++) {
            // 选一个数，看是否被用过
            // 首先 k 在 state 中必须是 1
            // 因为当前要计算 加入第k个数的时候的可能性
            if (((state >> (k - 1)) & 1) == 1) {
              // 数值 k 和位置 i 之间满足任一整除关系
              if (k % i == 0 || i % k == 0) {
                // state & (~(1 << (k - 1))) 代表将 state 中数值 k 的位置置零
                // (1 << k-1)左移k-1
                // 1000(k-1个0)
                // 再取反，前置的0也会变成1
                // 0111(k-1个1)
                dp[i][state] += dp[i - 1][state & (~(1 << (k - 1)))];
              }
            }
          }
        }
      }
      // O(n*n*2^n)
      return dp[n][mask - 1];
    }

    void dfs(int n, int index, boolean[] visited) {
      if (index == n + 1) {
        count++;
        return;
      }
      for (int i = 1; i <= n; i++) {
        if (visited[i]) {
          continue;
        }
        if (i % index == 0 || index % i == 0) {
          visited[i] = true;
          dfs(n, index + 1, visited);
          visited[i] = false;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
