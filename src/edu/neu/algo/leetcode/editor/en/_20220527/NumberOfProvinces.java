package edu.neu.algo.leetcode.editor.en._20220527;

public class NumberOfProvinces {

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
  // Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 51
  // 80 👎 239

  public static void main(String[] args) {
    Solution solution = new NumberOfProvinces().new Solution();
    solution.findCircleNum(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;
      UnionFind uf = new UnionFind(n);
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (isConnected[i][j] == 1) {
            uf.union(i, j);
          }
        }
      }
      return uf.count;
    }

    class UnionFind {
      private int count = 0;
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
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
