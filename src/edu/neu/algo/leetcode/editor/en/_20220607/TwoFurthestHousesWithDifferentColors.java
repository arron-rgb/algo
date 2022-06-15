package edu.neu.algo.leetcode.editor.en._20220607;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoFurthestHousesWithDifferentColors {

  // There are n houses evenly lined up on the street, and each house is
  // beautifully painted. You are given a 0-indexed integer array colors of length n, where
  // colors[i] represents the color of the iᵗʰ house.
  //
  // Return the maximum distance between two houses with different colors.
  //
  // The distance between the iᵗʰ and jᵗʰ houses is abs(i - j), where abs(x) is
  // the absolute value of x.
  //
  //
  // Example 1:
  //
  //
  // Input: colors = [1,1,1,6,1,1,1]
  // Output: 3
  // Explanation: In the above image, color 1 is blue, and color 6 is red.
  // The furthest two houses with different colors are house 0 and house 3.
  // House 0 has color 1, and house 3 has color 6. The distance between them is
  // abs(0 - 3) = 3.
  // Note that houses 3 and 6 can also produce the optimal answer.
  //
  //
  // Example 2:
  //
  //
  // Input: colors = [1,8,3,8,3]
  // Output: 4
  // Explanation: In the above image, color 1 is blue, color 8 is yellow, and
  // color 3 is green.
  // The furthest two houses with different colors are house 0 and house 4.
  // House 0 has color 1, and house 4 has color 3. The distance between them is
  // abs(0 - 4) = 4.
  //
  //
  // Example 3:
  //
  //
  // Input: colors = [0,1]
  // Output: 1
  // Explanation: The furthest two houses with different colors are house 0 and
  // house 1.
  // House 0 has color 0, and house 1 has color 1. The distance between them is
  // abs(0 - 1) = 1.
  //
  //
  //
  // Constraints:
  //
  //
  // n == colors.length
  // 2 <= n <= 100
  // 0 <= colors[i] <= 100
  // Test data are generated such that at least two houses have different colors.
  //
  //
  // Related Topics Array Greedy 👍 440 👎 15

  public static void main(String[] args) {
    Solution solution = new TwoFurthestHousesWithDifferentColors().new Solution();
    int i = solution.maxDistance(new int[] {1, 8, 3, 8, 3});
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxDistance(int[] colors) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < colors.length; i++) {
        int color = colors[i];
        map.computeIfAbsent(color, (k) -> new ArrayList<>()).add(i);
      }
      List<List<Integer>> collect = map.values().stream().toList();
      int max = -1;
      for (int i = 0; i < collect.size(); i++) {
        for (int j = 0; j < collect.size(); j++) {
          if (i == j) {
            continue;
          }
          max = Math.max(max, Math.abs(collect.get(i).get(0) - collect.get(j).get(collect.get(j).size() - 1)));
        }
      }
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
