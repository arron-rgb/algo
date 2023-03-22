package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SudokuSolver {
  // 37
  // Write a program to solve a Sudoku puzzle by filling the empty cells.
  //
  // A sudoku solution must satisfy all of the following rules:
  //
  //
  // Each of the digits 1-9 must occur exactly once in each row.
  // Each of the digits 1-9 must occur exactly once in each column.
  // Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
  // boxes of the grid.
  //
  //
  // The '.' character indicates empty cells.
  //
  //
  // Example 1:
  //
  //
  // Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
  // ",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
  // ",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
  // ","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
  // "],[".",".",".",".","8",".",".","7","9"]]
  // Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
  // ","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
  // "],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
  // "9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
  // "4","5","2","8","6","1","7","9"]]
  // Explanation: The input board is shown above and the only valid solution is
  // shown below:
  //
  //
  //
  //
  //
  // Constraints:
  //
  //
  // board.length == 9
  // board[i].length == 9
  // board[i][j] is a digit or '.'.
  // It is guaranteed that the input board has only one solution.
  //
  //
  // Related Topics Array Hash Table Backtracking Matrix 👍 7338 👎 197

  public static void main(String[] args) {
    Solution solution = new SudokuSolver().new Solution();
    String[] data =
      """
        [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        """
        .trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[char[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      char[][] param = (char[][])params[1 - 1 + i * paramTypes.length];
      solution.solveSudoku(param);
      System.out.println(Arrays.deepToString(param));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
      for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
          if (board[i][j] == '.') {
            spaces.add(new int[] {i, j});
          } else {
            int digit = board[i][j] - '0' - 1;
            line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
          }
        }
      }

      dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
      if (pos == spaces.size()) {
        valid = true;
        return;
      }

      int[] space = spaces.get(pos);
      int i = space[0], j = space[1];
      for (int digit = 0; digit < 9 && !valid; ++digit) {
        if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
          line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
          board[i][j] = (char)(digit + '0' + 1);
          dfs(board, pos + 1);
          line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
        }
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
