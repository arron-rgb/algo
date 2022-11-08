package edu.neu.algo.review.leetcode.editor.en._20221105;

import java.util.*;
import edu.neu.util.InputUtil;

public class OrderlyQueue {
  // 899
  // You are given a string s and an integer k. You can choose one of the first k
  // letters of s and append it at the end of the string..
  //
  // Return the lexicographically smallest string you could have after applying
  // the mentioned step any number of moves.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "cba", k = 1
  // Output: "acb"
  // Explanation:
  // In the first move, we move the 1ˢᵗ character 'c' to the end, obtaining the
  // string "bac".
  // In the second move, we move the 1ˢᵗ character 'b' to the end, obtaining the
  // final result "acb".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "baaca", k = 3
  // Output: "aaabc"
  // Explanation:
  // In the first move, we move the 1ˢᵗ character 'b' to the end, obtaining the
  // string "aacab".
  // In the second move, we move the 3ʳᵈ character 'c' to the end, obtaining the
  // final result "aaabc".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= s.length <= 1000
  // s consist of lowercase English letters.
  //
  // Related Topics Math String Sorting 👍 656 👎 389

  public static void main(String[] args) {
    Solution solution = new OrderlyQueue().new Solution();
    String[] data = """
          "cba"
      1
      "baaca"
      3
          """.trim().replaceAll("\n", "<newLine>").split("<newLine>");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.orderlyQueue((String)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String orderlyQueue(String s, int k) {
      if (k == 1) {
        // 比较所有的可能的最小的开头
        String min = s;
        int n = s.length();
        for (int i = 0; i < n; i++) {
          String tmp = s.substring(i) + s.substring(0, i);
          if (tmp.compareTo(min) < 0) {
            min = tmp;
          }
        }
        return min;
      }
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return new String(chars);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
