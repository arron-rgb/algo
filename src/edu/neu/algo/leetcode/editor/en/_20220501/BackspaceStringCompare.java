package edu.neu.algo.leetcode.editor.en._20220501;

public class BackspaceStringCompare {

  // Given two strings s and t, return true if they are equal when both are typed
  // into empty text editors. '#' means a backspace character.
  //
  // Note that after backspacing an empty text, the text will continue empty.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "ab#c", t = "ad#c"
  // Output: true
  // Explanation: Both s and t become "ac".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "ab##", t = "c#d#"
  // Output: true
  // Explanation: Both s and t become "".
  //
  //
  // Example 3:
  //
  //
  // Input: s = "a#c", t = "b"
  // Output: false
  // Explanation: s becomes "c" while t becomes "b".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length, t.length <= 200
  // s and t only contain lowercase letters and '#' characters.
  //
  //
  //
  // Follow up: Can you solve it in O(n) time and O(1) space?
  // Related Topics Two Pointers String Stack Simulation 👍 4191 👎 194

  public static void main(String[] args) {
    Solution solution = new BackspaceStringCompare().new Solution();
    boolean b = solution.backspaceCompare("a#c", "b");
    System.out.println(b);
    System.out.println(solution.backspaceCompare("ab##", "c#d#"));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean backspaceCompare(String s, String t) {
      StringBuilder deque = new StringBuilder();
      for (char c : s.toCharArray()) {
        if (c == '#' && deque.length() > 0) {
          deque.deleteCharAt(deque.length() - 1);
        } else if (c == '#' && deque.length() == 0) {
        } else {
          deque.append(c);
        }
      }
      StringBuilder d2 = new StringBuilder();
      for (char c : t.toCharArray()) {
        if (c == '#' && d2.length() > 0) {
          d2.deleteCharAt(d2.length() - 1);
        } else if (c == '#' && d2.length() == 0) {
        } else {
          d2.append(c);
        }
      }
      return d2.toString().equals(deque.toString());
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
