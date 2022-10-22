package edu.neu.algo.monotonic.leetcode.editor.en._20221019;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class OddEvenLinkedList {
  // 328
  // Given the head of a singly linked list, group all the nodes with odd indices
  // together followed by the nodes with even indices, and return the reordered list.
  //
  //
  // The first node is considered odd, and the second node is even, and so on.
  //
  // Note that the relative order inside both the even and odd groups should
  // remain as it was in the input.
  //
  // You must solve the problem in O(1) extra space complexity and O(n) time
  // complexity.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5]
  // Output: [1,3,5,2,4]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [2,1,3,5,6,4,7]
  // Output: [2,3,6,7,1,5,4]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the linked list is in the range [0, 10⁴].
  // -10⁶ <= Node.val <= 10⁶
  //
  // Related Topics Linked List 👍 6330 👎 399

  public static void main(String[] args) {
    Solution solution = new OddEvenLinkedList().new Solution();
    String[] data = """
          [1,2,3,4,5]
      [2,1,3,5,6,4,7]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.oddEvenList((ListNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode oddEvenList(ListNode head) {
      if (head == null) {
        return null;
      }
      ListNode odd = head;
      ListNode even = head.next;
      ListNode evenHead = head.next;
      // `even != null` rules out the list of only 1 node
      // `even.next != null` rules out the list of only 2 nodes
      while (even != null && even.next != null) {
        // Put odd to the odd list
        odd.next = odd.next.next;
        // Put even to the even list
        even.next = even.next.next;
        // Move the pointer to the next odd/even
        odd = odd.next;
        even = even.next;
      }
      odd.next = evenHead;
      return head;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
