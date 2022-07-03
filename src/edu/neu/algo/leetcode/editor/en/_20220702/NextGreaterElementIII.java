package edu.neu.algo.leetcode.editor.en._20220702;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class NextGreaterElementIII {
  // 556
  // Given a positive integer n, find the smallest integer which has exactly the
  // same digits existing in the integer n and is greater in value than n. If no such
  // positive integer exists, return -1.
  //
  // Note that the returned integer should fit in 32-bit integer, if there is a
  // valid answer but it does not fit in 32-bit integer, return -1.
  //
  //
  // Example 1:
  // Input: n = 12
  // Output: 21
  // Example 2:
  // Input: n = 21
  // Output: -1
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 2³¹ - 1
  //
  // Related Topics Math Two Pointers String 👍 2402 👎 360

  public static void main(String[] args) {
    Solution solution = new NextGreaterElementIII().new Solution();
    String[] data = """
          12
      21
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.nextGreaterElement((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int nextGreaterElement(int n) {
      char[] number = (n + "").toCharArray();

      int i, j;
      // I) Start from the right most digit and
      // find the first digit that is
      // smaller than the digit next to it.
      for (i = number.length - 1; i > 0; i--) {
        if (number[i - 1] < number[i]) {
          break;
        }
      }
      // If no such digit is found, its the edge case 1.
      if (i == 0) {
        return -1;
      }
      // II) Find the smallest digit on right side of (i-1)'th
      // digit that is greater than number[i-1]
      int x = number[i - 1], smallest = i;
      for (j = i + 1; j < number.length; j++) {
        if (number[j] > x && number[j] <= number[smallest]) {
          smallest = j;
        }
      }
      // III) Swap the above found smallest digit with
      // number[i-1]
      char temp = number[i - 1];
      number[i - 1] = number[smallest];
      number[smallest] = temp;
      // IV) Sort the digits after (i-1) in ascending order
      Arrays.sort(number, i, number.length);
      long val = Long.parseLong(new String(number));
      return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class Solution2 {
    public int nextGreaterElement(int n) {
      char[] a = ("" + n).toCharArray();
      int i = a.length - 2;
      while (i >= 0 && a[i + 1] <= a[i]) {
        i--;
      }
      if (i < 0) {
        return -1;
      }
      int j = a.length - 1;
      while (j >= 0 && a[j] <= a[i]) {
        j--;
      }
      swap(a, i, j);
      reverse(a, i + 1);
      try {
        return Integer.parseInt(new String(a));
      } catch (Exception e) {
        return -1;
      }
    }

    private void reverse(char[] a, int start) {
      int i = start, j = a.length - 1;
      while (i < j) {
        swap(a, i, j);
        i++;
        j--;
      }
    }

    private void swap(char[] a, int i, int j) {
      char temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

}
