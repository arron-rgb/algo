package edu.neu.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arronshentu
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {

    StringBuilder output = new StringBuilder();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(this);
    while (!nodeQueue.isEmpty()) {
      int size = nodeQueue.size();
      boolean notNull = false;
      StringBuilder level = new StringBuilder();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodeQueue.remove();
        if (node == null) {
          level.append("null, ");
          continue;
        } else {
          notNull = true;
        }
        level.append(node.val).append(", ");
        nodeQueue.add(node.left);
        nodeQueue.add(node.right);
      }
      if (notNull) {
        output.append(level);
      }
    }
    return "[" + output.substring(0, output.length() - 2) + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    TreeNode treeNode = (TreeNode)o;

    if (val != treeNode.val)
      return false;
    if (left != null ? !left.equals(treeNode.left) : treeNode.left != null)
      return false;
    return right != null ? right.equals(treeNode.right) : treeNode.right == null;
  }

  @Override
  public int hashCode() {
    int result = val;
    result = 31 * result + (left != null ? left.hashCode() : 0);
    result = 31 * result + (right != null ? right.hashCode() : 0);
    return result;
  }
}
