package edu.neu.algo.review.leetcode.editor.en._20221030;

import java.util.*;
import edu.neu.util.InputUtil;

public class PacificAtlanticWaterFlow {
  // 417
  // There is an m x n rectangular island that borders both the Pacific Ocean and
  // Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and
  // the Atlantic Ocean touches the island's right and bottom edges.
  //
  // The island is partitioned into a grid of square cells. You are given an m x
  // n integer matrix heights where heights[r][c] represents the height above sea
  // level of the cell at coordinate (r, c).
  //
  // The island receives a lot of rain, and the rain water can flow to
  // neighboring cells directly north, south, east, and west if the neighboring cell's height
  // is less than or equal to the current cell's height. Water can flow from any cell
  // adjacent to an ocean into the ocean.
  //
  // Return a 2D list of grid coordinates result where result[i] = [ri, ci]
  // denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic
  // oceans.
  //
  //
  // Example 1:
  //
  //
  // Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
  //
  // Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
  // Explanation: The following cells can flow to the Pacific and Atlantic oceans,
  // as shown below:
  // [0,4]: [0,4] -> Pacific Ocean
  //   [0,4] -> Atlantic Ocean
  // [1,3]: [1,3] -> [0,3] -> Pacific Ocean
  //   [1,3] -> [1,4] -> Atlantic Ocean
  // [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
  //   [1,4] -> Atlantic Ocean
  // [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
  //   [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
  // [3,0]: [3,0] -> Pacific Ocean
  //   [3,0] -> [4,0] -> Atlantic Ocean
  // [3,1]: [3,1] -> [3,0] -> Pacific Ocean
  //   [3,1] -> [4,1] -> Atlantic Ocean
  // [4,0]: [4,0] -> Pacific Ocean
  // [4,0] -> Atlantic Ocean
  // Note that there are other possible paths for these cells to flow to the
  // Pacific and Atlantic oceans.
  //
  //
  // Example 2:
  //
  //
  // Input: heights = [[1]]
  // Output: [[0,0]]
  // Explanation: The water can flow from the only cell to the Pacific and
  // Atlantic oceans.
  //
  //
  //
  // Constraints:
  //
  //
  // m == heights.length
  // n == heights[r].length
  // 1 <= m, n <= 200
  // 0 <= heights[r][c] <= 10⁵
  //
  // Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 5773 ?
  // ? 1091

  public static void main(String[] args) {
    Solution solution = new PacificAtlanticWaterFlow().new Solution();
    String[] data = """
          [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
      [[1]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.pacificAtlantic((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      this.heights = heights;
      this.m = heights.length;
      this.n = heights[0].length;
      boolean[][] pacific = new boolean[m][n];
      boolean[][] atlantic = new boolean[m][n];
      for (int i = 0; i < m; i++) {
        bfs(i, 0, pacific);
      }
      for (int j = 1; j < n; j++) {
        bfs(0, j, pacific);
      }
      for (int i = 0; i < m; i++) {
        bfs(i, n - 1, atlantic);
      }
      for (int j = 0; j < n - 1; j++) {
        bfs(m - 1, j, atlantic);
      }
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (pacific[i][j] && atlantic[i][j]) {
            List<Integer> cell = new ArrayList<>();
            cell.add(i);
            cell.add(j);
            result.add(cell);
          }
        }
      }
      return result;
    }

    public void bfs(int row, int col, boolean[][] ocean) {
      if (ocean[row][col]) {
        return;
      }
      ocean[row][col] = true;
      Queue<int[]> queue = new ArrayDeque<>();
      queue.offer(new int[] {row, col});
      while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] dir : dirs) {
          int newRow = cell[0] + dir[0], newCol = cell[1] + dir[1];
          if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
            && heights[newRow][newCol] >= heights[cell[0]][cell[1]] && !ocean[newRow][newCol]) {
            ocean[newRow][newCol] = true;
            queue.offer(new int[] {newRow, newCol});
          }
        }
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
