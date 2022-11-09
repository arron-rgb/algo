package edu.neu.algo.review.leetcode.editor.en._20221109;

import edu.neu.util.InputUtil;

import java.util.*;

public class ShortestPathToGetAllKeys {

  // You are given an m x n grid grid where:
  //
  //
  // '.' is an empty cell.
  // '#' is a wall.
  // '@' is the starting point.
  // Lowercase letters represent keys.
  // Uppercase letters represent locks.
  //
  //
  // You start at the starting point and one move consists of walking one space
  // in one of the four cardinal directions. You cannot walk outside the grid, or walk
  // into a wall.
  //
  // If you walk over a key, you can pick it up and you cannot walk over a lock
  // unless you have its corresponding key.
  //
  // For some 1 <= k <= 6, there is exactly one lowercase and one uppercase
  // letter of the first k letters of the English alphabet in the grid. This means that
  // there is exactly one key for each lock, and one lock for each key; and also that
  // the letters used to represent the keys and locks were chosen in the same order as
  // the English alphabet.
  //
  // Return the lowest number of moves to acquire all keys. If it is impossible,
  // return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = ["@.a..","###.#","b.A.B"]
  // Output: 8
  // Explanation: Note that the goal is to obtain all the keys not to open all the
  // locks.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = ["@..aA","..B#.","....b"]
  // Output: 6
  //
  //
  // Example 3:
  //
  //
  // Input: grid = ["@Aa"]
  // Output: -1
  //
  //
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 30
  // grid[i][j] is either an English letter, '.', '#', or '@'.
  // The number of keys in the grid is in the range [1, 6].
  // Each key in the grid is unique.
  // Each key in the grid has a matching lock.
  //
  // Related Topics Array Bit Manipulation Breadth-First Search Matrix 👍 895 👎 3
  // 8

  public static void main(String[] args) {
    Solution solution = new ShortestPathToGetAllKeys().new Solution();
    String[] data = """
                  ["@.a..","###.#","b.A.B"]
      ["@..aA","..B#.","....b"]
      ["@Aa"]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.shortestPathAllKeys((String[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
      int m = grid.length, n = grid[0].length();
      int sx = 0, sy = 0;
      Map<Character, Integer> keyToIndex = new HashMap<>();
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i].charAt(j) == '@') {
            sx = i;
            sy = j;
          } else if (Character.isLowerCase(grid[i].charAt(j))) {
            int idx = keyToIndex.size();
            keyToIndex.put(grid[i].charAt(j), idx);
          }
        }
      }

      Queue<int[]> queue = new ArrayDeque<>();
      // 第三维表示有多少key
      int[][][] dist = new int[m][n][1 << keyToIndex.size()];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          Arrays.fill(dist[i][j], -1);
        }
      }
      queue.offer(new int[] {sx, sy, 0});
      dist[sx][sy][0] = 0;
      while (!queue.isEmpty()) {
        int[] arr = queue.poll();
        int x = arr[0], y = arr[1], mask = arr[2];
        for (int[] d : dirs) {
          int nx = x + d[0];
          int ny = y + d[1];
          if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
            if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
              if (dist[nx][ny][mask] == -1) {
                // 当前位置还没访问过，就设置为之前一位+1
                dist[nx][ny][mask] = dist[x][y][mask] + 1;
                queue.offer(new int[] {nx, ny, mask});
              }
            } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
              // 碰到key
              int idx = keyToIndex.get(grid[nx].charAt(ny));
              // 当前位置还没访问过，说明还没拿到key
              if (dist[nx][ny][mask | (1 << idx)] == -1) {
                // 把key的对应位置设为1
                dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
                if ((mask | (1 << idx)) == (1 << keyToIndex.size()) - 1) {
                  // 如果mask|(1<<idx)的结果 已经是拿到全部的钥匙了，就直接返回
                  return dist[nx][ny][mask | (1 << idx)];
                }
                // 把key对应的mask位置标记为1
                queue.offer(new int[] {nx, ny, mask | (1 << idx)});
              }
            } else {
              // 碰到lock
              int idx = keyToIndex.get(Character.toLowerCase(grid[nx].charAt(ny)));
              if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                // 把
                dist[nx][ny][mask] = dist[x][y][mask] + 1;
                queue.offer(new int[] {nx, ny, mask});
              }
            }
          }
        }
      }
      return -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class WASolution {
    public int shortestPathAllKeys(String[] grid) {
      int startI = 0, startJ = 0;
      int m = grid.length;
      int n = grid[0].length();
      int keys = 0;
      Set<Character> ownedKeys = new HashSet<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          char c = grid[i].charAt(j);
          if (c == '@') {
            startI = i;
            startJ = j;
          } else if (Character.isAlphabetic(c)) {
            keys++;
          }
        }
      }

      // 从[startI, startJ]出发，如果下一个点#，直接返回
      boolean[][] visited = new boolean[m][n];
      return dfs(startI, startJ, grid, ownedKeys, 0, visited, keys);
    }

    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int dfs(int i, int j, String[] grid, Set<Character> keys, int step, boolean[][] visited, int k) {
      if (i < 0 || j < 0 || j >= grid[0].length() || i >= grid.length || visited[i][j]) {
        return -1;
      }
      char c = grid[i].charAt(j);
      visited[i][j] = true;
      if (c == '#') {
        return -1;
      }
      if (Character.isUpperCase(c)) {
        if (!keys.contains(c)) {
          return -1;
        }
      } else if (Character.isLowerCase(c)) {
        keys.add(c);
      }

      if (keys.size() == k) {
        return step;
      }

      for (int[] direction : directions) {
        int s = dfs(i + direction[0], j + direction[1], grid, keys, step + 1, visited, k);
        if (s != -1) {
          return s;
        }
      }
      visited[i][j] = false;
      return -1;
    }
  }

}
