package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class CompleteBinaryTreeInserter {
  // 919
  // A complete binary tree is a binary tree in which every level, except possibly
  // the last, is completely filled, and all nodes are as far left as possible.
  //
  // Design an algorithm to insert a new node to a complete binary tree keeping
  // it complete after the insertion.
  //
  // Implement the CBTInserter class:
  //
  //
  // CBTInserter(TreeNode root) Initializes the data structure with the root of
  // the complete binary tree.
  // int insert(int v) Inserts a TreeNode into the tree with value Node.val ==
  // val so that the tree remains complete, and returns the value of the parent of the
  // inserted TreeNode.
  // TreeNode get_root() Returns the root node of the tree.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["CBTInserter", "insert", "insert", "get_root"]
  // [[[1, 2]], [3], [4], []]
  // Output
  // [null, 1, 2, [1, 2, 3, 4]]
  //
  // Explanation
  // CBTInserter cBTInserter = new CBTInserter([1, 2]);
  // cBTInserter.insert(3); // return 1
  // cBTInserter.insert(4); // return 2
  // cBTInserter.get_root(); // return [1, 2, 3, 4]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree will be in the range [1, 1000].
  // 0 <= Node.val <= 5000
  // root is a complete binary tree.
  // 0 <= val <= 5000
  // At most 10⁴ calls will be made to insert and get_root.
  //
  // Related Topics Tree Breadth-First Search Design Binary Tree 👍 825 👎 82

  public static void main(String[] args) {

    String[] data = """
          ["CBTInserter","insert","insert","get_root"]
      [[[1,2]],[3],[4],[]]
          """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[int[], int[]]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // TreeNode
    // for (int i = 0; i < loop; i++) {
    // }
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    CBTInserter solution = new CompleteBinaryTreeInserter().new CBTInserter(root);
    System.out.println(solution.insert(3));
    System.out.println(solution.insert(4));
    System.out.println(solution.get_root());
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class CBTInserter {
    Deque<TreeNode> deque;
    TreeNode root;

    public CBTInserter(TreeNode root) {
      deque = new ArrayDeque<>();
      deque.addFirst(root);
      this.root = root;
    }

    public int insert(int val) {
      TreeNode tmp = deque.peekFirst();
      while (!deque.isEmpty() && tmp.left != null && tmp.right != null) {
        deque.removeFirst();
        deque.addLast(tmp.left);
        deque.addLast(tmp.right);
        tmp = deque.peekFirst();
      }
      if (tmp.left == null) {
        tmp.left = new TreeNode(val);
      } else {
        tmp.right = new TreeNode(val);
      }
      return tmp.val;
    }

    public TreeNode get_root() {
      return root;
    }
  }

  /**
   * Your CBTInserter object will be instantiated and called as such: CBTInserter obj = new CBTInserter(root); int
   * param_1 = obj.insert(val); TreeNode param_2 = obj.get_root();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
