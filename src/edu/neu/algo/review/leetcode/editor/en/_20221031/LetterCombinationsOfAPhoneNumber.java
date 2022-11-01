package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;
import edu.neu.util.InputUtil;

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
  // Related Topics Hash Table String Backtracking 👍 13054 👎 772

  public static void main(String[] args) {
    Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    String[] data = """
      "23"
      "2"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.letterCombinations((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    Map<Character, List<Character>> map = new HashMap<>() {
      {
        put('2', Arrays.asList('a', 'b', 'c'));
        put('3', Arrays.asList('d', 'e', 'f'));
        put('4', Arrays.asList('g', 'h', 'i'));
        put('5', Arrays.asList('j', 'k', 'l'));
        put('6', Arrays.asList('m', 'n', 'o'));
        put('7', Arrays.asList('p', 'q', 'r', 's'));
        put('8', Arrays.asList('t', 'u', 'v'));
        put('9', Arrays.asList('w', 'x', 'y', 'z'));
      }
    };

    public List<String> letterCombinations(String digits) {
      if (digits.isEmpty()) {
        return new ArrayList<>();
      }
      List<String> res = new ArrayList<>();
      dfs(res, digits, 0, "");
      return res;
    }

    void dfs(List<String> dfs, String digits, int i, String s) {
      if (i >= digits.length()) {
        dfs.add(s);
        return;
      }
      List<Character> list = map.get(digits.charAt(i));
      for (char c : list) {
        dfs(dfs, digits, i + 1, s + c);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
