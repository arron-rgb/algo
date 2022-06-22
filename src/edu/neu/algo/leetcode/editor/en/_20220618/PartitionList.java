package edu.neu.algo.leetcode.editor.en._20220618;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class PartitionList {

  // Given the head of a linked list and a value x, partition it such that all
  // nodes less than x come before nodes greater than or equal to x.
  //
  // You should preserve the original relative order of the nodes in each of the
  // two partitions.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,4,3,2,5,2], x = 3
  // Output: [1,2,2,4,3,5]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [2,1], x = 2
  // Output: [1,2]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is in the range [0, 200].
  // -100 <= Node.val <= 100
  // -200 <= x <= 200
  //
  // Related Topics Linked List Two Pointers 👍 3564 👎 495

  public static void main(String[] args) {
    Solution solution = new PartitionList().new Solution();
    String[] data = """
          [1,4,3,2,5,2,2]
      3
      [2,1]
      2""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q =
        solution.partition((ListNode)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
      q.print();
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    ListNode partition(ListNode head, int x) {
      ListNode dummy1 = new ListNode(-1);
      ListNode dummy2 = new ListNode(-1);
      ListNode smaller = dummy1, bigger = dummy2;
      ListNode index = head;
      while (index != null) {
        if (index.val >= x) {
          bigger.next = index;
          bigger = bigger.next;
        } else {
          smaller.next = index;
          smaller = smaller.next;
        }
        index = index.next;
      }
      bigger.next = null;
      smaller.next = dummy2.next;

      return dummy1.next;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
