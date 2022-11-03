package edu.neu.algo.review.leetcode.editor.en._20221102;

import java.util.*;
import edu.neu.util.InputUtil;

public class PalindromePartitioningII {
  // 132
  // Given a string s, partition s such that every substring of the partition is a
  // palindrome.
  //
  // Return the minimum cuts needed for a palindrome partitioning of s.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "aab"
  // Output: 1
  // Explanation: The palindrome partitioning ["aa","b"] could be produced using 1
  // cut.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "a"
  // Output: 0
  //
  //
  // Example 3:
  //
  //
  // Input: s = "ab"
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 2000
  // s consists of lowercase English letters only.
  //
  // Related Topics String Dynamic Programming 👍 4187 👎 97

  public static void main(String[] args) {
    Solution solution = new PalindromePartitioningII().new Solution();
    String[] data = """
          "aab"
      "a"
      "ab"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minCut((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minCut(String s) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
