package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class AddOneRowToTree {

  public static void main(String[] args) {
    AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
    int i = addOneRowToTree.monkeyMove(500000003);
    System.out.println(i);
    System.out.println(addOneRowToTree.monkeyMove(55));
  }

  public int monkeyMove(int n) {
    int res = p(2, n, (int)1e9 + 7);
    return res - 2;
  }

  int p(long x, long y, int p) {
    long res = 1;
    x = x % p;
    if (x == 0) {
      return 0;
    }
    while (y > 0) {
      if ((y & 1) == 1) {
        res = (res * x) % p;
        y >>= 1;
        x = (x * x) % p;
      }
    }
    return (int)res;
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
      if (root == null) {
        return null;
      }
      if (depth == 2) {
        root.left = new TreeNode(val, root.left, null);
        root.right = new TreeNode(val, null, root.right);
        return root;
      }
      if (depth == 1) {
        root = new TreeNode(val, root, null);
        return root;
      }
      root.left = addOneRow(root.left, val, depth - 1);
      root.right = addOneRow(root.right, val, depth - 1);
      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
