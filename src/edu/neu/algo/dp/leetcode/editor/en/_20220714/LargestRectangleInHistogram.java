package edu.neu.algo.dp.leetcode.editor.en._20220714;

import java.util.*;
import edu.neu.util.InputUtil;

public class LargestRectangleInHistogram {
  // 84
  // Given an array of integers heights representing the histogram's bar height
  // where the width of each bar is 1, return the area of the largest rectangle in the
  // histogram.
  //
  //
  // Example 1:
  //
  //
  // Input: heights = [2,1,5,6,2,3]
  // Output: 10
  // Explanation: The above is a histogram where width of each bar is 1.
  // The largest rectangle is shown in the red area, which has an area = 10 units.
  //
  //
  // Example 2:
  //
  //
  // Input: heights = [2,4]
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= heights.length <= 10⁵
  // 0 <= heights[i] <= 10⁴
  //
  // Related Topics Array Stack Monotonic Stack 👍 10952 👎 153

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(null);
    System.out.println(deque.size());
    Solution solution = new LargestRectangleInHistogram().new Solution();
    String[] data = """
      [1,2,3]
      [2,1,5,6,2,3]
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.largestRectangleArea((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int largestRectangleArea(int[] heights) {
      Deque<Integer> deque = new ArrayDeque<>();
      deque.add(-1);
      int n = heights.length;
      int res = -1;
      for (int i = 0; i < n; i++) {
        while (deque.peek() != -1 && heights[deque.peek()] >= heights[i]) {
          int preHeight = heights[deque.pop()];
          // 遍历每个高度，是要以当前高度为基准，寻找最大的宽度 组成最大的矩形面积那就是要找左边第一个小于当前高度的下标left，
          //
          // 再找右边第一个小于当前高度的下标right 那宽度就是这两个下标之间的距离了
          // 但是要排除这两个下标 所以是right-left-1 用单调栈就可以很方便确定这两个边界了
          //
          // 另一种思路
          // 当heights[i] <= 栈中的高度的时候
          // 则穷举栈中的所有高度
          // 因为栈中的高度是递增的
          // 从最高的高度开始下降，会有越来越多的竖条加入考虑的范围当中

          int width = i - 1 - deque.peek();
          System.out.println(preHeight * width);
          res = Math.max(res, preHeight * width);
        }
        deque.push(i);
      }

      while (deque.peek() != -1) {
        int preHeight = heights[deque.pop()];
        int width = n - 1 - deque.peek();
        res = Math.max(res, preHeight * width);
      }
      // [3, 2, 1]
      // stack里存的height: [1,2,3]
      // 如果 stack[i] 右边有数，则肯定比他大
      // 所以 只需要求 n-1 - deque.peek() 为底，高为stack[i]
      // 左边肯定比他小，如果peek不为-1 还是会再求一遍，所以不用考虑
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
