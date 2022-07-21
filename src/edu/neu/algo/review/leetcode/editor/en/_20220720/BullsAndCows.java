package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class BullsAndCows {
  // 299
  // You are playing the Bulls and Cows game with your friend.
  //
  // You write down a secret number and ask your friend to guess what the number
  // is. When your friend makes a guess, you provide a hint with the following info:
  //
  //
  // The number of "bulls", which are digits in the guess that are in the correct
  // position.
  // The number of "cows", which are digits in the guess that are in your secret
  // number but are located in the wrong position. Specifically, the non-bull digits
  // in the guess that could be rearranged such that they become bulls.
  //
  //
  // Given the secret number secret and your friend's guess guess, return the
  // hint for your friend's guess.
  //
  // The hint should be formatted as "xAyB", where x is the number of bulls and y
  // is the number of cows. Note that both secret and guess may contain duplicate
  // digits.
  //
  //
  // Example 1:
  //
  //
  // Input: secret = "1807", guess = "7810"
  // Output: "1A3B"
  // Explanation: Bulls are connected with a '|' and cows are underlined:
  // "1807"
  // |
  // "7810"
  //
  // Example 2:
  //
  //
  // Input: secret = "1123", guess = "0111"
  // Output: "1A1B"
  // Explanation: Bulls are connected with a '|' and cows are underlined:
  // "1123" "1123"
  // | or |
  // "0111" "0111"
  // Note that only one of the two unmatched 1s is counted as a cow since the non-
  // bull digits can only be rearranged to allow one 1 to be a bull.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= secret.length, guess.length <= 1000
  // secret.length == guess.length
  // secret and guess consist of digits only.
  //
  // Related Topics Hash Table String Counting 👍 1512 👎 1412

  public static void main(String[] args) {
    Solution solution = new BullsAndCows().new Solution();
    String[] data = """
          "1807"
      "7810"
      "1123"
      "0111"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q =
        solution.getHint((String)params[1 + i * paramTypes.length - 1], (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String getHint(String secret, String guess) {
      int x = 0;
      int n = secret.length();
      int[] secrets = new int[10];
      int[] guesses = new int[10];
      for (int i = 0; i < n; i++) {
        char c = secret.charAt(i);
        char g = guess.charAt(i);
        if (c == g) {
          // 位置上匹配的
          x++;
        } else {
          secrets[c - '0']++;
          guesses[g - '0']++;
        }
      }
      // 统计一下字符有多少一样 然后减去x
      int y = 0;
      for (int j = 0; j < secrets.length; j++) {
        y += Math.min(guesses[j], secrets[j]);
      }
      return String.format("%dA%dB", x, y);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
