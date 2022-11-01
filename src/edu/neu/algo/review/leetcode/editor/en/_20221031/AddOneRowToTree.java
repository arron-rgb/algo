package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class AddOneRowToTree {
  // 623
  // Given the root of a binary tree and two integers val and depth, add a row of
  // nodes with value val at the given depth depth.
  //
  // Note that the root node is at depth 1.
  //
  // The adding rule is:
  //
  //
  // Given the integer depth, for each not null tree node cur at the depth depth -
  // 1, create two tree nodes with value val as cur's left subtree root and right
  // subtree root.
  // cur's original left subtree should be the left subtree of the new left
  // subtree root.
  // cur's original right subtree should be the right subtree of the new right
  // subtree root.
  // If depth == 1 that means there is no depth depth - 1 at all, then create a
  // tree node with value val as the new root of the whole original tree, and the
  // original tree is the new root's left subtree.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [4,2,6,3,1,5], val = 1, depth = 2
  // Output: [4,1,1,2,null,null,6,3,1,5]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [4,2,null,3,1], val = 1, depth = 3
  // Output: [4,2,null,1,1,3,null,null,1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // The depth of the tree is in the range [1, 10⁴].
  // -100 <= Node.val <= 100
  // -10⁵ <= val <= 10⁵
  // 1 <= depth <= the depth of tree + 1
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 25
  // 95 👎 221

  public static void main(String[] args) {
    Solution solution = new AddOneRowToTree().new Solution();
    String[] data = """
          [4,2,6,3,1,5]
      1
      2
      [4,2,null,3,1]
      1
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q = solution.addOneRow((TreeNode)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1], (int)params[3 + i * paramTypes.length - 1]);
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
      if (root == null) {
        return null;
      }
      if (depth == 2) {
        root.left = new TreeNode(val, root.left, null);
        root.right = new TreeNode(val, null, root.right);
        return root;
      }
      if (depth == 1) {
        root = new TreeNode(val, root, null);
        return root;
      }
      root.left = addOneRow(root.left, val, depth - 1);
      root.right = addOneRow(root.right, val, depth - 1);
      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
