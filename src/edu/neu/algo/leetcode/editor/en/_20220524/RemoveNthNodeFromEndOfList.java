package edu.neu.algo.leetcode.editor.en._20220524;

import edu.neu.base.ListNode;

public class RemoveNthNodeFromEndOfList {

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
  // Related Topics Linked List Two Pointers 👍 10052 👎 479

  public static void main(String[] args) {
    Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode fast = head;
      while (fast.next != null && --n > 0) {
        fast = fast.next;
      }
      ListNode slow = dummy;
      while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
      }

      slow.next = slow.next.next;
      return dummy.next;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
