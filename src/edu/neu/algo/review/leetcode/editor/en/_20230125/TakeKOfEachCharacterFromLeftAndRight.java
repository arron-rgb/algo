package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class TakeKOfEachCharacterFromLeftAndRight {
  // 2516
  // You are given a string s consisting of the characters 'a', 'b', and 'c' and a
  // non-negative integer k. Each minute, you may take either the leftmost character
  // of s, or the rightmost character of s.
  //
  // Return the minimum number of minutes needed for you to take at least k of
  // each character, or return -1 if it is not possible to take k of each character.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "aabaaaacaabc", k = 2
  // Output: 8
  // Explanation:
  // Take three characters from the left of s. You now have two 'a' characters,
  // and one 'b' character.
  // Take five characters from the right of s. You now have four 'a' characters,
  // two 'b' characters, and two 'c' characters.
  // A total of 3 + 5 = 8 minutes is needed.
  // It can be proven that 8 is the minimum number of minutes needed.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "a", k = 1
  // Output: -1
  // Explanation: It is not possible to take one 'b' or 'c' so return -1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s consists of only the letters 'a', 'b', and 'c'.
  // 0 <= k <= s.length
  //
  //
  // Related Topics Hash Table String Sliding Window 👍 448 👎 45

  public static void main(String[] args) {
    Solution solution = new TakeKOfEachCharacterFromLeftAndRight().new Solution();
    String[] data = """
                  "aabaaaacaabc"
      2
      "a"
      1
      "a"
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.takeCharacters((String)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int takeCharacters(String s, int k) {
      char[] cs = s.toCharArray();
      int[] freq = new int[100];
      // 哈希计数
      for (char c : cs)
        freq[c]++;

      // 判断能否取到
      for (int i = 97; i < freq.length; i++)
        if (freq[i] < k)
          return -1;
      // 从两端取值等价于从中间取值（滑动窗口），
      // 从两端取值每种字符至少 k 个
      // 即从中间取值每种字符至多 freq[c] - k 个
      // freq[c] 为某字符在字符串中出现的总次数
      int max = 0;
      int n = cs.length;
      int left = 0, right = 0;
      // 滑窗
      while (right < n) {
        if (--freq[cs[right]] < k) {
          max = Math.max(max, right - left);
          while (freq[cs[right]] < k) {
            freq[cs[left]]++;
            left++;
          }
        }
        right++;
      }
      // 尾处理
      max = Math.max(max, right - left);

      return n - max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
