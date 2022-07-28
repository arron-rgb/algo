package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class CountNodesWithTheHighestScore {
  // 2049
  // There is a binary tree rooted at 0 consisting of n nodes. The nodes are
  // labeled from 0 to n - 1. You are given a 0-indexed integer array parents representing
  // the tree, where parents[i] is the parent of node i. Since node 0 is the root,
  // parents[0] == -1.
  //
  // Each node has a score. To find the score of a node, consider if the node and
  // the edges connected to it were removed. The tree would become one or more non-
  // empty subtrees. The size of a subtree is the number of the nodes in it. The score
  // of the node is the product of the sizes of all those subtrees.
  //
  // Return the number of nodes that have the highest score.
  //
  //
  // Example 1:
  //
  //
  // Input: parents = [-1,2,0,2,0]
  // Output: 3
  // Explanation:
  // - The score of node 0 is: 3 * 1 = 3
  // - The score of node 1 is: 4 = 4
  // - The score of node 2 is: 1 * 1 * 2 = 2
  // - The score of node 3 is: 4 = 4
  // - The score of node 4 is: 4 = 4
  // The highest score is 4, and three nodes (node 1, node 3, and node 4) have the
  // highest score.
  //
  //
  // Example 2:
  //
  //
  // Input: parents = [-1,2,0]
  // Output: 2
  // Explanation:
  // - The score of node 0 is: 2 = 2
  // - The score of node 1 is: 2 = 2
  // - The score of node 2 is: 1 * 1 = 1
  // The highest score is 2, and two nodes (node 0 and node 1) have the highest
  // score.
  //
  //
  //
  // Constraints:
  //
  //
  // n == parents.length
  // 2 <= n <= 10⁵
  // parents[0] == -1
  // 0 <= parents[i] <= n - 1 for i != 0
  // parents represents a valid binary tree.
  //
  // Related Topics Array Tree Depth-First Search Binary Tree 👍 525 👎 32

  public static void main(String[] args) {
    Solution solution = new CountNodesWithTheHighestScore().new Solution();
    String[] data = """
          [-1,2,0,2,0]
      [-1,2,0]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.countHighestScoreNodes((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    long maxScore = 0;
    int cnt = 0;
    int n;
    List<List<Integer>> children;

    public int countHighestScoreNodes(int[] parents) {
      n = parents.length;
      children = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        children.add(new ArrayList<>());
      }
      for (int i = 0; i < n; i++) {
        int p = parents[i];
        if (p != -1) {
          children.get(p).add(i);
        }
      }
      dfs(0);
      return cnt;
    }

    public int dfs(int node) {
      long score = 1;
      int size = n - 1;
      for (int c : children.get(node)) {
        int t = dfs(c);
        score *= t;
        size -= t;
      }
      if (node != 0) {
        score *= size;
      }
      if (score == maxScore) {
        cnt++;
      } else if (score > maxScore) {
        maxScore = score;
        cnt = 1;
      }
      return n - size;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
