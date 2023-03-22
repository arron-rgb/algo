package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class NumberOfProvinces {
  // 547
  // There are n cities. Some of them are connected, while some are not. If city a
  // is connected directly with city b, and city b is connected directly with city c,
  // then city a is connected indirectly with city c.
  //
  // A province is a group of directly or indirectly connected cities and no
  // other cities outside of the group.
  //
  // You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
  // iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0
  // otherwise.
  //
  // Return the total number of provinces.
  //
  //
  // Example 1:
  //
  //
  // Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
  // Output: 2
  //
  //
  // Example 2:
  //
  //
  // Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 200
  // n == isConnected.length
  // n == isConnected[i].length
  // isConnected[i][j] is 1 or 0.
  // isConnected[i][i] == 1
  // isConnected[i][j] == isConnected[j][i]
  //
  //
  // Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 69
  // 44 👎 281

  public static void main(String[] args) {
    Solution solution = new NumberOfProvinces().new Solution();
    String[] data = """
                  [[1,1,0],[1,1,0],[0,0,1]]
      [[1,0,0],[0,1,0],[0,0,1]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findCircleNum((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;

      UnionFind unionFind = new UnionFind(n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (isConnected[i][j] == 1)
            unionFind.union(i, j);
        }
      }
      return unionFind.count();
    }
  }

  class UnionFind {
    private int count;
    private int[] parent, rank;

    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]]; // path compression by halving
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      }
      if (rank[rootQ] > rank[rootP]) {
        parent[rootP] = rootQ;
      } else {
        parent[rootQ] = rootP;
        if (rank[rootP] == rank[rootQ]) {
          rank[rootP]++;
        }
      }
      count--;
    }

    public int count() {
      return count;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
