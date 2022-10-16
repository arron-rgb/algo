package edu.neu.algo.leetcode.editor.en._20220707;

import edu.neu.util.InputUtil;

public class ShuffleTheArray {

  // 1470
  // Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2
  // ,...,yn].
  //
  // Return the array in the form [x1,y1,x2,y2,...,xn,yn].
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,5,1,3,4,7], n = 3
  // Output: [2,3,5,4,1,7]
  // Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,
  // 5,4,1,7].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4,4,3,2,1], n = 4
  // Output: [1,4,2,3,3,2,4,1]
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,1,2,2], n = 2
  // Output: [1,2,1,2]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 500
  // nums.length == 2n
  // 1 <= nums[i] <= 10^3
  // Related Topics Array 👍 2542 👎 182

  public static void main(String[] args) {
    // Solution solution = new ShuffleTheArray().new Solution();
    String[] data = """
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
    for (int i = 0; i < loop; i++) {
      // int[] q =
      // solution.shuffle((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
    }
    // shuffleTheArray.canReceiveAllSignals()
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] shuffle(int[] nums, int n) {
      // [0, 1, ... n-1] -> [0, 2, ... 2n]
      // [n, n+1, ... 2n-1] -> [1, 3, ... , 2n-1]
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
          int j = i;
          while (nums[i] > 0) {
            j = j < n ? 2 * j : 2 * (j - n) + 1;
            swap(nums, i, j);
            nums[j] = -nums[j];
          }
        }
      }
      for (int num : nums) {
        num = -num;
      }

      Pair pair = new Pair(1, 2);

      return nums;
    }

    void swap(int[] nums, int j, int i) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  record Pair(int x, int y) {
    public static String name;
  }

}
