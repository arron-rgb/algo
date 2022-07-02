package edu.neu.algo.leetcode.editor.en._20220702;

import java.util.HashMap;
import java.util.Map;

import edu.neu.util.InputUtil;

public class DegreeOfAnArray {
  // 697
  // Given a non-empty array of non-negative integers nums, the degree of this
  // array is defined as the maximum frequency of any one of its elements.
  //
  // Your task is to find the smallest possible length of a (contiguous) subarray
  // of nums, that has the same degree as nums.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,2,3,1]
  // Output: 2
  // Explanation:
  // The input array has a degree of 2 because both elements 1 and 2 appear twice.
  // Of the subarrays that have the same degree:
  // [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
  // The shortest length is 2. So return 2.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,2,3,1,4,2]
  // Output: 6
  // Explanation:
  // The degree is 3 because the element 2 is repeated 3 times.
  // So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
  //
  //
  //
  // Constraints:
  //
  //
  // nums.length will be between 1 and 50,000.
  // nums[i] will be an integer between 0 and 49,999.
  //
  // Related Topics Array Hash Table 👍 2119 👎 1341

  public static void main(String[] args) {
    Solution solution = new DegreeOfAnArray().new Solution();
    String[] data = """
      [1,2,1]
      [1,2,2,3,1]
      [1,2,2,3,1,4,2]
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findShortestSubArray((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findShortestSubArray(int[] nums) {
      Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
      int res = 0, degree = 0;
      for (int i = 0; i < nums.length; ++i) {
        first.putIfAbsent(nums[i], i);
        count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        if (count.get(nums[i]) > degree) {
          degree = count.get(nums[i]);
          res = i - first.get(nums[i]) + 1;
        } else if (count.get(nums[i]) == degree) {
          res = Math.min(res, i - first.get(nums[i]) + 1);
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
