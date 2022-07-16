package edu.neu.algo.review.leetcode.editor.en._20220715;

import java.util.*;
import edu.neu.util.InputUtil;

public class MagneticForceBetweenTwoBalls {
  // 1552
  // In the universe Earth C-137, Rick discovered a special form of magnetic force
  // between two balls if they are put in his new invented basket. Rick has n empty
  // baskets, the iᵗʰ basket is at position[i], Morty has m balls and needs to
  // distribute the balls into the baskets such that the minimum magnetic force between any
  // two balls is maximum.
  //
  // Rick stated that magnetic force between two different balls at positions x
  // and y is |x - y|.
  //
  // Given the integer array position and the integer m. Return the required
  // force.
  //
  //
  // Example 1:
  //
  //
  // Input: position = [1,2,3,4,7], m = 3
  // Output: 3
  // Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the
  // magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We
  // cannot achieve a larger minimum magnetic force than 3.
  //
  //
  // Example 2:
  //
  //
  // Input: position = [5,4,3,2,1,1000000000], m = 2
  // Output: 999999999
  // Explanation: We can use baskets 1 and 1000000000.
  //
  //
  //
  // Constraints:
  //
  //
  // n == position.length
  // 2 <= n <= 10⁵
  // 1 <= position[i] <= 10⁹
  // All integers in position are distinct.
  // 2 <= m <= position.length
  //
  // Related Topics Array Binary Search Sorting 👍 1299 👎 84

  public static void main(String[] args) {
    Solution solution = new MagneticForceBetweenTwoBalls().new Solution();
    String[] data = """
          [1,2,3,4,7]
      3
      [5,4,3,2,1,1000000000]
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.maxDistance((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxDistance(int[] position, int m) {
      Arrays.sort(position);
      int left = 0;
      int right = position[position.length - 1];
      while (left < right) {
        int mid = left + (right - left + 1) / 2;
        if (check(position, m, mid)) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return left;
    }

    /*
     * returns whether we can put m balls such that minimum distance between two consecutive ball is always greater than or equal to the max.
     */
    private boolean check(int[] positions, int mid, int max) {
      int count = 1;
      int last = positions[0];
      for (int position : positions) {
        if (position - last >= max) {
          last = position;
          count++;
        }
      }
      return count >= mid;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
