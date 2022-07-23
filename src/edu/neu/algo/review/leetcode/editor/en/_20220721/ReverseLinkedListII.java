package edu.neu.algo.review.leetcode.editor.en._20220721;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class ReverseLinkedListII {
  // 92
  // Given the head of a singly linked list and two integers left and right where
  // left <= right, reverse the nodes of the list from position left to position
  // right, and return the reversed list.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,2,3,4,5], left = 2, right = 4
  // Output: [1,4,3,2,5]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [5], left = 1, right = 1
  // Output: [5]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is n.
  // 1 <= n <= 500
  // -500 <= Node.val <= 500
  // 1 <= left <= right <= n
  //
  //
  //
  // Follow up: Could you do it in one pass? Related Topics Linked List 👍 6939 👎
  // 313

  public static void main(String[] args) {
    Solution solution = new ReverseLinkedListII().new Solution();
    String[] data = """
          [1,2,3,4,5]
      2
      4
      [5]
      1
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.reverseBetween((ListNode)params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1], (int)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

      // Empty list
      if (head == null) {
        return null;
      }

      // Move the two pointers until they reach the proper starting point
      // in the list.
      ListNode cur = head, prev = null;
      while (m > 1) {
        prev = cur;
        cur = cur.next;
        m--;
        n--;
      }

      // The two pointers that will fix the final connections.
      ListNode con = prev, tail = cur;

      // Iteratively reverse the nodes until n becomes 0.
      ListNode third = null;
      while (n > 0) {
        third = cur.next;
        cur.next = prev;
        prev = cur;
        cur = third;
        n--;
      }

      // Adjust the final connections as explained in the algorithm
      if (con != null) {
        con.next = prev;
      } else {
        head = prev;
      }

      tail.next = cur;
      return head;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
