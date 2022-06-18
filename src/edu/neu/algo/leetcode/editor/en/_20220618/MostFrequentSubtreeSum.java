package edu.neu.algo.leetcode.editor.en._20220618;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class MostFrequentSubtreeSum {

  // Given the root of a binary tree, return the most frequent subtree sum. If
  // there is a tie, return all the values with the highest frequency in any order.
  //
  // The subtree sum of a node is defined as the sum of all the node values
  // formed by the subtree rooted at that node (including the node itself).
  //
  //
  // Example 1:
  //
  //
  // Input: root = [5,2,-3]
  // Output: [2,-3,4]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [5,2,-5]
  // Output: [2]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  //
  // Related Topics Hash Table Tree Depth-First Search Binary Tree 👍 1560 👎 235

  public static void main(String[] args) {
    Solution solution = new MostFrequentSubtreeSum().new Solution();
    String[] data = """
          [5,2,-3]
      [5,2,-5]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.findFrequentTreeSum((TreeNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    Map<Integer, Integer> count;

    public int[] findFrequentTreeSum(TreeNode root) {
      count = new HashMap<>();
      int max = 0;
      sum(root);
      for (int v : count.values()) {
        max = Math.max(max, v);
      }
      List<Integer> res = new ArrayList<>();
      int finalMax = max;
      count.forEach((k, v) -> {
        if (v == finalMax) {
          res.add(k);
        }
      });
      return res.stream().mapToInt(t -> t).toArray();
    }

    int sum(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = sum(root.left);
      int right = sum(root.right);
      int sum = left + right + root.val;
      count.put(sum, count.getOrDefault(sum, 0) + 1);
      return sum;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
