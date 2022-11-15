package edu.neu.algo.review.leetcode.editor.en._20221114;

import edu.neu.util.InputUtil;

public class NumberOfStudentsDoingHomeworkAtAGivenTime {

  // Given two integer arrays startTime and endTime and given an integer queryTime.
  //
  //
  // The ith student started doing their homework at the time startTime[i] and
  // finished it at time endTime[i].
  //
  // Return the number of students doing their homework at time queryTime. More
  // formally, return the number of students where queryTime lays in the interval [
  // startTime[i], endTime[i]] inclusive.
  //
  //
  // Example 1:
  //
  //
  // Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
  // Output: 1
  // Explanation: We have 3 students where:
  // The first student started doing homework at time 1 and finished at time 3 and
  // wasn't doing anything at time 4.
  // The second student started doing homework at time 2 and finished at time 2
  // and also wasn't doing anything at time 4.
  // The third student started doing homework at time 3 and finished at time 7 and
  // was the only student doing homework at time 4.
  //
  //
  // Example 2:
  //
  //
  // Input: startTime = [4], endTime = [4], queryTime = 4
  // Output: 1
  // Explanation: The only student was doing their homework at the queryTime.
  //
  //
  //
  // Constraints:
  //
  //
  // startTime.length == endTime.length
  // 1 <= startTime.length <= 100
  // 1 <= startTime[i] <= endTime[i] <= 1000
  // 1 <= queryTime <= 1000
  //
  // Related Topics Array 👍 687 👎 139

  public static void main(String[] args) {
    Solution solution = new NumberOfStudentsDoingHomeworkAtAGivenTime().new Solution();
    String[] data = """
                  [1,2,3]
      [3,2,7]
      4
      [4]
      [4]
      4
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.busyStudent((int[])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
      int n = startTime.length;
      int res = 0;
      for (int i = 0; i < n; i++) {
        if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
          res++;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
