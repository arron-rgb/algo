package edu.neu.algo.leetcode.editor.en._20220426;

import edu.neu.base.ListNode;

public class SwapNodesInPairs {

  // Given a linked list, swap every two adjacent nodes and return its head. You
  // must solve the problem without modifying the values in the list's nodes (i.e.,
  // only nodes themselves may be changed.)
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4]
  // Output: [2,1,4,3]
  //
  //
  // Example 2:
  //
  //
  // Input: head = []
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: head = [1]
  // Output: [1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is in the range [0, 100].
  // 0 <= Node.val <= 100
  //
  // Related Topics Linked List Recursion 👍 6821 👎 293

  public static void main(String[] args) {
    Solution solution = new SwapNodesInPairs().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode cur = head;
      ListNode newHead = head.next;
      while (cur != null && cur.next != null) {
        ListNode tmp = cur;
        cur = cur.next;
        tmp.next = cur.next;
        cur.next = tmp;
        cur = tmp.next;
        if (cur != null && cur.next != null) {
          tmp.next = cur.next;
        }
      }
      return newHead;
    }
    // public ListNode swapPairs(ListNode head) {
    // if (head == null || head.next == null) {
    // return head;
    // }
    // ListNode tmp = head.next;
    // head.next = swapPairs(head.next.next);
    // tmp.next = head;
    // return tmp;

    // }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
