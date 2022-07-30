package edu.neu.algo.monotonic.leetcode.editor.en._20220730;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReorderDataInLogFiles {
  // 937
  // You are given an array of logs. Each log is a space-delimited string of words,
  // where the first word is the identifier.
  //
  // There are two types of logs:
  //
  //
  // Letter-logs: All words (except the identifier) consist of lowercase English
  // letters.
  // Digit-logs: All words (except the identifier) consist of digits.
  //
  //
  // Reorder these logs so that:
  //
  //
  // The letter-logs come before all digit-logs.
  // The letter-logs are sorted lexicographically by their contents. If their
  // contents are the same, then sort them lexicographically by their identifiers.
  // The digit-logs maintain their relative ordering.
  //
  //
  // Return the final order of the logs.
  //
  //
  // Example 1:
  //
  //
  // Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig",
  // "let3 art zero"]
  // Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1",
  // "dig2 3 6"]
  // Explanation:
  // The letter-log contents are all different, so their ordering is "art can",
  // "art zero", "own kit dig".
  // The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
  //
  //
  // Example 2:
  //
  //
  // Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act
  // zoo"]
  // Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= logs.length <= 100
  // 3 <= logs[i].length <= 100
  // All the tokens of logs[i] are separated by a single space.
  // logs[i] is guaranteed to have an identifier and at least one word after the
  // identifier.
  //
  // Related Topics Array String Sorting 👍 1766 👎 4069

  public static void main(String[] args) {
    Solution solution = new ReorderDataInLogFiles().new Solution();
    String[] data = """
          ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
      ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String[] q = solution.reorderLogFiles((String[])params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String[] reorderLogFiles(String[] logs) {
      List<String> stringList = new ArrayList<>();
      String[] res = new String[logs.length];

      int temp = logs.length - 1;
      for (int i = logs.length - 1; i >= 0; i--) {
        int index = logs[i].indexOf(" ");
        if (Character.isDigit(logs[i].charAt(index + 1))) {
          res[temp--] = logs[i];
        } else {
          stringList.add(logs[i]);
        }
      }

      stringList.sort((o1, o2) -> {
        int index = o1.indexOf(" ");
        int index1 = o2.indexOf(" ");
        int sub = o1.substring(index).compareTo(o2.substring(index1));
        return sub == 0 ? o1.compareTo(o2) : sub;
      });

      for (int i = 0; i < stringList.size(); i++) {
        res[i] = stringList.get(i);
      }

      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
