package edu.neu.algo.leetcode.editor.en._20220704;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class Candy {
  // 135
  // There are n children standing in a line. Each child is assigned a rating
  // value given in the integer array ratings.
  //
  // You are giving candies to these children subjected to the following
  // requirements:
  //
  //
  // Each child must have at least one candy.
  // Children with a higher rating get more candies than their neighbors.
  //
  //
  // Return the minimum number of candies you need to have to distribute the
  // candies to the children.
  //
  //
  // Example 1:
  //
  //
  // Input: ratings = [1,0,2]
  // Output: 5
  // Explanation: You can allocate to the first, second and third child with 2, 1,
  // 2 candies respectively.
  //
  //
  // Example 2:
  //
  //
  // Input: ratings = [1,2,2]
  // Output: 4
  // Explanation: You can allocate to the first, second and third child with 1, 2,
  // 1 candies respectively.
  // The third child gets 1 candy because it satisfies the above two conditions.
  //
  //
  //
  // Constraints:
  //
  //
  // n == ratings.length
  // 1 <= n <= 2 * 10⁴
  // 0 <= ratings[i] <= 2 * 10⁴
  //
  // Related Topics Array Greedy 👍 4197 👎 298

  public static void main(String[] args) {
    Solution solution = new Candy().new Solution();
    String[] data = """
          [1,0,2]
          [1,3,2,2,1]
          [1,3,4,5,2]
      [1,2,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.candy((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int candy(int[] ratings) {
      int n = ratings.length;
      int[] candies = new int[n];
      Arrays.fill(candies, 1);

      for (int i = 0; i < n - 1; i++) {
        // 保证自己分数比左边高的话 比左边的大
        if (ratings[i + 1] > ratings[i]) {
          candies[i + 1] = candies[i] + 1;
        }
      }
      for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1] && candies[i + 1] + 1 > candies[i]) {
          candies[i] = candies[i + 1] + 1;
        }
      }
      n = 0;
      for (int candy : candies) {
        n += candy;
      }
      return n;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
