package edu.neu.algo.leetcode.editor.en._20220524;

public class UniqueSubstringsInWraparoundString {

  // We define the string s to be the infinite wraparound string of
  // "abcdefghijklmnopqrstuvwxyz", so s will look like this:
  //
  //
  // "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
  //
  //
  // Given a string p, return the number of unique non-empty substrings of p are
  // present in s.
  //
  //
  // Example 1:
  //
  //
  // Input: p = "a"
  // Output: 1
  // Explanation: Only the substring "a" of p is in s.
  //
  //
  // Example 2:
  //
  //
  // Input: p = "cac"
  // Output: 2
  // Explanation: There are two substrings ("a", "c") of p in s.
  //
  //
  // Example 3:
  //
  //
  // Input: p = "zab"
  // Output: 6
  // Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab")
  // of p in s.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= p.length <= 10⁵
  // p consists of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 1092 👎 138

  public static void main(String[] args) {
    Solution solution = new UniqueSubstringsInWraparoundString().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findSubstringInWraproundString(String p) {
      int[] count = new int[26];
      int res = 0;
      int currentLength = 1;
      for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        if (i > 0 && (c - p.charAt(i - 1) == 1 || p.charAt(i - 1) - c == 25)) {
          currentLength++;
        } else {
          currentLength = 1;
        }
        count[c - 'a'] = Math.max(count[c - 'a'], currentLength);
      }
      for (int i : count) {
        res += i;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
