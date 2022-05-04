package edu.neu.algo.leetcode.editor.en._20220504;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

  // You are given an integer array nums and an integer k.
  //
  // In one operation, you can pick two numbers from the array whose sum equals k
  // and remove them from the array.
  //
  // Return the maximum number of operations you can perform on the array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4], k = 5
  // Output: 2
  // Explanation: Starting with nums = [1,2,3,4]:
  // - Remove numbers 1 and 4, then nums = [2,3]
  // - Remove numbers 2 and 3, then nums = []
  // There are no more pairs that sum up to 5, hence a total of 2 operations.
  //
  // Example 2:
  //
  //
  // Input: nums = [3,1,3,4,3], k = 6
  // Output: 1
  // Explanation: Starting with nums = [3,1,3,4,3]:
  // - Remove the first two 3's, then nums = [1,4,3]
  // There are no more pairs that sum up to 6, hence a total of 1 operation.
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁹
  // 1 <= k <= 10⁹
  //
  // Related Topics Array Hash Table Two Pointers Sorting 👍 888 👎 28

  public static void main(String[] args) {
    Solution solution = new MaxNumberOfKSumPairs().new Solution();
    int x = (int)10e9;
    long v = (long)10e9;
    System.out.println(x);
    System.out.println(v);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxOperations(int[] nums, int k) {
      Arrays.sort(nums);
      int left = 0, right = nums.length - 1;
      int count = 0;
      while (left < right) {
        long tmp = nums[left] + nums[right];
        if (tmp == k) {
          count++;
          left++;
          right--;
        } else if (tmp < k) {
          left++;
        } else {
          right--;
        }
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
