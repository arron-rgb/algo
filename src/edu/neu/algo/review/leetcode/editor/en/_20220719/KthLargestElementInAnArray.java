package edu.neu.algo.review.leetcode.editor.en._20220719;

import java.util.*;
import edu.neu.util.InputUtil;

public class KthLargestElementInAnArray {
  // 215
  // Given an integer array nums and an integer k, return the kᵗʰ largest element
  // in the array.
  //
  // Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ
  // distinct element.
  //
  // You must solve it in O(n) time complexity.
  //
  //
  // Example 1:
  // Input: nums = [3,2,1,5,6,4], k = 2
  // Output: 5
  // Example 2:
  // Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
  // Output: 4
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  // Related Topics Array Divide and Conquer Sorting Heap (Priority Queue)
  // Quickselect 👍 10921 👎 560

  public static void main(String[] args) {
    Solution solution = new KthLargestElementInAnArray().new Solution();
    String[] data = """
          [3,2,1,5,6,4]
      2
      [3,2,3,1,2,4,5,5,6]
      4
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findKthLargest((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for (int val : nums) {
        pq.offer(val);
        if (pq.size() > k) {
          pq.poll();
        }
      }
      return pq.peek();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
