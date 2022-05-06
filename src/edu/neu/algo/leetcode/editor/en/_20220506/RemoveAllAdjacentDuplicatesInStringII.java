package edu.neu.algo.leetcode.editor.en._20220506;

public class RemoveAllAdjacentDuplicatesInStringII {

  // You are given a string s and an integer k, a k duplicate removal consists of
  // choosing k adjacent and equal letters from s and removing them, causing the left
  // and the right side of the deleted substring to concatenate together.
  //
  // We repeatedly make k duplicate removals on s until we no longer can.
  //
  // Return the final string after all such duplicate removals have been made. It
  // is guaranteed that the answer is unique.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abcd", k = 2
  // Output: "abcd"
  // Explanation: There's nothing to delete.
  //
  // Example 2:
  //
  //
  // Input: s = "deeedbbcccbdaa", k = 3
  // Output: "aa"
  // Explanation:
  // First delete "eee" and "ccc", get "ddbbbdaa"
  // Then delete "bbb", get "dddaa"
  // Finally delete "ddd", get "aa"
  //
  // Example 3:
  //
  //
  // Input: s = "pbbcggttciiippooaais", k = 2
  // Output: "ps"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // 2 <= k <= 10⁴
  // s only contains lower case English letters.
  //
  // Related Topics String Stack 👍 3334 👎 64

  public static void main(String[] args) {
    Solution solution = new RemoveAllAdjacentDuplicatesInStringII().new Solution();
    String deeedbbcccbdaa = solution.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4);
    System.out.println(deeedbbcccbdaa);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String removeDuplicates(String s, int k) {
      char pre = s.charAt(0);
      int count = 1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(pre);
      for (int i = 1; i < s.length(); i++) {
        if (pre == s.charAt(i)) {
          count++;
          if (count == k) {
            // don't add the char
            int len = stringBuilder.length();
            stringBuilder.delete(len - k + 1, len);
            len = stringBuilder.length();
            pre = len > 0 ? stringBuilder.charAt(len - 1) : '0';
            // check the former character
            count = 1;
            for (int j = len - 2; j >= 0; j--) {
              if (stringBuilder.charAt(j) == pre) {
                count++;
              } else {
                break;
              }
            }
            continue;
          }
        } else {
          count = 1;
          pre = s.charAt(i);
        }
        stringBuilder.append(s.charAt(i));
      }
      return stringBuilder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
