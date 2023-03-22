package edu.neu.algo.review.leetcode.editor.en._20230228;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class FindDuplicateSubtrees {
  // 652
  // Given the root of a binary tree, return all duplicate subtrees.
  //
  // For each kind of duplicate subtrees, you only need to return the root node
  // of any one of them.
  //
  // Two trees are duplicate if they have the same structure with the same node
  // values.
  //
  //
  // Example 1:
  //
  //
  // Input: root = [1,2,3,4,null,2,4,null,null,4]
  // Output: [[2,4],[4]]
  //
  //
  // Example 2:
  //
  //
  // Input: root = [2,1,1]
  // Output: [[1]]
  //
  //
  // Example 3:
  //
  //
  // Input: root = [2,2,2,3,null,3,null]
  // Output: [[2,3],[3]]
  //
  //
  //
  // Constraints:
  //
  //
  // The number of the nodes in the tree will be in the range [1, 5000]
  // -200 <= Node.val <= 200
  //
  //
  // Related Topics Hash Table Tree Depth-First Search Binary Tree 👍 4379 👎 361

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [1,2,3,4,null,2,4,null,null,4]
      [2,1,1]
      [2,2,2,3,null,3,null]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<TreeNode> q = solution.findDuplicateSubtrees((TreeNode)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> res = new LinkedList<>();
      traverse(root, new HashMap<>(), new HashMap<>(), res);
      return res;
    }

    public int traverse(TreeNode node, Map<String, Integer> tripletToID, Map<Integer, Integer> cnt,
      List<TreeNode> res) {
      if (node == null) {
        return 0;
      }
      String triplet =
        traverse(node.left, tripletToID, cnt, res) + "," + node.val + "," + traverse(node.right, tripletToID, cnt, res);
      if (!tripletToID.containsKey(triplet)) {
        tripletToID.put(triplet, tripletToID.size() + 1);
      }
      int id = tripletToID.get(triplet);
      cnt.put(id, cnt.getOrDefault(id, 0) + 1);
      if (cnt.get(id) == 2) {
        res.add(node);
      }
      return id;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
