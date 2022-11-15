package edu.neu.algo.review.leetcode.editor.en._20221109;

import edu.neu.util.InputUtil;

import java.util.*;

public class CourseSchedule {

  // There are a total of numCourses courses you have to take, labeled from 0 to
  // numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
  // bi] indicates that you must take course bi first if you want to take course ai.
  //
  //
  //
  // For example, the pair [0, 1], indicates that to take course 0 you have to
  // first take course 1.
  //
  //
  // Return true if you can finish all courses. Otherwise, return false.
  //
  //
  // Example 1:
  //
  //
  // Input: numCourses = 2, prerequisites = [[1,0]]
  // Output: true
  // Explanation: There are a total of 2 courses to take.
  // To take course 1 you should have finished course 0. So it is possible.
  //
  //
  // Example 2:
  //
  //
  // Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
  // Output: false
  // Explanation: There are a total of 2 courses to take.
  // To take course 1 you should have finished course 0, and to take course 0 you
  // should also have finished course 1. So it is impossible.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= numCourses <= 2000
  // 0 <= prerequisites.length <= 5000
  // prerequisites[i].length == 2
  // 0 <= ai, bi < numCourses
  // All the pairs prerequisites[i] are unique.
  //
  // Related Topics Depth-First Search Breadth-First Search Graph Topological
  // Sort 👍 11845 👎 460

  public static void main(String[] args) {
    Solution solution = new CourseSchedule().new Solution();
    String[] data = """
      2
      [[1,0]]
      2
      [[1,0],[0,1]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q =
        solution.canFinish((int)params[1 - 1 + i * paramTypes.length], (int[][])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      Map<Integer, List<Integer>> graph = new HashMap<>();
      int[] count = new int[numCourses];
      for (int[] prerequisite : prerequisites) {
        graph.computeIfAbsent(prerequisite[1], t -> new ArrayList<>()).add(prerequisite[0]);
        count[prerequisite[0]]++;
      }
      Deque<Integer> queue = new ArrayDeque<>();
      for (int i = 0; i < numCourses; i++) {
        if (count[i] == 0) {
          queue.add(i);
        }
      }
      int visited = 0;
      while (!queue.isEmpty()) {
        // 如果没满足条件的不会被加进来
        // 所以直接考虑访问到的即可
        visited++;
        int poll = queue.poll();
        for (int next : graph.getOrDefault(poll, List.of())) {
          count[next]--;
          if (count[next] == 0) {
            queue.add(next);
          }
        }
      }
      return visited == numCourses;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
