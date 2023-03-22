package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
  // 17
  // Given a string containing digits from 2-9 inclusive, return all possible
  // letter combinations that the number could represent. Return the answer in any order.
  //
  //
  // A mapping of digits to letters (just like on the telephone buttons) is given
  // below. Note that 1 does not map to any letters.
  //
  //
  // Example 1:
  //
  //
  // Input: digits = "23"
  // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
  //
  //
  // Example 2:
  //
  //
  // Input: digits = ""
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: digits = "2"
  // Output: ["a","b","c"]
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= digits.length <= 4
  // digits[i] is a digit in the range ['2', '9'].
  //
  //
  // Related Topics Hash Table String Backtracking 👍 14053 👎 809

  public static void main(String[] args) {
    Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    // String[] data = """
    // 23
    // 2
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[String]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // List<String> q = solution.letterCombinations((String)params[1 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
    System.out.println(solution.letterCombinations("23"));
    System.out.println(solution.letterCombinations("2"));
    System.out.println(solution.letterCombinations(""));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<String> dic = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    List<String> res;

    public List<String> letterCombinations(String digits) {
      if (digits.length() == 0) {
        return List.of();
      }
      char[] tmp = new char[digits.length()];
      res = new ArrayList<>();
      // O(n*4^n)
      dfs(0, tmp, digits);
      return res;
    }

    void dfs(int i, char[] tmp, String digits) {
      if (i == digits.length()) {
        res.add(new String(tmp));
        return;
      }
      int t = digits.charAt(i) - '0';
      // 4
      for (char c : dic.get(t).toCharArray()) {
        tmp[i] = c;
        dfs(i + 1, tmp, digits);
      }
      // dic.get(t).chars().forEach(c -> {
      // tmp[i] = (char)c;
      // dfs(i + 1, tmp, digits);
      // });
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
