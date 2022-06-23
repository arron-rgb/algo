package edu.neu.algo.leetcode.editor.en._20220622;

import edu.neu.util.InputUtil;

public class ReverseString {

  // Write a function that reverses a string. The input string is given as an
  // array of characters s.
  //
  // You must do this by modifying the input array in-place with O(1) extra
  // memory.
  //
  //
  // Example 1:
  // Input: s = ["h","e","l","l","o"]
  // Output: ["o","l","l","e","h"]
  // Example 2:
  // Input: s = ["H","a","n","n","a","h"]
  // Output: ["h","a","n","n","a","H"]
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s[i] is a printable ascii character.
  //
  // Related Topics Two Pointers String Recursion 👍 5282 👎 958

  public static void main(String[] args) {
    Solution solution = new ReverseString().new Solution();
    String[] data = """
          ["h","e","l","l","o"]
      ["H","a","n","n","a","h"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[char[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.reverseString((char[])params[1 - 1 + i * paramTypes.length]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void reverseString(char[] s) {
      int left = 0, right = s.length - 1;
      while (left < right) {
        swap(left, right, s);
        left++;
        right--;
      }
    }

    void swap(int left, int right, char[] s) {
      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
