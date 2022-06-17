package edu.neu.algo.leetcode.editor.en._20220617;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class AddTwoNumbersII {

  // You are given two non-empty linked lists representing two non-negative
  // integers. The most significant digit comes first and each of their nodes contains a
  // single digit. Add the two numbers and return the sum as a linked list.
  //
  // You may assume the two numbers do not contain any leading zero, except the
  // number 0 itself.
  //
  //
  // Example 1:
  //
  //
  // Input: l1 = [7,2,4,3], l2 = [5,6,4]
  // Output: [7,8,0,7]
  //
  //
  // Example 2:
  //
  //
  // Input: l1 = [2,4,3], l2 = [5,6,4]
  // Output: [8,0,7]
  //
  //
  // Example 3:
  //
  //
  // Input: l1 = [0], l2 = [0]
  // Output: [0]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in each linked list is in the range [1, 100].
  // 0 <= Node.val <= 9
  // It is guaranteed that the list represents a number that does not have
  // leading zeros.
  //
  //
  //
  // Follow up: Could you solve it without reversing the input lists?
  // Related Topics Linked List Math Stack 👍 3600 👎 227

  public static void main(String[] args) {
    Solution solution = new AddTwoNumbersII().new Solution();
    String[] data = """
      [7,2,4,3]
      [5,6,4]""".replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i]);
    }
    // 2
    ListNode r = solution.addTwoNumbers((ListNode)params[0], (ListNode)params[1]);
    r.print();

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode i = l1, j = l2;
      int len1 = 0, len2 = 0;
      while (i != null || j != null) {
        if (i != null) {
          i = i.next;
          len1++;
        }
        if (j != null) {
          j = j.next;
          len2++;
        }
      }
      ListNode reversed = null;
      ListNode bigger = len1 > len2 ? l1 : l2;
      ListNode smaller = len1 > len2 ? l2 : l1;
      for (int k = 0; k < Math.abs(len1 - len2) && bigger != null; k++) {
        // prev = 7
        ListNode prev = new ListNode(bigger.val);
        // 7 -> -1
        prev.next = reversed;
        reversed = prev;
        bigger = bigger.next;
      }
      for (int k = 0; k < Math.min(len1, len2); k++) {
        ListNode prev = new ListNode(bigger.val + smaller.val);
        prev.next = reversed;
        reversed = prev;

        bigger = bigger.next;
        smaller = smaller.next;
      }
      int carry = 0;
      // 7 -> 9 -> 10 -> 7 -> -1
      ListNode index = null;
      while (reversed != null) {
        int val = reversed.val + carry;
        carry = val / 10;
        val %= 10;
        reversed.val = val;

        ListNode prev = reversed.next;
        reversed.next = index;
        index = reversed;
        reversed = prev;
      }
      if (carry != 0) {
        reversed = new ListNode(1);
        reversed.next = index;
        index = reversed;
      }
      return index;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
