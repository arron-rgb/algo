package edu.neu.algo.dp.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class PalindromicSubstrings {
  // 647
  // Given a string s, return the number of palindromic substrings in it.
  //
  // A string is a palindrome when it reads the same backward as forward.
  //
  // A substring is a contiguous sequence of characters within the string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abc"
  // Output: 3
  // Explanation: Three palindromic strings: "a", "b", "c".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "aaa"
  // Output: 6
  // Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consists of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 7428 👎 163

  public static void main(String[] args) {
    Solution solution = new PalindromicSubstrings().new Solution();
    String[] data = """
          "abc"
      "aaa"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.countSubstrings((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int countSubstrings(String s) {
      int len, ans = 0;
      if (s == null || (len = s.length()) < 1) {
        return 0;
      }
      // dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
      boolean[][] dp = new boolean[len][len];
      for (int j = 0; j < len; j++) {
        for (int i = 0; i <= j; i++) {
          // 当两端字母一样时，才可以两端收缩进一步判断
          if (s.charAt(i) == s.charAt(j)) {
            // i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
            if (j - i < 3) {
              dp[i][j] = true;
            } else {
              // 否则通过收缩之后的字串判断
              dp[i][j] = dp[i + 1][j - 1];
            }
          } else {// 两端字符不一样，不是回文串
            dp[i][j] = false;
          }
        }
      }
      // 遍历每一个字串，统计回文串个数
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if (dp[i][j]) {
            ans++;
          }
        }
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
