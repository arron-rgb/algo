package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class LowestCommonAncestorOfABinaryTree {
  // 236
  // Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
  // in the tree.
  //
  // According to the definition of LCA on Wikipedia: “The lowest common ancestor
  // is defined between two nodes p and q as the lowest node in T that has both p
  // and q as descendants (where we allow a node to be a descendant of itself).”
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
  // Output: 3
  // Explanation: The LCA of nodes 5 and 1 is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
  // Output: 5
  // Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
  // of itself according to the LCA definition.
  //
  //
  // Example 3:
  //
  //
  // Input: root = [1,2], p = 1, q = 2
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [2, 10⁵].
  // -10⁹ <= Node.val <= 10⁹
  // All Node.val are unique.
  // p != q
  // p and q will exist in the tree.
  //
  // Related Topics Tree Depth-First Search Binary Tree 👍 10623 👎 287

  public static void main(String[] args) {
    Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    String[] data = """
          [3,5,1,6,2,0,8,null,null,7,4]
      5
      1
      [3,5,1,6,2,0,8,null,null,7,4]
      5
      4
      [1,2]
      1
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, TreeNode, TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q = solution.lowestCommonAncestor((TreeNode)params[1 + i * paramTypes.length - 1],
        (TreeNode)params[2 + i * paramTypes.length - 1], (TreeNode)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x)
   * { val = x; } }
   */
  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return null;
      }
      if (root.val == p.val || root.val == q.val) {
        return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left == null && right == null) {
        return null;
      } else if (left != null && right != null) {
        return root;
      }
      return left != null ? left : right;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
