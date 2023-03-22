package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class MergeTwoSortedLists {
  // 21
  // You are given the heads of two sorted linked lists list1 and list2.
  //
  // Merge the two lists in a one sorted list. The list should be made by
  // splicing together the nodes of the first two lists.
  //
  // Return the head of the merged linked list.
  //
  //
  // Example 1:
  //
  //
  // Input: list1 = [1,2,4], list2 = [1,3,4]
  // Output: [1,1,2,3,4,4]
  //
  //
  // Example 2:
  //
  //
  // Input: list1 = [], list2 = []
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: list1 = [], list2 = [0]
  // Output: [0]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in both lists is in the range [0, 50].
  // -100 <= Node.val <= 100
  // Both list1 and list2 are sorted in non-decreasing order.
  //
  // Related Topics Linked List Recursion 👍 13675 👎 1235

  public static void main(String[] args) {

    Solution solution = new MergeTwoSortedLists().new Solution();
    String[] data = """
          [1,2,4]
      [1,3,4]
      []
      []
      []
      [0]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.mergeTwoLists((ListNode)params[1 + i * paramTypes.length - 1],
        (ListNode)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      } else if (l2 == null) {
        return l1;
      }
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          curr.next = l1;
          l1 = l1.next;
        } else {
          curr.next = l2;
          l2 = l2.next;
        }
        curr = curr.next;
      }
      curr.next = l1 == null ? l2 : l1;
      return dummy.next;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class RecursiveSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
      }
    }
  }
}
