package edu.neu.algo.leetcode.editor.en._20220702;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import edu.neu.util.InputUtil;

public class EscapeALargeMaze {
  // 1036
  // There is a 1 million by 1 million grid on an XY-plane, and the coordinates of
  // each grid square are (x, y).
  //
  // We start at the source = [sx, sy] square and want to reach the target = [tx,
  // ty] square. There is also an array of blocked squares, where each blocked[i] = [
  // xi, yi] represents a blocked square with coordinates (xi, yi).
  //
  // Each move, we can walk one square north, east, south, or west if the square
  // is not in the array of blocked squares. We are also not allowed to walk outside
  // of the grid.
  //
  // Return true if and only if it is possible to reach the target square from
  // the source square through a sequence of valid moves.
  //
  //
  // Example 1:
  //
  //
  // Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
  // Output: false
  // Explanation: The target square is inaccessible starting from the source
  // square because we cannot move.
  // We cannot move north or east because those squares are blocked.
  // We cannot move south or west because we cannot go outside of the grid.
  //
  //
  // Example 2:
  //
  //
  // Input: blocked = [], source = [0,0], target = [999999,999999]
  // Output: true
  // Explanation: Because there are no blocked cells, it is possible to reach the
  // target square.
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= blocked.length <= 200
  // blocked[i].length == 2
  // 0 <= xi, yi < 10⁶
  // source.length == target.length == 2
  // 0 <= sx, sy, tx, ty < 10⁶
  // source != target
  // It is guaranteed that source and target are not blocked.
  //
  // Related Topics Array Hash Table Depth-First Search Breadth-First Search 👍 48
  // 4 👎 147

  public static void main(String[] args) {
    Solution solution = new EscapeALargeMaze().new Solution();
    System.out.println(1e4);
    String[] data = """
          [[0,1],[1,0]]
      [0,0]
      [0,2]
      []
      [0,0]
      [999999,999999]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isEscapePossible((int[][])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length], (int[])params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
      // 添加断言
      // 加入期望值和实际值
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
      // return bfs(blocked, source, target) && bfs(blocked, target, source);
      Set<Long> set = new HashSet<>();
      for (int[] ints : blocked) {
        set.add(131L * ints[0] + ints[1]);
      }
      return dfs(target, source, source[0], source[1], new HashSet<>(), set)
        && dfs(source, target, target[0], target[1], new HashSet<>(), set);
    }

    private boolean bfs(int[][] blocked, int[] source, int[] target) {
      Set<Long> blocks = new HashSet<>();
      for (int[] ints : blocked) {
        blocks.add(131L * ints[0] + ints[1]);
      }
      int m = (int)1e6;
      Set<Long> visited = new HashSet<>();
      Deque<int[]> deque = new ArrayDeque<>();
      deque.offerLast(source);
      visited.add(131L * source[0] + source[1]);
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          int[] poll = deque.pollFirst();
          for (int[] direction : directions) {
            int nextI = direction[0] + poll[0];
            int nextJ = direction[1] + poll[1];
            int[] ints = new int[] {nextI, nextJ};
            long hash = nextI * 131L + nextJ;
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= m || blocks.contains(hash)
              || visited.contains(nextI * 131L + nextJ)) {
              continue;
            }
            if ((Math.abs(source[0] - nextI) + Math.abs(source[1] - nextJ) > 200)
              || (nextI == target[0] && nextJ == target[1])) {
              return true;
            }
            visited.add(hash);
            deque.offerLast(ints);
          }
        }
      }
      return false;
    }

    private boolean dfs(int[] target, int[] source, int i, int j, Set<Long> visited, Set<Long> blocks) {
      long hash = 131L * i + j;
      if (i < 0 || i >= 1000000 || j < 0 || j >= 1000000 || blocks.contains(hash) || visited.contains(hash)) {
        return false;
      }
      if (Math.abs(i - source[0]) + Math.abs(j - source[1]) > 200) {
        return true;
      }
      if (target[0] == i && target[1] == j) {
        return true;
      }
      visited.add(hash);
      for (int[] direction : directions) {
        if (dfs(target, source, i + direction[0], j + direction[1], visited, blocks)) {
          return true;
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
