package edu.neu.algo.monotonic.leetcode.editor.en._20221019;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class LinkedListCycleII {
  // 142
  // Given the head of a linked list, return the node where the cycle begins. If
  // there is no cycle, return null.
  //
  // There is a cycle in a linked list if there is some node in the list that can
  // be reached again by continuously following the next pointer. Internally, pos is
  // used to denote the index of the node that tail's next pointer is connected to (0
  // -indexed). It is -1 if there is no cycle. Note that pos is not passed as a
  // parameter.
  //
  // Do not modify the linked list.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [3,2,0,-4], pos = 1
  // Output: tail connects to node index 1
  // Explanation: There is a cycle in the linked list, where tail connects to the
  // second node.
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1,2], pos = 0
  // Output: tail connects to node index 0
  // Explanation: There is a cycle in the linked list, where tail connects to the
  // first node.
  //
  //
  // Example 3:
  //
  //
  // Input: head = [1], pos = -1
  // Output: no cycle
  // Explanation: There is no cycle in the linked list.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of the nodes in the list is in the range [0, 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  // pos is -1 or a valid index in the linked-list.
  //
  //
  //
  // Follow up: Can you solve it using O(1) (i.e. constant) memory?
  // Related Topics Hash Table Linked List Two Pointers 👍 9233 👎 641

  public static void main(String[] args) {
    Solution solution = new LinkedListCycleII().new Solution();
    String[] data = """
          [3,2,0,-4]
      1
      [1,2]
      0
      [1]
      -1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.detectCycle((ListNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val = x; next = null;
   * } }
   */
  public class Solution {
    public ListNode detectCycle(ListNode head) {
      ListNode fast = head, slow = head;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
          slow = head;
          while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
          }
          return slow;
        }
      }
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
