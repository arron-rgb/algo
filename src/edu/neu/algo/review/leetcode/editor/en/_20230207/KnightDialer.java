package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KnightDialer {
  // 935
  // The chess knight has a unique movement, it may move two squares vertically
  // and one square horizontally, or two squares horizontally and one square vertically
  // (with both forming the shape of an L). The possible movements of chess knight
  // are shown in this diagaram:
  //
  // A chess knight can move as indicated in the chess diagram below:
  //
  // We have a chess knight and a phone pad as shown below, the knight can only
  // stand on a numeric cell (i.e. blue cell).
  //
  // Given an integer n, return how many distinct phone numbers of length n we
  // can dial.
  //
  // You are allowed to place the knight on any numeric cell initially and then
  // you should perform n - 1 jumps to dial a number of length n. All jumps should be
  // valid knight jumps.
  //
  // As the answer may be very large, return the answer modulo 10⁹ + 7.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 1
  // Output: 10
  // Explanation: We need to dial a number of length 1, so placing the knight over
  // any numeric cell of the 10 cells is sufficient.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 2
  // Output: 20
  // Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34,
  // 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
  //
  //
  // Example 3:
  //
  //
  // Input: n = 3131
  // Output: 136006598
  // Explanation: Please take care of the mod.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 5000
  //
  //
  // Related Topics Dynamic Programming 👍 1893 👎 379

  public static void main(String[] args) {
    KnightDialer knightDialer = new KnightDialer();
    knightDialer.minCost(new int[] {4, 2, 2, 2}, new int[] {1, 4, 1, 2});
    // Solution solution = new KnightDialer().new Solution();
    // String[] data = """
    // 1
    // 2
    // 3131
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[int]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // int q = solution.knightDialer((int)params[1 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int knightDialer(int n) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public long minCost(int[] basket1, int[] basket2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : basket1) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int i : basket2) {
      map.put(i, map.getOrDefault(i, 0) - 1);
    }
    List<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      Integer k = entry.getKey();
      Integer v = entry.getValue();
      min = Math.min(k, min);
      int abs = Math.abs(v);
      if (abs % 2 != 0) {
        return -1;
      }
      if (abs == 0) {
        continue;
      }
      for (int i = 0; i < abs / 2; i++) {
        list.add(k);
      }
    }
    long res = 0;
    Collections.sort(list);
    for (int n = list.size(), i = n / 2 - 1; i >= 0; i--) {
      if (list.get(i) > 2 * min) {
        res += 2 * min;
      } else {
        res += list.get(i);
      }
    }
    return res;
  }

  int[][] tmp = new int[][] {{1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}};

}
