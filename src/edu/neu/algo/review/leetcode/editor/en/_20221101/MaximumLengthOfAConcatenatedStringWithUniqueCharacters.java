package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
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
  // Related Topics Array String Backtracking Bit Manipulation 👍 3182 👎 224

  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
    String[] data = """
      ["jnfbyktlrqumowxd","mvhgcpxnjzrdei"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[List<string>]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxLength((List<String>)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int max;

    public int maxLength(List<String> arr) {
      // 已每个元素为起点，如果下一个的元素拼接起来没冲突，就加进去，计算长度
      max = 0;
      arr = arr.stream().filter((s) -> {
        int[] count = new int[26];
        for (int i = 0, n = s.length(); i < n; i++) {
          count[s.charAt(i) - 'a']++;
        }
        for (int i : count) {
          if (i > 1) {
            return false;
          }
        }
        return true;
      }).toList();
      dfs(arr, 0, "");
      return max;
    }

    void dfs(List<String> arr, int index, String s) {
      if (index == arr.size()) {
        max = Math.max(max, s.length());
        return;
      }
      for (int i = index; i < arr.size(); i++) {
        if (check(s, arr.get(i))) {
          dfs(arr, i + 1, s + arr.get(i));
        } else {
          dfs(arr, i + 1, s);
        }
      }
    }

    boolean check(String s, String t) {
      for (int i = 0, n = t.length(); i < n; i++) {
        if (s.indexOf(t.charAt(i)) != -1) {
          return false;
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
