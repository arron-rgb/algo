package edu.neu.algo.leetcode.editor.en._20220626;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.neu.util.InputUtil;

public class RepeatedDNASequences {

  // The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
  // 'C', 'G', and 'T'.
  //
  //
  // For example, "ACGAATTCCG" is a DNA sequence.
  //
  //
  // When studying DNA, it is useful to identify repeated sequences within the
  // DNA.
  //
  // Given a string s that represents a DNA sequence, return all the 10-letter-
  // long sequences (substrings) that occur more than once in a DNA molecule. You may
  // return the answer in any order.
  //
  //
  // Example 1:
  // Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
  // Output: ["AAAAACCCCC","CCCCCAAAAA"]
  // Example 2:
  // Input: s = "AAAAAAAAAAAAA"
  // Output: ["AAAAAAAAAA"]
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s[i] is either 'A', 'C', 'G', or 'T'.
  //
  // Related Topics Hash Table String Bit Manipulation Sliding Window Rolling
  // Hash Hash Function 👍 2113 👎 422

  public static void main(String[] args) {
    Solution solution = new RepeatedDNASequences().new Solution();
    String[] data = """
          "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
      "AAAAAAAAAAAAA"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.findRepeatedDnaSequences((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
      for (int i = 0; i < s.length() - 9; i++) {
        String tmp = s.substring(i, i + 10);
        if (!seen.add(tmp)) {
          repeated.add(tmp);
        }
      }
      return new ArrayList<>(repeated);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
