package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import java.util.*;

public class LongestRepeatingCharacterReplacement {
  // 424
  // You are given a string s and an integer k. You can choose any character of
  // the string and change it to any other uppercase English character. You can perform
  // this operation at most k times.
  //
  // Return the length of the longest substring containing the same letter you
  // can get after performing the above operations.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "ABAB", k = 2
  // Output: 4
  // Explanation: Replace the two 'A's with two 'B's or vice versa.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "AABABBA", k = 1
  // Output: 4
  // Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
  // The substring "BBBB" has the longest repeating letters, which is 4.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s consists of only uppercase English letters.
  // 0 <= k <= s.length
  //
  //
  // Related Topics Hash Table String Sliding Window 👍 7213 👎 287

  public static void main(String[] args) {
    Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    String[] data = """
                  "ABAB"
      2
      "AABABBA"
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.characterReplacement((String)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int characterReplacement(String answerKey, int k) {
      int res = Integer.MIN_VALUE;
      for (char c = 'A'; c <= 'Z'; c++) {
        res = Math.max(res, maxConsecutiveChar(answerKey, k, c));
      }
      return res;
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
      int n = answerKey.length();
      int ans = 0;
      for (int left = 0, right = 0, sum = 0; right < n; right++) {
        sum += answerKey.charAt(right) != ch ? 1 : 0;
        while (sum > k) {
          sum -= answerKey.charAt(left++) != ch ? 1 : 0;
        }
        ans = Math.max(ans, right - left + 1);
      }
      return ans;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
