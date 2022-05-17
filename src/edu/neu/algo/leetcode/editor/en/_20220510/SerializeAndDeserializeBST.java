package edu.neu.algo.leetcode.editor.en._20220510;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import edu.neu.base.TreeNode;

public class SerializeAndDeserializeBST {

  // Serialization is converting a data structure or object into a sequence of
  // bits so that it can be stored in a file or memory buffer, or transmitted across a
  // network connection link to be reconstructed later in the same or another computer
  // environment.
  //
  // Design an algorithm to serialize and deserialize a binary search tree. There
  // is no restriction on how your serialization/deserialization algorithm should
  // work. You need to ensure that a binary search tree can be serialized to a string,
  // and this string can be deserialized to the original tree structure.
  //
  // The encoded string should be as compact as possible.
  //
  //
  // Example 1:
  // Input: root = [2,1,3]
  // Output: [2,1,3]
  // Example 2:
  // Input: root = []
  // Output: []
  //
  //
  // Constraints:
  //
  //
  // The number of nodes in the tree is in the range [0, 10⁴].
  // 0 <= Node.val <= 10⁴
  // The input tree is guaranteed to be a binary search tree.
  //
  // Related Topics String Tree Depth-First Search Breadth-First Search Design
  // Binary Search Tree Binary Tree 👍 2669 👎 133

  public static void main(String[] args) {
    Codec solution = new SerializeAndDeserializeBST().new Codec();

    TreeNode deserialize = solution.deserialize("2,1,3,4,5");
    System.out.println(deserialize);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x)
   * { val = x; } }
   */
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder stringBuilder = new StringBuilder();
      dfs(stringBuilder, root);
      return stringBuilder.toString();
    }

    private void dfs(StringBuilder stringBuilder, TreeNode root) {
      if (root == null) {
        return;
      }
      stringBuilder.append(root.val).append(",");
      dfs(stringBuilder, root.left);
      dfs(stringBuilder, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
        return null;
      }
      Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(",")));
      return deserialize(deque, 0, data.length());
    }

    private TreeNode deserialize(Deque<String> q, int low, int high) {
      if (q.isEmpty()) {
        return null;
      }
      String s = q.peek();
      int val = Integer.parseInt(s);
      if (val < low || val > high) {
        return null;
      }
      q.poll();
      TreeNode node = new TreeNode(val);
      node.left = deserialize(q, low, val);
      node.right = deserialize(q, val, high);
      return node;
    }
  }

  // Your Codec object will be instantiated and called as such:
  // Codec ser = new Codec();
  // Codec deser = new Codec();
  // String tree = ser.serialize(root);
  // TreeNode ans = deser.deserialize(tree);
  // return ans;
  // leetcode submit region end(Prohibit modification and deletion)

}
