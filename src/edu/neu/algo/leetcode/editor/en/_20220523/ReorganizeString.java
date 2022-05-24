package edu.neu.algo.leetcode.editor.en._20220523;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {

  // Given a string s, rearrange the characters of s so that any two adjacent
  // characters are not the same.
  //
  // Return any possible rearrangement of s or return "" if not possible.
  //
  //
  // Example 1:
  // Input: s = "aab"
  // Output: "aba"
  // Example 2:
  // Input: s = "aaab"
  // Output: ""
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 500
  // s consists of lowercase English letters.
  //
  // Related Topics Hash Table String Greedy Sorting Heap (Priority Queue)
  // Counting 👍 4680 👎 177

  public static void main(String[] args) {
    Solution solution = new ReorganizeString().new Solution();
    String aab = solution.reorganizeString("aab");
    System.out.println(aab);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reorganizeString(String s) {
      char[] chars = s.toCharArray();
      int[] count = new int[26];
      int max = -1;
      for (char tmp : chars) {
        count[tmp - 'a']++;
        max = Math.max(max, count[tmp - 'a']);
      }
      if (max > (s.length() + 1) / 2) {
        return "";
      }
      StringBuilder stringBuilder = new StringBuilder();
      PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> -o[1]));
      for (int i = 0; i < count.length; i++) {
        if (count[i] != 0) {
          queue.add(new int[] {i + 'a', count[i]});
        }
      }
      while (!queue.isEmpty()) {
        int[] first = queue.poll();
        if (stringBuilder.isEmpty() || stringBuilder.charAt(stringBuilder.length() - 1) != (char)first[0]) {
          stringBuilder.append((char)first[0]);
          first[1]--;
          if (first[1] > 0) {
            queue.add(first);
          }
        } else {
          int[] second = queue.poll();
          if (second == null) {
            return "";
          }
          stringBuilder.append((char)second[0]);
          second[1]--;
          if (second[1] > 0) {
            queue.add(second);
          }
          queue.add(first);
        }
      }
      return stringBuilder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
