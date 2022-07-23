package edu.neu.algo.review.leetcode.editor.en._20220722;

import java.util.*;
import edu.neu.util.InputUtil;

public class CountOfSmallerNumbersAfterSelf {
  // 315
  // You are given an integer array nums and you have to return a new counts array.
  // The counts array has the property where counts[i] is the number of smaller
  // elements to the right of nums[i].
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [5,2,6,1]
  // Output: [2,1,1,0]
  // Explanation:
  // To the right of 5 there are 2 smaller elements (2 and 1).
  // To the right of 2 there is only 1 smaller element (1).
  // To the right of 6 there is 1 smaller element (1).
  // To the right of 1 there is 0 smaller element.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [-1]
  // Output: [0]
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [-1,-1]
  // Output: [0,0]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  // Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree
  // Segment Tree Merge Sort Ordered Set 👍 5988 👎 171

  public static void main(String[] args) {
    Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
    String[] data = """
          [5,2,6,1]
      [-1]
      [-1,-1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.countSmaller((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> countSmaller(int[] nums) {
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
