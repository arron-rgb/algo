package edu.neu.algo.leetcode.editor.en._20220619;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class SortLinkedListAlreadySortedUsingAbsoluteValues {

  // null Related Topics Linked List Two Pointers Sorting 👍 78 👎 0

  public static void main(String[] args) {
    Solution solution = new SortLinkedListAlreadySortedUsingAbsoluteValues().new Solution();
    String[] data = """
          [0,2,-5,5,10,-10]
      [0,1,2]
      [1]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.sortLinkedList((ListNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  class Solution {
    public ListNode sortLinkedList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode pre = head, cur = head.next;
      while (cur != null) {
        // cur为非负数时则两个指针向后移动；
        if (cur.val >= 0) {
          pre = pre.next;
          cur = pre.next;
        }
        // 将cur为负数的节点全部插入头部之前
        if (cur != null && cur.val < 0) {
          pre.next = cur.next;
          cur.next = head;
          head = cur;
          cur = pre.next;
        }
      }
      return head;
    }
  }

}
