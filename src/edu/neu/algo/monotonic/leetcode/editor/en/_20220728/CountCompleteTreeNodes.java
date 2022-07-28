package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class CountCompleteTreeNodes {
  // 222
  // Given the root of a complete binary tree, return the number of the nodes in
  // the tree.
  //
  // According to Wikipedia, every level, except possibly the last, is completely
  // filled in a complete binary tree, and all nodes in the last level are as far
  // left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
  //
  //
  // Design an algorithm that runs in less than O(n) time complexity.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3,4,5,6]
  // Output: 6
  //
  //
  // Example 2:
  //
  //
  // Input: root = []
  // Output: 0
  //
  //
  // Example 3:
  //
  //
  // Input: root = [1]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 5 * 10⁴].
  // 0 <= Node.val <= 5 * 10⁴
  // The tree is guaranteed to be complete.
  //
  // Related Topics Binary Search Tree Depth-First Search Binary Tree 👍 5344 👎 3
  // 23

  public static void main(String[] args) {
    Solution solution = new CountCompleteTreeNodes().new Solution();
    String[] data = """
          [1,2,3,4,5,6]
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
      int q = solution.countNodes((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    int count = 0;

    public int countNodes(TreeNode root) {
      // count = 0;
      // dfs(root);
      // return count;
      if (root == null) {
        return 0;
      }
      return 1 + countNodes(root.left) + countNodes(root.right);
    }

    void dfs(TreeNode root) {
      if (root == null) {
        return;
      }
      if (root.left != null && root.right != null) {
        count++;
      } else if (root.left == null && root.right == null) {
        count++;
      } else if (root.left != null && root.right == null) {
        count++;
      }
      dfs(root.left);
      dfs(root.right);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
