package edu.neu.algo.leetcode.editor.en._20220504;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

  // Given a string containing digits from 2-9 inclusive, return all possible
  // letter combinations that the number could represent. Return the answer in any order.
  //
  //
  // A mapping of digit to letters (just like on the telephone buttons) is given
  // below. Note that 1 does not map to any letters.
  //
  //
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
  // Related Topics Hash Table String Backtracking 👍 9731 👎 671

  public static void main(String[] args) {
    Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    List<String> strings = solution.letterCombinations("23");
    strings.forEach(System.out::println);
    strings = solution.letterCombinations("2");
    strings = solution.letterCombinations("");
    strings.forEach(System.out::println);
  }

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
    List<String> res;

    public List<String> letterCombinations(String digits) {
      if (digits.isEmpty()) {
        return new ArrayList<>();
      }
      res = new ArrayList<>();
      dfs(digits, 0, new StringBuilder());
      return res;
    }

    void dfs(String digits, int index, StringBuilder tmp) {
      if (index == digits.length()) {
        res.add(tmp.toString());
        return;
      }
      char c = digits.charAt(index);
      for (Character character : map.get(c)) {
        tmp.append(character);
        dfs(digits, index + 1, tmp);
        tmp.deleteCharAt(tmp.length() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
