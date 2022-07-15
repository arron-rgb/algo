package edu.neu.algo.review.leetcode.editor.en._20220715;

import java.util.*;
import edu.neu.util.InputUtil;

public class FirstBadVersion {
  // 278
  // You are a product manager and currently leading a team to develop a new
  // product. Unfortunately, the latest version of your product fails the quality check.
  // Since each version is developed based on the previous version, all the versions
  // after a bad version are also bad.
  //
  // Suppose you have n versions [1, 2, ..., n] and you want to find out the
  // first bad one, which causes all the following ones to be bad.
  //
  // You are given an API bool isBadVersion(version) which returns whether
  // version is bad. Implement a function to find the first bad version. You should
  // minimize the number of calls to the API.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 5, bad = 4
  // Output: 4
  // Explanation:
  // call isBadVersion(3) -> false
  // call isBadVersion(5) -> true
  // call isBadVersion(4) -> true
  // Then 4 is the first bad version.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 1, bad = 1
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= bad <= n <= 2³¹ - 1
  //
  // Related Topics Binary Search Interactive 👍 5423 👎 2021

  public static void main(String[] args) {
    Solution solution = new FirstBadVersion().new Solution();
    String[] data = """
          5
      1

          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.firstBadVersion((int)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

  public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int left = 0, right = n;
      while (left < right) {
        int mid = left + (right - left) / 2;
        // [0, ..., mid, bad,]
        if (isBadVersion(mid)) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return left;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  class VersionControl {
    boolean isBadVersion(int version) {
      return false;
    }
  }
}
