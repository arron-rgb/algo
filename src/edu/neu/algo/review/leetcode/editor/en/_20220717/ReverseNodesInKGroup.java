package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;

import edu.neu.base.*;
import edu.neu.util.InputUtil;

public class ReverseNodesInKGroup {
  // 25
  // Given the head of a linked list, reverse the nodes of the list k at a time,
  // and return the modified list.
  //
  // k is a positive integer and is less than or equal to the length of the
  // linked list. If the number of nodes is not a multiple of k then left-out nodes, in
  // the end, should remain as it is.
  //
  // You may not alter the values in the list's nodes, only nodes themselves may
  // be changed.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5], k = 2
  // Output: [2,1,4,3,5]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1,2,3,4,5], k = 3
  // Output: [3,2,1,4,5]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is n.
  // 1 <= k <= n <= 5000
  // 0 <= Node.val <= 1000
  //
  //
  //
  // Follow-up: Can you solve the problem in O(1) extra memory space?
  // Related Topics Linked List Recursion 👍 8060 👎 513

  public static void main(String[] args) {
    Solution solution = new ReverseNodesInKGroup().new Solution();
    String[] data = """
          [1,2,3,4,5]
      2
      [1,2,3,4,5]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.reverseKGroup((ListNode)params[1 + i * paramTypes.length - 1],
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
    public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode tail = head;
      for (int i = 0; i < k; i++) {
        // 剩余数量小于k的话，则不需要反转。
        if (tail == null) {
          return head;
        }
        tail = tail.next;
      }
      // 反转前 k 个元素
      ListNode newHead = reverse(head, tail);
      // 下一轮的开始的地方就是tail
      head.next = reverseKGroup(tail, k);

      return newHead;
    }

    /*
    左闭又开区间
     */
    private ListNode reverse(ListNode head, ListNode tail) {
      ListNode pre = null;
      ListNode next = null;
      while (head != tail) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
      }
      return pre;

    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
