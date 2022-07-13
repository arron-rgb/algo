package edu.neu.algo.dp.leetcode.editor.en._20220713;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class BinaryTreeLevelOrderTraversal {
  // 102
  // Given the root of a binary tree, return the level order traversal of its
  // nodes' values. (i.e., from left to right, level by level).
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,9,20,null,null,15,7]
  // Output: [[3],[9,20],[15,7]]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1]
  // Output: [[1]]
  //
  //
  // Example 3:
  //
  //
  // Input: root = []
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 2000].
  // -1000 <= Node.val <= 1000
  //
  // Related Topics Tree Breadth-First Search Binary Tree 👍 9544 👎 188

  public static void main(String[] args) {
    Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    String[] data = """
          [3,9,20,null,null,15,7]
      [1]
      []
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.levelOrder((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return List.of();
      }
      List<List<Integer>> list = new ArrayList<>();
      dfs(list, 0, root);
      return list;
      // return bfs(root);
    }

    void dfs(List<List<Integer>> list, int depth, TreeNode root) {
      if (root == null) {
        return;
      }
      if (depth + 1 > list.size()) {
        list.add(new ArrayList<>());
      }
      list.get(depth).add(root.val);
      dfs(list, depth + 1, root.left);
      dfs(list, depth + 1, root.right);
    }

    private List<List<Integer>> bfs(TreeNode root) {
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.add(root);
      List<List<Integer>> list = new ArrayList<>();
      while (!deque.isEmpty()) {
        int size = deque.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = deque.remove();
          level.add(node.val);
          if (node.left != null) {
            deque.add(node.left);
          }
          if (node.right != null) {
            deque.add(node.right);
          }
        }
        list.add(level);
      }
      return list;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
