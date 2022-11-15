package edu.neu.algo.review.leetcode.editor.en._20221109;

import edu.neu.util.InputUtil;

import java.util.*;

public class CourseScheduleII {

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
  // Return the ordering of courses you should take to finish all courses. If
  // there are many valid answers, return any of them. If it is impossible to finish all
  // courses, return an empty array.
  //
  //
  // Example 1:
  //
  //
  // Input: numCourses = 2, prerequisites = [[1,0]]
  // Output: [0,1]
  // Explanation: There are a total of 2 courses to take. To take course 1 you
  // should have finished course 0. So the correct course order is [0,1].
  //
  //
  // Example 2:
  //
  //
  // Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
  // Output: [0,2,1,3]
  // Explanation: There are a total of 4 courses to take. To take course 3 you
  // should have finished both courses 1 and 2. Both courses 1 and 2 should be taken
  // after you finished course 0.
  // So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
  // ].
  //
  //
  // Example 3:
  //
  //
  // Input: numCourses = 1, prerequisites = []
  // Output: [0]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= numCourses <= 2000
  // 0 <= prerequisites.length <= numCourses * (numCourses - 1)
  // prerequisites[i].length == 2
  // 0 <= ai, bi < numCourses
  // ai != bi
  // All the pairs [ai, bi] are distinct.
  //
  // Related Topics Depth-First Search Breadth-First Search Graph Topological
  // Sort 👍 8212 👎 273

  public static void main(String[] args) {
    Solution solution = new CourseScheduleII().new Solution();
    String[] data = """
                  2
      [[1,0]]
      4
      [[1,0],[2,0],[3,1],[3,2]]
      1
      []
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q =
        solution.findOrder((int)params[1 - 1 + i * paramTypes.length], (int[][])params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      int[] count = new int[numCourses];
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int[] ints : prerequisites) {
        map.computeIfAbsent(ints[1], t -> new ArrayList<>()).add(ints[0]);
        count[ints[0]]++;
      }
      Deque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < count.length; i++) {
        if (count[i] == 0) {
          deque.addLast(i);
        }
      }
      List<Integer> res = new ArrayList<>();
      while (!deque.isEmpty()) {
        int poll = deque.pollFirst();
        res.add(poll);
        List<Integer> list = map.getOrDefault(poll, List.of());
        for (int next : list) {
          if (--count[next] == 0) {
            deque.addLast(next);
          }
        }
      }
      return res.size() == numCourses ? res.stream().mapToInt(t -> t).toArray() : new int[] {};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited = new boolean[n];
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], t -> new ArrayList<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], t -> new ArrayList<>()).add(edge[0]);
    }
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addLast(0);
    while (!deque.isEmpty()) {
      int poll = deque.pollFirst();
      if (visited[poll]) {
        return false;
      }
      visited[poll] = true;
      List<Integer> list = map.getOrDefault(poll, List.of());
      for (int i : list) {
        map.get(i).remove(poll);
        deque.addLast(i);
      }
    }
    for (boolean v : visited) {
      if (!v) {
        return false;
      }
    }
    return true;
  }

  public int minimumSemesters(int n, int[][] relations) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] count = new int[n + 1];
    for (int[] relation : relations) {
      map.computeIfAbsent(relation[0], t -> new ArrayList<>()).add(relation[1]);
      count[relation[1]]++;
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (count[i] == 0) {
        deque.addLast(i);
      }
    }
    boolean[] visited = new boolean[n + 1];
    int res = 1;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        int poll = deque.pollFirst();
        visited[poll] = true;
        List<Integer> list = map.getOrDefault(poll, List.of());
        for (int next : list) {
          if (visited[next]) {
            return -1;
          }
          count[next]--;
          if (count[next] == 0) {
            deque.addLast(next);
          }
        }
      }
      res++;
    }
    return res;
  }
}
