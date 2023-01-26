package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class LinkedListCycle {

  // Given head, the head of a linked list, determine if the linked list has a
  // cycle in it.
  //
  // There is a cycle in a linked list if there is some node in the list that can
  // be reached again by continuously following the next pointer. Internally, pos is
  // used to denote the index of the node that tail's next pointer is connected to.
  // Note that pos is not passed as a parameter.
  //
  // Return true if there is a cycle in the linked list. Otherwise, return false.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: head = [3,2,0,-4], pos = 1
  // Output: true
  // Explanation: There is a cycle in the linked list, where the tail connects to
  // the 1st node (0-indexed).
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1,2], pos = 0
  // Output: true
  // Explanation: There is a cycle in the linked list, where the tail connects to
  // the 0th node.
  //
  //
  // Example 3:
  //
  //
  // Input: head = [1], pos = -1
  // Output: false
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
  // Related Topics Hash Table Linked List Two Pointers 👍 10871 👎 922

  public static void main(String[] args) {
    Solution solution = new LinkedListCycle().new Solution();
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
      boolean q = solution.hasCycle((ListNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val = x; next = null;
   * } }
   */
  public class Solution {
    public boolean hasCycle(ListNode head) {
      ListNode fast = head, slow = head;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
          return true;
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  class MyQueue {

    Deque<Integer> deque;
    Deque<Integer> help;

    public MyQueue() {
      deque = new ArrayDeque<>();
      help = new ArrayDeque<>();
    }

    public void push(int x) {
      deque.addLast(x);
    }

    public int pop() {
      if (empty()) {
        return -1;
      }
      toHelp();
      return help.pollLast();
    }

    public int peek() {
      if (empty()) {
        return -1;
      }
      toHelp();
      return help.peekLast();
    }

    void toHelp() {
      if (help.isEmpty()) {
        while (!deque.isEmpty()) {
          help.addLast(deque.pollLast());
        }
      }
    }

    public boolean empty() {
      return deque.isEmpty() && help.isEmpty();
    }
  }

}
