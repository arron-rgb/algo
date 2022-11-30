package edu.neu.algo.review.leetcode.editor.en._20221118;

import edu.neu.util.InputUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SplitArrayWithSameAverage {

  // You are given an integer array nums.
  //
  // You should move each element of nums into one of the two arrays A and B such
  // that A and B are non-empty, and average(A) == average(B).
  //
  // Return true if it is possible to achieve that and false otherwise.
  //
  // Note that for an array arr, average(arr) is the sum of all the elements of
  // arr over the length of arr.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4,5,6,7,8]
  // Output: true
  // Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of
  // them have an average of 4.5.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,1]
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 30
  // 0 <= nums[i] <= 10⁴
  //
  // Related Topics Array Math Dynamic Programming Bit Manipulation Bitmask 👍 100
  // 1 👎 124

  public static void main(String[] args) {
    Solution solution = new SplitArrayWithSameAverage().new Solution();
    String[] data = """
                  [1,2,3,4,5,6,7,8]
      [3,1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.splitArraySameAverage((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean splitArraySameAverage(int[] nums) {
      // 返回：can we split an array into 2 arrays, their averages are same

      // Sa / Na = Sb / Nb = (S-Sa)/(N-Na)
      // Sa/Na = S/N
      // 求：是否存在一个子序列，它的平均数 = 整个数组的平均数
      // 注意到：把每个数都减去数组的平均数的话，这个数组的总和就变成了0
      // 但平均数可能会是浮点数，如果把减去的平均数改成减去数组的总和
      // 总和仍然为0
      int sum = Arrays.stream(nums).sum();
      int n = nums.length;
      if (n == 1) {
        return false;
      }
      for (int i = 0; i < n; i++) {
        nums[i] = nums[i] * n - sum;
      }
      // 此时 nums的和为0，如果我们能够找到一个子序列，它的平均数也为0。则剩下的数的和肯定也为0，所以平均数也为0
      // 因此我们只需要判断 数组中是否存在一个子序列的总和为0 或 某个序列对应的和S，存在对应的和为-S
      // 例如当 i=6 时，二进制表示为 110，则意味着选取第2和第3个元素求和，即 tot=nums[2]+nums[1]
      // i: 因为至少要取一个元素，所以 i 从1开始，直到 2^m-1
      Set<Integer> left = new HashSet<>();
      int m = n / 2;
      for (int i = 1; i < (1 << m); i++) {
        int tot = 0;
        // 对每种取法，都要遍历前半个数组，选取相应的元素进行求和
        for (int j = 0; j < m; j++) {
          if ((i & (1 << j)) != 0) {
            tot += nums[j];
          }
        }
        // 如果前半个数组有部分元素之和为0，则剩余的所有元素之和肯定也为0，直接返回true。
        if (tot == 0) {
          return true;
        }
        left.add(tot);
      }
      // 记录后半个数组的所有元素之和，用于后面判断，避免出现同时选择数组中所有元素之和为0的情况
      int rsum = 0;
      for (int i = m; i < n; i++) {
        rsum += nums[i];
      }
      // 对后半个数组如法炮制
      for (int i = 1; i < (1 << (n - m)); i++) {
        int tot = 0;
        for (int j = m; j < n; j++) {
          if ((i & (1 << (j - m))) != 0) {
            tot += nums[j];
          }
        }
        // 当 后半个数组有部分元素之和为0，或者 前半个数组的子集的元素之和 是 后半个数组的子集的元素之和 的相反数时，返回true。
        // 为什么不会出现 前半个数组的真子集的元素之和 是 后半个数组的全部元素之和 的相反数这种情况？
        // 因为如果是这种情况，在遍历前半个数组时就会直接返回true
        if (tot == 0 || (rsum != tot && left.contains(-tot))) {
          return true;
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
