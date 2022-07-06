package edu.neu.algo.dp.leetcode.editor.en._20220705;

import edu.neu.util.InputUtil;

public class EditDistance {
  // 72
  // Given two strings word1 and word2, return the minimum number of operations
  // required to convert word1 to word2.
  //
  // You have the following three operations permitted on a word:
  //
  //
  // Insert a character
  // Delete a character
  // Replace a character
  //
  //
  //
  // Example 1:
  //
  //
  // Input: word1 = "horse", word2 = "ros"
  // Output: 3
  // Explanation:
  // horse -> rorse (replace 'h' with 'r')
  // rorse -> rose (remove 'r')
  // rose -> ros (remove 'e')
  //
  //
  // Example 2:
  //
  //
  // Input: word1 = "intention", word2 = "execution"
  // Output: 5
  // Explanation:
  // intention -> inention (remove 't')
  // inention -> enention (replace 'i' with 'e')
  // enention -> exention (replace 'n' with 'x')
  // exention -> exection (replace 'n' with 'c')
  // exection -> execution (insert 'u')
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= word1.length, word2.length <= 500
  // word1 and word2 consist of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 9025 👎 106

  public static void main(String[] args) {
    Solution solution = new EditDistance().new Solution();
    String[] data = """
          "horse"
      "ros"
      "intention"
      "execution"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minDistance((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minDistance(String word1, String word2) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
