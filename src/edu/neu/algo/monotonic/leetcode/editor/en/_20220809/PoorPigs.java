package edu.neu.algo.monotonic.leetcode.editor.en._20220809;

import java.util.*;
import edu.neu.util.InputUtil;

public class PoorPigs {
  // 458
  // There are buckets buckets of liquid, where exactly one of the buckets is
  // poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs
  // the liquid to see whether they will die or not. Unfortunately, you only have
  // minutesToTest minutes to determine which bucket is poisonous.
  //
  // You can feed the pigs according to these steps:
  //
  //
  // Choose some live pigs to feed.
  // For each pig, choose which buckets to feed it. The pig will consume all the
  // chosen buckets simultaneously and will take no time.
  // Wait for minutesToDie minutes. You may not feed any other pigs during this
  // time.
  // After minutesToDie minutes have passed, any pigs that have been fed the
  // poisonous bucket will die, and all others will survive.
  // Repeat this process until you run out of time.
  //
  //
  // Given buckets, minutesToDie, and minutesToTest, return the minimum number of
  // pigs needed to figure out which bucket is poisonous within the allotted time.
  //
  //
  // Example 1:
  // Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
  // Output: 5
  // Example 2:
  // Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
  // Output: 2
  // Example 3:
  // Input: buckets = 4, minutesToDie = 15, minutesToTest = 30
  // Output: 2
  //
  //
  // Constraints:
  //
  //
  // 1 <= buckets <= 1000
  // 1 <= minutesToDie <= minutesToTest <= 100
  //
  // Related Topics Math Dynamic Programming Combinatorics 👍 1264 👎 2623

  public static void main(String[] args) {
    Solution solution = new PoorPigs().new Solution();
    String[] data = """
          1000
      15
      60
      4
      15
      15
      4
      15
      30
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.poorPigs((int)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1],
        (int)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
      int states = minutesToTest / minutesToDie + 1;
      return (int)Math.ceil(Math.log(buckets) / Math.log(states));
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
