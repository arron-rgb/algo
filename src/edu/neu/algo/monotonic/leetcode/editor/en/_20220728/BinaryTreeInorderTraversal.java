package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class BinaryTreeInorderTraversal {
  // 94
  // Given the root of a binary tree, return the inorder traversal of its nodes'
  // values.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,null,2,3]
  // Output: [1,3,2]
  //
  //
  // Example 2:
  //
  //
  // Input: root = []
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: root = [1]
  // Output: [1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 100].
  // -100 <= Node.val <= 100
  //
  //
  //
  // Follow up: Recursive solution is trivial, could you do it iteratively?
  // Related Topics Stack Tree Depth-First Search Binary Tree 👍 8483 👎 394

  public static void main(String[] args) {
    Solution solution = new BinaryTreeInorderTraversal().new Solution();
    String[] data = """
          [1,null,2,3]
      []
      [1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.inorderTraversal((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public List<Integer> inorderTraversal(TreeNode root) {
      ArrayList<Integer> res = new ArrayList<>();
      dfs(res, root);
      return res;
    }

    void dfs(List<Integer> res, TreeNode root) {
      if (root == null) {
        return;
      }
      dfs(res, root.left);
      res.add(root.val);
      dfs(res, root.right);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
