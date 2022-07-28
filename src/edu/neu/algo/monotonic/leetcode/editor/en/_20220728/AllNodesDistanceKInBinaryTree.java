package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;

import com.sun.source.tree.Tree;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class AllNodesDistanceKInBinaryTree {
  // 863
  // Given the root of a binary tree, the value of a target node target, and an
  // integer k, return an array of the values of all nodes that have a distance k from
  // the target node.
  //
  // You can return the answer in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
  // Output: [7,4,1]
  // Explanation: The nodes that are a distance 2 from the target node (with value
  // 5) have values 7, 4, and 1.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [1], target = 1, k = 3
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 500].
  // 0 <= Node.val <= 500
  // All the values Node.val are unique.
  // target is the value of one of the nodes in the tree.
  // 0 <= k <= 1000
  //
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 68
  // 26 👎 132

  public static void main(String[] args) {
    Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
    String[] data = """
          [3,5,1,6,2,0,8,null,null,7,4]
      5
      2
      [1]
      1
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, TreeNode, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.distanceK((TreeNode)params[1 + i * paramTypes.length - 1],
        (TreeNode)params[2 + i * paramTypes.length - 1], (int)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<Integer> res;
    TreeNode targetFather;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      res = new ArrayList<>();
      if (k == 0) {
        res.add(target.val);
        return res;
      }
      dfs(root, target, null);
      collect(target, k);
      collect(targetFather, k - 1);
      return res;
    }

    public boolean dfs(TreeNode root, TreeNode target, TreeNode father) {
      if (root == null) {
        return false;
      }
      if (root.val == target.val) {
        targetFather = father;
        return true;
      }
      if (dfs(root.left, target, root)) {
        root.left = father;
        return true;
      }
      if (dfs(root.right, target, root)) {
        root.right = father;
        return true;
      }
      return false;
    }

    public void collect(TreeNode root, int k) {
      if (root == null) {
        return;
      }
      if (k == 0) {
        res.add(root.val);
      } else {
        collect(root.left, k - 1);
        collect(root.right, k - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
