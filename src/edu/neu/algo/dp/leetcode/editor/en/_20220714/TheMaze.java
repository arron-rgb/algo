package edu.neu.algo.dp.leetcode.editor.en._20220714;

import edu.neu.util.InputUtil;

/**
 * @author arronshentu
 */
public class TheMaze {
  public static void main(String[] args) {
    Solution solution = new TheMaze().new Solution();
    String[] data = """
      [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
      [0,4]
      [4,4]
      [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
      [0,4]
      [3,2]
      [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
      [4,3]
      [0,1]
                """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.hasPath((int[][])params[1 + i * paramTypes.length - 1],
        (int[])params[2 + i * paramTypes.length - 1], (int[])params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      boolean[][] visited = new boolean[maze.length][maze[0].length];
      return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
      if (visited[start[0]][start[1]]) {
        return false;
      }
      if (start[0] == destination[0] && start[1] == destination[1]) {
        return true;
      }
      visited[start[0]][start[1]] = true;
      int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
      while (r < maze[0].length && maze[start[0]][r] == 0) {
        r++;
      }
      if (dfs(maze, new int[] {start[0], r - 1}, destination, visited)) {
        return true;
      }
      while (l >= 0 && maze[start[0]][l] == 0) {
        l--;
      }
      if (dfs(maze, new int[] {start[0], l + 1}, destination, visited)) {
        return true;
      }
      while (u >= 0 && maze[u][start[1]] == 0) {
        u--;
      }
      if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited)) {
        return true;
      }
      while (d < maze.length && maze[d][start[1]] == 0) {
        d++;
      }
      return dfs(maze, new int[] {d - 1, start[1]}, destination, visited);
    }
  }

}
