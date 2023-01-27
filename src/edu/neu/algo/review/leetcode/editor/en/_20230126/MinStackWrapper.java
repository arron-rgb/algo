package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MinStackWrapper {
  // 155
  // Design a stack that supports push, pop, top, and retrieving the minimum
  // element in constant time.
  //
  // Implement the MinStack class:
  //
  //
  // MinStack() initializes the stack object.
  // void push(int val) pushes the element val onto the stack.
  // void pop() removes the element on the top of the stack.
  // int top() gets the top element of the stack.
  // int getMin() retrieves the minimum element in the stack.
  //
  //
  // You must implement a solution with O(1) time complexity for each function.
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["MinStack","push","push","push","getMin","pop","top","getMin"]
  // [[],[-2],[0],[-3],[],[],[],[]]
  //
  // Output
  // [null,null,null,null,-3,null,0,-2]
  //
  // Explanation
  // MinStack minStack = new MinStack();
  // minStack.push(-2);
  // minStack.push(0);
  // minStack.push(-3);
  // minStack.getMin(); // return -3
  // minStack.pop();
  // minStack.top(); // return 0
  // minStack.getMin(); // return -2
  //
  //
  //
  // Constraints:
  //
  //
  // -2³¹ <= val <= 2³¹ - 1
  // Methods pop, top and getMin operations will always be called on non-empty
  // stacks.
  // At most 3 * 10⁴ calls will be made to push, pop, top, and getMin.
  //
  //
  // Related Topics Stack Design 👍 10655 👎 709

  public static void main(String[] args) {
    MinStack instance = new MinStackWrapper().new MinStack();
    instance.push(-2);
    instance.push(0);
    instance.push(-3);
    int value0 = instance.getMin();
    instance.pop();
    int value1 = instance.top();
    int value2 = instance.getMin();

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class MinStack {
    Deque<Integer> deque;
    Deque<Integer> min;

    public MinStack() {
      deque = new ArrayDeque<>();
      min = new ArrayDeque<>();

    }

    public void push(int val) {
      deque.push(val);
      min.push(min.isEmpty() ? val : Math.min(getMin(), val));
    }

    public void pop() {
      deque.pop();
      min.pop();
    }

    public int top() {
      return deque.peek();
    }

    public int getMin() {
      return min.peek();
    }
  }

  /**
   * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack(); obj.push(val);
   * obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
