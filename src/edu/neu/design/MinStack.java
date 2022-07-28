package edu.neu.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author arronshentu
 */
public class MinStack {

  Deque<Integer> stack;
  Deque<Integer> help;

  public MinStack() {
    stack = new ArrayDeque<>();
    help = new ArrayDeque<>();
    help.push(Integer.MAX_VALUE);
  }

  public void push(int val) {
    stack.push(val);
    help.push(Math.min(help.peek(), val));
  }

  public void pop() {
    stack.pop();
    help.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return help.peek();
  }
}

class OneSpaceMinStack {

  Integer min = null;
  Deque<Long> data = new ArrayDeque<>();

  /**
   * initialize your data structure here.
   */
  public OneSpaceMinStack() {}

  public void push(int x) {
    if (data.isEmpty()) {
      data.push(0L);
      min = x;
    } else {
      // 如果x是最小的数，这里可能越界，所以用Long来保存
      data.push(Long.valueOf(x) - min);
      min = Math.min(x, min);
    }
  }

  public void pop() {
    Long diff = data.pop();
    if (diff >= 0) {
      // return min + diff;
    } else {
      int res = min;
      min = (int)(min - diff);
      // return res;
    }
  }

  public int top() {
    Long diff = data.peek();
    if (diff >= 0) {
      return (int)(min + diff);
    } else {
      return min;
    }
  }

  public int getMin() {
    return min;
  }
}
