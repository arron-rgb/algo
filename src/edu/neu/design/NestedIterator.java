package edu.neu.design;

/**
 * @author arronshentu
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
  private Deque<NestedInteger> deque;

  public NestedIterator(List<NestedInteger> nestedList) {
    deque = new ArrayDeque<>();
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      deque.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    return deque.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!deque.isEmpty()) {
      NestedInteger tmp = deque.peek();
      if (tmp.isInteger()) {
        return true;
      }
      deque.pop();
      for (int j = tmp.getList().size() - 1; j >= 0; j--) {
        deque.push(tmp.getList().get(j));
      }
    }
    return false;
  }
}
/**
 * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
 * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
 */
