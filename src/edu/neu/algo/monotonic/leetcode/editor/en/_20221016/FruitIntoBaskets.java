package edu.neu.algo.monotonic.leetcode.editor.en._20221016;

import java.util.*;
import edu.neu.util.InputUtil;

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
  // Related Topics Array Hash Table Sliding Window 👍 1669 👎 121

  public static void main(String[] args) {
    Solution solution = new FruitIntoBaskets().new Solution();
    String[] data = """
          [1,2,1]
      [0,1,2,2]
      [1,2,3,2,2]
      [1,0,1,4,1,4,1,2,3]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.totalFruit((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int totalFruit(int[] fruits) {
      int left = 0, right = 0;
      int n = fruits.length;
      int max = 1;
      Map<Integer, Integer> map = new HashMap<>();
      while (right < n) {
        map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
        while (map.size() > 2) {
          int value = map.get(fruits[left]) - 1;
          if (value == 0) {
            map.remove(fruits[left]);
          } else {
            map.put(fruits[left], value);
          }
          left++;
        }
        max = Math.max(right - left + 1, max);
        right++;
      }
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  class Solution2 {
    public int totalFruit(int[] fruits) {
      int n = fruits.length;
      Map<Integer, Integer> cnt = new HashMap<>();

      int left = 0, ans = 0;
      for (int right = 0; right < n; ++right) {
        cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
        while (cnt.size() > 2) {
          cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
          if (cnt.get(fruits[left]) == 0) {
            cnt.remove(fruits[left]);
          }
          ++left;
        }
        ans = Math.max(ans, right - left + 1);
      }
      return ans;
    }
  }

}
