package edu.neu.algo.dp.leetcode.editor.en._20220627;

import edu.neu.base.Pair;
import edu.neu.util.InputUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClimbingStairs {
  // 70
  // You are climbing a staircase. It takes n steps to reach the top.
  //
  // Each time you can either climb 1 or 2 steps. In how many distinct ways can
  // you climb to the top?
  //
  //
  // Example 1:
  //
  //
  // Input: n = 2
  // Output: 2
  // Explanation: There are two ways to climb to the top.
  // 1. 1 step + 1 step
  // 2. 2 steps
  //
  //
  // Example 2:
  //
  //
  // Input: n = 3
  // Output: 3
  // Explanation: There are three ways to climb to the top.
  // 1. 1 step + 1 step + 1 step
  // 2. 1 step + 2 steps
  // 3. 2 steps + 1 step
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 45
  //
  // Related Topics Math Dynamic Programming Memoization 👍 12471 👎 380

  public static void main(String[] args) {
    ClimbingStairs stairs = new ClimbingStairs();
    stairs.minimizeSet(2, 4, 8, 2);
    // Solution solution = new ClimbingStairs().new Solution();
    // String[] data = """
    // 2
    // 3
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[int]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // int q = solution.climbStairs((int)params[1 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int climbStairs(int n) {
      if (n < 4) {
        return n;
      }
      int[] dp = new int[n + 1];
      int[] steps = new int[] {1, 2};
      dp[0] = 1;
      // dp[1] = 1;
      // dp[2] = 2;
      for (int i = 1; i < dp.length; i++) {
        for (int step : steps) {
          if (i - step >= 0) {
            dp[i] += dp[i - step];
          }
        }
        // dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  public int minimizeSet(int d1, int d2, int m, int n) {
    int left = 0, right = (int)1e9;
    while (left < right) {
      int mid = right + (right - left) / 2;
      if (check(mid, d1, d2, m, n)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  boolean check(int mid, int d1, int d2, int m, int n) {
    List<Integer> n1 = new ArrayList<>();
    List<Integer> n2 = new ArrayList<>();
    // mid: 最大元素的最小值
    int max = Integer.MAX_VALUE;
    for (int i = 1; i < max; i++) {
      if (n1.size() == m && n2.size() == n) {
        break;
      }
      boolean f1 = i % d1 != 0;
      boolean f2 = i % d2 != 0;
      if (!f1 && !f2) {
        continue;
      }
      if (f1 && f2) {
        // 加到哪都行
        if (m - n1.size() > n - n2.size()) {
          n1.add(i);
        } else {
          n2.add(i);
        }
      } else if (f1 && n1.size() < m) {
        n1.add(i);
      } else if (f2 && n2.size() < n) {
        n2.add(i);
      }
    }
    return Math.min(n1.stream().max(Integer::compareTo).get(), n2.stream().max(Integer::compareTo).get()) == mid;
  }

  // // 找到第m+n+1个数
  // // 这个数要求即与d1互质 又要与d2互质
  // // 前面的m+n个数
  // // 几种情况
  // // 1: 其他: 只能放他那
  // // 3: 与d1不互 且 与d2不互 不要
  // // 4. 与d1互 且 与d2互: 放谁那都行
  // int max = Integer.MAX_VALUE;
  // int count = 0;
  // int c1 = 0;
  // int c2 = 0;
  // for (int i = 1; i < max; i++) {
  // // f1: true: i与d1互 false：
  // boolean f1 = i % divisor1 != 0;
  // boolean f2 = i % divisor2 != 0;
  // if (!f1 && !f2) {
  // } else {
  // boolean flag = false;
  // if (!f1 && c2 < n) {
  // // 往c2填充
  // c2++;
  // count++;
  // flag = true;
  // } else if (!f2 && c1 < m) {
  // // 往c1填充
  // c1++;
  // count++;
  // flag = true;
  // }
  // if (flag) {
  // System.out.println(i);
  // if (count >= m + n) {
  // System.out.println("last" + i);
  // return i;
  // }
  // }
  // }
  // }
  // return -1;

}
