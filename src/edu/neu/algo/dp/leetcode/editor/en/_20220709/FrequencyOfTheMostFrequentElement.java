package edu.neu.algo.dp.leetcode.editor.en._20220709;

import java.rmi.dgc.VMID;
import java.util.*;
import edu.neu.util.InputUtil;

public class FrequencyOfTheMostFrequentElement {
  // 1838
  // The frequency of an element is the number of times it occurs in an array.
  //
  // You are given an integer array nums and an integer k. In one operation, you
  // can choose an index of nums and increment the element at that index by 1.
  //
  // Return the maximum possible frequency of an element after performing at most
  // k operations.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,4], k = 5
  // Output: 3
  // Explanation: Increment the first element three times and the second element
  // two times to make nums = [4,4,4].
  // 4 has a frequency of 3.
  //
  // Example 2:
  //
  //
  // Input: nums = [1,4,8,13], k = 5
  // Output: 2
  // Explanation: There are multiple optimal solutions:
  // - Increment the first element three times to make nums = [4,4,8,13]. 4 has a
  // frequency of 2.
  // - Increment the second element four times to make nums = [1,8,8,13]. 8 has a
  // frequency of 2.
  // - Increment the third element five times to make nums = [1,4,13,13]. 13 has a
  // frequency of 2.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [3,9,6], k = 2
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁵
  // 1 <= k <= 10⁵
  //
  // Related Topics Array Binary Search Greedy Sliding Window Sorting Prefix Sum ?
  // ? 1404 👎 31

  public static void main(String[] args) {
    Solution solution = new FrequencyOfTheMostFrequentElement().new Solution();
    String[] data = """
          [1,2,4]
      5
      [1,4,8,13]
      5
      [3,9,6]
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
        solution.maxFrequency((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maxFrequency(int[] nums, int k) {
      Arrays.sort(nums);
      int left = 1, right = nums.length;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (check(mid, nums, k)) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return left;
    }

    boolean check(int len, int[] nums, int k) {
      long sum = 0;
      for (int i = 0; i < len; i++) {
        sum += nums[i];
      }
      if (sum + k >= (long)nums[len - 1] * len) {
        return true;
      }
      // 取nums[i+len-1]为出现最高频的元素
      for (int i = 1; i + len - 1 < nums.length; i++) {
        sum += (nums[i + len - 1] - nums[i - 1]);
        if (sum + k >= (long)nums[i + len - 1] * len) {
          return true;
        }
      }
      return false;
    }

  }

  // leetcode submit region end(Prohibit modification and deletion)
  class WindowSolution {
    public int maxFrequency(int[] nums, int k) {
      Arrays.sort(nums);
      int window = 0;
      int left = 0;
      int right = 0;
      while (right < nums.length) {
        int count = right - left + 1;
        int max = nums[right];
        window += nums[right];
        if (max * count - window > k) {
          window -= nums[left++];
        }
        right++;
      }
      return right - left;
    }
  }
}
