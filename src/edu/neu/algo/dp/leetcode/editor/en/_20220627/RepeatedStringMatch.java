package edu.neu.algo.dp.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class RepeatedStringMatch {
  // 686
  // Given two strings a and b, return the minimum number of times you should
  // repeat string a so that string b is a substring of it. If it is impossible for b to
  // be a substring of a after repeating it, return -1.
  //
  // Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and
  // repeated 2 times is "abcabc".
  //
  //
  // Example 1:
  //
  //
  // Input: a = "abcd", b = "cdabcdab"
  // Output: 3
  // Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b
  // is a substring of it.
  //
  //
  // Example 2:
  //
  //
  // Input: a = "a", b = "aa"
  // Output: 2
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= a.length, b.length <= 10⁴
  // a and b consist of lowercase English letters.
  //
  // Related Topics String String Matching 👍 1537 👎 906

  public static void main(String[] args) {
    Solution solution = new RepeatedStringMatch().new Solution();
    String[] data = """
          "abcd"
      "cdabcdab"
      "a"
      "aa"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.repeatedStringMatch((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int repeatedStringMatch(String a, String b) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
