package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class ReverseLinkedList {
  // 206
  // Given the head of a singly linked list, reverse the list, and return the
  // reversed list.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5]
  // Output: [5,4,3,2,1]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1,2]
  // Output: [2,1]
  //
  //
  // Example 3:
  //
  //
  // Input: head = []
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is the range [0, 5000].
  // -5000 <= Node.val <= 5000
  //
  //
  //
  // Follow up: A linked list can be reversed either iteratively or recursively.
  // Could you implement both?
  // Related Topics Linked List Recursion 👍 13751 👎 237

  public static void main(String[] args) {
    Solution solution = new ReverseLinkedList().new Solution();
    String[] data = """
          [1,2,3,4,5]
      [1,2]
      []
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.reverseList((ListNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode reverse = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return reverse;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
