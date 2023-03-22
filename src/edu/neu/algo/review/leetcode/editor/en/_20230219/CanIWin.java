package edu.neu.algo.review.leetcode.editor.en._20230219;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CanIWin {
  // 464
  // In the "100 game" two players take turns adding, to a running total, any
  // integer from 1 to 10. The player who first causes the running total to reach or
  // exceed 100 wins.
  //
  // What if we change the game so that players cannot re-use integers?
  //
  // For example, two players might take turns drawing from a common pool of
  // numbers from 1 to 15 without replacement until they reach a total >= 100.
  //
  // Given two integers maxChoosableInteger and desiredTotal, return true if the
  // first player to move can force a win, otherwise, return false. Assume both
  // players play optimally.
  //
  //
  // Example 1:
  //
  //
  // Input: maxChoosableInteger = 10, desiredTotal = 11
  // Output: false
  // Explanation:
  // No matter which integer the first player choose, the first player will lose.
  // The first player can choose an integer from 1 up to 10.
  // If the first player choose 1, the second player can only choose integers from
  // 2 up to 10.
  // The second player will win by choosing 10 and get a total = 11, which is >=
  // desiredTotal.
  // Same with other integers chosen by the first player, the second player will
  // always win.
  //
  //
  // Example 2:
  //
  //
  // Input: maxChoosableInteger = 10, desiredTotal = 0
  // Output: true
  //
  //
  // Example 3:
  //
  //
  // Input: maxChoosableInteger = 10, desiredTotal = 1
  // Output: true
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= maxChoosableInteger <= 20
  // 0 <= desiredTotal <= 300
  //
  //
  // Related Topics Math Dynamic Programming Bit Manipulation Memoization Game
  // Theory Bitmask 👍 2222 👎 341

  public static void main(String[] args) {
    Solution solution = new CanIWin().new Solution();
    String[] data = """
                  10
      11
      10
      0
      10
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q =
        solution.canIWin((int)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private Boolean[] dp;
    private int n, total;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
      dp = new Boolean[1 << maxChoosableInteger];
      n = maxChoosableInteger;
      total = desiredTotal;
      return n * (n + 1) / 2 >= total && dfs(0);
    }

    private Boolean dfs(int state) {
      if (dp[state] != null) {
        return dp[state];
      }
      int sum = 0;
      for (int i = 0; i < n; i++) {
        if (((state >> i) & 1) == 1) {
          sum += i + 1;
        }
      }
      for (int i = 0; i < n; i++) {
        if (((state >> i) & 1) == 0) {
          if (sum + i + 1 >= total || !dfs(state | (1 << i))) {
            dp[state] = true;
            return true;
          }
        }
      }
      dp[state] = false;
      return false;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

  public long minimalKSum(int[] nums, int k) {
    int pre = 0;
    long sum = 0;
    Arrays.sort(nums);
    int n = nums.length;
    // 统计 [pre, nums[i]] 区间内有几个数没出现
    for (int num : nums) {
      if (num - pre > +1) {
        if (k > num - pre) {
          // 全部加上
          k -= num - pre;
          sum += (long)(pre + num) * (num - pre + 1) / 2;
        } else {
          // 只能选择k个
          // 加上后return
          return sum;
        }
      }
    }
    return sum;
  }
}
