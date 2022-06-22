package edu.neu.algo.leetcode.editor.en._20220621;

import java.util.ArrayDeque;
import java.util.Deque;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class FindBottomLeftTreeValue {

  // Given the root of a binary tree, return the leftmost value in the last row of
  // the tree.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [2,1,3]
  // Output: 1
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,2,3,4,null,5,6,null,null,7]
  // Output: 7
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁴].
  // -2³¹ <= Node.val <= 2³¹ - 1
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 22
  // 09 👎 220

  public static void main(String[] args) {
    Solution solution = new FindBottomLeftTreeValue().new Solution();
    String[] data = """
          [2,1,3]
      [1,2,3,4,null,5,6,null,null,7]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findBottomLeftValue((TreeNode)params[1 - 1 + i * paramTypes.length]);
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
    public int findBottomLeftValue(TreeNode root) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      TreeNode res = null;
      while (!queue.isEmpty()) {
        int size = queue.size();
        res = queue.peekFirst();
        for (int i = 0; i < size; i++) {
          TreeNode poll = queue.pollFirst();
          if (poll.left != null) {
            queue.offerLast(poll.left);
          }
          if (poll.right != null) {
            queue.offerLast(poll.right);
          }
        }
        if (queue.isEmpty()) {
          return res.val;
        }
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
