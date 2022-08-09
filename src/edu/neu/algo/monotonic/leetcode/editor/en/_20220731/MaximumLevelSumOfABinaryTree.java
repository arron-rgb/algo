package edu.neu.algo.monotonic.leetcode.editor.en._20220731;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class MaximumLevelSumOfABinaryTree {
  // 1161
  // Given the root of a binary tree, the level of its root is 1, the level of its
  // children is 2, and so on.
  //
  // Return the smallest level x such that the sum of all the values of nodes at
  // level x is maximal.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,7,0,7,-8,null,null]
  // Output: 2
  // Explanation:
  // Level 1 sum = 1.
  // Level 2 sum = 7 + 0 = 7.
  // Level 3 sum = 7 + -8 = -1.
  // So we return the level with the maximum sum which is level 2.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
  // Output: 2
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 15
  // 32 👎 60

  public static void main(String[] args) {
    Solution solution = new MaximumLevelSumOfABinaryTree().new Solution();
    String[] data = """
          [1,7,0,7,-8,null,null]
      [989,null,10250,98693,-89388,null,null,null,-32127]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxLevelSum((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public int maxLevelSum(TreeNode root) {
      if (root == null) {
        return 0;
      }
      Queue<TreeNode> queue = new ArrayDeque<>();
      int level = 1;
      int max = Integer.MIN_VALUE;
      int res = 0;
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
          TreeNode tmp = queue.remove();
          sum += tmp.val;
          if (tmp.left != null) {
            queue.add(tmp.left);
          }
          if (tmp.right != null) {
            queue.add(tmp.right);
          }
        }
        if (sum > max) {
          max = sum;
          res = level;
        }
        level++;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
