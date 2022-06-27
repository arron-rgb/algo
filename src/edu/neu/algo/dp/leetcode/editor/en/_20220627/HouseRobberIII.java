package edu.neu.algo.dp.leetcode.editor.en._20220627;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class HouseRobberIII {
  // 337
  // The thief has found himself a new place for his thievery again. There is only
  // one entrance to this area, called root.
  //
  // Besides the root, each house has one and only one parent house. After a tour,
  // the smart thief realized that all houses in this place form a binary tree. It
  // will automatically contact the police if two directly-linked houses were broken
  // into on the same night.
  //
  // Given the root of the binary tree, return the maximum amount of money the
  // thief can rob without alerting the police.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,2,3,null,3,null,1]
  // Output: 7
  // Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [3,4,5,1,3,null,1]
  // Output: 9
  // Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // 0 <= Node.val <= 10⁴
  //
  // Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 639
  // 1 👎 97

  public static void main(String[] args) {
    Solution solution = new HouseRobberIII().new Solution();
    String[] data = """
          [3,2,3,null,3,null,1]
      [3,4,5,1,3,null,1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.rob((TreeNode)params[1 - 1 + i * paramTypes.length]);
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
    public int rob(TreeNode root) {
      return 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
