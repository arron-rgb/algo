package edu.neu.algo.leetcode.editor.en._20220426;

import java.util.ArrayList;
import java.util.List;

import edu.neu.base.TreeNode;

public class BinaryTreePaths {

  // Given the root of a binary tree, return all root-to-leaf paths in any order.
  //
  // A leaf is a node with no children.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3,null,5]
  // Output: ["1->2->5","1->3"]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1]
  // Output: ["1"]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 100].
  // -100 <= Node.val <= 100
  //
  // Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 400
  // 1 👎 182

  public static void main(String[] args) {
    Solution solution = new BinaryTreePaths().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
      if (root == null) {
        return List.of();
      }
      res = new ArrayList<>();
      dfs(root, "");
      return res;
    }

    void dfs(TreeNode root, String sb) {
      if (root == null) {
        return;
      }
      if (root.left == null && root.right == null) {
        res.add(sb + root.val);
        return;
      }
      if (root.left != null) {
        dfs(root.left, sb + root.val + "->");
      }
      if (root.right != null) {
        dfs(root.right, sb + root.val + "->");
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
