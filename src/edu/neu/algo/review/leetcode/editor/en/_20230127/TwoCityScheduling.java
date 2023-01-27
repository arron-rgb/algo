package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class TwoCityScheduling {
  // 1029
  // A company is planning to interview 2n people. Given the array costs where
  // costs[i] = [aCosti, bCosti], the cost of flying the iᵗʰ person to city a is aCosti,
  // and the cost of flying the iᵗʰ person to city b is bCosti.
  //
  // Return the minimum cost to fly every person to a city such that exactly n
  // people arrive in each city.
  //
  //
  // Example 1:
  //
  //
  // Input: costs = [[10,20],[30,200],[400,50],[30,20]]
  // Output: 110
  // Explanation:
  // The first person goes to city A for a cost of 10.
  // The second person goes to city A for a cost of 30.
  // The third person goes to city B for a cost of 50.
  // The fourth person goes to city B for a cost of 20.
  //
  // The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
  // interviewing in each city.
  //
  //
  // Example 2:
  //
  //
  // Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
  // Output: 1859
  //
  //
  // Example 3:
  //
  //
  // Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[65
  // 0,359],[631,42]]
  // Output: 3086
  //
  //
  //
  // Constraints:
  //
  //
  // 2 * n == costs.length
  // 2 <= costs.length <= 100
  // costs.length is even.
  // 1 <= aCosti, bCosti <= 1000
  //
  //
  // Related Topics Array Greedy Sorting 👍 4147 👎 311

  public static void main(String[] args) {
    Solution solution = new TwoCityScheduling().new Solution();
    String[] data = """
                  [[10,20],[30,200],[400,50],[30,20]]
      [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
      [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.twoCitySchedCost((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int twoCitySchedCost(int[][] costs) {
      // all people go to city A
      // the total cost is sum[costs[0]]
      // choose n people go to city B
      // change cost is priceA - priceB
      Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));
      int n = costs.length / 2;
      int res = 0;
      for (int i = 0; i < n; i++) {
        res += costs[i][0] + costs[i + n][1];
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
