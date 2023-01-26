package edu.neu.algo.review.leetcode.editor.en._20221216;

import edu.neu.util.InputUtil;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TopKFrequentWords {

  // Given an array of strings words and an integer k, return the k most frequent
  // strings.
  //
  // Return the answer sorted by the frequency from highest to lowest. Sort the
  // words with the same frequency by their lexicographical order.
  //
  //
  // Example 1:
  //
  //
  // Input: words = ["i","love","leetcode","i","love","coding"], k = 2
  // Output: ["i","love"]
  // Explanation: "i" and "love" are the two most frequent words.
  // Note that "i" comes before "love" due to a lower alphabetical order.
  //
  //
  // Example 2:
  //
  //
  // Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
  // k = 4
  // Output: ["the","is","sunny","day"]
  // Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
  // with the number of occurrence being 4, 3, 2 and 1 respectively.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= words.length <= 500
  // 1 <= words[i].length <= 10
  // words[i] consists of lowercase English letters.
  // k is in the range [1, The number of unique words[i]]
  //
  //
  //
  // Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
  // Related Topics Hash Table String Trie Sorting Heap (Priority Queue) Bucket
  // Sort Counting 👍 6543 👎 305

  public static void main(String[] args) {
    Solution solution = new TopKFrequentWords().new Solution();
    String[] data = """
                  ["i","love","leetcode","i","love","coding"]
      2
      ["the","day","is","sunny","the","the","the","sunny","is","is"]
      4
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.topKFrequent((String[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      Map<String, Integer> map = new HashMap<>();
      for (String word : words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }

      List<Pair> res = new ArrayList<>();
      map.forEach((key, value) -> {
        Pair e = new Pair();
        e.s = key;
        e.i = value;
        res.add(e);
      });
      return res.stream().sorted((o1, o2) -> {
        if (o1.i == o2.i) {
          return o1.s.compareTo(o2.s);
        }
        return -o1.i + o2.i;
      }).limit(k).map(t -> t.s).toList();
    }

    class Pair {
      String s;
      int i;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
