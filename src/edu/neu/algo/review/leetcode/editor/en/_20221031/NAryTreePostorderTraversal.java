package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;

import edu.neu.base.Node;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class NAryTreePostorderTraversal {
  // 590
  // Given the root of an n-ary tree, return the postorder traversal of its nodes'
  // values.
  //
  // Nary-Tree input serialization is represented in their level order traversal.
  // Each group of children is separated by the null value (See examples)
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,null,3,2,4,null,5,6]
  // Output: [5,6,3,2,4,1]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
  // null,12,null,13,null,null,14]
  // Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 10⁴].
  // 0 <= Node.val <= 10⁴
  // The height of the n-ary tree is less than or equal to 1000.
  //
  //
  //
  // Follow up: Recursive solution is trivial, could you do it iteratively?
  // Related Topics Stack Tree Depth-First Search 👍 1917 👎 87

  public static void main(String[] args) {
    Solution solution = new NAryTreePostorderTraversal().new Solution();
    String[] data = """
          [1,null,3,2,4,null,5,6]
      [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.postorder((Node)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }
  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  /*
  // Definition for a Node.
  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
  };
  */

  class Solution {
    public List<Integer> postorder(Node root) {
      List<Integer> res = new ArrayList<>();
      dfs(res, root);
      return res;
    }

    void dfs(List<Integer> list, Node root) {
      if (root == null) {
        return;
      }
      if (root.children == null || root.children.isEmpty()) {
        list.add(root.val);
        return;
      }
      for (Node child : root.children) {
        dfs(list, child);
      }
      list.add(root.val);
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
  }

  TreeNode build(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    if (left == right) {
      return root;
    }
    root.left = build(nums, 0, mid - 1);
    root.right = build(nums, mid + 1, right);
    return root;
  }
}
