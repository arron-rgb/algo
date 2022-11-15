package edu.neu.algo.review.leetcode.editor.en._20221110;

import edu.neu.util.InputUtil;

public class FindTheIndexOfTheFirstOccurrenceInAString {

  // Given two strings needle and haystack, return the index of the first
  // occurrence of needle in haystack, or -1 if needle is not part of haystack.
  //
  //
  // Example 1:
  //
  //
  // Input: haystack = "sadbutsad", needle = "sad"
  // Output: 0
  // Explanation: "sad" occurs at index 0 and 6.
  // The first occurrence is at index 0, so we return 0.
  //
  //
  // Example 2:
  //
  //
  // Input: haystack = "leetcode", needle = "leeto"
  // Output: -1
  // Explanation: "leeto" did not occur in "leetcode", so we return -1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= haystack.length, needle.length <= 10⁴
  // haystack and needle consist of only lowercase English characters.
  //
  // Related Topics Two Pointers String String Matching 👍 804 👎 60

  public static void main(String[] args) {
    Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    String[] data = """
                  "sadbutsad"
      "sad"
      "leetcode"
      "leeto"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.strStr((String)params[1 - 1 + i * paramTypes.length], (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int strStr(String haystack, String needle) {
      return -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int p = 0;
    for (int q = 1; q < nums.length; q++) {
      if (nums[p] != nums[q]) {
        nums[p + 1] = nums[q];
        p++;
      }
      q++;
    }
    return p + 1;
  }

}
