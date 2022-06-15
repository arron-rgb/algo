package edu.neu.algo.leetcode.editor.en._20220607;

public class CouplesHoldingHands {

  public static void main(String[] args) {
    CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands();
    Solution solution = couplesHoldingHands.new Solution();
    // int[] ints = couplesHoldingHands.xorQueries(new int[] {1, 3, 4, 8}, new int[][] {{0, 1}, {1, 2}, {0, 3}, {3,
    // 3}});
    // System.out.println(Arrays.toString(ints));
  }

  // There are n couples sitting in 2n seats arranged in a row and want to hold
  // hands.
  //
  // The people and seats are represented by an integer array row where row[i] is
  // the ID of the person sitting in the iᵗʰ seat. The couples are numbered in order,
  // the first couple being (0, 1), the second couple being (2, 3), and so on with
  // the last couple being (2n - 2, 2n - 1).
  //
  // Return the minimum number of swaps so that every couple is sitting side by
  // side. A swap consists of choosing any two people, then they stand up and switch
  // seats.
  //
  //
  // Example 1:
  //
  //
  // Input: row = [0,2,1,3]
  // Output: 1
  // Explanation: We only need to swap the second (row[1]) and third (row[2])
  // person.
  //
  //
  // Example 2:
  //
  //
  // Input: row = [3,2,0,1]
  // Output: 0
  // Explanation: All couples are already seated side by side.
  //
  //
  //
  // Constraints:
  //
  //
  // 2n == row.length
  // 2 <= n <= 30
  // n is even.
  // 0 <= row[i] < 2n
  // All the elements of row are unique.
  //
  // Related Topics Greedy Depth-First Search Breadth-First Search Union Find
  // Graph 👍 1669 👎 87

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[] parent = new int[70];

    void union(int i, int j) {
      parent[find(i)] = parent[find(j)];
    }

    int find(int id) {
      if (parent[id] != id) {
        parent[id] = find(parent[id]);
      }
      return parent[id];
    }

    public int minSwapsCouples(int[] row) {
      int n = row.length;
      int couples = n / 2;
      for (int i = 0; i < couples; i++) {
        parent[i] = i;
      }
      for (int i = 0; i < n; i += 2) {
        union(row[i] / 2, row[i + 1] / 2);
      }

      int count = 0;
      for (int i = 0; i < couples; i++) {
        if (find(i) == i) {
          count++;
        }
      }

      return couples - count;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
