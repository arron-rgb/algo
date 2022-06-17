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
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(val);
    ListNode index = next;
    while (index != null) {
      stringBuilder.append(" -> ").append(index.val);
      index = index.next;
    }
    System.out.println(stringBuilder);
  }
}
