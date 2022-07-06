package edu.neu.algo.dp.leetcode.editor.en._20220705;

import edu.neu.util.InputUtil;

public class DeleteOperationForTwoStrings {
  // 583
  // Given two strings word1 and word2, return the minimum number of steps
  // required to make word1 and word2 the same.
  //
  // In one step, you can delete exactly one character in either string.
  //
  //
  // Example 1:
  //
  //
  // Input: word1 = "sea", word2 = "eat"
  // Output: 2
  // Explanation: You need one step to make "sea" to "ea" and another step to make
  // "eat" to "ea".
  //
  //
  // Example 2:
  //
  //
  // Input: word1 = "leetcode", word2 = "etco"
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= word1.length, word2.length <= 500
  // word1 and word2 consist of only lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 4176 👎 62

  public static void main(String[] args) {
    Solution solution = new DeleteOperationForTwoStrings().new Solution();
    String[] data = """
          "sea"
      "eat"
      "leetcode"
      "etco"
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
