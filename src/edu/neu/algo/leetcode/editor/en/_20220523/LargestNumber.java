package edu.neu.algo.leetcode.editor.en._20220523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {

  // Given a list of non-negative integers nums, arrange them such that they form
  // the largest number and return it.
  //
  // Since the result may be very large, so you need to return a string instead
  // of an integer.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [10,2]
  // Output: "210"
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,30,34,5,9]
  // Output: "9534330"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 100
  // 0 <= nums[i] <= 10⁹
  //
  // Related Topics String Greedy Sorting 👍 4885 👎 415

  public static void main(String[] args) {
    Solution solution = new LargestNumber().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String largestNumber(int[] nums) {
      List<String> strs = new ArrayList<>(Arrays.stream(nums).mapToObj(String::valueOf).toList());
      strs.sort((o1, o2) -> {
        String num1 = String.valueOf(o1);
        String num2 = String.valueOf(o2);
        return (num2 + num1).compareTo(num1 + num2);
      });
      if ("0".equals(strs.get(0))) {
        return "0";
      }
      return String.join("", strs);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
