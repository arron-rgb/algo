package edu.neu.algo.review.leetcode.editor.en._20230216;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class RemoveDuplicatesFromSortedList {
  // 83
  // Given the head of a sorted linked list, delete all duplicates such that each
  // element appears only once. Return the linked list sorted as well.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [1,1,2]
  // Output: [1,2]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [1,1,2,3,3]
  // Output: [1,2,3]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is in the range [0, 300].
  // -100 <= Node.val <= 100
  // The list is guaranteed to be sorted in ascending order.
  //
  //
  // Related Topics Linked List 👍 6777 👎 238

  public static void main(String[] args) {
    Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    String[] data = """
                  [1,1,2]
      [1,1,2,3,3]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.deleteDuplicates((ListNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode index = head;
      while (index != null) {
        if (index.next == null) {
          break;
        }
        if (index.val == index.next.val) {
          index.next = index.next.next;
        } else {
          index = index.next;
        }
      }
      return head;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
