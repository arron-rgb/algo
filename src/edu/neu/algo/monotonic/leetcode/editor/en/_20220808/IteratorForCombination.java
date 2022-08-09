package edu.neu.algo.monotonic.leetcode.editor.en._20220808;

import java.util.*;
import edu.neu.util.InputUtil;

public class IteratorForCombination {
  // 1286
  // Design the CombinationIterator class:
  //
  //
  // CombinationIterator(string characters, int combinationLength) Initializes
  // the object with a string characters of sorted distinct lowercase English letters
  // and a number combinationLength as arguments.
  // next() Returns the next combination of length combinationLength in
  // lexicographical order.
  // hasNext() Returns true if and only if there exists a next combination.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next",
  // "hasNext"]
  // [["abc", 2], [], [], [], [], [], []]
  // Output
  // [null, "ab", true, "ac", true, "bc", false]
  //
  // Explanation
  // CombinationIterator itr = new CombinationIterator("abc", 2);
  // itr.next(); // return "ab"
  // itr.hasNext(); // return True
  // itr.next(); // return "ac"
  // itr.hasNext(); // return True
  // itr.next(); // return "bc"
  // itr.hasNext(); // return False
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= combinationLength <= characters.length <= 15
  // All the characters of characters are unique.
  // At most 10⁴ calls will be made to next and hasNext.
  // It is guaranteed that all calls of the function next are valid.
  //
  // Related Topics String Backtracking Design Iterator 👍 1200 👎 95

  public static void main(String[] args) {
//    Solution solution = new IteratorForCombination().new Solution();
    String[] data = """
          ["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]
      [["abc",2],[],[],[],[],[],[]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // List<String> q =
      // solution.${question.functionName}(
      // (int[])params[1 + i * paramTypes.length - 1]
      // ,
      // (int[])params[2 + i * paramTypes.length - 1]
      // );
      // System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class CombinationIterator {
    private List<String> list = new ArrayList<>();
    private int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
      backtrack(characters, 0, combinationLength, "");
    }

    // 顺序获取元素
    public String next() {
      return list.get(index++);
    }

    // 是否遍历完成
    public boolean hasNext() {
      return index < list.size();
    }

    // 回溯算法，使用StringBuilder记录结果，递归完成后从后往前删除
    public void backtrack(String s, int index, int target, String sb) {
      if (sb.length() == target) {
        list.add(sb);
        return;
      }
      for (int i = index; i < s.length(); i++) {
        // sb.append(s.charAt(i));
        backtrack(s, i + 1, target, sb + s.charAt(i));
        // sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  /**
   * Your CombinationIterator object will be instantiated and called as such: CombinationIterator obj = new
   * CombinationIterator(characters, combinationLength); String param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */

  /**
   * Your CombinationIterator object will be instantiated and called as such: CombinationIterator obj = new
   * CombinationIterator(characters, combinationLength); String param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
