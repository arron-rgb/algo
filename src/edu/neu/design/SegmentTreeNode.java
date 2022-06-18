package edu.neu.design;

/**
 * @author arronshentu
 */
public class SegmentTreeNode {
  public int start, end, max;
  public SegmentTreeNode left, right;

  // [start, end] 代表节点的区间范围
  // max 是节点在(start,end)区间上的最大值
  // left , right 是当前节点区间划分之后的左右节点区间
  public SegmentTreeNode(int start, int end, int max) {
    this.start = start;
    this.end = end;
    this.max = max;
    this.left = this.right = null;
  }

  public SegmentTreeNode build(int[] A) {
    // write your code here
    return buildhelper(0, A.length - 1, A);
  }

  public SegmentTreeNode buildhelper(int left, int right, int[] A) {
    if (left > right) {
      return null;
    }
    // 根据节点区间的左边界的序列值为节点赋初值
    SegmentTreeNode root = new SegmentTreeNode(left, right, A[left]);
    if (left == right) {
      // 如果左边界和右边界相等,节点左边界的序列值就是线段树节点的接节点值
      return root;
    }
    // 划分当前区间的左右区间
    int mid = (left + right) / 2;
    root.left = buildhelper(left, mid, A);
    root.right = buildhelper(mid + 1, right, A);
    // 根据节点区间的左右区间的节点值得到当前节点的节点值
    root.max = Math.max(root.left.max, root.right.max);
    return root;
  }

  // 单点更新的代码及注释
  public void modify(SegmentTreeNode root, int index, int value) {
    // 找到被改动的叶子节点
    if (root.start == root.end && root.start == index) {
      // 改变value值
      root.max = value;
      return;
    }
    // 将当前节点区间分割为2个区间的分割线
    int mid = (root.start + root.end) / 2;
    // 如果index在当前节点的左边
    if (index <= mid) {
      modify(root.left, index, value);
      // 可能对当前节点的影响
      root.max = Math.max(root.right.max, root.left.max);
    } else {
      // 如果index在当前节点的右边
      modify(root.right, index, value);
      // 可能对当前节点的影响
      root.max = Math.max(root.left.max, root.right.max);
    }
  }

}
