package edu.neu.algo.leetcode.editor.en._20220502;

import java.util.Arrays;

public class ReorderDataInLogFiles {

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
  // Related Topics Array String Sorting 👍 1661 👎 3883

  public static void main(String[] args) {
    Solution solution = new ReorderDataInLogFiles().new Solution();
    String[] tmp = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
    String[] strings = solution.reorderLogFiles(tmp);
    System.out.println(Arrays.toString(strings));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String[] reorderLogFiles(String[] logs) {
      return Arrays.stream(logs).map(this::parse).sorted((l1, l2) -> {
        if (l1.isLetter && l2.isLetter) {
          int tmp = l1.content.compareTo(l2.content);
          if (tmp == 0) {
            return l1.id.compareTo(l2.id);
          }
          return tmp;
        }
        if (!l1.isLetter && !l2.isLetter) {
          return 0;
        } else if (l1.isLetter) {
          return -1;
        } else {
          return 1;
        }
      }).map(l -> l.raw).toArray(String[]::new);
    }

    Log parse(String log) {
      Log log1 = new Log();
      log1.raw = log;
      log1.id = log.substring(0, log.indexOf(' '));
      log1.content = log.substring(log.indexOf(' ') + 1);
      log1.isLetter = !Character.isDigit(log1.content.charAt(0));
      return log1;
    }

    class Log {
      String id;
      String content;
      String raw;
      boolean isLetter;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
