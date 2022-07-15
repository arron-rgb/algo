package edu.neu.algo.dp.leetcode.editor.en._20220713;

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
  // Related Topics Array Binary Search Dynamic Programming Greedy 👍 6285 👎 155

  public static void main(String[] args) {
    Solution solution = new SplitArrayLargestSum().new Solution();
    ConfusingSolution confusingSolution = new SplitArrayLargestSum().new ConfusingSolution();
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
      q = confusingSolution.splitArray((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);

    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int splitArray(int[] nums, int m) {
      int left = Arrays.stream(nums).max().getAsInt();
      int right = Arrays.stream(nums).sum();
      return binary(nums, left, right, m);
    }

    int binary(int[] nums, int left, int right, int m) {
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (check(nums, mid, m)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    boolean check(int[] nums, int mid, int m) {
      int currentSum = 0;
      int splitsRequired = 0;

      for (int element : nums) {
        if (currentSum + element <= mid) {
          currentSum += element;
        } else {
          currentSum = element;
          splitsRequired++;
        }
      }
      return splitsRequired + 1 <= m;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class ConfusingSolution {
    public int splitArray(int[] nums, int m) {
      int right = 0;
      int left = 0;
      for (int num : nums) {
        right += num;
        left = Math.max(left, num);
      }
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (check(nums, mid, m)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    private boolean check(int[] nums, int mid, int m) {
      int cur = 0;
      int count = 0;

      for (int element : nums) {
        if (cur + element <= mid) {
          cur += element;
        } else {
          cur = element;
          count++;
        }
      }
      return count + 1 <= m;
    }
  }

}
