package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class AverageOfLevelsInBinaryTree {
  // 637
  // Given the root of a binary tree, return the average value of the nodes on
  // each level in the form of an array. Answers within 10⁻⁵ of the actual answer will
  // be accepted.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,9,20,null,null,15,7]
  // Output: [3.00000,14.50000,11.00000]
  // Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
  // and on level 2 is 11.
  // Hence return [3, 14.5, 11].
  //
  //
  // Example 2:
  //
  //
  // Input: root = [3,9,20,15,7]
  // Output: [3.00000,14.50000,11.00000]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -2³¹ <= Node.val <= 2³¹ - 1
  //
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 44
  // 93 👎 280

  public static void main(String[] args) {
    Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    String[] data = """
                  [3,9,20,null,null,15,7]
      [3,9,20,15,7]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Double> q = solution.averageOfLevels((TreeNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
      if (root == null) {
        return List.of(0.0);
      }
      List<Double> res = new ArrayList<>();
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.add(root);
      while (!deque.isEmpty()) {
        int n = deque.size();
        long sum = 0;
        for (int i = 0; i < n; i++) {
          TreeNode node = deque.poll();
          sum += node.val;
          if (node.left != null) {
            deque.add(node.left);
          }
          if (node.right != null) {
            deque.add(node.right);
          }
        }
        res.add(sum * 1.0 / n);
      }
      return res;
    }

  }
  // runtime:2 ms
  // memory:46.9 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
