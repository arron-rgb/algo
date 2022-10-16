package edu.neu.algo.monotonic.leetcode.editor.en._20221011;

import java.util.*;

import edu.neu.base.ListNode;
import edu.neu.util.InputUtil;

public class LinkedListComponents {
  // 817
  // You are given the head of a linked list containing unique integer values and
  // an integer array nums that is a subset of the linked list values.
  //
  // Return the number of connected components in nums where two values are
  // connected if they appear consecutively in the linked list.
  //
  //
  // Example 1:
  //
  //
  // Input: head = [0,1,2,3], nums = [0,1,3]
  // Output: 2
  // Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected
  // components.
  //
  //
  // Example 2:
  //
  //
  // Input: head = [0,1,2,3,4], nums = [0,3,1,4]
  // Output: 2
  // Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4
  // ] are the two connected components.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the linked list is n.
  // 1 <= n <= 10⁴
  // 0 <= Node.val < n
  // All the values Node.val are unique.
  // 1 <= nums.length <= n
  // 0 <= nums[i] < n
  // All the values of nums are unique.
  //
  // Related Topics Array Hash Table Linked List 👍 793 👎 1913

  public static void main(String[] args) {
    Solution solution = new LinkedListComponents().new Solution();
    String[] data = """
      [0,1,2,3]
      [0,1,3]
      [0,1,2,3,4]
      [0,3,1,4]
      [3,4,0,2,1]
      [4]
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode, int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numComponents((ListNode)params[1 + i * paramTypes.length - 1],
        (int[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  class Solution {
    public int numComponents(ListNode head, int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int i : nums) {
        set.add(i);
      }

      int res = 0;
      ListNode index = head;
      while (index != null) {
        if (set.contains(index.val)) {
          res++;
          while (index != null && set.contains(index.val)) {
            index = index.next;
          }
        } else {
          index = index.next;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
