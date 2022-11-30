package edu.neu.algo.review.leetcode.editor.en._20221129;

import edu.neu.util.InputUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximumFrequencyStackWrapper {

  // Design a stack-like data structure to push elements to the stack and pop the
  // most frequent element from the stack.
  //
  // Implement the FreqStack class:
  //
  //
  // FreqStack() constructs an empty frequency stack.
  // void push(int val) pushes an integer val onto the top of the stack.
  // int pop() removes and returns the most frequent element in the stack.
  //
  // If there is a tie for the most frequent element, the element closest to the
  // stack's top is removed and returned.
  //
  //
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop",
  // "pop", "pop"]
  // [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
  // Output
  // [null, null, null, null, null, null, null, 5, 7, 5, 4]
  //
  // Explanation
  // FreqStack freqStack = new FreqStack();
  // freqStack.push(5); // The stack is [5]
  // freqStack.push(7); // The stack is [5,7]
  // freqStack.push(5); // The stack is [5,7,5]
  // freqStack.push(7); // The stack is [5,7,5,7]
  // freqStack.push(4); // The stack is [5,7,5,7,4]
  // freqStack.push(5); // The stack is [5,7,5,7,4,5]
  // freqStack.pop(); // return 5, as 5 is the most frequent. The stack becomes [
  // 5,7,5,7,4].
  // freqStack.pop(); // return 7, as 5 and 7 is the most frequent, but 7 is
  // closest to the top. The stack becomes [5,7,5,4].
  // freqStack.pop(); // return 5, as 5 is the most frequent. The stack becomes [
  // 5,7,4].
  // freqStack.pop(); // return 4, as 4, 5 and 7 is the most frequent, but 4 is
  // closest to the top. The stack becomes [5,7].
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= val <= 10⁹
  // At most 2 * 10⁴ calls will be made to push and pop.
  // It is guaranteed that there will be at least one element in the stack before
  // calling pop.
  //
  // Related Topics Hash Table Stack Design Ordered Set 👍 4100 👎 62

  public static void main(String[] args) {
    MaximumFrequencyStackWrapper maximumFrequencyStackWrapper = new MaximumFrequencyStackWrapper();
    maximumFrequencyStackWrapper.getNoZeroIntegers(9);
    FreqStack instance = new MaximumFrequencyStackWrapper().new FreqStack();
    instance.push(5);
    instance.push(7);
    instance.push(5);
    instance.push(7);
    instance.push(4);
    instance.push(5);
    int value0 = instance.pop();
    int value1 = instance.pop();
    int value2 = instance.pop();
    int value3 = instance.pop();

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class FreqStack {

    Map<Integer, Deque<Integer>> stack;
    Map<Integer, Integer> count;
    Deque<Integer> empty = new ArrayDeque<>();

    public FreqStack() {
      stack = new HashMap<>();
      count = new HashMap<>();
    }

    public void push(int val) {
      int old = count.getOrDefault(val, 0);
      // if (stack.getOrDefault(old, empty).contains(val)) {
      // stack.get(old).remove(val);
      // }
      stack.computeIfAbsent(old + 1, t -> new ArrayDeque<>()).addFirst(val);
      count.put(val, count.getOrDefault(val, 0) + 1);
    }

    public int pop() {
      List<Integer> keys = new ArrayList<>(stack.keySet());
      Collections.sort(keys);
      int n = keys.size();
      int maxTimes = keys.get(n - 1);
      int val = stack.get(maxTimes).pollFirst();
      // val为这个值
      // old为这个值出现的次数
      if (stack.get(maxTimes).isEmpty()) {
        stack.remove(maxTimes);
      }

      int old = count.getOrDefault(val, 0);
      if (old == 0) {
        return -1;
      } else if (old == 1) {
        // 不再把它放入count和stack
      } else {
        // 这里存在的问题是 要使用原始入栈顺序，而不是使用其更新后的数据
        // 放入stack[count-1]
        count.put(val, old - 1);
        // stack.computeIfAbsent(old - 1, t -> new ArrayDeque<>()).addFirst(val);
        // 其实push的时候不需要移动
        // 只需要在他更新的时候把它加到新的地方即可，这样pop也不用额外调整
      }

      return val;
    }
  }

  /**
   * Your FreqStack object will be instantiated and called as such: FreqStack obj = new FreqStack(); obj.push(val); int
   * param_2 = obj.pop();
   */
  // leetcode submit region end(Prohibit modification and deletion)
  public int[] getNoZeroIntegers(int n) {
    for (int i = 1; i < n; i++) {
      if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
        // return new int[] {i, n - i};
      }
    }
    List<Integer> list = new ArrayList<>();
    int sum = list.stream().mapToInt(t -> t).sum();
    // Integer.max()
    List<Integer> evens = IntStream.range(0, 100).filter(i -> i % 2 == 0).boxed().toList();
    // List<Integer> collect = Stream.iterate(0, i -> i + 2).toList();
    double random = Math.random();
    return new int[]{-1, -1};
  }

}
