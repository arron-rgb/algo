package edu.neu.algo.leetcode.editor.en._20220506;

import java.util.*;

public class MinimumGeneticMutation {

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
  // Related Topics Hash Table String Breadth-First Search 👍 884 👎 102

  public static void main(String[] args) {
    Solution solution = new MinimumGeneticMutation().new Solution();
    int i = solution.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"});
    System.out.println(i);
    i = solution.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"});
    System.out.println(i);
    i = solution.minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"});
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minMutation(String start, String end, String[] bank) {
      Set<String> set = new HashSet<>(Arrays.asList(bank));
      Deque<String> queue = new ArrayDeque<>();
      char[] geneSource = {'A', 'C', 'G', 'T'};
      Set<String> visited = new HashSet<>();
      queue.add(start);
      int level = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          String current = queue.poll();
          if (current != null && current.equals(end)) {
            return level;
          }
          char[] chars = current.toCharArray();
          for (int j = 0; j < chars.length; j++) {
            for (char c : geneSource) {
              char tmp = chars[j];
              chars[j] = c;
              String next = new String(chars);
              if (set.contains(next) && !visited.contains(next)) {
                queue.offer(next);
                visited.add(next);
              }
              chars[j] = tmp;
            }
          }
        }
        level++;
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
