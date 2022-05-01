package edu.neu.algo.leetcode.editor.en._20220407;

import edu.neu.base.ListNode;

public class RotateList {

  // Given the head of a linked list, rotate the list to the right by k places.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5], k = 2
  // Output: [4,5,1,2,3]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [0,1,2], k = 4
  // Output: [2,0,1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is in the range [0, 500].
  // -100 <= Node.val <= 100
  // 0 <= k <= 2 * 10⁹
  //
  // Related Topics Linked List Two Pointers 👍 4928 👎 1265

  public static void main(String[] args) {}

  // public ListNode rotateRight(ListNode head, int k) {
  // if (head == null || head.next == null) {
  // return head;
  // }
  // ListNode dummy = new ListNode(0);
  // dummy.next = head;
  // ListNode slow = dummy, fast = dummy;
  // int count = 0;
  // while (fast.next != null) {
  // count++;
  // fast = fast.next;
  // }
  // int steps = count - k % count;
  // while (steps > 0) {
  // fast = fast.next;
  // steps--;
  // }
  // while (fast.next != null) {
  // slow = slow.next;
  // fast = fast.next;
  // }
  // fast.next = dummy.next;
  // dummy.next = slow.next;
  // slow.next = null;
  // return dummy.next;
  // }
  // }

  // leetcode submit region begin(Prohibit modification and deletion)

  class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if (head == null) {
        return null;
      }
      ListNode fast = head;
      ListNode slow = head;
      int len = 1;
      while (fast.next != null) {
        fast = fast.next;
        len++;
      }
      fast.next = head;
      k = k % len;
      for (int i = 0; i < len - k - 1; i++) {
        slow = slow.next;
      }
      ListNode newHead = slow.next;
      slow.next = null;
      return newHead;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
