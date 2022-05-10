package edu.neu.algo.leetcode.editor.en._20220508;

import java.util.Arrays;

public class DIStringMatch {

  // A permutation perm of n + 1 integers of all the integers in the range [0, n]
  // can be represented as a string s of length n where:
  //
  //
  // s[i] == 'I' if perm[i] < perm[i + 1], and
  // s[i] == 'D' if perm[i] > perm[i + 1].
  //
  //
  // Given a string s, reconstruct the permutation perm and return it. If there
  // are multiple valid permutations perm, return any of them.
  //
  //
  // Example 1:
  // Input: s = "IDID"
  // Output: [0,4,1,3,2]
  // Example 2:
  // Input: s = "III"
  // Output: [0,1,2,3]
  // Example 3:
  // Input: s = "DDI"
  // Output: [3,2,0,1]
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s[i] is either 'I' or 'D'.
  //
  // Related Topics Array Math Two Pointers String Greedy 👍 1670 👎 661

  public static void main(String[] args) {
    Solution solution = new DIStringMatch().new Solution();
    int[] idids = solution.diStringMatch("IDID");
    System.out.println(Arrays.toString(idids));

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] diStringMatch(String s) {
      // let res[0] as 0
      // s[1] == 'I' res[1] = 1
      //
      int[] res = new int[s.length() + 1];
      int left = 0, right = s.length();
      for (int i = 0; i < s.length(); i++) {
        res[i] = s.charAt(i) == 'I' ? left++ : right--;
      }
      res[s.length()] = left;
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
