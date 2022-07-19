package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class NextGreaterNodeInLinkedList {
  // 1019
  // You are given the head of a linked list with n nodes.
  //
  // For each node in the list, find the value of the next greater node. That is,
  // for each node, find the value of the first node that is next to it and has a
  // strictly larger value than it.
  //
  // Return an integer array answer where answer[i] is the value of the next
  // greater node of the iᵗʰ node (1-indexed). If the iᵗʰ node does not have a next
  // greater node, set answer[i] = 0.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [2,1,5]
  // Output: [5,5,0]
  //
  //
  // Example 2:
  //
  //
  // Input: head = [2,7,4,3,5]
  // Output: [7,0,5,5,0]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the list is n.
  // 1 <= n <= 10⁴
  // 1 <= Node.val <= 10⁹
  //
  // Related Topics Array Linked List Stack Monotonic Stack 👍 2285 👎 99

  public static void main(String[] args) {
    Solution solution = new NextGreaterNodeInLinkedList().new Solution();
    String[] data = """
          [2,1,5]
      [2,7,4,3,5]
      [3,3]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.nextLargerNodes((ListNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public int[] nextLargerNodes(ListNode head) {
      List<Integer> list = new ArrayList<>();
      while (head != null) {
        list.add(head.val);
        head = head.next;
      }
      int[] res = new int[list.size()];
      Deque<Integer> stack = new ArrayDeque<>();
      for (int i = res.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
          stack.pop();
        }
        res[i] = stack.isEmpty() ? 0 : stack.peek();
        stack.push(list.get(i));
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
