package edu.neu.algo.leetcode.editor.en._20220701;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class RangeSumOfBST {
  // 938
  // Given the root node of a binary search tree and two integers low and high,
  // return the sum of values of all nodes with a value in the inclusive range [low,
  // high].
  //
  //
  // Example 1:
  //
  //
  // Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
  // Output: 32
  // Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
  // Output: 23
  // Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 2 * 10⁴].
  // 1 <= Node.val <= 10⁵
  // 1 <= low <= high <= 10⁵
  // All Node.val are unique.
  //
  // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 4296
  // 👎 334

  public static void main(String[] args) {
    Solution solution = new RangeSumOfBST().new Solution();
    String[] data = """
          [10,5,15,3,7,null,18]
      7
      15
      [10,5,15,3,7,13,18,1,null,6]
      6
      10
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.rangeSumBST((TreeNode)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
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
    int res;

    public int rangeSumBST(TreeNode root, int low, int high) {
      res = 0;
      dfs(root, low, high);
      return res;
    }

    void dfs(TreeNode root, int low, int high) {
      if (root == null) {
        return;
      }
      if (root.val >= low && root.val <= high) {
        res += root.val;
      }
      dfs(root.left, low, high);
      dfs(root.right, low, high);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
