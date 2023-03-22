package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MergeInBetweenLinkedLists {
  // 1669
  // You are given two linked lists: list1 and list2 of sizes n and m respectively.
  //
  //
  // Remove list1's nodes from the aᵗʰ node to the bᵗʰ node, and put list2 in
  // their place.
  //
  // The blue edges and nodes in the following figure indicate the result:
  //
  // Build the result list and return its head.
  //
  //
  // Example 1:
  //
  //
  // Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
  // Output: [0,1,2,1000000,1000001,1000002,5]
  // Explanation: We remove the nodes 3 and 4 and put the entire list2 in their
  // place. The blue edges and nodes in the above figure indicate the result.
  //
  //
  // Example 2:
  //
  //
  // Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002
  // ,1000003,1000004]
  // Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
  // Explanation: The blue edges and nodes in the above figure indicate the result.
  //
  //
  //
  //
  // Constraints:
  //
  //
  // 3 <= list1.length <= 10⁴
  // 1 <= a <= b < list1.length - 1
  // 1 <= list2.length <= 10⁴
  //
  //
  // Related Topics Linked List 👍 1211 👎 156

  public static void main(String[] args) {
    Solution solution = new MergeInBetweenLinkedLists().new Solution();
    String[] data = """
                  [0,1,2,3,4,5]
      3
      4
      [1000000,1000001,1000002]
      [0,1,2,3,4,5,6]
      2
      5
      [1000000,1000001,1000002,1000003,1000004]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int, int, ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.mergeInBetween((ListNode)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length],
        (ListNode)params[4 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
      ListNode n1 = list1;
      for (int i = 0; i < a - 1; i++) {
        n1 = n1.next;
      }
      ListNode n2 = list1;
      for (int i = 0; i < b; i++) {
        n2 = n2.next;
      }
      ListNode tail = list2;
      while (tail.next != null) {
        tail = tail.next;
      }
      n1.next = list2;
      tail.next = n2.next;
      return list1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast == null) {
      return null;
    }
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

}
