package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class FruitIntoBaskets {
  // 904
  // You are visiting a farm that has a single row of fruit trees arranged from
  // left to right. The trees are represented by an integer array fruits where fruits[i]
  // is the type of fruit the iᵗʰ tree produces.
  //
  // You want to collect as much fruit as possible. However, the owner has some
  // strict rules that you must follow:
  //
  //
  // You only have two baskets, and each basket can only hold a single type of
  // fruit. There is no limit on the amount of fruit each basket can hold.
  // Starting from any tree of your choice, you must pick exactly one fruit from
  // every tree (including the start tree) while moving to the right. The picked
  // fruits must fit in one of your baskets.
  // Once you reach a tree with fruit that cannot fit in your baskets, you must
  // stop.
  //
  //
  // Given the integer array fruits, return the maximum number of fruits you can
  // pick.
  //
  //
  // Example 1:
  //
  //
  // Input: fruits = [1,2,1]
  // Output: 3
  // Explanation: We can pick from all 3 trees.
  //
  //
  // Example 2:
  //
  //
  // Input: fruits = [0,1,2,2]
  // Output: 3
  // Explanation: We can pick from trees [1,2,2].
  // If we had started at the first tree, we would only pick from trees [0,1].
  //
  //
  // Example 3:
  //
  //
  // Input: fruits = [1,2,3,2,2]
  // Output: 4
  // Explanation: We can pick from trees [2,3,2,2].
  // If we had started at the first tree, we would only pick from trees [1,2].
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= fruits.length <= 10⁵
  // 0 <= fruits[i] < fruits.length
  //
  //
  // Related Topics Array Hash Table Sliding Window 👍 2178 👎 162

  public static void main(String[] args) {
    Solution solution = new FruitIntoBaskets().new Solution();
    String[] data = """
                  [1,2,1]
      [0,1,2,2]
      [1,2,3,2,2]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.totalFruit((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int totalFruit(int[] fruits) {
      // We use a hash map 'basket' to store the number of each type of fruit.
      Map<Integer, Integer> basket = new HashMap<>();
      int left = 0, maxPicked = 0;

      // Add fruit from the right index (right) of the window.
      for (int right = 0; right < fruits.length; ++right) {
        basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

        // If the current window has more than 2 types of fruit,
        // we remove fruit from the left index (left) of the window,
        // until the window has only 2 types of fruit.
        while (basket.size() > 2) {
          basket.put(fruits[left], basket.get(fruits[left]) - 1);
          if (basket.get(fruits[left]) == 0)
            basket.remove(fruits[left]);
          left++;
        }

        // Update maxPicked.
        maxPicked = Math.max(maxPicked, right - left + 1);
      }

      // Return maxPicked as the maximum number of fruits we can collect.
      return maxPicked;
    }
  }
  // runtime:92 ms
  // memory:108.6 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
