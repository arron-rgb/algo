package edu.neu.algo.stock.leetcode.editor.en._20220703;

import java.util.*;

import edu.neu.util.InputUtil;

public class MinimumAbsoluteDifference {
  // 1200
  // Given an array of distinct integers arr, find all pairs of elements with the
  // minimum absolute difference of any two elements.
  //
  // Return a list of pairs in ascending order(with respect to pairs), each pair [
  // a, b] follows
  //
  //
  // a, b are from arr
  // a < b
  // b - a equals to the minimum absolute difference of any two elements in arr
  //
  //
  //
  // Example 1:
  //
  //
  // Input: arr = [4,2,1,3]
  // Output: [[1,2],[2,3],[3,4]]
  // Explanation: The minimum absolute difference is 1. List all pairs with
  // difference equal to 1 in ascending order.
  //
  // Example 2:
  //
  //
  // Input: arr = [1,3,6,10,15]
  // Output: [[1,3]]
  //
  //
  // Example 3:
  //
  //
  // Input: arr = [3,8,-10,23,19,-4,-14,27]
  // Output: [[-14,-10],[19,23],[23,27]]
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= arr.length <= 10⁵
  // -10⁶ <= arr[i] <= 10⁶
  //
  // Related Topics Array Sorting 👍 1570 👎 60

  public static void main(String[] args) {
    Solution solution = new MinimumAbsoluteDifference().new Solution();
    // String[] data = """
    // [4,2,1,3]
    // [1,3,6,10,15]
    // [3,8,-10,23,19,-4,-14,27]
    // """.trim().replaceAll("\n", "|").split("\\|");
    String[] data = """
      5
      [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
      3
      3
      [[0,2],[2,1]]
      2
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // List<List<Integer>> q = solution.minimumAbsDifference((int[])params[1 - 1 + i * paramTypes.length]);
      int q = solution.numWays((int)params[1 - 1 + i * paramTypes.length],
        (int[][])params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
      List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(arr);
      int min = Integer.MAX_VALUE;
      int n = arr.length;

      for (int i = 0; i < n - 1; i++) {
        int val = arr[i + 1] - arr[i];
        if (val < min) {
          min = val;
          list.clear();
          list.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
        } else if (val == min) {
          list.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
        }
      }
      return list;
    }

    public int numWays(int n, int[][] relation, int k) {
      // Map<Integer, List<Integer>> map = new HashMap<>();
      // for (int[] ints : relation) {
      // map.computeIfAbsent(ints[0], t -> new ArrayList<>()).add(ints[1]);
      // }
      // // map.forEach((key, e) -> System.out.println(key + " " + e));
      // // int count = bfs(n, k, map);
      // count = 0;
      // // build(n, k, 0, 0, map);
      //
      // return count;
      int[][] dp = new int[k + 1][n];
      dp[0][0] = 1;
      // 两层循环，外层循环 0->k
      for (int i = 1; i <= k; i++) {
        for (int[] edge : relation) {
          int start = edge[0];
          int end = edge[1];
          // 前序的end -> 当前的start
          dp[i][end] += dp[i - 1][start];
        }
      }
      return dp[k][n - 1];
    }

    int count = 0;

    void dfs(int n, int k, int step, int index, Map<Integer, List<Integer>> map) {
      if (k == step) {
        if (index == n - 1) {
          count++;
        }
        return;
      }
      for (int i : map.getOrDefault(index, new ArrayList<>())) {
        dfs(n, k, step + 1, i, map);
      }
    }

    private int bfs(int n, int k, Map<Integer, List<Integer>> map) {
      Deque<Integer> deque = new ArrayDeque<>();
      deque.offerLast(0);
      int count = 0;
      for (int i = 0; i < k; i++) {
        // 从deque里的出发
        int size = deque.size();
        for (int j = 0; j < size; j++) {
          Integer poll = deque.pollFirst();
          List<Integer> list = map.getOrDefault(poll, new ArrayList<>());
          for (int target : list) {
            if (target == n - 1 && i == k - 1) {
              count++;
            }
            deque.offerLast(target);
          }
        }
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  // 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
  //
  // 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
  // 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
  // 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
  // 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
  //
}
