package edu.neu.algo.leetcode.editor.en._20220416;

import java.util.LinkedList;
import java.util.Queue;

import edu.neu.base.TreeNode;

public class ConvertBSTToGreaterTree {

  // Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
  // such that every key of the original BST is changed to the original key plus the
  // sum of all keys greater than the original key in BST.
  //
  // As a reminder, a binary search tree is a tree that satisfies these
  // constraints:
  //
  //
  // The left subtree of a node contains only nodes with keys less than the
  // node's key.
  // The right subtree of a node contains only nodes with keys greater than the
  // node's key.
  // Both the left and right subtrees must also be binary search trees.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
  // Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [0,null,1]
  // Output: [1,null,1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 10⁴].
  // -10⁴ <= Node.val <= 10⁴
  // All the values in the tree are unique.
  // root is guaranteed to be a valid binary search tree.
  //
  //
  //
  // Note: This question is the same as 1038: https://leetcode.com/problems/
  // binary-search-tree-to-greater-sum-tree/
  // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 3456
  // 👎 151
  public static class MainClass {
    public static TreeNode stringToTreeNode(String input) {
      input = input.trim();
      input = input.substring(1, input.length() - 1);
      if (input.length() == 0) {
        return null;
      }

      String[] parts = input.split(",");
      String item = parts[0];
      TreeNode root = new TreeNode(Integer.parseInt(item));
      Queue<TreeNode> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);

      int index = 1;
      while (!nodeQueue.isEmpty()) {
        TreeNode node = nodeQueue.remove();

        if (index == parts.length) {
          break;
        }

        item = parts[index++];
        item = item.trim();
        if (!item.equals("null")) {
          int leftNumber = Integer.parseInt(item);
          node.left = new TreeNode(leftNumber);
          nodeQueue.add(node.left);
        }

        if (index == parts.length) {
          break;
        }

        item = parts[index++];
        item = item.trim();
        if (!item.equals("null")) {
          int rightNumber = Integer.parseInt(item);
          node.right = new TreeNode(rightNumber);
          nodeQueue.add(node.right);
        }
      }
      return root;
    }

    public static String treeNodeToString(TreeNode root) {
      if (root == null) {
        return "[]";
      }

      String output = "";
      Queue<TreeNode> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);
      while (!nodeQueue.isEmpty()) {
        TreeNode node = nodeQueue.remove();

        if (node == null) {
          output += "null, ";
          continue;
        }

        output += node.val + ", ";
        nodeQueue.add(node.left);
        nodeQueue.add(node.right);
      }
      return "[" + output.substring(0, output.length() - 2) + "]";
    }

  }

  public static void main(String[] args) {
    Solution solution = new ConvertBSTToGreaterTree.Solution();
    String line = "[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]";
    TreeNode root = MainClass.stringToTreeNode(line);
    solution.convertBST(root);
  }

  static

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public TreeNode convertBST(TreeNode root) {
      dfs(root, 0);
      return root;
    }

    /**
     * @param root
     * @param sum
     *          root节点右边所有节点的总和
     * @return 累加后的值，传递给左边节点
     */
    int dfs(TreeNode root, int sum) {
      if (root == null) {
        return sum;
      }
      root.val += dfs(root.right, sum);
      return dfs(root.left, root.val);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
