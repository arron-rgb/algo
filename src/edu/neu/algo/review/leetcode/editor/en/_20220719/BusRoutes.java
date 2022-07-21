package edu.neu.algo.review.leetcode.editor.en._20220719;

import java.util.*;
import edu.neu.util.InputUtil;

public class BusRoutes {
  // 815
  // You are given an array routes representing bus routes where routes[i] is a
  // bus route that the iᵗʰ bus repeats forever.
  //
  //
  // For example, if routes[0] = [1, 5, 7], this means that the 0ᵗʰ bus travels
  // in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
  //
  //
  // You will start at the bus stop source (You are not on any bus initially),
  // and you want to go to the bus stop target. You can travel between bus stops by
  // buses only.
  //
  // Return the least number of buses you must take to travel from source to
  // target. Return -1 if it is not possible.
  //
  //
  // Example 1:
  //
  //
  // Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
  // Output: 2
  // Explanation: The best strategy is take the first bus to the bus stop 7, then
  // take the second bus to the bus stop 6.
  //
  //
  // Example 2:
  //
  //
  // Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
  // 12
  // Output: -1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= routes.length <= 500.
  // 1 <= routes[i].length <= 10⁵
  // All the values of routes[i] are unique.
  // sum(routes[i].length) <= 10⁵
  // 0 <= routes[i][j] < 10⁶
  // 0 <= source, target < 10⁶
  //
  // Related Topics Array Hash Table Breadth-First Search 👍 2346 👎 58

  public static void main(String[] args) {
    Solution solution = new BusRoutes().new Solution();
    String[] data = """
          [[1,2,7],[3,6,7]]
      1
      6
      [[7,12],[4,5,15],[6],[15,19],[9,12,13]]
      15
      12
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numBusesToDestination((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1], (int)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
      if (source == target) {
        return 0;
      }
      Deque<Integer> deque = new ArrayDeque<>();
      Map<Integer, Integer> distance = new HashMap<>();
      Map<Integer, Set<Integer>> graph = new HashMap<>();
      int n = routes.length;
      for (int i = 0; i < n; i++) {
        for (int station : routes[i]) {
          if (station == source) {
            deque.addLast(i);
            distance.put(i, 1);
          }
          graph.computeIfAbsent(station, tmp -> new HashSet<>()).add(i);
        }
      }
      while (!deque.isEmpty()) {
        int bus = deque.pollFirst();
        int step = distance.get(bus);
        for (int station : routes[bus]) {
          if (station == target) {
            return step;
          }
          Set<Integer> set = graph.getOrDefault(station, Set.of());
          for (int next : set) {
            if (!distance.containsKey(next)) {
              distance.put(next, step + 1);
              deque.offerLast(next);
            }
          }
        }
      }
      return -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class OtherSolution extends Solution {
    public int numBusesToDestination(int[][] rs, int s, int t) {
      if (s == t) {
        return 0;
      }
      return bfs(rs, s, t);
    }

    int bfs(int[][] routes, int source, int target) {
      Map<Integer, Set<Integer>> graph = new HashMap<>();
      Deque<Integer> d = new ArrayDeque<>();
      Map<Integer, Integer> distance = new HashMap<>();
      int n = routes.length;
      for (int i = 0; i < n; i++) {
        for (int station : routes[i]) {
          if (station == source) {
            d.addLast(i);
            distance.put(i, 1);
          }
          graph.computeIfAbsent(station, tmp -> new HashSet<>()).add(i);
        }
      }
      while (!d.isEmpty()) {
        int bus = d.pollFirst();
        int step = distance.get(bus);
        for (int station : routes[bus]) {
          if (station == target) {
            return step;
          }
          Set<Integer> lines = graph.getOrDefault(station, Set.of());
          for (int next : lines) {
            if (!distance.containsKey(next)) {
              distance.put(next, step + 1);
              d.add(next);
            }
          }
        }
      }
      return -1;
    }
  }

}
