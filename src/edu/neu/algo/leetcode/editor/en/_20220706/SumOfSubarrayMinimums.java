package edu.neu.algo.leetcode.editor.en._20220706;

import java.util.ArrayDeque;
import java.util.Deque;

import edu.neu.util.InputUtil;

public class SumOfSubarrayMinimums {
  // 907
  // Given an array of integers arr, find the sum of min(b), where b ranges over
  // every (contiguous) subarray of arr. Since the answer may be large, return the
  // answer modulo 10⁹ + 7.
  //
  //
  // Example 1:
  //
  //
  // Input: arr = [3,1,2,4]
  // Output: 17
  // Explanation:
  // Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,
  // 2,4].
  // Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
  // Sum is 17.
  //
  //
  // Example 2:
  //
  //
  // Input: arr = [11,81,94,43,3]
  // Output: 444
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= arr.length <= 3 * 10⁴
  // 1 <= arr[i] <= 3 * 10⁴
  //
  // Related Topics Array Dynamic Programming Stack Monotonic Stack 👍 3785 👎 250
  //

  public static void main(String[] args) {
    Solution solution = new SumOfSubarrayMinimums().new Solution();
    String[] data = """
          [3,1,2,4]
      [11,81,94,43,3]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.sumSubarrayMins((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int mod = (int)(1e9 + 7);
    // 对于每一个元素 e，可以让它作为最小值的那些数组必定在这样的区间 (a,b) 内，其中 a 为 e 左边第一个小于等于它的值的位置，b 为 e 右边第一个小于它的值的位置。
    //
    // 简言之，寻找以每个元素作为最小值时的最长子数组区间。
    //
    // 所以核心问题和这两道题（1856. 子数组最小乘积的最大值、84. 柱状图中最大的矩形）没有差别。
    //
    // 最直接的办法就是从每个元素开始向两边搜索对应的 a 和 b 即可，更优化的办法同样是使用单调递增栈。
    //
    // 区间 (a, b) 内的所有包含元素 e 的数组个数的计算公式为：(a - b - 1) + (idx - a - 1) * (b - idx - 1)。其中 idx 为元素 e 的索引位置。

    public int sumSubarrayMins(int[] arr) {
      int n = arr.length;
      int[] dp = new int[n + 1];
      Deque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
          deque.pollLast();
        }
        int top = deque.isEmpty() ? -1 : deque.peekLast();
        dp[i + 1] = (dp[top + 1] + (i - top) * arr[i]) % mod;
        deque.offerLast(i);
      }
      int sum = 0;
      for (int i : dp) {
        sum += i;
        sum %= mod;
      }
      return sum;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
