package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class SearchInABinarySearchTree {
  // 700
  // You are given the root of a binary search tree (BST) and an integer val.
  //
  // Find the node in the BST that the node's value equals val and return the
  // subtree rooted with that node. If such a node does not exist, return null.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [4,2,7,1,3], val = 2
  // Output: [2,1,3]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [4,2,7,1,3], val = 5
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 5000].
  // 1 <= Node.val <= 10⁷
  // root is a binary search tree.
  // 1 <= val <= 10⁷
  //
  // Related Topics Tree Binary Search Tree Binary Tree 👍 4154 👎 157

  public static void main(String[] args) {
    Solution solution = new SearchInABinarySearchTree().new Solution();
    String[] data = """
          [4,2,7,1,3]
      2
      [4,2,7,1,3]
      5
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q =
        solution.searchBST((TreeNode)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
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
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null) {
        return null;
      }
      if (root.val == val) {
        return root;
      }
      if (root.val > val) {
        return searchBST(root.left, val);
      }
      return searchBST(root.right, val);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
