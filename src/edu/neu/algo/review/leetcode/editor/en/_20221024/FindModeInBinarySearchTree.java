package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class FindModeInBinarySearchTree {
  // 501
  // Given the root of a binary search tree (BST) with duplicates, return all the
  // mode(s) (i.e., the most frequently occurred element) in it.
  //
  // If the tree has more than one mode, return them in any order.
  //
  // Assume a BST is defined as follows:
  //
  //
  // The left subtree of a node contains only nodes with keys less than or equal
  // to the node's key.
  // The right subtree of a node contains only nodes with keys greater than or
  // equal to the node's key.
  // Both the left and right subtrees must also be binary search trees.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,null,2,2]
  // Output: [2]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [0]
  // Output: [0]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  //
  //
  //
  // Follow up: Could you do that without using any extra space? (Assume that the
  // implicit stack space incurred due to recursion does not count). Related Topics
  // Tree Depth-First Search Binary Search Tree Binary Tree 👍 2593 👎 612

  public static void main(String[] args) {
    Solution solution = new FindModeInBinarySearchTree().new Solution();
    String[] data = """
          [1,null,2,2]
      [0]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.findMode((TreeNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  public class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
      if (root == null) {
        return new int[0];
      }
      List<Integer> list = new ArrayList<>();
      traverse(root, list);

      int[] res = new int[list.size()];
      for (int i = 0; i < list.size(); ++i) {
        res[i] = list.get(i);
      }
      return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
      if (root == null) {
        return;
      }
      traverse(root.left, list);
      if (prev != null) {
        if (root.val == prev) {
          count++;
        } else {
          count = 1;
        }
      }
      if (count > max) {
        max = count;
        list.clear();
        list.add(root.val);
      } else if (count == max) {
        list.add(root.val);
      }
      prev = root.val;
      traverse(root.right, list);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
