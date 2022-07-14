package edu.neu.algo.dp.leetcode.editor.en._20220714;

import java.util.*;

import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  // 105
  // Given two integer arrays preorder and inorder where preorder is the preorder
  // traversal of a binary tree and inorder is the inorder traversal of the same tree,
  // construct and return the binary tree.
  //
  //
  // Example 1:
  //
  //
  // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
  // Output: [3,9,20,null,null,15,7]
  //
  //
  // Example 2:
  //
  //
  // Input: preorder = [-1], inorder = [-1]
  // Output: [-1]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= preorder.length <= 3000
  // inorder.length == preorder.length
  // -3000 <= preorder[i], inorder[i] <= 3000
  // preorder and inorder consist of unique values.
  // Each value of inorder also appears in preorder.
  // preorder is guaranteed to be the preorder traversal of the tree.
  // inorder is guaranteed to be the inorder traversal of the tree.
  //
  // Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 9306 ?
  // ? 256

  public static void main(String[] args) {
    Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    String[] data = """
          [3,9,20,15,7]
      [9,3,15,20,7]
      [-1]
      [-1]
      [1,2]
      [1,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      TreeNode q =
        solution.buildTree((int[])params[1 + i * paramTypes.length - 1], (int[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param pre
     *          先序遍历
     * @param in
     *          中序遍历
     * @param preStart
     *          preOrder的左边界
     * @param j
     *          preOrder的右边界
     * @param inStart
     *          inOrder的左边界
     * @param inEnd
     *          inOrder的右边界
     * @return 以preOrder[preStart]为根结点的root preorder 数组切分为 [0+1, 0+1+ index] [0+1+index+1, preorder.length-1]
     */
    TreeNode dfs(int[] pre, int[] in, int preStart, int j, int inStart, int inEnd) {
      // 条件差在 inStart > inEnd
      if (preStart > pre.length - 1 || inStart > inEnd) {
        return null;
      }

      // 都在preorder中找第一个
      TreeNode root = new TreeNode(pre[preStart]);
      int mid = -1;
      // inOrder中找到它的位置
      for (int k = inStart; k <= inEnd; k++) {
        if (in[k] == pre[preStart]) {
          mid = k;
          break;
        }
      }
      if (mid == -1) {
        return root;
      }
      int leftLen = mid - inStart;
      root.left = dfs(pre, in, preStart + 1, preStart + leftLen, inStart, mid - 1);
      // left中构建树
      // preorder [preStart+1, preStart+leftLen] inorder [inStart, mid-1]
      // right中构建树
      // preorder [preStart+leftLen+1, j] inorder [mid+1, inEnd]
      root.right = dfs(pre, in, preStart + 1 + leftLen, j, mid + 1, inEnd);

      return root;
    }

  }

  // leetcode submit region end(Prohibit modification and deletion)
  class OtherSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
      if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
      }
      TreeNode root = new TreeNode(preorder[preStart]);
      int mid = 0; // Index of current root in inorder
      for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
          mid = i;
        }
      }
      root.left = helper(preStart + 1, inStart, mid - 1, preorder, inorder);
      root.right = helper(preStart + mid - inStart + 1, mid + 1, inEnd, preorder, inorder);
      return root;
    }
  }
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */

}
