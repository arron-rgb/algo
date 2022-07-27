package edu.neu.algo.monotonic.leetcode.editor.en._20220726;

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
  // Related Topics Array String Backtracking Bit Manipulation 👍 1908 👎 159

  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
    String[] data = """
          ["un","iq","ue"]
      ["cha","r","act","ers"]
      ["abcdefghijklmnopqrstuvwxyz"]
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

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxLength(List<String> arr) {
      return dfs(arr, 0, 0);
    }

    // [index ...]自由选择，可获得最大的可行解长度是多少？
    // bitmap 第 i 位表示：‘a’+i 字符是否选择过
    private static int dfs(List<String> arr, int index, int bitmap) {
      if (index == arr.size()) {
        return 0;
      }

      // 1）选择不要arr[index]：
      int p1 = dfs(arr, index + 1, bitmap);

      // 2）选择要arr[index]，是有条件的：
      String str = arr.get(index);
      int p2 = 0;
      boolean can = true; // 能否要arr[index] ?
      for (char c : str.toCharArray()) {
        if ((bitmap & (1 << (c - 'a'))) != 0) { // 当前已有这个字符了
          can = false; // 不能要arr[index]了
          break;
        } else { // 将当前字符标记到位图上
          bitmap |= (1 << (c - 'a'));
        }
      }
      if (can) { // 如果可以要arr[index]，计算长度
        p2 = str.length() + dfs(arr, index + 1, bitmap);
      }

      return Math.max(p1, p2);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
