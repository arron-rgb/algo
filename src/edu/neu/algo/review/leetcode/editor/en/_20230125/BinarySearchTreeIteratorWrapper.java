package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class BinarySearchTreeIteratorWrapper {
  // 173
  // Implement the BSTIterator class that represents an iterator over the in-order
  // traversal of a binary search tree (BST):
  //
  //
  // BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
  // The root of the BST is given as part of the constructor. The pointer should be
  // initialized to a non-existent number smaller than any element in the BST.
  // boolean hasNext() Returns true if there exists a number in the traversal to
  // the right of the pointer, otherwise returns false.
  // int next() Moves the pointer to the right, then returns the number at the
  // pointer.
  //
  //
  // Notice that by initializing the pointer to a non-existent smallest number,
  // the first call to next() will return the smallest element in the BST.
  //
  // You may assume that next() calls will always be valid. That is, there will
  // be at least a next number in the in-order traversal when next() is called.
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next",
  // "hasNext", "next", "hasNext"]
  // [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
  // Output
  // [null, 3, 7, true, 9, true, 15, true, 20, false]
  //
  //
  // Explanation
  // BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
  // bSTIterator.next(); // return 3
  // bSTIterator.next(); // return 7
  // bSTIterator.hasNext(); // return True
  // bSTIterator.next(); // return 9
  // bSTIterator.hasNext(); // return True
  // bSTIterator.next(); // return 15
  // bSTIterator.hasNext(); // return True
  // bSTIterator.next(); // return 20
  // bSTIterator.hasNext(); // return False
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 10⁵].
  // 0 <= Node.val <= 10⁶
  // At most 10⁵ calls will be made to hasNext, and next.
  //
  //
  //
  // Follow up:
  //
  //
  // Could you implement next() and hasNext() to run in average O(1) time and use
  // O(h) memory, where h is the height of the tree?
  //
  //
  // Related Topics Stack Tree Design Binary Search Tree Binary Tree Iterator 👍 7
  // 224 👎 436

  public static void main(String[] args) {
    BSTIterator instance =
      new BinarySearchTreeIteratorWrapper().new BSTIterator(InputUtil.stringToTree("[7, 3, 15, null, null, 9, 20]"));
    int value0 = instance.next();
    int value1 = instance.next();
    boolean value2 = instance.hasNext();
    int value3 = instance.next();
    boolean value4 = instance.hasNext();
    int value5 = instance.next();
    boolean value6 = instance.hasNext();
    int value7 = instance.next();
    boolean value8 = instance.hasNext();

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    System.out.println(value4);
    System.out.println(value5);
    System.out.println(value6);
    System.out.println(value7);
    System.out.println(value8);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class BSTIterator {

    public BSTIterator(TreeNode root) {
      deq = new ArrayDeque<>();
      push(root);
    }

    Deque<TreeNode> deq;

    void push(TreeNode root) {
      while (root != null) {
        deq.push(root);
        root = root.left;
      }
    }

    public int next() {
      TreeNode tmp = deq.pop();
      push(tmp.right);
      return tmp.val;
    }

    public boolean hasNext() {
      return !deq.isEmpty();
    }
  }

  /**
   * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new BSTIterator(root); int
   * param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */
  // leetcode submit region end(Prohibit modification and deletion)

  // 285
  class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      Deque<TreeNode> stack = new ArrayDeque<>();
      TreeNode prev = null, curr = root;
      while (!stack.isEmpty() || curr != null) {
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }
        curr = stack.pop();
        if (prev == p) {
          return curr;
        }
        prev = curr;
        curr = curr.right;
      }
      return null;
    }
  }

  public String getSmallestString(int n, int k) {
    String pre = "a".repeat(n - (n - k) / 25);
    String post = "z".repeat((n - k) / 25);
    if ((k - n) % 25 != 0) {
      pre = pre.substring(0, pre.length() - 1);
      pre += (char)('a' + k - n);
    }
    return pre + post;
  }

}
