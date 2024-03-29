package edu.neu.algo.leetcode.editor.en._20220508;

import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

  // You are given a nested list of integers nestedList. Each element is either an
  // integer or a list whose elements may also be integers or other lists. Implement
  // an iterator to flatten it.
  //
  // Implement the NestedIterator class:
  //
  //
  // NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with
  // the nested list nestedList.
  // int next() Returns the next integer in the nested list.
  // boolean hasNext() Returns true if there are still some integers in the
  // nested list and false otherwise.
  //
  //
  // Your code will be tested with the following pseudocode:
  //
  //
  // initialize iterator with nestedList
  // res = []
  // while iterator.hasNext()
  // append iterator.next() to the end of res
  // return res
  //
  //
  // If res matches the expected flattened list, then your code will be judged as
  // correct.
  //
  //
  // Example 1:
  //
  //
  // Input: nestedList = [[1,1],2,[1,1]]
  // Output: [1,1,2,1,1]
  // Explanation: By calling next repeatedly until hasNext returns false, the
  // order of elements returned by next should be: [1,1,2,1,1].
  //
  //
  // Example 2:
  //
  //
  // Input: nestedList = [1,[4,[6]]]
  // Output: [1,4,6]
  // Explanation: By calling next repeatedly until hasNext returns false, the
  // order of elements returned by next should be: [1,4,6].
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nestedList.length <= 500
  // The values of the integers in the nested list is in the range [-10⁶, 10⁶].
  //
  // Related Topics Stack Tree Depth-First Search Design Queue Iterator 👍 3198 👎
  // 1128

  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }

  public static void main(String[] args) {
    NestedIterator solution = new FlattenNestedListIterator().new NestedIterator(null);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * // This is the interface that allows for creating nested lists. // You should not implement it, or speculate about
   * its implementation public interface NestedInteger {
   *
   * // @return true if this NestedInteger holds a single integer, rather than a nested list. public boolean
   * isInteger();
   *
   * // @return the single integer that this NestedInteger holds, if it holds a single integer // Return null if this
   * NestedInteger holds a nested list public Integer getInteger();
   *
   * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return empty list if this
   * NestedInteger holds a single integer public List<NestedInteger> getList(); }
   */

  public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
      dfs(nestedList);
      this.iterator = this.list.iterator();
    }

    void dfs(List<NestedInteger> list) {
      if (list == null || list.isEmpty()) {
        return;
      }
      for (NestedInteger nestedInteger : list) {
        if (nestedInteger.isInteger()) {
          this.list.add(nestedInteger.getInteger());
        } else {
          dfs(nestedInteger.getList());
        }
      }
    }

    @Override
    public Integer next() {
      return iterator.next();
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }
  }

  /**
   * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
   * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
