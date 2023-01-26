package edu.neu.algo.review.leetcode.editor.en._20221216;

import edu.neu.util.InputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProfitInJobScheduling {

  // We have n jobs, where every job is scheduled to be done from startTime[i] to
  // endTime[i], obtaining a profit of profit[i].
  //
  // You're given the startTime, endTime and profit arrays, return the maximum
  // profit you can take such that there are no two jobs in the subset with overlapping
  // time range.
  //
  // If you choose a job that ends at time X you will be able to start another
  // job that starts at time X.
  //
  //
  // Example 1:
  //
  //
  //
  //
  // Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
  // Output: 120
  // Explanation: The subset chosen is the first and fourth job.
  // Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
  //
  //
  // Example 2:
  //
  //
  //
  //
  // Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
  // ,60]
  // Output: 150
  // Explanation: The subset chosen is the first, fourth and fifth job.
  // Profit obtained 150 = 20 + 70 + 60.
  //
  //
  // Example 3:
  //
  //
  //
  //
  // Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
  // Output: 6
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴
  // 1 <= startTime[i] < endTime[i] <= 10⁹
  // 1 <= profit[i] <= 10⁴
  //
  // Related Topics Array Binary Search Dynamic Programming Sorting 👍 4758 👎 55

  public static void main(String[] args) {
    Solution solution = new MaximumProfitInJobScheduling().new Solution();
    String[] data = """
                  [1,2,3,3]
      [3,4,5,6]
      [50,10,40,70]
      [1,2,3,4,6]
      [3,5,10,6,9]
      [20,20,100,70,60]
      [1,1,1]
      [2,3,4]
      [5,6,4]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.jobScheduling((int[])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length], (int[])params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      int n = startTime.length;
      List<int[]> events = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        events.add(new int[] {startTime[i], 1, i});
        events.add(new int[] {endTime[i], 0, i});
      }

      events.sort((o1, o2) -> {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      });
      int[] maxProfit = new int[n];
      int previousMax = 0;
      for (int[] event : events) {
        int type = event[1];
        int index = event[2];
        if (type == 1) {
          maxProfit[index] = previousMax + profit[index];
        } else {
          previousMax = Math.max(previousMax, maxProfit[index]);
        }
      }
      return previousMax;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
