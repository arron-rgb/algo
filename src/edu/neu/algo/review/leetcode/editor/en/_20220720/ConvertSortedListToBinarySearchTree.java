package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;

import com.sun.source.tree.Tree;
import edu.neu.base.ListNode;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class ConvertSortedListToBinarySearchTree {
  // 109
  // Given the head of a singly linked list where elements are sorted in ascending
  // order, convert it to a height balanced BST.
  //
  // For this problem, a height-balanced binary tree is defined as a binary tree
  // in which the depth of the two subtrees of every node never differ by more than 1.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: head = [-10,-3,0,5,9]
  // Output: [0,-3,9,-10,null,5]
  // Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the
  // shown height balanced BST.
  //
  //
  // Example 2:
  //
  //
  // Input: head = []
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in head is in the range [0, 2 * 10⁴].
  // -10⁵ <= Node.val <= 10⁵
  //
  // Related Topics Linked List Divide and Conquer Tree Binary Search Tree Binary
  // Tree 👍 4848 👎 117

  public static void main(String[] args) {
    Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    String[] data = """
          [-10,-3,0,5,9]
      []
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[ListNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q = solution.sortedListToBST((ListNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
        return null;
      }
      if (head.next == null) {
        return new TreeNode(head.val);
      }
      ListNode slow = head, pre = null, fast = head;
      while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      pre.next = null;
      TreeNode n = new TreeNode(slow.val);
      n.left = sortedListToBST(head);
      n.right = sortedListToBST(slow.next);
      return n;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
