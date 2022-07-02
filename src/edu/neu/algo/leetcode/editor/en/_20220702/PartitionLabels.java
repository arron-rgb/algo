package edu.neu.algo.leetcode.editor.en._20220702;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  // Related Topics Hash Table Two Pointers String Greedy 👍 7911 👎 300

  public static void main(String[] args) {
    Solution solution = new PartitionLabels().new Solution();
    String[] data = """
          "ababcbacadefegdehijhklij"
      "eccbbbbdecacafa"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.partitionLabels((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> partitionLabels(String s) {
      // 对于每个字母，统计出现的最晚的位置 i
      // 再看它的区间内出现的字母，计算出现的最晚的位置 j
      // 如果 j>i，再统计一次(i,j)中的字母出现的最晚的位置
      int[] lastIndex = new int[26];
      for (int i = 0; i < s.length(); i++) {
        lastIndex[s.charAt(i) - 'a'] = i;
      }
      int i = 0;
      List<Integer> res = new ArrayList<>();
      for (; i < s.length(); i++) {
        int tmp = i;
        Set<Character> set = new HashSet<>();
        int index = lastIndex[s.charAt(i) - 'a'];
        for (int j = i; j <= index; j++) {
          set.add(s.charAt(i));
          tmp = Math.max(tmp, lastIndex[s.charAt(j) - 'a']);
        }
        // [i, lastIndex[]]中 某个字母的lastIndex超过了 index
        // 就需要更新tmp的位置：重复上述操作
        for (int k = index; k <= tmp; k++) {
          if (!set.contains(s.charAt(k))) {
            set.add(s.charAt(k));
            tmp = Math.max(tmp, lastIndex[s.charAt(k) - 'a']);
          }
        }
        // System.out.println(s.substring(i, tmp + 1));
        res.add(tmp - i + 1);
        i = tmp;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
