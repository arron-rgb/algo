package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SplitTheArrayToMakeCoprimeProducts {
  // 2584
  // You are given a 0-indexed integer array nums of length n.
  //
  // A split at an index i where 0 <= i <= n - 2 is called valid if the product
  // of the first i + 1 elements and the product of the remaining elements are coprime.
  //
  //
  //
  // For example, if nums = [2, 3, 3], then a split at the index i = 0 is valid
  // because 2 and 9 are coprime, while a split at the index i = 1 is not valid
  // because 6 and 3 are not coprime. A split at the index i = 2 is not valid because i ==
  // n - 1.
  //
  //
  // Return the smallest index i at which the array can be split validly or -1 if
  // there is no such split.
  //
  // Two values val1 and val2 are coprime if gcd(val1, val2) == 1 where gcd(val1,
  // val2) is the greatest common divisor of val1 and val2.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [4,7,8,15,3,5]
  // Output: 2
  // Explanation: The table above shows the values of the product of the first i +
  // 1 elements, the remaining elements, and their gcd at each index i.
  // The only valid split is at index 2.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [4,7,15,8,3,5]
  // Output: -1
  // Explanation: The table above shows the values of the product of the first i +
  // 1 elements, the remaining elements, and their gcd at each index i.
  // There is no valid split.
  //
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 10⁴
  // 1 <= nums[i] <= 10⁶
  //
  //
  // Related Topics Array Hash Table Math Number Theory 👍 235 👎 104

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [4,7,8,15,3,5]
      [4,7,15,8,3,5]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findValidSplit((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findValidSplit(int[] nums) {
      int n = nums.length;
      var left = new HashMap<Integer, Integer>(); // left[p] 表示质数 p 首次出现的下标
      var right = new int[n]; // right[i] 表示左端点为 i 的区间的右端点的最大值

      for (int i = 0; i < n; i++) {
        int x = nums[i];
        // 分解质因数
        for (int d = 2; d * d <= x; ++d) {
          if (x % d == 0) {
            if (left.containsKey(d)) {
              right[left.get(d)] = i; // 记录左端点对应的右端点的最大值
            } else {
              left.put(d, i); // 第一次遇到质数 d
            }
            for (x /= d; x % d == 0; x /= d);
          }
        }
        if (x > 1)
          if (left.containsKey(x))
            right[left.get(x)] = i;
          else
            left.put(x, i);
      }

      for (int l = 0, maxR = 0; l < n; l++) {
        if (l > maxR) // 最远可以遇到 maxR
          return maxR; // 也可以写 l-1
        maxR = Math.max(maxR, right[l]);
      }
      return -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
