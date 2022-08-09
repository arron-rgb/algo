package edu.neu.algo.monotonic.leetcode.editor.en._20220809;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class PrintBinaryTree {
  // 655
  // Given the root of a binary tree, construct a 0-indexed m x n string matrix
  // res that represents a formatted layout of the tree. The formatted layout matrix
  // should be constructed using the following rules:
  //
  //
  // The height of the tree is height and the number of rows m should be equal to
  // height + 1.
  // The number of columns n should be equal to 2ʰᵉⁱᵍʰᵗ⁺¹ - 1.
  // Place the root node in the middle of the top row (more formally, at location
  // res[0][(n-1)/2]).
  // For each node that has been placed in the matrix at position res[r][c],
  // place its left child at res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] and its right child at res[r+1][c+2ʰᵉ
  // ⁱᵍʰᵗ⁻ʳ⁻¹].
  // Continue this process until all the nodes in the tree have been placed.
  // Any empty cells should contain the empty string "".
  //
  //
  // Return the constructed matrix res.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2]
  // Output:
  // [["","1",""],
  //  ["2","",""]]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,2,3,null,4]
  // Output:
  // [["","","","1","","",""],
  //  ["","2","","","","3",""],
  //  ["","","4","","","",""]]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 2¹⁰].
  // -99 <= Node.val <= 99
  // The depth of the tree will be in the range [1, 10].
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 23
  // 5 👎 272

  public static void main(String[] args) {
    Solution solution = new PrintBinaryTree().new Solution();
    String[] data = """
          [1,2]
      [1,2,3,null,4]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<String>> q = solution.printTree((TreeNode)params[1 + i * paramTypes.length - 1]);
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

    int getDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = getDepth(root.left);
      int right = getDepth(root.right);
      return Math.max(left, right) + 1;
    }

    class Pair {
      TreeNode root;
      int index;
      int parentIndex;

      public Pair(TreeNode root, int index, int parentIndex) {
        this.root = root;
        this.index = index;
        this.parentIndex = parentIndex;
      }
    }

    public List<List<String>> printTree(TreeNode root) {
      List<List<String>> res = new ArrayList<>();
      int n = getDepth(root);
      Deque<Pair> deque = new ArrayDeque<>();
      List<String> levelTemplate = new ArrayList<>();
      int col = (1 << n) - 1;
      for (int i = 0; i < col; i++) {
        levelTemplate.add("");
      }
      Pair pair = new Pair(root, 0, -1);
      pair.index = col / 2;
      pair.parentIndex = -1;
      deque.add(pair);
      while (!deque.isEmpty()) {
        List<String> level = new ArrayList<>(levelTemplate);
        Deque<Pair> next = new ArrayDeque<>();
        int size = deque.size();
        int r = res.size();
        for (int i = 0; i < size; i++) {
          Pair remove = deque.remove();
          int c = remove.index;
          int offset = 1 << (n - r - 2);
          level.set(c, String.valueOf(remove.root.val));
          if (remove.root.left != null) {
            next.add(new Pair(remove.root.left, c - offset, c));
          }
          if (remove.root.right != null) {
            next.add(new Pair(remove.root.right, c + offset, c));
          }
        }
        deque = next;
        res.add(level);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
