package edu.neu.algo.dp.leetcode.editor.en._20220709;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class BinaryTreeCameras {
  // 968
  // You are given the root of a binary tree. We install cameras on the tree nodes
  // where each camera at a node can monitor its parent, itself, and its immediate
  // children.
  //
  // Return the minimum number of cameras needed to monitor all nodes of the tree.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: root = [0,0,null,0,0]
  // Output: 1
  // Explanation: One camera is enough to monitor all nodes if placed as shown.
  //
  //
  // Example 2:
  //
  //
  // Input: root = [0,0,null,0,null,0,null,null,0]
  // Output: 2
  // Explanation: At least two cameras are needed to monitor all nodes of the tree.
  // The above image shows one of the valid configurations of camera placement.
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [1, 1000].
  // Node.val == 0
  //
  // Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 419
  // 2 👎 54

  public static void main(String[] args) {
    Solution solution = new BinaryTreeCameras().new Solution();
    Solutoin2 solution2 = new BinaryTreeCameras().new Solutoin2();
    String[] data = """
          [1,2,null,4,5]
      [1,2,null,4,null,6,null,null,9]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution2.minCameraCover((TreeNode)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    // 给一棵树，在树上安装摄像头，可以监视父，自身，及子节点
    // 计算覆盖整棵树的最小的摄像头数量
    public int minCameraCover(TreeNode root) {
      // 要覆盖root:
      // 1. root装, 则保证root.left与root.right的【子树】被监控到
      // 2. root不装，则root.left与root.right需要装，且需要保证root.left与root.right的【子树】被监控到
      // 对于root三个状态
      // 0: 在自身装, left2 + right2 + 1; 如果某个子树为null，则不能在此处放，返回大整数即可
      // 1: 左右子树选一个装, 左子树装, min(left0 + right1, right0 + left1, a)
      // 2: 左右子树覆盖到的情况, min(a, left1 + right1)
      return dfs(root)[1];
    }

    int[] dfs(TreeNode root) {
      if (root == null) {
        return new int[] {Integer.MAX_VALUE / 2, 0, 0};
      }
      int[] tmp = new int[3];
      int[] left = dfs(root.left);
      int[] right = dfs(root.right);
      tmp[0] = left[2] + right[2] + 1;
      tmp[1] = Math.min(tmp[0], left[0] + right[1]);
      tmp[1] = Math.min(tmp[1], left[1] + right[0]);
      tmp[2] = Math.min(tmp[0], left[1] + right[1]);
      return tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  class Solutoin2 {
    /**
     * 摄像头个数
     */
    private int ans = 0;

    public int minCameraCover(TreeNode root) {
      if (root == null) {
        return 0;
      }
      if (dfs(root) == 2) {
        ans++;
      }
      return ans;
    }

    // 0：该节点安装了监视器 1：该节点可观，但没有安装监视器 2：该节点不可观
    private int dfs(TreeNode node) {
      if (node == null) {
        return 1;
      }
      int left = dfs(node.left), right = dfs(node.right);
      // 自底向上开始
      // 叶节点的父亲开始安装
      if (left == 2 || right == 2) {
        ans++;
        System.out.println(node);
        return 0;
      } else if (left == 0 || right == 0) {
        // left或者right装了 自己就不用装
        return 1;
      }
      // 没法看到
      return 2;
    }
  }

}
