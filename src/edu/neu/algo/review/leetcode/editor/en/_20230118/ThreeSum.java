package edu.neu.algo.review.leetcode.editor.en._20230118;

import edu.neu.util.InputUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
  // k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
  //
  // Notice that the solution set must not contain duplicate triplets.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-1,0,1,2,-1,-4]
  // Output: [[-1,-1,2],[-1,0,1]]
  // Explanation:
  // nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
  // nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
  // nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
  // The distinct triplets are [-1,0,1] and [-1,-1,2].
  // Notice that the order of the output and the order of the triplets does not
  // matter.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,1,1]
  // Output: []
  // Explanation: The only possible triplet does not sum up to 0.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [0,0,0]
  // Output: [[0,0,0]]
  // Explanation: The only possible triplet sums up to 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 3 <= nums.length <= 3000
  // -10⁵ <= nums[i] <= 10⁵
  //
  // Related Topics Array Two Pointers Sorting 👍 23578 👎 2154

  public static void main(String[] args) {
    Solution solution = new ThreeSum().new Solution();
    String[] data = """
                  [-1,0,1,2,-1,-4]
      [0,1,1]
      [0,0,0,0]
      [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.threeSum((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      // not contain duplicate triplets
      // System.out.println(Arrays.toString(nums));
      List<List<Integer>> res = new ArrayList<>();
      // so we have to skip the elements which have same value

      // for each element, nums[i]
      // find the pairs, whose sum is equal to 0 - nums[i]
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        // skip the same value
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        // two sum
        int j = i + 1, k = n - 1;
        while (j < k) {
          // skip the element which is equal to the value we have already counted
          while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          int tmp = nums[j] + nums[k] + nums[i];
          if (j == k) {
            break;
          }
          if (tmp < 0) {
            j++;
          } else if (tmp > 0) {
            k--;
          } else {
            res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
            j++;
          }
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
