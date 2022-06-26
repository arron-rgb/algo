package edu.neu.algo.leetcode.editor.en._20220626;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.neu.util.InputUtil;

public class LongestUncommonSubsequenceII {

  // Given an array of strings strs, return the length of the longest uncommon
  // subsequence between them. If the longest uncommon subsequence does not exist,
  // return -1.
  //
  // An uncommon subsequence between an array of strings is a string that is a
  // subsequence of one string but not the others.
  //
  // A subsequence of a string s is a string that can be obtained after deleting
  // any number of characters from s.
  //
  //
  // For example, "abc" is a subsequence of "aebdc" because you can delete the
  // underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc"
  // include "aebdc", "aeb", and "" (empty string).
  //
  //
  //
  // Example 1:
  // Input: strs = ["aba","cdc","eae"]
  // Output: 3
  // Example 2:
  // Input: strs = ["aaa","aaa","aa"]
  // Output: -1
  //
  //
  // Constraints:
  //
  //
  // 2 <= strs.length <= 50
  // 1 <= strs[i].length <= 10
  // strs[i] consists of lowercase English letters.
  //
  // Related Topics Array Hash Table Two Pointers String Sorting 👍 388 👎 1096

  public static void main(String[] args) {
    Solution solution = new LongestUncommonSubsequenceII().new Solution();
    String[] data = """
          ["aba","cdc","eae"]
      ["aaa","aaa","aa"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findLUSlength((String[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findLUSlength(String[] strs) {
      Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());
      Set<String> duplicates = getDuplicates(strs);
      for (int i = 0; i < strs.length; i++) {
        if (!duplicates.contains(strs[i])) {
          if (i == 0) {
            return strs[0].length();
          }
          for (int j = 0; j < i; j++) {
            if (isSubsequence(strs[j], strs[i])) {
              break;
            }
            if (j == i - 1) {
              return strs[i].length();
            }
          }
        }
      }
      return -1;
    }

    public boolean isSubsequence(String a, String b) {
      int i = 0, j = 0;
      while (i < a.length() && j < b.length()) {
        if (a.charAt(i) == b.charAt(j)) {
          j++;
        }
        i++;
      }
      return j == b.length();
    }

    private Set<String> getDuplicates(String[] strs) {
      Set<String> set = new HashSet<>();
      Set<String> duplicates = new HashSet<>();
      for (String s : strs) {
        if (set.contains(s)) {
          duplicates.add(s);
        }
        set.add(s);
      }
      return duplicates;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
