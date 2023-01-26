package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class BalancedBinaryTree {

  // Given a binary tree, determine if it is height-balanced.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,9,20,null,null,15,7]
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,2,2,3,3,null,null,4,4]
  // Output: false
  //
  //
  // Example 3:
  //
  //
  // Input: root = []
  // Output: true
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 5000].
  // -10⁴ <= Node.val <= 10⁴
  //
  // Related Topics Tree Depth-First Search Binary Tree 👍 7921 👎 446

  public static void main(String[] args) {
    Solution solution = new BalancedBinaryTree().new Solution();
    String[] data = """
                  [3,9,20,null,null,15,7]
      [1,2,2,3,3,null,null,4,4]
      []
      [1,2,2,3,null,null,3,4,null,null,4]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isBalanced((TreeNode)params[1 - 1 + i * paramTypes.length]);
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
    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      }
      return depth(root) != -1;
    }

    int depth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = depth(root.left);
      int right = depth(root.right);
      if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
        return -1;
      }
      return Math.max(left, right) + 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
