package edu.neu.algo.leetcode.editor.en._20220707;

import java.util.Deque;
import java.util.LinkedList;

import edu.neu.util.InputUtil;

public class MinimumOperationsToConvertNumber {
  // 2059
  // You are given a 0-indexed integer array nums containing distinct numbers, an
  // integer start, and an integer goal. There is an integer x that is initially set
  // to start, and you want to perform operations on x such that it is converted to
  // goal. You can perform the following operation repeatedly on the number x:
  //
  // If 0 <= x <= 1000, then for any index i in the array (0 <= i < nums.length),
  // you can set x to any of the following:
  //
  //
  // x + nums[i]
  // x - nums[i]
  // x ^ nums[i] (bitwise-XOR)
  //
  //
  // Note that you can use each nums[i] any number of times in any order.
  // Operations that set x to be out of the range 0 <= x <= 1000 are valid, but no more
  // operations can be done afterward.
  //
  // Return the minimum number of operations needed to convert x = start into
  // goal, and -1 if it is not possible.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,4,12], start = 2, goal = 12
  // Output: 2
  // Explanation: We can go from 2 → 14 → 12 with the following 2 operations.
  // - 2 + 12 = 14
  // - 14 - 2 = 12
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,5,7], start = 0, goal = -4
  // Output: 2
  // Explanation: We can go from 0 → 3 → -4 with the following 2 operations.
  // - 0 + 3 = 3
  // - 3 - 7 = -4
  // Note that the last operation sets x out of the range 0 <= x <= 1000, which is
  // valid.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [2,8,16], start = 0, goal = 1
  // Output: -1
  // Explanation: There is no way to convert 0 into 1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 1000
  // -10⁹ <= nums[i], goal <= 10⁹
  // 0 <= start <= 1000
  // start != goal
  // All the integers in nums are distinct.
  //
  // Related Topics Array Breadth-First Search 👍 418 👎 22

  public static void main(String[] args) {
    Solution solution = new MinimumOperationsToConvertNumber().new Solution();
    String[] data = """
          [2,4,12]
      2
      12
      [3,5,7]
      0
      -4
      [2,8,16]
      0
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minimumOperations((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
      Deque<Integer> q = new LinkedList<>();
      q.offer(start);
      boolean[] visited = new boolean[1001];
      visited[start] = true;
      int step = 0;
      while (!q.isEmpty()) {
        int size = q.size();
        step++;
        while (size-- > 0) {// 当前队列元素对应同一个step
          int poll = q.poll();
          for (int n : nums) {
            for (int x : new int[] {poll - n, poll + n, poll ^ n}) {
              if (x == goal) {
                return step;
              }
              if (x >= 0 && x <= 1000 && !visited[x]) {
                q.offer(x);
                visited[x] = true;
              }
            }
          }
        }
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
