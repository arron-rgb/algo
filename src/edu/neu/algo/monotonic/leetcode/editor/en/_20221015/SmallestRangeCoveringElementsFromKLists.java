package edu.neu.algo.monotonic.leetcode.editor.en._20221015;

import edu.neu.util.InputUtil;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
  // 632
  // You have k lists of sorted integers in non-decreasing order. Find the
  // smallest range that includes at least one number from each of the k lists.
  //
  // We define the range [a, b] is smaller than range [c, d] if b - a < d - c or
  // a < c if b - a == d - c.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
  // Output: [20,24]
  // Explanation:
  // List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
  // List 2: [0, 9, 12, 20], 20 is in range [20,24].
  // List 3: [5, 18, 22, 30], 22 is in range [20,24].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
  // Output: [1,1]
  //
  //
  //
  // Constraints:
  //
  //
  // nums.length == k
  // 1 <= k <= 3500
  // 1 <= nums[i].length <= 50
  // -10⁵ <= nums[i][j] <= 10⁵
  // nums[i] is sorted in non-decreasing order.
  //
  // Related Topics Array Hash Table Greedy Sliding Window Sorting Heap (Priority
  // Queue) 👍 2631 👎 46

  public static void main(String[] args) {
    // solution.countTime("?5:00");
    // Solution solution = new SmallestRangeCoveringElementsFromKLists().new Solution();
    // String[] data = """
    // [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
    // [[1,2,3],[1,2,3],[1,2,3]]
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[List<List<Integer>>]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // int[] q = solution.smallestRange((List<List<Integer>>)params[1 + i * paramTypes.length - 1]);
    // System.out.println(q);
  }

  class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      // 区间的左边和右边
      int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
      // 最小范围
      int minRange = rangeRight - rangeLeft;
      // 区间的左边最大值
      int max = Integer.MIN_VALUE;
      int size = nums.size();
      // 由于 k 个列表都是升序排列的，因此对每个列表维护一个指针，
      // 通过指针得到列表中的元素，指针右移之后指向的元素一定大于或等于之前的元素。
      int[] next = new int[size];
      // 使用最小堆维护 k 个指针指向的元素中的最小值
      PriorityQueue<Integer> priorityQueue =
        new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(next[index])));

      for (int i = 0; i < size; i++) {
        // 初始时，i 个指针都指向下标 0，因为next[i]=0
        priorityQueue.offer(i);
        // 最大元素即为所有列表的下标 0 位置的元素中的最大值
        max = Math.max(max, nums.get(i).get(0));
      }

      while (true) {
        // 每次从堆中取出最小值，minIndex是指第几个列表，也代表指针数组next的下标
        int minIndex = priorityQueue.poll();
        // 根据最大值和最小值计算当前区间
        int curRange = max - nums.get(minIndex).get(next[minIndex]);
        // 如果当前区间小于最小区间则用当前区间更新最小区间
        if (curRange < minRange) {
          minRange = curRange;
          rangeLeft = nums.get(minIndex).get(next[minIndex]);
          rangeRight = max;
        }
        // 然后将对应列表的指针右移
        next[minIndex]++;
        // 如果一个列表的指针超出该列表的下标范围，则说明该列表中的所有元素都被遍历过，
        // 堆中不会再有该列表中的元素，因此退出循环。
        if (next[minIndex] == nums.get(minIndex).size()) {
          break;
        }
        // 将新元素加入堆中
        priorityQueue.offer(minIndex);
        // 并更新堆中元素的最大值
        max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
      }
      return new int[] {rangeLeft, rangeRight};
    }

    // leetcode submit region end(Prohibit modification and deletion)

  }

  public int countTime(String time) {
    String[] split = time.split(":");
    int left = 0;
    if (!split[0].contains("?")) {
      left = 1;
    } else {
      int hr = 0;
      for (int i = 0; i < 3; i++) {
        if (split[0].charAt(0) == '?') {
          hr = i * 10;
        } else {
          hr = (split[0].charAt(0) - '0') * 10;
        }
        if (split[0].charAt(1) == '?') {
          hr += split[0].charAt(1) - '0';
          if (hr >= 0 && hr <= 24) {
            left++;
          }
        } else {
          for (int j = 0; j < 10; j++) {
            int tmp = hr;
            tmp += j;
            if (tmp >= 0 && tmp <= 24) {
              left++;
            }
          }
        }
      }
    }
    int right = 0;
    if (!split[1].contains("?")) {
      right = 1;
    } else {
      int min = 0;
      for (int i = 0; i < 6; i++) {
        if (split[1].charAt(0) == '?') {
          min = i * 10;
        } else {
          min = (split[1].charAt(0) - '0') * 10;
        }
        if (split[1].charAt(1) == '?') {
          for (int j = 0; j < 10; j++) {
            int tmp = min;
            tmp += j;
            if (tmp >= 0 && tmp <= 59) {
              right++;
            }
          }
        } else {
          min += split[1].charAt(1) - '0';
          if (min >= 0 && min <= 59) {
            right++;
          }
        }
      }
    }
    return left * right;
  }

  public int[] productQueries(int n, int[][] queries) {
    int len = queries.length;
    int[] res = new int[len];
    int mod = (int)(1e9 + 7);
    String s = Integer.toBinaryString(n);
    List<Long> powers = new ArrayList<>();
    long pow = 1;
    powers.add(pow);
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '1') {
        powers.add(pow);
      }
      pow *= 2;
    }
    Long[] prefix = powers.toArray(new Long[0]);
    for (int i = 1; i < prefix.length; i++) {
      prefix[i] = prefix[i] % mod * prefix[i - 1] % mod;
    }
    System.out.println(powers);
    System.out.println(Arrays.toString(prefix));
    for (int i = 0; i < len; i++) {
      if (queries[i][0] == queries[i][1]) {
        res[i] = (int)(powers.get(queries[i][0] + 1) % mod);
        continue;
      }
      res[i] = (int)((prefix[queries[i][1] + 1] % mod / prefix[queries[i][0]]) % mod);
    }
    return res;
  }
}

// leetcode submit region begin(Prohibit modification and deletion)
