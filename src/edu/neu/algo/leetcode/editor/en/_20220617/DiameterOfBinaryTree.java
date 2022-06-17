package edu.neu.algo.leetcode.editor.en._20220617;

import edu.neu.base.TreeNode;

public class DiameterOfBinaryTree {

  // Given the root of a binary tree, return the length of the diameter of the
  // tree.
  //
  // The diameter of a binary tree is the length of the longest path between any
  // two nodes in a tree. This path may or may not pass through the root.
  //
  // The length of a path between two nodes is represented by the number of edges
  // between them.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3,4,5]
  // Output: 3
  // Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,2]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -100 <= Node.val <= 100
  //
  // Related Topics Tree Depth-First Search Binary Tree 👍 8160 👎 506

  public static void main(String[] args) {
    Solution solution = new DiameterOfBinaryTree().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      maxDistance(root);
      return res;
    }

    int maxDistance(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = maxDistance(root.left);
      int right = maxDistance(root.right);
      res = Math.max(res, left + right);
      return Math.max(left, right) + 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
