package edu.neu.algo.review.leetcode.editor.en._20230216;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MinimumDistanceBetweenBSTNodes {
  // 783
  // Given the root of a Binary Search Tree (BST), return the minimum difference
  // between the values of any two different nodes in the tree.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [4,2,6,1,3]
  // Output: 1
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,0,48,null,null,12,49]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [2, 100].
  // 0 <= Node.val <= 10⁵
  //
  //
  //
  // Note: This question is the same as 530: https://leetcode.com/problems/
  // minimum-absolute-difference-in-bst/
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Search
  // Tree Binary Tree 👍 2097 👎 345

  public static void main(String[] args) {
    Solution solution = new MinimumDistanceBetweenBSTNodes().new Solution();
    String[] data = """
                  [4,2,6,1,3]
      [1,0,48,null,null,12,49]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minDiffInBST((TreeNode)params[1 - 1 + i * paramTypes.length]);
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

    int minDistance = Integer.MAX_VALUE;
    // Initially, it will be null.
    TreeNode prevValue;

    void inorderTraversal(TreeNode root) {
      if (root == null) {
        return;
      }
      inorderTraversal(root.left);
      // Find the difference with the previous value if it is there.
      if (prevValue != null) {
        minDistance = Math.min(minDistance, root.val - prevValue.val);
      }
      prevValue = root;
      inorderTraversal(root.right);
    }

    public int minDiffInBST(TreeNode root) {
      inorderTraversal(root);
      return minDistance;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
