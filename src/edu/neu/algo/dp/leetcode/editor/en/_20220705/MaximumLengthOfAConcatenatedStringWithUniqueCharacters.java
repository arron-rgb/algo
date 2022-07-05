package edu.neu.algo.dp.leetcode.editor.en._20220705;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.neu.util.InputUtil;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
  // 1239
  // You are given an array of strings arr. A string s is formed by the
  // concatenation of a subsequence of arr that has unique characters.
  //
  // Return the maximum possible length of s.
  //
  // A subsequence is an array that can be derived from another array by deleting
  // some or no elements without changing the order of the remaining elements.
  //
  //
  // Example 1:
  //
  //
  // Input: arr = ["un","iq","ue"]
  // Output: 4
  // Explanation: All the valid concatenations are:
  // - ""
  // - "un"
  // - "iq"
  // - "ue"
  // - "uniq" ("un" + "iq")
  // - "ique" ("iq" + "ue")
  // Maximum length is 4.
  //
  //
  // Example 2:
  //
  //
  // Input: arr = ["cha","r","act","ers"]
  // Output: 6
  // Explanation: Possible longest valid concatenations are "chaers" ("cha" +
  // "ers") and "acters" ("act" + "ers").
  //
  //
  // Example 3:
  //
  //
  // Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
  // Output: 26
  // Explanation: The only string in arr has all 26 characters.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= arr.length <= 16
  // 1 <= arr[i].length <= 26
  // arr[i] contains only lowercase English letters.
  //
  // Related Topics Array String Backtracking Bit Manipulation 👍 1839 👎 159

  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
    String[] data = """
          ["un","iq","ue"]
      ["cha","r","act","ers"]
      ["abcdefghijklmnopqrstuvwxyz"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[list<String>]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxLength((List<String>)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int max = 0;

    public int maxLength(List<String> arr) {
      dfs(0, arr, "");
      return max;
    }

    public void dfs(int index, List<String> arr, String str) {
      if (!validate(str)) {
        return;
      }
      if (str.length() > max) {
        max = str.length();
      }
      for (int i = index; i < arr.size(); i++) {
        dfs(i + 1, arr, str + arr.get(i));
      }
    }

    boolean validate(String s) {
      Set<Character> set = new HashSet<>();

      for (char ch : s.toCharArray()) {
        if (set.contains(ch)) {
          return false;
        }
        set.add(ch);
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
