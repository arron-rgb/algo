package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class KthSmallestElementInABST {
  // 230
  // Given the root of a binary search tree, and an integer k, return the kᵗʰ
  // smallest value (1-indexed) of all the values of the nodes in the tree.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,1,4,null,2], k = 1
  // Output: 1
  //
  //
  // Example 2:
  //
  //
  // Input: root = [5,3,6,2,4,null,null,1], k = 3
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is n.
  // 1 <= k <= n <= 10⁴
  // 0 <= Node.val <= 10⁴
  //
  //
  //
  // Follow up: If the BST is modified often (i.e., we can do insert and delete
  // operations) and you need to find the kth smallest frequently, how would you
  // optimize?
  // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 8604
  // 👎 151

  public static void main(String[] args) {
    Solution solution = new KthSmallestElementInABST().new Solution();
    String[] data = """
          [3,1,4,null,2]
      1
      [5,3,6,2,4,null,null,1]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.kthSmallest((TreeNode)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public int kthSmallest(TreeNode root, int k) {
      int left = countNodes(root.left);
      if (left >= k) {
        return kthSmallest(root.left, k);
      } else if (left + 1 < k) {
        return kthSmallest(root.right, k - left - 1);
      }
      return root.val;
    }

    int countNodes(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
