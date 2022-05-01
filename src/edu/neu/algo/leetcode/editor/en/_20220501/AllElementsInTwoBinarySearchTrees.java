package edu.neu.algo.leetcode.editor.en._20220501;

import java.util.ArrayList;
import java.util.List;

import edu.neu.base.TreeNode;

public class AllElementsInTwoBinarySearchTrees {

  // Given two binary search trees root1 and root2, return a list containing all
  // the integers from both trees sorted in ascending order.
  //
  //
  // Example 1:
  //
  //
  // Input: root1 = [2,1,4], root2 = [1,0,3]
  // Output: [0,1,1,2,3,4]
  //
  //
  // Example 2:
  //
  //
  // Input: root1 = [1,null,8], root2 = [8,1]
  // Output: [1,1,8,8]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in each tree is in the range [0, 5000].
  // -10⁵ <= Node.val <= 10⁵
  //
  // Related Topics Tree Depth-First Search Binary Search Tree Sorting Binary
  // Tree 👍 2211 👎 65

  public static void main(String[] args) {
    Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
    TreeNode root1 = new TreeNode(1);
    // root1.left = new TreeNode(1);
    root1.right = new TreeNode(8);
    TreeNode root2 = new TreeNode(8);
    root2.left = new TreeNode(1);
    // root2.right = new TreeNode(3);
    List<Integer> allElements = solution.getAllElements(root1, root2);
    System.out.println(allElements);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
   * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
   * = left; this.right = right; } }
   */
  class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> list1 = dfs(new ArrayList<>(), root1);
      List<Integer> list2 = dfs(new ArrayList<>(), root2);
      int left = 0;
      while (!list2.isEmpty()) {
        if (left < list1.size() && list1.get(left) > list2.get(0)) {
          list1.add(left, list2.remove(0));
        } else {
          left++;
          if (left > list1.size()) {
            list1.addAll(list2);
            break;
          }
        }
      }
      return list1;
    }

    List<Integer> dfs(List<Integer> tmp, TreeNode root) {
      if (root == null) {
        return tmp;
      }
      dfs(tmp, root.left);
      tmp.add(root.val);
      dfs(tmp, root.right);
      return tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
