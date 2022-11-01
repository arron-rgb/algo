package edu.neu.algo.review.leetcode.editor.en._20221030;

import java.util.*;
import edu.neu.util.InputUtil;

public class PossibleBipartition {
  // 886
  // We want to split a group of n people (labeled from 1 to n) into two groups of
  // any size. Each person may dislike some other people, and they should not go
  // into the same group.
  //
  // Given the integer n and the array dislikes where dislikes[i] = [ai, bi]
  // indicates that the person labeled ai does not like the person labeled bi, return
  // true if it is possible to split everyone into two groups in this way.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
  // Output: true
  // Explanation: group1 [1,4] and group2 [2,3].
  //
  //
  // Example 2:
  //
  //
  // Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
  // Output: false
  //
  //
  // Example 3:
  //
  //
  // Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 2000
  // 0 <= dislikes.length <= 10⁴
  // dislikes[i].length == 2
  // 1 <= dislikes[i][j] <= n
  // ai < bi
  // All the pairs of dislikes are unique.
  //
  // Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 27
  // 83 👎 65

  public static void main(String[] args) {
    Solution solution = new PossibleBipartition().new Solution();
    String[] data = """
          4
      [[1,2],[1,3],[2,4]]
      3
      [[1,2],[1,3],[2,3]]
      5
      [[1,2],[2,3],[3,4],[4,5],[1,5]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.possibleBipartition((int)params[1 + i * paramTypes.length - 1],
        (int[][])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int[] dislike : dislikes) {
        map.computeIfAbsent(dislike[0], t -> new ArrayList<>()).add(dislike[1]);
        map.computeIfAbsent(dislike[1], t -> new ArrayList<>()).add(dislike[0]);
      }
      // 构建图
      Map<Integer, Integer> groups = new HashMap<>();
      // 给每个点一个颜色
      for (int i = 1; i < n + 1; i++) {
        // 判断每个未判断颜色的点
        if (!groups.containsKey(i) && !dfs(i, 1, groups, map)) {
          return false;
        }
      }
      return true;
    }

    boolean dfs(int i, int color, Map<Integer, Integer> groups, Map<Integer, List<Integer>> map) {
      // groups[i] = color;
      groups.put(i, color);
      List<Integer> list = map.getOrDefault(i, List.of());
      for (int next : list) {
        // 判断next是否已染色
        // next需要与当前点颜色不同
        // 如果已染色，且加起来不为3
        // 则false
        if (groups.containsKey(next) && groups.get(next) + color != 3) {
          return false;
        }
        // 如果未染色，继续走当前点，并判断从该点之后的点是否会有冲突
        if (!groups.containsKey(next) && !dfs(next, 3 - color, groups, map)) {
          return false;
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
