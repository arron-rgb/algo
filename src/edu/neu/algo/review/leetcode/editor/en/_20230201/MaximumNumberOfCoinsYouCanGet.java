package edu.neu.algo.review.leetcode.editor.en._20230201;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MaximumNumberOfCoinsYouCanGet {
  // 1561
  // There are 3n piles of coins of varying size, you and your friends will take
  // piles of coins as follows:
  //
  //
  // In each step, you will choose any 3 piles of coins (not necessarily
  // consecutive).
  // Of your choice, Alice will pick the pile with the maximum number of coins.
  // You will pick the next pile with the maximum number of coins.
  // Your friend Bob will pick the last pile.
  // Repeat until there are no more piles of coins.
  //
  //
  // Given an array of integers piles where piles[i] is the number of coins in
  // the iᵗʰ pile.
  //
  // Return the maximum number of coins that you can have.
  //
  //
  // Example 1:
  //
  //
  // Input: piles = [2,4,1,2,7,8]
  // Output: 9
  // Explanation: Choose the triplet (2, 7, 8), Alice Pick the pile with 8 coins,
  // you the pile with 7 coins and Bob the last one.
  // Choose the triplet (1, 2, 4), Alice Pick the pile with 4 coins, you the pile
  // with 2 coins and Bob the last one.
  // The maximum number of coins which you can have are: 7 + 2 = 9.
  // On the other hand if we choose this arrangement (1, 2, 8), (2, 4, 7) you only
  // get 2 + 4 = 6 coins which is not optimal.
  //
  //
  // Example 2:
  //
  //
  // Input: piles = [2,4,5]
  // Output: 4
  //
  //
  // Example 3:
  //
  //
  // Input: piles = [9,8,7,6,5,1,2,3,4]
  // Output: 18
  //
  //
  //
  // Constraints:
  //
  //
  // 3 <= piles.length <= 10⁵
  // piles.length % 3 == 0
  // 1 <= piles[i] <= 10⁴
  //
  //
  // Related Topics Array Math Greedy Sorting Game Theory 👍 948 👎 116

  public static void main(String[] args) {
    Solution solution = new MaximumNumberOfCoinsYouCanGet().new Solution();
    String[] data = """
                  [2,4,1,2,7,8]
      [2,4,5]
      [9,8,7,6,5,1,2,3,4]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxCoins((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxCoins(int[] piles) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
