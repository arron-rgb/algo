package edu.neu.algo.leetcode.editor.en._20220507;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

  // Given an integer array nums of length n where all the integers of nums are in
  // the range [1, n] and each integer appears once or twice, return an array of all
  // the integers that appears twice.
  //
  // You must write an algorithm that runs in O(n) time and uses only constant
  // extra space.
  //
  //
  // Example 1:
  // Input: nums = [4,3,2,7,8,2,3,1]
  // Output: [2,3]
  // Example 2:
  // Input: nums = [1,1,2]
  // Output: [1]
  // Example 3:
  // Input: nums = [1]
  // Output: []
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 10⁵
  // 1 <= nums[i] <= n
  // Each element in nums appears once or twice.
  //
  // Related Topics Array Hash Table 👍 6102 👎 249

  public static void main(String[] args) {
    Solution solution = new FindAllDuplicatesInAnArray().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        while (nums[i] != nums[nums[i] - 1]) {
          swap(nums, i, nums[i] - 1);
        }
      }
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] - 1 != i) {
          res.add(nums[i]);
        }
      }
      return res;
    }

    void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
