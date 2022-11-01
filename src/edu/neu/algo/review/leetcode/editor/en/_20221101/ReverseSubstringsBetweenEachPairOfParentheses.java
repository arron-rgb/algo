package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReverseSubstringsBetweenEachPairOfParentheses {
  // 1190
  // You are given a string s that consists of lower case English letters and
  // brackets.
  //
  // Reverse the strings in each pair of matching parentheses, starting from the
  // innermost one.
  //
  // Your result should not contain any brackets.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "(abcd)"
  // Output: "dcba"
  //
  //
  // Example 2:
  //
  //
  // Input: s = "(u(love)i)"
  // Output: "iloveu"
  // Explanation: The substring "love" is reversed first, then the whole string is
  // reversed.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "(ed(et(oc))el)"
  // Output: "leetcode"
  // Explanation: First, we reverse the substring "oc", then "etco", and finally,
  // the whole string.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 2000
  // s only contains lower case English characters and parentheses.
  // It is guaranteed that all parentheses are balanced.
  //
  // Related Topics String Stack 👍 1507 👎 40

  public static void main(String[] args) {
    Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    String[] data = """
      "(ed(et(oc))el)"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseParentheses((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
    // Wrong Answer: input: Output:"sxmdllxikeq" Expected:"sxmdllqekix"
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseParentheses(String s) {
      // int lastLeftParentheses = s.lastIndexOf("(");
      // if (lastLeftParentheses == -1) {
      // return s;
      // }
      // int firstRightParentheses = lastLeftParentheses + 1;
      // while (firstRightParentheses < s.length() && s.charAt(firstRightParentheses) != ')') {
      // firstRightParentheses++;
      // }
      // char[] ss = s.toCharArray();
      // int left = lastLeftParentheses + 1;
      // int right = firstRightParentheses - 1;
      // while (left < right) {
      // char tmp = ss[left];
      // ss[left] = ss[right];
      // ss[right] = tmp;
      // left++;
      // right--;
      // }
      // ss[lastLeftParentheses] = ' ';
      // ss[firstRightParentheses] = ' ';
      // String s1 = new String(ss).replaceAll(" ", "");
      // return reverseParentheses(s1);
      return stackSolution(s);
    }

    private String stackSolution(String s) {
      // 负责外层的括号的翻转
      // 当进入内层括号时，先把外层的缓冲至stack里
      Deque<String> deque = new ArrayDeque<>();
      StringBuilder stringBuilder = new StringBuilder();
      int n = s.length();
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) == '(') {
          deque.push(stringBuilder.toString());
          stringBuilder.setLength(0);

//          System.out.println("StringBuilder: " + stringBuilder);
//          System.out.println("Deque: " + deque);
        } else if (s.charAt(i) == ')') {
          // 到了某层
          // 先翻转
          // 再把他外面一层的东西加到头部
          // 为什么是先翻转再加到头部
          // 加到头部: 在stack里的本身就在他前面
          // 翻转：完整括号要翻转
          stringBuilder.reverse();
          stringBuilder.insert(0, deque.pop());

//          System.out.println("StringBuilder: " + stringBuilder);
//          System.out.println("Deque: " + deque);
        } else {
          stringBuilder.append(s.charAt(i));
        }

      }
      return stringBuilder.toString();
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
