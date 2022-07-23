package edu.neu.base;

/**
 * @author arronshentu
 */
public class SegmentTreeNode {
  public int start, end, max;
  public SegmentTreeNode left, right;

  public SegmentTreeNode(int start, int end, int max) {
    this.start = start;
    this.end = end;
    this.max = max;
    this.left = this.right = null;
  }

  public SegmentTreeNode build(int[] nums) {
    return build(0, nums.length - 1, nums);
  }

  public SegmentTreeNode build(int left, int right, int[] nums) {
    if (left > right) {
      return null;
    }
    SegmentTreeNode root = new SegmentTreeNode(left, right, nums[left]);
    if (left == right) {
      return root;
    }
    int mid = (left + right) / 2;
    root.left = build(left, mid, nums);
    root.right = build(mid + 1, right, nums);
    root.max = Math.max(root.left.max, root.right.max);
    return root;
  }

  public void modify(SegmentTreeNode root, int index, int value) {
    if (root.start == root.end && root.start == index) {
      root.max = value;
      return;
    }
    int mid = (root.start + root.end) / 2;
    if (index <= mid) {
      modify(root.left, index, value);
      root.max = Math.max(root.right.max, root.left.max);
    } else {
      modify(root.right, index, value);
      root.max = Math.max(root.left.max, root.right.max);
    }
  }

  public int query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && root.end <= end) {
      return root.max;
    }
    int mid = (root.start + root.end) / 2;
    int ans = Integer.MIN_VALUE;
    if (mid >= start) {
      ans = Math.max(ans, query(root.left, start, end));
    }
    if (mid + 1 <= end) {
      ans = Math.max(ans, query(root.right, start, end));
    }
    return ans;
  }

}
