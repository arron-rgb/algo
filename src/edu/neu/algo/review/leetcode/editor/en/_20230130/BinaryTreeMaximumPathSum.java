package edu.neu.algo.review.leetcode.editor.en._20230130;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class BinaryTreeMaximumPathSum {
  // 124
  // A path in a binary tree is a sequence of nodes where each pair of adjacent
  // nodes in the sequence has an edge connecting them. A node can only appear in the
  // sequence at most once. Note that the path does not need to pass through the root.
  //
  //
  // The path sum of a path is the sum of the node's values in the path.
  //
  // Given the root of a binary tree, return the maximum path sum of any non-
  // empty path.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3]
  // Output: 6
  // Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
  //
  //
  //
  // Example 2:
  //
  //
  // Input: root = [-10,9,20,null,null,15,7]
  // Output: 42
  // Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
  // = 42.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 3 * 10⁴].
  // -1000 <= Node.val <= 1000
  //
  //
  // Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 134
  // 08 👎 628

  public static void main(String[] args) {
    Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    String[] data = """
                  [1,2,3]
      [-10,9,20,null,null,15,7]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxPathSum((TreeNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
      postOrder(root);
      return val;
    }

    private int postOrder(TreeNode root) {
      if (root == null)
        return 0;
      int sumLeft = postOrder(root.left);
      int sumRight = postOrder(root.right);
      int max = root.val;
      max = Math.max(max, root.val + sumLeft);
      max = Math.max(max, root.val + sumRight);
      max = Math.max(max, root.val + sumLeft + sumRight);
      if (max > val)
        val = max;
      return Math.max(root.val, root.val + Math.max(sumLeft, sumRight));
    }
  }
  // runtime:1 ms
  // memory:44.1 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
