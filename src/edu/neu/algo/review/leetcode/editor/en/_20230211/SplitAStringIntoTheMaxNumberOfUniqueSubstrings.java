package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
  // 1593
  // Given a string s, return the maximum number of unique substrings that the
  // given string can be split into.
  //
  // You can split string s into any list of non-empty substrings, where the
  // concatenation of the substrings forms the original string. However, you must split
  // the substrings such that all of them are unique.
  //
  // A substring is a contiguous sequence of characters within a string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "ababccc"
  // Output: 5
  // Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
  // Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b'
  // multiple times.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "aba"
  // Output: 2
  // Explanation: One way to split maximally is ['a', 'ba'].
  //
  //
  // Example 3:
  //
  //
  // Input: s = "aa"
  // Output: 1
  // Explanation: It is impossible to split the string any further.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 16
  // s contains only lower case English letters.
  //
  //
  // Related Topics Hash Table String Backtracking 👍 699 👎 26

  public static void main(String[] args) {
    Solution solution = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings().new Solution();
    String[] data = """
                  "ababccc"
      "aba"
      "aa"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxUniqueSplit((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int maxSplit = 1;

    public int maxUniqueSplit(String s) {
      backtrack(0, 0, s, new HashSet<>());
      return maxSplit;
    }

    public void backtrack(int index, int split, String s, Set<String> set) {
      int length = s.length();
      if (index >= length) {
        maxSplit = Math.max(maxSplit, split);
        return;
      }
      for (int i = index; i < length; i++) {
        String substr = s.substring(index, i + 1);
        if (set.add(substr)) {
          backtrack(i + 1, split + 1, s, set);
          set.remove(substr);
        }
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
