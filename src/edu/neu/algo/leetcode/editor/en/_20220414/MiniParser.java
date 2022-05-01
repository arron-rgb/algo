package edu.neu.algo.leetcode.editor.en._20220414;

import java.util.List;

public class MiniParser {

  // Given a string s represents the serialization of a nested list, implement a
  // parser to deserialize it and return the deserialized NestedInteger.
  //
  // Each element is either an integer or a list whose elements may also be
  // integers or other lists.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "324"
  // Output: 324
  // Explanation: You should return a NestedInteger object which contains a single
  // integer 324.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "[123,[456,[789]]]"
  // Output: [123,[456,[789]]]
  // Explanation: Return a NestedInteger object containing a nested list with 2
  // elements:
  // 1. An integer containing value 123.
  // 2. A nested list containing two elements:
  // i. An integer containing value 456.
  // ii. A nested list with one element:
  // a. An integer containing value 789
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 5 * 10⁴
  // s consists of digits, square brackets "[]", negative sign '-', and commas ',
  // '.
  // s is the serialization of valid NestedInteger.
  // All the values in the input are in the range [-10⁶, 10⁶].
  //
  // Related Topics String Stack Depth-First Search 👍 359 👎 1122

  public static void main(String[] args) {

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * // This is the interface that allows for creating nested lists. // You should not implement it, or speculate about
   * its implementation public interface NestedInteger { // Constructor initializes an empty nested list. public
   * NestedInteger();
   *
   * // Constructor initializes a single integer. public NestedInteger(int value);
   *
   * // @return true if this NestedInteger holds a single integer, rather than a nested list. public boolean
   * isInteger();
   *
   * // @return the single integer that this NestedInteger holds, if it holds a single integer // Return null if this
   * NestedInteger holds a nested list public Integer getInteger();
   *
   * // Set this NestedInteger to hold a single integer. public void setInteger(int value);
   *
   * // Set this NestedInteger to hold a nested list and adds a nested integer to it. public void add(NestedInteger ni);
   *
   * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return empty list if this
   * NestedInteger holds a single integer public List<NestedInteger> getList(); }
   */
  class Solution {
    int index = 0;

    public NestedInteger deserialize(String s) {
      if (s.charAt(index) == '[') {
        index++;
        NestedInteger root = new NestedInteger();
        while (s.charAt(index) != ']') {
          root.add(deserialize(s));
          if (s.charAt(index) == ',') {
            index++;
          }
        }
        index++;
        return root;
      } else {
        boolean negative = false;
        if (s.charAt(index) == '-') {
          index++;
          negative = true;
        }
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
          num = num * 10 + (s.charAt(index) - '0');
          index++;
        }
        if (negative) {
          num = -num;
        }
        return new NestedInteger(num);
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class NestedInteger {
    public NestedInteger() {}

    public NestedInteger(int value) {}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
      return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      return null;
    }
  }
}
