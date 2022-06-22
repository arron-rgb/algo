package edu.neu.algo.leetcode.editor.en._20220620;

import edu.neu.util.InputUtil;

public class NextGreaterElementI {

  // The next greater element of some element x in an array is the first greater
  // element that is to the right of x in the same array.
  //
  // You are given two distinct 0-indexed integer arrays nums1 and nums2, where
  // nums1 is a subset of nums2.
  //
  // For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[
  // j] and determine the next greater element of nums2[j] in nums2. If there is no
  // next greater element, then the answer for this query is -1.
  //
  // Return an array ans of length nums1.length such that ans[i] is the next
  // greater element as described above.
  //
  //
  // Example 1:
  //
  //
  // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
  // Output: [-1,3,-1]
  // Explanation: The next greater element for each value of nums1 is as follows:
  // - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
  // the answer is -1.
  // - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
  // - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
  // the answer is -1.
  //
  //
  // Example 2:
  //
  //
  // Input: nums1 = [2,4], nums2 = [1,2,3,4]
  // Output: [3,-1]
  // Explanation: The next greater element for each value of nums1 is as follows:
  // - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
  // - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so
  // the answer is -1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums1.length <= nums2.length <= 1000
  // 0 <= nums1[i], nums2[i] <= 10⁴
  // All integers in nums1 and nums2 are unique.
  // All the integers of nums1 also appear in nums2.
  //
  //
  //
  // Follow up: Could you find an O(nums1.length + nums2.length) solution? Related
  // Topics Array Hash Table Stack Monotonic Stack 👍 3176 👎 209

  public static void main(String[] args) {
    Solution solution = new NextGreaterElementI().new Solution();
    String[] data = """
          [4,1,2]
      [1,3,4,2]
      [2,4]
      [1,2,3,4]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.nextGreaterElement((int[])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int m = nums1.length, n = nums2.length;
      int[] res = new int[m];
      for (int i = 0; i < m; ++i) {
        int j = 0;
        while (j < n && nums2[j] != nums1[i]) {
          ++j;
        }
        int k = j + 1;
        while (k < n && nums2[k] < nums2[j]) {
          ++k;
        }
        res[i] = k < n ? nums2[k] : -1;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
