package edu.neu.algo.review.leetcode.editor.en._20221030;

import java.util.*;
import java.util.stream.Collectors;

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
  // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 76
  // 30 👎 153

  public static void main(String[] args) {
    Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
    String[] data = """
          [3,5,1,6,2,0,8,null,null,7,4]
      5
      2
      [1]
      1
      3
      [0,1,null,null,2,null,3,null,4]
      3
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[TreeNode, int, int]");
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
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x)
   * { val = x; } }
   */
  class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      Map<TreeNode, List<TreeNode>> map = buildMap(root);
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.add(target);
      List<Integer> list = new ArrayList<>();
      Set<TreeNode> visited = new HashSet<>();
      visited.add(target);
      while (!deque.isEmpty()) {
        if (k == 0) {
          list.addAll(deque.stream().map(t -> t.val).toList());
          break;
        }
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = deque.pollFirst();
          List<TreeNode> nodes = map.getOrDefault(node, List.of());
          for (TreeNode treeNode : nodes) {
            if (visited.add(treeNode)) {
              deque.addLast(treeNode);
            }
          }
        }
        k--;
      }
      return list;
    }

    Map<TreeNode, List<TreeNode>> buildMap(TreeNode root) {
      Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
      dfs(root, graph, null);
      return graph;
    }

    void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode parent) {
      if (root == null) {
        return;
      }
      if (parent != null) {
        map.computeIfAbsent(parent, t -> new ArrayList<>()).add(root);
        map.computeIfAbsent(root, t -> new ArrayList<>()).add(parent);
      }
      dfs(root.left, map, root);
      dfs(root.right, map, root);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
