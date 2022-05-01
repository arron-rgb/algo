package edu.neu.algo.leetcode.editor.en._20220428;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

  // Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the
  // Pascal's triangle.
  //
  // In Pascal's triangle, each number is the sum of the two numbers directly
  // above it as shown:
  //
  //
  // Example 1:
  // Input: rowIndex = 3
  // Output: [1,3,3,1]
  // Example 2:
  // Input: rowIndex = 0
  // Output: [1]
  // Example 3:
  // Input: rowIndex = 1
  // Output: [1,1]
  //
  //
  // Constraints:
  //
  //
  // 0 <= rowIndex <= 33
  //
  //
  //
  // Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
  // space?
  // Related Topics Array Dynamic Programming 👍 2510 👎 265

  public static void main(String[] args) {
    Solution solution = new PascalsTriangleII().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> getRow(int k) {
      Integer[] arr = new Integer[k + 1];
      Arrays.fill(arr, 0);
      arr[0] = 1;
      for (int i = 1; i <= k; i++) {
        for (int j = i; j > 0; j--) {
          arr[j] = arr[j] + arr[j - 1];
        }
      }
      return Arrays.asList(arr);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
