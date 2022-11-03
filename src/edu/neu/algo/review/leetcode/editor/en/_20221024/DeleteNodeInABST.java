package edu.neu.algo.review.leetcode.editor.en._20221024;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class DeleteNodeInABST {
  // 450
  // Given a root node reference of a BST and a key, delete the node with the
  // given key in the BST. Return the root node reference (possibly updated) of the BST.
  //
  // Basically, the deletion can be divided into two stages:
  //
  //
  // Search for a node to remove.
  // If the node is found, delete the node.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [5,3,6,2,4,null,7], key = 3
  // Output: [5,4,6,2,null,null,7]
  // Explanation: Given key to delete is 3. So we find the node with value 3 and
  // delete it.
  // One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
  // Please notice that another valid answer is [5,2,6,null,4,null,7] and it's
  // also accepted.
  //
  //
  //
  // Example 2:
  //
  //
  // Input: root = [5,3,6,2,4,null,7], key = 0
  // Output: [5,3,6,2,4,null,7]
  // Explanation: The tree does not contain a node with value = 0.
  //
  //
  // Example 3:
  //
  //
  // Input: root = [], key = 0
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  // Each node has a unique value.
  // root is a valid binary search tree.
  // -10⁵ <= key <= 10⁵
  //
  //
  //
  // Follow up: Could you solve it with time complexity O(height of tree)?
  // Related Topics Tree Binary Search Tree Binary Tree 👍 6477 👎 167

  public static void main(String[] args) {
    Solution solution = new DeleteNodeInABST().new Solution();
    String[] data = """
          [5,3,6,2,4,null,7]
      3
      [5,3,6,2,4,null,7]
      0
      []
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q = solution.deleteNode((TreeNode)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
        return null;
      }
      if (root.val > key) {
        root.left = deleteNode(root.left, key);
      } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
      } else {
        if (root.left == null) {
          return root.right;
        }
        if (root.right == null) {
          return root.left;
        }
        TreeNode smallest = root.right;
        while (smallest.left != null) {
          smallest = smallest.left;
        }
        smallest.left = root.left;
        return root.right;
      }
      return root;
    }
  }
  // runtime:0 ms
  // memory:49.4 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
