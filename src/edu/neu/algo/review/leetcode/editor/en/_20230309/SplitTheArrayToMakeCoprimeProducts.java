package edu.neu.algo.review.leetcode.editor.en._20230309;

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
  // Related Topics Array Hash Table Math Number Theory 👍 186 👎 98

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
      int q = solution.findValidSplit((int[])params[i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private List<Integer> primesOf(int x) {
      List<Integer> result = new ArrayList<>();
      if (x % 2 == 0) {
        result.add(2);
        x >>= Integer.numberOfTrailingZeros(x);
      }
      int p = 3;
      while (p * p <= x) {
        if (x % p == 0) {
          result.add(p);
          do
            x /= p;
          while (x % p == 0);
        }
        p += 2;
      }
      if (x > 1)
        result.add(x);
      return result;
    }

    public int findValidSplit(int[] nums) {
      int n = nums.length;
      Map<Integer, int[]> primeRange = new HashMap<>();
      for (int i = 0; i < n; i++) {
        for (Integer p : primesOf(nums[i])) {
          // primeRange中key为素数p
          // value为一个长度为2的int[], int[0]表示第一次出现的位置, int[1]表示第二次出现的位置
          // int[1]如果为0则表示只出现了第一次
          // 但不影响后面更新的maxEnd
          int[] range = primeRange.putIfAbsent(p, new int[] {i, 0});
          if (range != null) {
            // 持有的引用更改
            range[1] = i;
          }
        }
      }
      //
      int[] maxEnd = new int[n];
      for (int[] range : primeRange.values()) {
        int begin = range[0];
        // 如果range[1]为0，表示该素数只出现在了begin的位置
        // maxEnd[begin]仍为0
        // 不影响maxEnd的存储
        maxEnd[begin] = Math.max(range[1], maxEnd[begin]);
      }
      // maxEnd表示为出现在index的的素数，他最后一次出现在哪里
      int end = 0;
      // end如果为n-1，则right没有元素
      // 从0开始统计，如果从0开始，不断更新end，begin始终无法大于end的话
      // 则表示出现过的素数都无法满足条件
      // 换一个角度
      // 如果begin > end
      // 说明在begin-1的位置,maxEnd是>=end的，这时候出现过的素数均在end及其左边
      // 满足划分
      for (int begin = 0; begin <= end; begin++)
        end = Math.max(maxEnd[begin], end);
      return end < n - 1 ? end : -1;
    }

    public static void main(String[] args) {
      Map<Integer, int[]> map = new HashMap<>();
      int[] value = {1, 3};
      map.putIfAbsent(1, value);
      System.out.println(Arrays.toString(map.get(1)));
      value[1] = 4;
      System.out.println(Arrays.toString(map.get(1)));
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
