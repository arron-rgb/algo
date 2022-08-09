package edu.neu.algo.monotonic.leetcode.editor.en._20220807;

import java.util.*;
import edu.neu.util.InputUtil;

public class WordSearch {
  // 79
  // Given an m x n grid of characters board and a string word, return true if
  // word exists in the grid.
  //
  // The word can be constructed from letters of sequentially adjacent cells,
  // where adjacent cells are horizontally or vertically neighboring. The same letter
  // cell may not be used more than once.
  //
  //
  // Example 1:
  //
  //
  // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
  // "ABCCED"
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
  // "SEE"
  // Output: true
  //
  //
  // Example 3:
  //
  //
  // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
  // "ABCB"
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // m == board.length
  // n = board[i].length
  // 1 <= m, n <= 6
  // 1 <= word.length <= 15
  // board and word consists of only lowercase and uppercase English letters.
  //
  //
  //
  // Follow up: Could you use search pruning to make your solution faster with a
  // larger board?
  // Related Topics Array Backtracking Matrix 👍 10358 👎 389

  public static void main(String[] args) {
    Solution solution = new WordSearch().new Solution();
    String[] data = """
      [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
      "ABCB"
                      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[char[][], String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q =
        solution.exist((char[][])params[1 + i * paramTypes.length - 1], (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }

  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean exist(char[][] board, String word) {
      int m = board.length;
      int n = board[0].length;

      boolean[][] visited = new boolean[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (dfs(board, i, j, 0, word, visited)) {
            return true;
          }
        }
      }
      return false;
    }

    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
      if (board[i][j] != word.charAt(index)) {
        return false;
      } else if (index == word.length() - 1) {
        return true;
      }
      visited[i][j] = true;
      for (int[] dir : directions) {
        int tmpI = i + dir[0];
        int tmpJ = j + dir[1];
        if (tmpI < 0 || tmpJ < 0 || tmpI >= board.length || tmpJ >= board[0].length
          || board[tmpI][tmpJ] != word.charAt(index) || visited[tmpI][tmpJ]) {
          continue;
        }
        if (dfs(board, tmpI, tmpJ, index + 1, word, visited)) {
          System.out.println(Arrays.deepToString(visited));
          visited[i][j] = false;
          return true;
        }
      }
      visited[i][j] = false;
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
