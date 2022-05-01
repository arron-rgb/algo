package edu.neu.base;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author arronshentu
 */
public class TreeUtil {
  private final static Codec CODEC = new Codec();
  private static boolean withNull = false;

  public static TreeNode deserialize(String s) {
    return CODEC.deserialize(s);
  }

  public static String serialize(TreeNode node) {
    return CODEC.serialize(node);
  }

  private static class Codec {
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder stringBuilder = new StringBuilder();
      dfs(stringBuilder, root);
      return stringBuilder.toString();
    }

    void dfs(StringBuilder sb, TreeNode root) {
      if (root == null) {
        // if (withNull) {
        sb.append(NULL).append(",");
        // }
        return;
      }
      sb.append(root.val).append(",");
      dfs(sb, root.left);
      dfs(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data.isEmpty()) {
        return null;
      }
      Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
      return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
      // return withNull ? deserialize(queue) : deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode deserialize(Queue<String> q) {
      String poll = q.poll();
      if (poll == null || NULL.equals(poll)) {
        return null;
      }
      int val = Integer.parseInt(poll);
      TreeNode node = new TreeNode(val);
      node.left = deserialize(q);
      node.right = deserialize(q);
      return node;
    }

    TreeNode deserialize(Queue<String> q, int low, int high) {
      if (q.isEmpty()) {
        return null;
      }
      String s = q.peek();
      if (s.equals(NULL)) {
        q.poll();
        return null;
      }
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

}
