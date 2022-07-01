package edu.neu.algo.leetcode.editor.en._20220628;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.util.InputUtil;

public class PartitionLabels {
  // 763
  // You are given a string s. We want to partition the string into as many parts
  // as possible so that each letter appears in at most one part.
  //
  // Note that the partition is done so that after concatenating all the parts in
  // order, the resultant string should be s.
  //
  // Return a list of integers representing the size of these parts.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "ababcbacadefegdehijhklij"
  // Output: [9,7,8]
  // Explanation:
  // The partition is "ababcbaca", "defegde", "hijhklij".
  // This is a partition so that each letter appears in at most one part.
  // A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
  // splits s into less parts.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "eccbbbbdec"
  // Output: [10]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 500
  // s consists of lowercase English letters.
  //
  // Related Topics Hash Table Two Pointers String Greedy 👍 7882 👎 299

  public static void main(String[] args) {
    Solution solution = new PartitionLabels().new Solution();
    String[] data = """
          "ababcbacadefegdehijhklij"
      "eccbbbbdec"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.partitionLabels((String)params[0 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> partitionLabels(String s) {
      Map<Character, Integer> map = new HashMap<>();
      // filling impact of character's
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        map.put(ch, i);
      }
      // making of result
      List<Integer> res = new ArrayList<>();
      int prev = -1;
      int max = 0;

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        max = Math.max(max, map.get(ch));
        if (max == i) {
          // partition time
          res.add(max - prev);
          prev = max;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
