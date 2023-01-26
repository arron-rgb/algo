package edu.neu.algo.review.leetcode.editor.en._20221216;

import edu.neu.util.InputUtil;

public class MedianOfTwoSortedArrays {

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
  // Related Topics Array Binary Search Divide and Conquer 👍 21103 👎 2379

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
      double q = solution.findMedianSortedArrays((int[])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // int n = nums1.length, m = nums2.length;
    // int total = n + m;
    // if (total % 2 == 0) {
    // return findKthSmallest(nums1, n, 0, nums2, m, 0, total / 2 + 1);
    // } else {
    // int left = findKthSmallest(nums1, n, 0, nums2, m, 0, total / 2);
    // int right = findKthSmallest(nums1, n, 0, nums2, m, 0, total / 2 + 1);
    // return (left + right) * 1.0 / 2;
    // }
    // }
    //
    // int findKthSmallest(int[] nums1, int n, int i, int[] nums2, int m, int j, int k) {
    // if (n > m) {
    // return findKthSmallest(nums2, m, j, nums1, n, i, k);
    // }
    // if (m == 0) {
    // return nums2[j + k - 1];
    // }
    // if (k == 1) {
    // return Math.min(nums1[i], nums2[j]);
    // }
    // int partA = Math.min(k / 2, n), partB = k - partA;
    // int left = nums1[i + partA - 1];
    // int right = nums2[j + partB - 1];
    // if (left == right) {
    // return left;
    // } else if (left > right) {
    // return findKthSmallest(nums1, n, i, nums2, m - partB, j + partB, k - partB);
    // } else {
    // return findKthSmallest(nums1, n - partA, i + partA, nums2, m, j, k - partA);
    // }
    // }

    public static int findKthSmallest(int[] nums1, int m, int i, int[] nums2, int n, int j, int k) {

      if (m > n)
        return findKthSmallest(nums2, n, j, nums1, m, i, k);
      if (m == 0)
        return nums2[j + k - 1];
      if (k == 1)
        return Integer.min(nums1[i], nums2[j]);
      int partA = Integer.min(k / 2, m), partB = k - partA;
      if (nums1[i + partA - 1] == nums2[j + partB - 1])
        return nums1[i + partA - 1];
      else if (nums1[i + partA - 1] > nums2[j + partB - 1])
        return findKthSmallest(nums1, m, i, nums2, n - partB, j + partB, k - partB);
      else
        return findKthSmallest(nums1, m - partA, i + partA, nums2, n, j, k - partA);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] n) {
      int m = nums1.length, len2 = n.length, total = m + len2;
      if (total % 2 != 0) {
        return findKthSmallest(nums1, m, 0, n, len2, 0, total / 2 + 1);
      } else {
        return (findKthSmallest(nums1, m, 0, n, len2, 0, total / 2)
          + findKthSmallest(nums1, m, 0, n, len2, 0, total / 2 + 1)) / 2.0;
      }

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
