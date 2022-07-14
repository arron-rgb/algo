package edu.neu.algo.dp.leetcode.editor.en._20220713;

import java.util.*;
import edu.neu.util.InputUtil;

public class MapOfHighestPeak {
  // 1765
  // You are given an integer matrix isWater of size m x n that represents a map
  // of land and water cells.
  //
  //
  // If isWater[i][j] == 0, cell (i, j) is a land cell.
  // If isWater[i][j] == 1, cell (i, j) is a water cell.
  //
  //
  // You must assign each cell a height in a way that follows these rules:
  //
  //
  // The height of each cell must be non-negative.
  // If the cell is a water cell, its height must be 0.
  // Any two adjacent cells must have an absolute height difference of at most 1.
  // A cell is adjacent to another cell if the former is directly north, east, south,
  // or west of the latter (i.e., their sides are touching).
  //
  //
  // Find an assignment of heights such that the maximum height in the matrix is
  // maximized.
  //
  // Return an integer matrix height of size m x n where height[i][j] is cell (i,
  // j)'s height. If there are multiple solutions, return any of them.
  //
  //
  // Example 1:
  //
  //
  //
  //
  // Input: isWater = [[0,1],[0,0]]
  // Output: [[1,0],[2,1]]
  // Explanation: The image shows the assigned heights of each cell.
  // The blue cell is the water cell, and the green cells are the land cells.
  //
  //
  // Example 2:
  //
  //
  //
  //
  // Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
  // Output: [[1,1,0],[0,1,1],[1,2,2]]
  // Explanation: A height of 2 is the maximum possible height of any assignment.
  // Any height assignment that has a maximum height of 2 while still meeting the
  // rules will also be accepted.
  //
  //
  //
  // Constraints:
  //
  //
  // m == isWater.length
  // n == isWater[i].length
  // 1 <= m, n <= 1000
  // isWater[i][j] is 0 or 1.
  // There is at least one water cell.
  //
  // Related Topics Array Breadth-First Search Matrix 👍 556 👎 36

  public static void main(String[] args) {
    Solution solution = new MapOfHighestPeak().new Solution();
    String[] data = """
          [[0,1],[0,0]]
      [[0,0,1],[1,0,0],[0,0,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q = solution.highestPeak((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
      int m = isWater.length;
      int n = isWater[0].length;
      int[][] heights = new int[m][n];
      Deque<int[]> deque = new ArrayDeque<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (isWater[i][j] == 1) {
            deque.add(new int[] {i, j});
            heights[i][j] = -1;
          }
        }
      }
      int count = 1;
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          int[] remove = deque.remove();
          for (int[] direction : directions) {
            int nextI = direction[0] + remove[0];
            int nextJ = direction[1] + remove[1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && heights[nextI][nextJ] == 0
              && isWater[nextI][nextJ] == 0) {
              deque.add(new int[] {nextI, nextJ});
              heights[nextI][nextJ] = count;
            }
          }
        }
        count++;
      }
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (heights[i][j] == -1) {
            heights[i][j] = 0;
          }
        }
      }
      return heights;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
