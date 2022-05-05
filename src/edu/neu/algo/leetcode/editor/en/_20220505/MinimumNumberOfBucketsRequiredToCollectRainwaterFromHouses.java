package edu.neu.algo.leetcode.editor.en._20220505;

public class MinimumNumberOfBucketsRequiredToCollectRainwaterFromHouses {

  // You are given a 0-indexed string street. Each character in street is either
  // 'H' representing a house or '.' representing an empty space.
  //
  // You can place buckets on the empty spaces to collect rainwater that falls
  // from the adjacent houses. The rainwater from a house at index i is collected if a
  // bucket is placed at index i - 1 and/or index i + 1. A single bucket, if placed
  // adjacent to two houses, can collect the rainwater from both houses.
  //
  // Return the minimum number of buckets needed so that for every house, there
  // is at least one bucket collecting rainwater from it, or -1 if it is impossible.
  //
  //
  // Example 1:
  //
  //
  // Input: street = "H..H"
  // Output: 2
  // Explanation:
  // We can put buckets at index 1 and index 2.
  // "H..H" -> "HBBH" ('B' denotes where a bucket is placed).
  // The house at index 0 has a bucket to its right, and the house at index 3 has
  // a bucket to its left.
  // Thus, for every house, there is at least one bucket collecting rainwater from
  // it.
  //
  //
  // Example 2:
  //
  //
  // Input: street = ".H.H."
  // Output: 1
  // Explanation:
  // We can put a bucket at index 2.
  // ".H.H." -> ".HBH." ('B' denotes where a bucket is placed).
  // The house at index 1 has a bucket to its right, and the house at index 3 has
  // a bucket to its left.
  // Thus, for every house, there is at least one bucket collecting rainwater from
  // it.
  //
  //
  // Example 3:
  //
  //
  // Input: street = ".HHH."
  // Output: -1
  // Explanation:
  // There is no empty space to place a bucket to collect the rainwater from the
  // house at index 2.
  // Thus, it is impossible to collect the rainwater from all the houses.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= street.length <= 10⁵
  // street[i] is either'H' or '.'.
  //
  // Related Topics String Dynamic Programming Greedy 👍 304 👎 13

  public static void main(String[] args) {
    Solution solution = new MinimumNumberOfBucketsRequiredToCollectRainwaterFromHouses().new Solution();
    int i = solution.minimumBuckets("..");
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumBuckets(String street) {
      if (street.length() < 2) {
        return ".".equals(street) ? 0 : -1;
      }
      int count = 0;
      // 1. replace the char whose left and right are the house
      // 2. replace the char whose left or right is the house
      char[] chars = street.toCharArray();
      boolean[] collected = new boolean[street.length()];
      int n = chars.length;
      for (int i = 1; i + 1 < n; i++) {
        boolean availableForTwoHouse =
          chars[i] == '.' && chars[i - 1] == 'H' && chars[i + 1] == 'H' && !collected[i - 1] && !collected[i + 1];
        if (availableForTwoHouse) {
          chars[i] = 'B';
          collected[i - 1] = true;
          collected[i + 1] = true;
        }
      }
      for (int i = 1; i < n - 1; i++) {
        boolean left = chars[i - 1] == 'H' && !collected[i - 1];
        boolean right = chars[i + 1] == 'H' && !collected[i + 1];
        boolean availableForOneHouse = chars[i] == '.' && (left || right);
        if (availableForOneHouse) {
          if (left) {
            chars[i - 1] = 'B';
            collected[i - 1] = true;
          } else {
            chars[i + 1] = 'B';
            collected[i + 1] = true;
          }
        }
      }
      if (chars[0] == '.' && !collected[1] && chars[1] == 'H') {
        chars[0] = 'B';
        collected[1] = true;
      }
      if (chars[n - 1] == '.' && !collected[n - 2] && chars[n - 2] == 'H') {
        chars[n - 1] = 'B';
        collected[n - 2] = true;
      }
      for (int i = 0; i < n; i++) {
        if (chars[i] == 'B') {
          count++;
        } else if (chars[i] == 'H' && !collected[i]) {
          return -1;
        }
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
