package edu.neu.algo.monotonic.leetcode.editor.en._20221019;

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
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 87
  // 89 👎 510

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

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<List<Integer>> dfs = new ArrayList<>();
      List<Integer> res = new ArrayList<>();
      dfs(dfs, root, 0);
      for (List<Integer> list : dfs) {
        res.add(list.get(list.size() - 1));
      }
      return res;
    }

    void dfs(List<List<Integer>> dfs, TreeNode root, int level) {
      if (root == null) {
        return;
      }
      if (dfs.size() <= level) {
        dfs.add(new ArrayList<>());
      }
      List<Integer> cur = dfs.get(level);
      dfs(dfs, root.left, level + 1);
      cur.add(root.val);
      dfs(dfs, root.right, level + 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public boolean checkInclusion(String s1, String s2) {
    int[] s = count(s1);
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 > len2) {
      return false;
    }
    if (len1 == len2) {
      return Arrays.equals(s, count(s2));
    }
    for (int i = 0; i < len2 - len1; i++) {
      if (Arrays.equals(s, count(s2.substring(i, i + len1)))) {
        return true;
      }
    }
    return false;
  }

  int[] count(String s) {
    int[] count = new int[26];
    for (int i = 0, n = s.length(); i < n; i++) {
      count[s.charAt(i) - 'a']++;
    }
    return count;
  }
}
