package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class ValidateBinarySearchTree {
  // 98
  // Given the root of a binary tree, determine if it is a valid binary search
  // tree (BST).
  //
  // A valid BST is defined as follows:
  //
  //
  // The left subtree of a node contains only nodes with keys less than the
  // node's key.
  // The right subtree of a node contains only nodes with keys greater than the
  // node's key.
  // Both the left and right subtrees must also be binary search trees.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [2,1,3]
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: root = [5,1,4,null,null,3,6]
  // Output: false
  // Explanation: The root node's value is 5 but its right child's value is 4.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -2³¹ <= Node.val <= 2³¹ - 1
  //
  // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 1290
  // 8 👎 1038

  public static void main(String[] args) {
    Solution solution = new ValidateBinarySearchTree().new Solution();
    String[] data = """
          [1,1]
          [2,1,3]
      [5,1,4,null,null,3,6]
      [5,4,6,null,null,3,7]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isValidBST((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public boolean isValidBST(TreeNode root) {
      return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long min, long max) {
      if (root == null) {
        return true;
      }
      if (root.val <= min || root.val >= max) {
        return false;
      }
      return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
