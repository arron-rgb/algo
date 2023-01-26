package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import java.util.*;

public class MaximizeTheConfusionOfAnExam {
  // 2024
  // A teacher is writing a test with n true/false questions, with 'T' denoting
  // true and 'F' denoting false. He wants to confuse the students by maximizing the
  // number of consecutive questions with the same answer (multiple trues or multiple
  // falses in a row).
  //
  // You are given a string answerKey, where answerKey[i] is the original answer
  // to the iᵗʰ question. In addition, you are given an integer k, the maximum number
  // of times you may perform the following operation:
  //
  //
  // Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i]
  // to 'T' or 'F').
  //
  //
  // Return the maximum number of consecutive 'T's or 'F's in the answer key
  // after performing the operation at most k times.
  //
  //
  // Example 1:
  //
  //
  // Input: answerKey = "TTFF", k = 2
  // Output: 4
  // Explanation: We can replace both the 'F's with 'T's to make answerKey =
  // "TTTT".
  // There are four consecutive 'T's.
  //
  //
  // Example 2:
  //
  //
  // Input: answerKey = "TFFT", k = 1
  // Output: 3
  // Explanation: We can replace the first 'T' with an 'F' to make answerKey =
  // "FFFT".
  // Alternatively, we can replace the second 'T' with an 'F' to make answerKey =
  // "TFFF".
  // In both cases, there are three consecutive 'F's.
  //
  //
  // Example 3:
  //
  //
  // Input: answerKey = "TTFTTFTT", k = 1
  // Output: 5
  // Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
  // Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
  // In both cases, there are five consecutive 'T's.
  //
  //
  //
  // Constraints:
  //
  //
  // n == answerKey.length
  // 1 <= n <= 5 * 10⁴
  // answerKey[i] is either 'T' or 'F'
  // 1 <= k <= n
  //
  //
  // Related Topics String Binary Search Sliding Window Prefix Sum 👍 829 👎 18

  public static void main(String[] args) {
    Solution solution = new MaximizeTheConfusionOfAnExam().new Solution();
    String[] data = """
                  "TTFF"
      2
      "TFFT"
      1
      "TTFTTFTT"
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxConsecutiveAnswers((String)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
      return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
      int n = answerKey.length();
      int ans = 0;
      int left = 0, right = 0, sum = 0;
      while (right < n) {
        sum += answerKey.charAt(right) != ch ? 1 : 0;
        while (sum > k) {
          sum -= answerKey.charAt(left++) != ch ? 1 : 0;
        }
        // 每一个循环停止的状态都是 sum = k
        // 并且符合最大连续的条件
        // 所以只需要对each character 求一次max length就可以
        ans = Math.max(ans, right - left + 1);
        right++;
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
