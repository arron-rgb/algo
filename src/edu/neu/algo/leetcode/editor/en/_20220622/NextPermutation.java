package edu.neu.algo.leetcode.editor.en._20220622;

import edu.neu.util.InputUtil;

public class NextPermutation {

  // A permutation of an array of integers is an arrangement of its members into a
  // sequence or linear order.
  //
  //
  // For example, for arr = [1,2,3], the following are considered permutations of
  // arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
  //
  //
  // The next permutation of an array of integers is the next lexicographically
  // greater permutation of its integer. More formally, if all the permutations of the
  // array are sorted in one container according to their lexicographical order,
  // then the next permutation of that array is the permutation that follows it in the
  // sorted container. If such arrangement is not possible, the array must be
  // rearranged as the lowest possible order (i.e., sorted in ascending order).
  //
  //
  // For example, the next permutation of arr = [1,2,3] is [1,3,2].
  // Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
  // While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does
  // not have a lexicographical larger rearrangement.
  //
  //
  // Given an array of integers nums, find the next permutation of nums.
  //
  // The replacement must be in place and use only constant extra memory.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3]
  // Output: [1,3,2]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,2,1]
  // Output: [1,2,3]
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,1,5]
  // Output: [1,5,1]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 100
  // 0 <= nums[i] <= 100
  //
  // Related Topics Array Two Pointers 👍 11311 👎 3527

  public static void main(String[] args) {
    Solution solution = new NextPermutation().new Solution();
    String[] data = """
          [1,2,3]
      [3,2,1]
      [1,1,5]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.nextPermutation((int[])params[1 - 1 + i * paramTypes.length]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void nextPermutation(int[] nums) {
      if (nums == null || nums.length <= 1) {
        return;
      }
      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--; // Find 1st id i that breaks descending order
      }
      if (i >= 0) { // If not entirely descending
        int j = nums.length - 1; // Start from the end
        while (nums[j] <= nums[i]) {
          j--; // Find rightmost first larger id j
        }
        swap(nums, i, j); // Switch i and j
      }
      reverse(nums, i + 1, nums.length - 1); // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
      while (i < j) {
        swap(A, i++, j--);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
