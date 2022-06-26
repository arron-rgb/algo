package edu.neu.algo.leetcode.editor.en._20220625;

import java.util.*;

import edu.neu.util.InputUtil;

public class RandomPickWithBlacklist {

  // You are given an integer n and an array of unique integers blacklist. Design
  // an algorithm to pick a random integer in the range [0, n - 1] that is not in
  // blacklist. Any integer that is in the mentioned range and not in blacklist should
  // be equally likely to be returned.
  //
  // Optimize your algorithm such that it minimizes the number of calls to the
  // built-in random function of your language.
  //
  // Implement the Solution class:
  //
  //
  // Solution(int n, int[] blacklist) Initializes the object with the integer n
  // and the blacklisted integers blacklist.
  // int pick() Returns a random integer in the range [0, n - 1] and not in
  // blacklist.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
  // [[7, [2, 3, 5]], [], [], [], [], [], [], []]
  // Output
  // [null, 0, 4, 1, 6, 1, 0, 4]
  //
  // Explanation
  // Solution solution = new Solution(7, [2, 3, 5]);
  // solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note
  // that for every call of pick,
  // // 0, 1, 4, and 6 must be equally likely to be returned (i.e.
  // , with probability 1/4).
  // solution.pick(); // return 4
  // solution.pick(); // return 1
  // solution.pick(); // return 6
  // solution.pick(); // return 1
  // solution.pick(); // return 0
  // solution.pick(); // return 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 10⁹
  // 0 <= blacklist.length <= min(10⁵, n - 1)
  // 0 <= blacklist[i] < n
  // All the values of blacklist are unique.
  // At most 2 * 10⁴ calls will be made to pick.
  //
  // Related Topics Hash Table Math Binary Search Sorting Randomized 👍 648 👎 92

  public static void main(String[] args) {
    // Solution solution = new RandomPickWithBlacklist().new Solution();
    String[] data = """
          ["Solution","pick","pick","pick","pick","pick","pick","pick"]
      [[7,[2,3,5]],[],[],[],[],[],[],[]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // List<String> q =
    // solution.pic(
    // (int[])params[1 -1 + i * paramTypes.length]
    // ,
    // (int[])params[2 -1 + i * paramTypes.length]
    // );
    // System.out.println(q);
    // }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public Solution(int n, int[] blacklist) {
      b2w = new HashMap<>();
      random = new Random();
      int m = blacklist.length;
      bound = n - m;
      Set<Integer> black = new HashSet<>();
      for (int b : blacklist) {
        if (b >= bound) {
          black.add(b);
        }
      }

      int w = bound;
      for (int b : blacklist) {
        if (b < bound) {
          while (black.contains(w)) {
            ++w;
          }
          b2w.put(b, w);
          ++w;
        }
      }
    }

    public int pick() {
      int x = random.nextInt(bound);
      return b2w.getOrDefault(x, x);
    }
  }

  /**
   * Your Solution object will be instantiated and called as such: Solution obj = new Solution(n, blacklist); int
   * param_1 = obj.pick();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
