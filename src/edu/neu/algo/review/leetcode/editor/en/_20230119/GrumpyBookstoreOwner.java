package edu.neu.algo.review.leetcode.editor.en._20230119;

import edu.neu.util.InputUtil;
import java.util.*;

public class GrumpyBookstoreOwner {

  // There is a bookstore owner that has a store open for n minutes. Every minute,
  // some number of customers enter the store. You are given an integer array
  // customers of length n where customers[i] is the number of the customer that enters the
  // store at the start of the iᵗʰ minute and all those customers leave after the
  // end of that minute.
  //
  // On some minutes, the bookstore owner is grumpy. You are given a binary array
  // grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the iᵗʰ
  // minute, and is 0 otherwise.
  //
  // When the bookstore owner is grumpy, the customers of that minute are not
  // satisfied, otherwise, they are satisfied.
  //
  // The bookstore owner knows a secret technique to keep themselves not grumpy
  // for minutes consecutive minutes, but can only use it once.
  //
  // Return the maximum number of customers that can be satisfied throughout the
  // day.
  //
  //
  // Example 1:
  //
  //
  // Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
  // Output: 16
  // Explanation: The bookstore owner keeps themselves not grumpy for the last 3
  // minutes.
  // The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5
  // = 16.
  //
  //
  // Example 2:
  //
  //
  // Input: customers = [1], grumpy = [0], minutes = 1
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // n == customers.length == grumpy.length
  // 1 <= minutes <= n <= 2 * 10⁴
  // 0 <= customers[i] <= 1000
  // grumpy[i] is either 0 or 1.
  //
  //
  // Related Topics Array Sliding Window 👍 1395 👎 117

  public static void main(String[] args) {
    Solution solution = new GrumpyBookstoreOwner().new Solution();
    String[] data = """


      3
      [1]
      [0]
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("${question.paramTypes}");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // }
    int i = solution.maxSatisfied(InputUtil.stringToArray("[1,0,1,2,1,1,7,5]"),
      InputUtil.stringToArray("[0,1,0,1,0,1,0,1]"), 3);
    System.out.println(i);
    i = solution.maxSatisfied(InputUtil.stringToArray("[1]"), InputUtil.stringToArray("[0]"), 1);
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      // maintain a minutes-size window, maximum the sum of elements whose grumpy[i] is zero
      int n = grumpy.length;
      // not grumpy: satisfied, sum
      // grumpy: minutes => not grumpy
      int res = 0;
      for (int i = 0; i < n; i++) {
        if (grumpy[i] == 0) {
          res += customers[i];
        }
      }
      int tmp = 0;
      for (int i = 0; i < minutes; i++) {
        if (grumpy[i] == 1) {
          tmp += customers[i];
        }
      }
      int max = tmp;
      for (int i = minutes; i < n; i++) {
        // i - minutes
        if (grumpy[i - minutes] == 1) {
          tmp -= customers[i - minutes];
        }
        if (grumpy[i] == 1) {
          tmp += customers[i];
        }
        if (max < tmp) {
          max = tmp;
        }
      }
      return max + res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
