package edu.neu.algo.monotonic.leetcode.editor.en._20220726;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class FlattenBinaryTreeToLinkedList {
  // 114
  // Given the root of a binary tree, flatten the tree into a "linked list":
  //
  //
  // The "linked list" should use the same TreeNode class where the right child
  // pointer points to the next node in the list and the left child pointer is always
  // null.
  // The "linked list" should be in the same order as a pre-order traversal of
  // the binary tree.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,5,3,4,null,6]
  // Output: [1,null,2,null,3,null,4,null,5,null,6]
  //
  //
  // Example 2:
  //
  //
  // Input: root = []
  // Output: []
  //
  //
  // Example 3:
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
  // The number of nodes in the tree is in the range [0, 2000].
  // -100 <= Node.val <= 100
  //
  //
  //
  // Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related
  // Topics Linked List Stack Tree Depth-First Search Binary Tree 👍 7819 👎 471

  public static void main(String[] args) {
    Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    String[] data = """
          [1,2,3]
          [5,null,6]
          [1,2,5,3,4,null,6]
      []
      [0]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode param = (TreeNode)params[1 + i * paramTypes.length - 1];
      solution.flatten(param);
      System.out.println(param);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public void flatten(TreeNode root) {
      if (root == null) {
        return;
      }
      flatten(root.left);
      TreeNode right = root.right;
      root.right = root.left;
      root.left = null;
      while (root.right != null) {
        root = root.right;
      }
      flatten(right);
      root.right = right;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
