package edu.neu.algo.review.leetcode.editor.en._20230219;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SearchInsertPosition {
  // 35
  // Given a sorted array of distinct integers and a target value, return the
  // index if the target is found. If not, return the index where it would be if it were
  // inserted in order.
  //
  // You must write an algorithm with O(log n) runtime complexity.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,5,6], target = 5
  // Output: 2
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,3,5,6], target = 2
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,3,5,6], target = 7
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁴ <= nums[i] <= 10⁴
  // nums contains distinct values sorted in ascending order.
  // -10⁴ <= target <= 10⁴
  //
  //
  // Related Topics Array Binary Search 👍 11775 👎 531

  public static void main(String[] args) {
    Solution solution = new SearchInsertPosition().new Solution();
    String[] data = """
                  [1,3,5,6]
      5
      [1,3,5,6]
      2
      [1,3,5,6]
      7
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.searchInsert((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int searchInsert(int[] nums, int target) {
      // nums中有target
      // 返回最左边的位置-1
      // nums中没有target
      // 找到最后一个小于它的数, 如果没有比他小的, 返回0
      // 如果全都比他小，返回n-1
      int left = 0, right = nums.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
          right = mid - 1;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          return mid;
        }
      }
      return left;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
