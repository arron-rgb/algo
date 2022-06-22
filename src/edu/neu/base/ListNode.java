package edu.neu.base;

/**
 * @author arronshentu
 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void print() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    if (hasCycle()) {
      return "List has cycle";
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(val);
    ListNode index = next;
    while (index != null) {
      stringBuilder.append(" -> ").append(index.val);
      index = index.next;
    }
    return stringBuilder.toString();
  }

  private boolean hasCycle() {
    ListNode fast = this, slow = this;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
