package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MaximumSumObtainedOfAnyPermutation {
  // 1589
  // We have an array of integers, nums, and an array of requests where requests[i]
  // = [starti, endi]. The iᵗʰ request asks for the sum of nums[starti] + nums[
  // starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.
  //
  //
  // Return the maximum total sum of all requests among all permutations of nums.
  //
  //
  // Since the answer may be too large, return it modulo 10⁹ + 7.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
  // Output: 19
  // Explanation: One permutation of nums is [2,1,3,4,5] with the following result:
  //
  // requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
  // requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
  // Total sum: 8 + 3 = 11.
  // A permutation with a higher total sum is [3,5,4,2,1] with the following
  // result:
  // requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
  // requests[1] -> nums[0] + nums[1] = 3 + 5 = 8
  // Total sum: 11 + 8 = 19, which is the best that you can do.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4,5,6], requests = [[0,1]]
  // Output: 11
  // Explanation: A permutation with the max total sum is [6,5,4,3,2,1] with
  // request sums [11].
  //
  // Example 3:
  //
  //
  // Input: nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
  // Output: 47
  // Explanation: A permutation with the max total sum is [4,10,5,3,2,1] with
  // request sums [19,18,10].
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 10⁵
  // 0 <= nums[i] <= 10⁵
  // 1 <= requests.length <= 10⁵
  // requests[i].length == 2
  // 0 <= starti <= endi < n
  //
  //
  // Related Topics Array Greedy Sorting Prefix Sum 👍 606 👎 31

  public static void main(String[] args) {
    Solution solution = new MaximumSumObtainedOfAnyPermutation().new Solution();
    String[] data = """
                  [1,2,3,4,5]
      [[1,3],[0,1]]
      [1,2,3,4,5,6]
      [[0,1]]
      [1,2,3,4,5,10]
      [[0,2],[1,3],[1,1]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxSumRangeQuery((int[])params[1 - 1 + i * paramTypes.length],
        (int[][])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // public int maxSumRangeQuery(int[] nums, int[][] requests) {
    // int mod = (int)(1e9 + 7);
    // Map<Integer, Long> map = new TreeMap<>();
    // for (int[] request : requests) {
    // map.put(request[0], map.getOrDefault(request[0], 0L) + 1);
    // map.put(request[1] + 1, map.getOrDefault(request[1], 0L) - 1);
    // }
    // int n = nums.length;
    // long cur = 0, res = 0;
    // // 按照能加最多 减最少的分配
    // // 0 1 2 3 4 5
    // // 1 1 0 0 -1
    // // 5 4 3 2 1
    // //
    // for (int i = 0; i < n; i++) {
    // cur += map.getOrDefault(i, 0L);
    // res += cur % mod;
    // }
    // return (int)res;
    // }
    public int maxSumRangeQuery(int[] nums, int[][] reqs) {
      long res = 0, mod = (long)1e9 + 7;
      int n = nums.length;
      int[] count = new int[n];
      for (int[] r : reqs) {
        count[r[0]] += 1;
        if (r[1] + 1 < n)
          count[r[1] + 1] -= 1;
      }
      for (int i = 1; i < n; ++i)
        count[i] += count[i - 1];
      Arrays.sort(nums);
      Arrays.sort(count);
      for (int i = 0; i < n; ++i)
        res += (long)nums[i] * count[i];
      return (int)(res % mod);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
