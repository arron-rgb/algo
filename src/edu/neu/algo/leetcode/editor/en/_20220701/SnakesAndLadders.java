package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edu.neu.util.InputUtil;

public class SnakesAndLadders {
  // 909
  // You are given an n x n integer matrix board where the cells are labeled from 1
  // to n² in a Boustrophedon style starting from the bottom left of the board (i.e.
  // board[n - 1][0]) and alternating direction each row.
  //
  // You start on square 1 of the board. In each move, starting from square curr,
  // do the following:
  //
  //
  // Choose a destination square next with a label in the range [curr + 1, min(
  // curr + 6, n²)].
  //
  //
  // This choice simulates the result of a standard 6-sided die roll: i.e., there
  // are always at most 6 destinations, regardless of the size of the board.
  //
  //
  // If next has a snake or ladder, you must move to the destination of that
  // snake or ladder. Otherwise, you move to next.
  // The game ends when you reach the square n².
  //
  //
  // A board square on row r and column c has a snake or ladder if board[r][c] !=
  // -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n² do
  // not have a snake or ladder.
  //
  // Note that you only take a snake or ladder at most once per move. If the
  // destination to a snake or ladder is the start of another snake or ladder, you do not
  // follow the subsequent snake or ladder.
  //
  //
  // For example, suppose the board is [[-1,4],[-1,3]], and on the first move,
  // your destination square is 2. You follow the ladder to square 3, but do not follow
  // the subsequent ladder to 4.
  //
  //
  // Return the least number of moves required to reach the square n². If it is
  // not possible to reach the square, return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-
  // 1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
  // Output: 4
  // Explanation:
  // In the beginning, you start at square 1 (at row 5, column 0).
  // You decide to move to square 2 and must take the ladder to square 15.
  // You then decide to move to square 17 and must take the snake to square 13.
  // You then decide to move to square 14 and must take the ladder to square 35.
  // You then decide to move to square 36, ending the game.
  // This is the lowest possible number of moves to reach the last square, so
  // return 4.
  //
  //
  // Example 2:
  //
  //
  // Input: board = [[-1,-1],[-1,3]]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // n == board.length == board[i].length
  // 2 <= n <= 20
  // grid[i][j] is either -1 or in the range [1, n²].
  // The squares labeled 1 and n² do not have any ladders or snakes.
  //
  // Related Topics Array Breadth-First Search Matrix 👍 774 👎 205

  public static void main(String[] args) {
    Solution solution = new SnakesAndLadders().new Solution();
    String[] data =
      """
            [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
        [[-1,-1],[-1,3]]
            """
        .trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.snakesAndLadders((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int snakesAndLadders(int[][] board) {
      // edge condition
      if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
        return 0;
      }

      // Preparation
      int rowNum = board.length;
      int colNum = board[0].length;

      boolean isRight = true;

      // 扁平化
      int[] nums = new int[rowNum * rowNum + 1];
      int index = 1;

      for (int i = rowNum - 1; i >= 0; i--) {
        if (isRight) {
          for (int j = 0; j < colNum; j++) {
            nums[index++] = board[i][j];
          }
        } else {
          for (int j = colNum - 1; j >= 0; j--) {
            nums[index++] = board[i][j];
          }
        }

        isRight = !isRight;
      }

      // Queue
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(1);

      // <Index, steps>
      Map<Integer, Integer> distanceMap = new HashMap<>();
      distanceMap.put(1, 0);

      while (!queue.isEmpty()) {
        int curIndex = queue.poll();
        int step = distanceMap.get(curIndex);

        // 走到左上角：答案
        if (curIndex == rowNum * rowNum) {
          return step;
        }

        for (int i = 1; i <= 6; i++) {
          int newIndex = curIndex + i;

          // isValid
          if (newIndex <= 0 || newIndex > rowNum * rowNum) {
            continue;
          }

          // 遇到蛇 或 梯子
          if (nums[newIndex] != -1) {
            newIndex = nums[newIndex];
          }

          // visited
          if (distanceMap.containsKey(newIndex)) {
            continue;
          }

          // 入 queue
          queue.offer(newIndex);

          // 当前点走过的距离
          distanceMap.put(newIndex, step + 1);
        }
      }

      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
