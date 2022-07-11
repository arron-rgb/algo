package edu.neu.algo.dp.leetcode.editor.en._20220710;

import java.util.*;
import edu.neu.util.InputUtil;

public class OpenTheLock {
  // 752
  // You have a lock in front of you with 4 circular wheels. Each wheel has 10
  // slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate
  // freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
  // Each move consists of turning one wheel one slot.
  //
  // The lock initially starts at '0000', a string representing the state of the 4
  // wheels.
  //
  // You are given a list of deadends dead ends, meaning if the lock displays any
  // of these codes, the wheels of the lock will stop turning and you will be unable
  // to open it.
  //
  // Given a target representing the value of the wheels that will unlock the
  // lock, return the minimum total number of turns required to open the lock, or -1 if
  // it is impossible.
  //
  //
  // Example 1:
  //
  //
  // Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
  // Output: 6
  // Explanation:
  // A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
  // 01" -> "1202" -> "0202".
  // Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202"
  // would be invalid,
  // because the wheels of the lock become stuck after the display becomes the
  // dead end "0102".
  //
  //
  // Example 2:
  //
  //
  // Input: deadends = ["8888"], target = "0009"
  // Output: 1
  // Explanation: We can turn the last wheel in reverse to move from "0000" -> "000
  // 9".
  //
  //
  // Example 3:
  //
  //
  // Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
  // target = "8888"
  // Output: -1
  // Explanation: We cannot reach the target without getting stuck.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= deadends.length <= 500
  // deadends[i].length == 4
  // target.length == 4
  // target will not be in the list deadends.
  // target and deadends[i] consist of digits only.
  //
  // Related Topics Array Hash Table String Breadth-First Search 👍 2984 👎 105

  public static void main(String[] args) {
    Solution solution = new OpenTheLock().new Solution();
    String[] data = """
          ["0201","0101","0102","1212","2002"]
      "0202"
      ["8888"]
      "0009"
      ["8887","8889","8878","8898","8788","8988","7888","9888"]
      "8888"
      ["0000"]
      "8888"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.openLock((String[])params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private boolean isFound;

    public int openLock(String[] deadends, String target) {
      // each move turning one wheel slot
      // means one wheel one slot
      Queue<String> queueBegin = new LinkedList<>();
      Queue<String> queueEnd = new LinkedList<>();
      int count = 0; // number of turns
      HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
      HashSet<String> beginVisited = new HashSet<>();
      HashSet<String> endVisited = new HashSet<>();
      if (deads.contains("0000")) {
        return -1;
      }
      if ("0000".equals(target)) {
        return 0;
      }
      queueBegin.offer("0000");
      beginVisited.add("0000");
      queueEnd.offer(target);
      endVisited.add(target);
      while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
        count++;
        if (queueBegin.size() <= queueEnd.size()) {
          bfs(queueBegin, queueEnd, beginVisited, endVisited, deads);
        } else {
          bfs(queueEnd, queueBegin, endVisited, beginVisited, deads);
        }
        if (isFound) {
          return count;
        }
      }
      return -1;
    }

    public void bfs(Queue<String> queue1, Queue<String> queue2, Set<String> beginVisited, Set<String> endVisited,
      Set<String> deads) {

      int size = queue1.size();
      for (int i = 0; i < size; i++) {
        String temp = queue1.poll();
        for (String child : getChildren(temp)) {
          if (endVisited.contains(child)) {
            isFound = true;
            return;
          }
          if (!beginVisited.contains(child) && !deads.contains(child)) {
            queue1.offer(child);
            beginVisited.add(child);
          }
        }
      }

    }

    public List<String> getChildren(String parent) {
      List<String> list = new LinkedList<>();
      char[] chars = parent.toCharArray();
      for (int i = 0; i < 4; i++) {
        char ch = chars[i];
        if (ch == '0') {
          chars[i] = '9';
        } else {
          chars[i] = Character.forDigit(ch - '0' - 1, 10);
        }
        list.add(new String(chars));
        if (ch == '9') {
          chars[i] = '0';
        } else {
          chars[i] = Character.forDigit(ch - '0' + 1, 10);
        }
        list.add(new String(chars));
        chars[i] = ch;
      }
      return list;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
