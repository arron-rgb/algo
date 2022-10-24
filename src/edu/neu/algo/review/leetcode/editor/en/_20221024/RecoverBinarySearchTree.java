package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class RecoverBinarySearchTree {
  // 99
  // You are given the root of a binary search tree (BST), where the values of
  // exactly two nodes of the tree were swapped by mistake. Recover the tree without
  // changing its structure.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,3,null,null,2]
  // Output: [3,1,null,null,2]
  // Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
  // makes the BST valid.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [3,1,4,null,null,2]
  // Output: [2,1,4,null,null,3]
  // Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
  // and 3 makes the BST valid.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [2, 1000].
  // -2³¹ <= Node.val <= 2³¹ - 1
  //
  //
  //
  // Follow up: A solution using O(n) space is pretty straight-forward. Could you
  // devise a constant O(1) space solution? Related Topics Tree Depth-First Search
  // Binary Search Tree Binary Tree 👍 6273 👎 209

  public static void main(String[] args) {
    Solution solution = new RecoverBinarySearchTree().new Solution();
    String[] data = """
          [1,3,null,null,2]
      [3,1,4,null,null,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.recoverTree((TreeNode)params[1 + i * paramTypes.length - 1]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
      if (root == null) {
        return;
      }
      inorder(root);
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }

    private void inorder(TreeNode root) {
      if (root == null) {
        return;
      }
      inorder(root.left);
      if (first == null && (pre == null || pre.val >= root.val)) {
        first = pre;
      }
      if (first != null && pre.val >= root.val) {
        second = root;
      }
      pre = root;
      inorder(root.right);
    }
  }
  // runtime:2 ms
  // memory:48.2 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
