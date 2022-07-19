package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class MergeKSortedLists {
  // 23
  // You are given an array of k linked-lists lists, each linked-list is sorted in
  // ascending order.
  //
  // Merge all the linked-lists into one sorted linked-list and return it.
  //
  //
  // Example 1:
  //
  //
  // Input: lists = [[1,4,5],[1,3,4],[2,6]]
  // Output: [1,1,2,3,4,4,5,6]
  // Explanation: The linked-lists are:
  // [
  // 1->4->5,
  // 1->3->4,
  // 2->6
  // ]
  // merging them into one sorted list:
  // 1->1->2->3->4->4->5->6
  //
  //
  // Example 2:
  //
  //
  // Input: lists = []
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: lists = [[]]
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // k == lists.length
  // 0 <= k <= 10⁴
  // 0 <= lists[i].length <= 500
  // -10⁴ <= lists[i][j] <= 10⁴
  // lists[i] is sorted in ascending order.
  // The sum of lists[i].length will not exceed 10⁴.
  //
  // Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge
  // Sort 👍 13055 👎 498

  public static void main(String[] args) {
    Solution solution = new MergeKSortedLists().new Solution();
    String[] data = """
          [[1,4,5],[1,3,4],[2,6]]
      []
      [[]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      ListNode q = solution.mergeKLists((ListNode[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
      return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
      if (l == r) {
        return lists[l];
      }
      if (l > r) {
        return null;
      }
      int mid = (l + r) >> 1;
      return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
      if (a == null || b == null) {
        return a != null ? a : b;
      }
      ListNode head = new ListNode(0);
      ListNode tail = head, aPtr = a, bPtr = b;
      while (aPtr != null && bPtr != null) {
        if (aPtr.val < bPtr.val) {
          tail.next = aPtr;
          aPtr = aPtr.next;
        } else {
          tail.next = bPtr;
          bPtr = bPtr.next;
        }
        tail = tail.next;
      }
      tail.next = (aPtr != null ? aPtr : bPtr);
      return head.next;
    }

  }

  // leetcode submit region end(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class QueueSolution {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null) {
        return null;
      }
      PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
      for (ListNode l : lists) {
        if (l != null) {
          queue.add(l);
        }
      }
      // queue.addAll(Arrays.asList(lists));
      ListNode dummy = new ListNode(-1);
      ListNode index = dummy;
      while (!queue.isEmpty()) {
        ListNode poll = queue.poll();
        if (poll == null) {
          return dummy.next;
        }
        index.next = poll;
        index = index.next;
        if (poll.next != null) {
          queue.offer(poll.next);
        }
      }
      return dummy.next;
    }
  }

}
