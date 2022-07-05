package edu.neu.algo.dp.leetcode.editor.en._20220705;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class MaximumPointsYouCanObtainFromCards {
  // 1423
  // There are several cards arranged in a row, and each card has an associated
  // number of points. The points are given in the integer array cardPoints.
  //
  // In one step, you can take one card from the beginning or from the end of the
  // row. You have to take exactly k cards.
  //
  // Your score is the sum of the points of the cards you have taken.
  //
  // Given the integer array cardPoints and the integer k, return the maximum
  // score you can obtain.
  //
  //
  // Example 1:
  //
  //
  // Input: cardPoints = [1,2,3,4,5,6,1], k = 3
  // Output: 12
  // Explanation: After the first step, your score will always be 1. However,
  // choosing the rightmost card first will maximize your total score. The optimal
  // strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
  // 2.
  //
  //
  // Example 2:
  //
  //
  // Input: cardPoints = [2,2,2], k = 2
  // Output: 4
  // Explanation: Regardless of which two cards you take, your score will always
  // be 4.
  //
  //
  // Example 3:
  //
  //
  // Input: cardPoints = [9,7,7,9,7,7,9], k = 7
  // Output: 55
  // Explanation: You have to take all the cards. Your score is the sum of points
  // of all cards.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= cardPoints.length <= 10⁵
  // 1 <= cardPoints[i] <= 10⁴
  // 1 <= k <= cardPoints.length
  //
  // Related Topics Array Sliding Window Prefix Sum 👍 4352 👎 162

  public static void main(String[] args) {
    Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
    String[] data = """
                [1,2,3,4,5,6,1]
            3
            [2,2,2]
            2
            [9,7,7,9,7,7,9]
            7
            [1,79,80,1,1,1,200,1]
            3
      [1,1000,1]
      1
      [100,40,17,9,73,75]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.maxScore((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int sum = Arrays.stream(cardPoints).sum();

      int n = cardPoints.length;
      if (n == k) {
        return sum;
      }
      int min = 0;
      for (int i = 0; i < n - k; i++) {
        min += cardPoints[i];
      }
      int tmp = min;
      // 两边共取k个数
      // 剩余n-k个数
      // 求中间 n-k个数的最小和
      for (int i = n - k; i < n; i++) {
        // 减开头 + 结尾
        tmp = tmp - cardPoints[i - n + k] + cardPoints[i];
        if (tmp < min) {
          min = tmp;
        }
      }
      return sum - min;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
