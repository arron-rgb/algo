package edu.neu.algo.review.leetcode.editor.en._20221030;

import java.util.*;
import edu.neu.util.InputUtil;

public class MinimumGeneticMutation {
  // 433
  // A gene string can be represented by an 8-character long string, with choices
  // from 'A', 'C', 'G', and 'T'.
  //
  // Suppose we need to investigate a mutation from a gene string start to a gene
  // string end where one mutation is defined as one single character changed in the
  // gene string.
  //
  //
  // For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
  //
  //
  // There is also a gene bank bank that records all the valid gene mutations. A
  // gene must be in bank to make it a valid gene string.
  //
  // Given the two gene strings start and end and the gene bank bank, return the
  // minimum number of mutations needed to mutate from start to end. If there is no
  // such a mutation, return -1.
  //
  // Note that the starting point is assumed to be valid, so it might not be
  // included in the bank.
  //
  //
  // Example 1:
  //
  //
  // Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
  // Output: 1
  //
  //
  // Example 2:
  //
  //
  // Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
  // "AAACGGTA"]
  // Output: 2
  //
  //
  // Example 3:
  //
  //
  // Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
  // "AACCCCCC"]
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // start.length == 8
  // end.length == 8
  // 0 <= bank.length <= 10
  // bank[i].length == 8
  // start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
  //
  //
  // Related Topics Hash Table String Breadth-First Search 👍 1124 👎 118

  public static void main(String[] args) {
    Solution solution = new MinimumGeneticMutation().new Solution();
    String[] data = """
          "AACCGGTT"
      "AACCGGTA"
      ["AACCGGTA"]
      "AACCGGTT"
      "AAACGGTA"
      ["AACCGGTA","AACCGCTA","AAACGGTA"]
      "AAAAACCC"
      "AACCCCCC"
      ["AAAACCCC","AAACCCCC","AACCCCCC"]
      "AACCGGTT"
      "AACCGCTA"
      ["AACCGGTA","AACCGCTA","AAACGGTA"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String, String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minMutation((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1], (String[])params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    static char[] items = new char[] {'A', 'C', 'G', 'T'};
    Set<String> bankSet = new HashSet<>();

    public int minMutation(String S, String T, String[] bank) {
      bankSet.add(S);
      bankSet.addAll(Arrays.asList(bank));
      if (!bankSet.contains(T)) {
        return -1;
      }
      Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
      d1.addLast(S);
      d2.addLast(T);
      Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
      m1.put(S, 0);
      m2.put(T, 0);
      while (!d1.isEmpty() && !d2.isEmpty()) {
        int t = d1.size() <= d2.size() ? update(d1, m1, m2) : update(d2, m2, m1);
        if (t != -1) {
          return t;
        }
      }
      return -1;
    }

    int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other) {
      int m = d.size();
      while (m-- > 0) {
        String s = d.pollFirst();
        char[] cs = s.toCharArray();
        int step = cur.get(s);
        for (int i = 0; i < 8; i++) {
          for (char c : items) {
            if (cs[i] == c) {
              continue;
            }
            char[] clone = cs.clone();
            clone[i] = c;
            String sub = String.valueOf(clone);
            if (!bankSet.contains(sub) || cur.containsKey(sub)) {
              continue;
            }
            if (other.containsKey(sub)) {
              return other.get(sub) + step + 1;
            }
            d.addLast(sub);
            cur.put(sub, step + 1);
          }
        }
      }
      return -1;
    }
  }

  // runtime:1 ms
  // memory:42.2 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
