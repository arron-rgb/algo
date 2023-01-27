package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class RotateList {
  // 61
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
  //
  // Related Topics Linked List Two Pointers 👍 7107 👎 1336

  public static void main(String[] args) {
    Solution solution = new RotateList().new Solution();
    String[] data = """
                  [1,2,3,4,5]
      2
      [0,1,2]
      4
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.rotateRight((ListNode)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */

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

  // runtime:0 ms
  // memory:41.8 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
