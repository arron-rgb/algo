package edu.neu.algo.review.leetcode.editor.en._20221114;

import edu.neu.util.InputUtil;

import java.util.Arrays;

public class CorporateFlightBookings {

  // There are n flights that are labeled from 1 to n.
  //
  // You are given an array of flight bookings bookings, where bookings[i] = [
  // firsti, lasti, seatsi] represents a booking for flights firsti through lasti (
  // inclusive) with seatsi seats reserved for each flight in the range.
  //
  // Return an array answer of length n, where answer[i] is the total number of
  // seats reserved for flight i.
  //
  //
  // Example 1:
  //
  //
  // Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
  // Output: [10,55,45,25,25]
  // Explanation:
  // Flight labels: 1 2 3 4 5
  // Booking 1 reserved: 10 10
  // Booking 2 reserved: 20 20
  // Booking 3 reserved: 25 25 25 25
  // Total seats: 10 55 45 25 25
  // Hence, answer = [10,55,45,25,25]
  //
  //
  // Example 2:
  //
  //
  // Input: bookings = [[1,2,10],[2,2,15]], n = 2
  // Output: [10,25]
  // Explanation:
  // Flight labels: 1 2
  // Booking 1 reserved: 10 10
  // Booking 2 reserved: 15
  // Total seats: 10 25
  // Hence, answer = [10,25]
  //
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 2 * 10⁴
  // 1 <= bookings.length <= 2 * 10⁴
  // bookings[i].length == 3
  // 1 <= firsti <= lasti <= n
  // 1 <= seatsi <= 10⁴
  //
  // Related Topics Array Prefix Sum 👍 1247 👎 146

  public static void main(String[] args) {
    Solution solution = new CorporateFlightBookings().new Solution();
    String[] data = """
                  [[1,2,10],[2,3,20],[2,5,25]]
      5
      [[1,2,10],[2,2,15]]
      2
      [[2,2,30],[2,2,45]]
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.corpFlightBookings((int[][])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
      int[] res = new int[n];
      for (int[] v : bookings) {
        res[v[0] - 1] += v[2];
        if (v[1] < n) res[v[1]] -= v[2];
      }
      for (int i = 1; i < n; ++i) res[i] += res[i - 1];
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
