package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class MedianOfTwoSortedArrays {
  // 4
  // Given two sorted arrays nums1 and nums2 of size m and n respectively, return
  // the median of the two sorted arrays.
  //
  // The overall run time complexity should be O(log (m+n)).
  //
  //
  // Example 1:
  //
  //
  // Input: nums1 = [1,3], nums2 = [2]
  // Output: 2.00000
  // Explanation: merged array = [1,2,3] and median is 2.
  //
  //
  // Example 2:
  //
  //
  // Input: nums1 = [1,2], nums2 = [3,4]
  // Output: 2.50000
  // Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
  //
  //
  //
  // Constraints:
  //
  //
  // nums1.length == m
  // nums2.length == n
  // 0 <= m <= 1000
  // 0 <= n <= 1000
  // 1 <= m + n <= 2000
  // -10⁶ <= nums1[i], nums2[i] <= 10⁶
  //
  // Related Topics Array Binary Search Divide and Conquer 👍 18174 👎 2140

  public static void main(String[] args) {
    Solution solution = new MedianOfTwoSortedArrays().new Solution();
    String[] data = """
          [1,3]
      [2]
      [1,2]
      [3,4]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      double q = solution.findMedianSortedArrays((int[])params[1 + i * paramTypes.length - 1],
        (int[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
      }

      int m = nums1.length;
      int n = nums2.length;
      int left = 0, right = m;
      // median1：前一部分的最大值
      // median2：后一部分的最小值
      int median1 = 0, median2 = 0;

      while (left <= right) {
        // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
        // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
        int i = (left + right) / 2;
        int j = (m + n + 1) / 2 - i;

        // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
        int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
        int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
        int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
        int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

        if (nums_im1 <= nums_j) {
          median1 = Math.max(nums_im1, nums_jm1);
          median2 = Math.min(nums_i, nums_j);
          left = i + 1;
        } else {
          right = i - 1;
        }
      }

      return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
