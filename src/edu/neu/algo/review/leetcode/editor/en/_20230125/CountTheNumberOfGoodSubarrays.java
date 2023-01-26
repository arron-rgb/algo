package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;
import java.util.stream.IntStream;

public class CountTheNumberOfGoodSubarrays {
  // 2537
  // Given an integer array nums and an integer k, return the number of good
  // subarrays of nums.
  //
  // A subarray arr is good if it there are at least k pairs of indices (i, j)
  // such that i < j and arr[i] == arr[j].
  //
  // A subarray is a contiguous non-empty sequence of elements within an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,1,1,1,1], k = 10
  // Output: 1
  // Explanation: The only good subarray is the array nums itself.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,1,4,3,2,2,4], k = 2
  // Output: 4
  // Explanation: There are 4 different good subarrays:
  // - [3,1,4,3,2,2] that has 2 pairs.
  // - [3,1,4,3,2,2,4] that has 3 pairs.
  // - [1,4,3,2,2,4] that has 2 pairs.
  // - [4,3,2,2,4] that has 2 pairs.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i], k <= 10⁹
  //
  //
  // Related Topics Array Hash Table Sliding Window 👍 431 👎 14

  public static void main(String[] args) {
    Solution solution = new CountTheNumberOfGoodSubarrays().new Solution();
    String[] data = """
                  [1,1,1,1,1]
      10
      [3,1,4,3,2,2,4]
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      long q =
        solution.countGood((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public long countGood(int[] nums, int k) {
      long res = 0;
      int n = nums.length;
      int left = 0, right = 0;
      int pairs = 0;
      Map<Integer, Integer> map = new HashMap<>();
      while (right < n) {
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        // map[nums[right]]起码为1，所以pairs不会为0
        pairs += map.get(nums[right]) - 1;
        while (pairs >= k) {
          // 只要当前满足条件
          // 那么加上后面未被算进subarray的数也可以
          // 所以加上 n - right
          res += n - right;
          pairs -= map.get(nums[left]) - 1;
          map.put(nums[left], map.get(nums[left]) - 1);
          left++;
        }
        right++;
      }
      return res;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

  class Solution2 {
    public long countGood(int[] nums, int k) {
      long res = 0;
      long cur = 0;
      Map<Integer, Integer> count = new HashMap<>();
      int n = nums.length;
      int right = 0, left = 0;
      while (right < n) {
        while (left < n && cur < k) {
          int t = count.getOrDefault(nums[left], 0);
          cur += t;
          count.put(nums[left], t + 1);
          left++;
        }
        if (cur >= k) {
          res += n - left + 1;
        }
        cur -= count.get(nums[right]) - 1;
        count.put(nums[right], count.get(nums[right]) - 1);
        right++;
      }
      return res;
    }
  }
}
