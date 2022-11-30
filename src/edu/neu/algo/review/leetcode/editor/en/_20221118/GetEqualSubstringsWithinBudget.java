package edu.neu.algo.review.leetcode.editor.en._20221118;

import edu.neu.util.InputUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GetEqualSubstringsWithinBudget {

  // You are given two strings s and t of the same length and an integer maxCost.
  //
  // You want to change s to t. Changing the iᵗʰ character of s to iᵗʰ character
  // of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values
  // of the characters).
  //
  // Return the maximum length of a substring of s that can be changed to be the
  // same as the corresponding substring of t with a cost less than or equal to
  // maxCost. If there is no substring from s that can be changed to its corresponding
  // substring from t, return 0.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abcd", t = "bcdf", maxCost = 3
  // Output: 3
  // Explanation: "abc" of s can change to "bcd".
  // That costs 3, so the maximum length is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "abcd", t = "cdef", maxCost = 3
  // Output: 1
  // Explanation: Each character in s costs 2 to change to character in t, so the
  // maximum length is 1.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "abcd", t = "acde", maxCost = 0
  // Output: 1
  // Explanation: You cannot make any change, so the maximum length is 1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // t.length == s.length
  // 0 <= maxCost <= 10⁶
  // s and t consist of only lowercase English letters.
  //
  // Related Topics String Binary Search Sliding Window Prefix Sum 👍 812 👎 52

  public static void main(String[] args) {
    Solution solution = new GetEqualSubstringsWithinBudget().new Solution();
    String[] data = """
      "abcd"
      "cdef"
      3
      "abcd"
      "acde"
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.equalSubstring((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
      int left = 0; // 窗口左边界
      int cost = 0; // 当前窗口消耗
      // i作为窗口右边界
      for (int i = 0; i < s.length(); i++) {
        cost += Math.abs(s.charAt(i) - t.charAt(i));
        // 如果当前窗口消耗大于总开销，则左边界++，缩减窗口
        if (cost > maxCost) {
          cost -= Math.abs(s.charAt(left) - t.charAt(left));
          left++;
        }
      }
      return s.length() - left;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
