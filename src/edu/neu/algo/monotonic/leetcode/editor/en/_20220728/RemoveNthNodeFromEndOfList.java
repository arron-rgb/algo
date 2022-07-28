package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class RemoveNthNodeFromEndOfList {
  // 19
  // Given the head of a linked list, remove the nᵗʰ node from the end of the list
  // and return its head.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5], n = 2
  // Output: [1,2,3,5]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1], n = 1
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: head = [1,2], n = 1
  // Output: [1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is sz.
  // 1 <= sz <= 30
  // 0 <= Node.val <= 100
  // 1 <= n <= sz
  //
  //
  //
  // Follow up: Could you do this in one pass?
  // Related Topics Linked List Two Pointers 👍 11402 👎 519

  public static void main(String[] args) {
    Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    String[] data = """
          [1,2,3,4,5]
      2
      [1]
      1
      [1,2]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.removeNthFromEnd((ListNode)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    // todo
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode fast = dummy, slow = dummy;
      while (n-- >= 0) {
        fast = fast.next;
      }
      while (fast != null) {
        fast = fast.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;
      return dummy.next;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
