package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class BinaryTreeRightSideView {
  // 199
  // Given the root of a binary tree, imagine yourself standing on the right side
  // of it, return the values of the nodes you can see ordered from top to bottom.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3,null,5,null,4]
  // Output: [1,3,4]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,null,3]
  // Output: [1,3]
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
  // The number of nodes in the tree is in the range [0, 100].
  // -100 <= Node.val <= 100
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 76
  // 24 👎 432

  public static void main(String[] args) {
    Solution solution = new BinaryTreeRightSideView().new Solution();
    String[] data = """
          [1,2,3,null,5,null,4]
      [1,null,3]
      []
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.rightSideView((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public List<Integer> rightSideView(TreeNode root) {
      level = new ArrayList<>();
      dfs(root, 1);
      List<Integer> list = new ArrayList<>();
      for (List<TreeNode> treeNodes : level) {
        list.add(treeNodes.get(treeNodes.size() - 1).val);
      }
      return list;
      // return bfs(root);
    }

    private List<Integer> bfs(TreeNode root) {
      if (root == null) {
        return List.of();
      }
      List<Integer> list = new ArrayList<>();
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.add(root);
      while (!deque.isEmpty()) {
        int size = deque.size();
        TreeNode remove = null;
        for (int i = 0; i < size; i++) {
          remove = deque.remove();
          if (remove.left != null) {
            deque.add(remove.left);
          }
          if (remove.right != null) {
            deque.add(remove.right);
          }
        }
        if (remove != null) {
          list.add(remove.val);
        }
      }
      return list;
    }

    List<List<TreeNode>> level;

    void dfs(TreeNode root, int depth) {
      if (root == null) {
        return;
      }
      if (level.size() < depth) {
        level.add(new ArrayList<>());
      }
      level.get(depth - 1).add(root);
      dfs(root.left, depth + 1);
      dfs(root.right, depth + 1);
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
