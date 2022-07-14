package edu.neu.algo.dp.leetcode.editor.en._20220713;

import java.util.*;
import edu.neu.util.InputUtil;

public class MatchsticksToSquare {
  // 473
  // You are given an integer array matchsticks where matchsticks[i] is the length
  // of the iᵗʰ matchstick. You want to use all the matchsticks to make one square.
  // You should not break any stick, but you can link them up, and each matchstick
  // must be used exactly one time.
  //
  // Return true if you can make this square and false otherwise.
  //
  //
  // Example 1:
  //
  //
  // Input: matchsticks = [1,1,2,2,2]
  // Output: true
  // Explanation: You can form a square with length 2, one side of the square came
  // two sticks with length 1.
  //
  //
  // Example 2:
  //
  //
  // Input: matchsticks = [3,3,3,3,4]
  // Output: false
  // Explanation: You cannot find a way to form a square with all the matchsticks.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= matchsticks.length <= 15
  // 1 <= matchsticks[i] <= 10⁸
  //
  // Related Topics Array Dynamic Programming Backtracking Bit Manipulation
  // Bitmask 👍 3054 👎 237

  public static void main(String[] args) {
    Solution solution = new MatchsticksToSquare().new Solution();
    String[] data = """
          [1,1,2,2,2]
      [3,3,3,3,4]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.makesquare((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean makesquare(int[] matchsticks) {
      int sum = 0;
      for (int i : matchsticks) {
        sum += i;
      }
      if ((sum % 4) != 0) {
        return false;
      }
      Arrays.sort(matchsticks);
      reverse(matchsticks);

      // 分成四组
      return dfs(matchsticks, new int[4], 0, sum / 4);
    }

    private void reverse(int[] nums) {
      int i = 0, j = nums.length - 1;
      while (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
      }
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
      if (index == nums.length) {
        for (int sum : sums) {
          if (sum != target) {
            return false;
          }
        }
        return true;
      }
      for (int i = 0; i < sums.length; i++) {
        int sum = sums[i];
        if (sum + nums[index] > target) {
          continue;
        }
        sums[i] += nums[index];
        if (dfs(nums, sums, index + 1, target)) {
          return true;
        }
        sums[i] -= nums[index];
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
