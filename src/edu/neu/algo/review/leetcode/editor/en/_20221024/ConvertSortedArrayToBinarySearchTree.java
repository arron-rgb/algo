package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class ConvertSortedArrayToBinarySearchTree {
  // 108
  // Given an integer array nums where the elements are sorted in ascending order,
  // convert it to a height-balanced binary search tree.
  //
  // A height-balanced binary tree is a binary tree in which the depth of the two
  // subtrees of every node never differs by more than one.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-10,-3,0,5,9]
  // Output: [0,-3,9,-10,null,5]
  // Explanation: [0,-10,5,null,-3,null,9] is also accepted:
  //
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,3]
  // Output: [3,1]
  // Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁴ <= nums[i] <= 10⁴
  // nums is sorted in a strictly increasing order.
  //
  // Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree ?
  // ? 8420 👎 422

  public static void main(String[] args) {
    Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
    String[] data = """
          [-10,-3,0,5,9]
      [1,3]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q = solution.sortedArrayToBST((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      int n = nums.length;
      return sortedArrayToBST(nums, 0, n - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
      if (left > right) {
        return null;
      }
      int mid = (left + right) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      if (left == right) {
        return root;
      }

      root.left = sortedArrayToBST(nums, left, mid - 1);
      root.right = sortedArrayToBST(nums, mid + 1, right);
      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
