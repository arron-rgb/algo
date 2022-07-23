package edu.neu.algo.review.leetcode.editor.en._20220722;

import java.util.*;
import java.util.stream.Collectors;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class VerticalOrderTraversalOfABinaryTree {
  // 987
  // Given the root of a binary tree, calculate the vertical order traversal of
  // the binary tree.
  //
  // For each node at position (row, col), its left and right children will be at
  // positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
  // the tree is at (0, 0).
  //
  // The vertical order traversal of a binary tree is a list of top-to-bottom
  // orderings for each column index starting from the leftmost column and ending on the
  // rightmost column. There may be multiple nodes in the same row and same column.
  // In such a case, sort these nodes by their values.
  //
  // Return the vertical order traversal of the binary tree.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,9,20,null,null,15,7]
  // Output: [[9],[3,15],[20],[7]]
  // Explanation:
  // Column -1: Only node 9 is in this column.
  // Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
  // Column 1: Only node 20 is in this column.
  // Column 2: Only node 7 is in this column.
  //
  // Example 2:
  //
  //
  // Input: root = [1,2,3,4,5,6,7]
  // Output: [[4],[2],[1,5,6],[3],[7]]
  // Explanation:
  // Column -2: Only node 4 is in this column.
  // Column -1: Only node 2 is in this column.
  // Column 0: Nodes 1, 5, and 6 are in this column.
  // 1 is at the top, so it comes first.
  // 5 and 6 are at the same position (2, 0), so we order them by their
  // value, 5 before 6.
  // Column 1: Only node 3 is in this column.
  // Column 2: Only node 7 is in this column.
  //
  //
  // Example 3:
  //
  //
  // Input: root = [1,2,3,4,6,5,7]
  // Output: [[4],[2],[1,5,6],[3],[7]]
  // Explanation:
  // This case is the exact same as example 2, but with nodes 5 and 6 swapped.
  // Note that the solution remains the same since 5 and 6 are in the same
  // location and should be ordered by their values.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 1000].
  // 0 <= Node.val <= 1000
  //
  // Related Topics Hash Table Tree Depth-First Search Breadth-First Search
  // Binary Tree 👍 3808 👎 3529

  public static void main(String[] args) {
    Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
    String[] data = """
          [3,9,20,null,null,15,7]
      [1,2,3,4,5,6,7]
      [1,2,3,4,6,5,7]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.verticalTraversal((TreeNode)params[1 + i * paramTypes.length - 1]);
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      Map<Integer, List<int[]>> map = new HashMap<>();
      dfs(root, map, 0, 0);
      List<List<int[]>> lists =
        map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).toList();
      List<List<Integer>> res = new ArrayList<>();
      for (List<int[]> list : lists) {
        list.sort((t1, t2) -> {
          if (t1[0] == t2[0]) {
            return t1[1] - t2[1];
          }
          return t1[0] - t2[0];
        });
        res.add(list.stream().map(t -> t[1]).collect(Collectors.toList()));
      }
      return res;
    }

    void dfs(TreeNode root, Map<Integer, List<int[]>> map, int col, int row) {
      if (root == null) {
        return;
      }
      map.computeIfAbsent(col, t -> new ArrayList<>()).add(new int[] {row, root.val});
      dfs(root.left, map, col - 1, row + 1);
      dfs(root.right, map, col + 1, row + 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
