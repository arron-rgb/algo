package edu.neu.algo.review.leetcode.editor.en._20220715;

import java.util.*;
import edu.neu.util.InputUtil;

public class SplitArrayLargestSum {
  // 410
  // Given an array nums which consists of non-negative integers and an integer m,
  // you can split the array into m non-empty continuous subarrays.
  //
  // Write an algorithm to minimize the largest sum among these m subarrays.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [7,2,5,10,8], m = 2
  // Output: 18
  // Explanation:
  // There are four ways to split nums into two subarrays.
  // The best way is to split it into [7,2,5] and [10,8],
  // where the largest sum among the two subarrays is only 18.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4,5], m = 2
  // Output: 9
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,4,4], m = 3
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 1000
  // 0 <= nums[i] <= 10⁶
  // 1 <= m <= min(50, nums.length)
  //
  // Related Topics Array Binary Search Dynamic Programming Greedy 👍 6300 👎 156

  public static void main(String[] args) {
    Solution solution = new SplitArrayLargestSum().new Solution();
    String[] data = """
          [7,2,5,10,8]
      2
      [1,2,3,4,5]
      2
      [1,4,4]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.splitArray((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int splitArray(int[] nums, int m) {
      int left = -1, right = 0;
      for (int num : nums) {
        left = Math.max(left, num);
        right += num;
      }
      while (left < right) {
        int mid = left + (right - left) / 2;
        // 如果mid满足,看看能不能更小
        // 但满足条件改变区间的时候要注意这个mid不能变
        if (check(mid, nums, m)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    boolean check(int largestSum, int[] nums, int m) {
      // 通过确保sum <= largest,来判断 子数组的个数<=m
      // 注意一下 count是从0开始的，但其实一开始 sum += num，已经有一个了

      // 如果count初始化为1，则最后条件需要设置为count<=m
      int count = 0;
      int sum = 0;
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> tmp = new ArrayList<>();
      for (int num : nums) {
        if (sum + num <= largestSum) {
          sum += num;
          tmp.add(num);
        } else {
          sum = num;
          count++;
          list.add(new ArrayList<>(tmp));
          tmp.clear();
          tmp.add(num);
        }
      }
      if (!tmp.isEmpty()) {
        list.add(new ArrayList<>(tmp));
      }
      if (count < m) {
        System.out.println(count + " " + list.size());
        System.out.println(list);
      }
      return count < m;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
