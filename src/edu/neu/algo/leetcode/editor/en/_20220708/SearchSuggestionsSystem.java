package edu.neu.algo.leetcode.editor.en._20220708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.neu.util.InputUtil;

public class SearchSuggestionsSystem {
  // 1268
  // You are given an array of strings products and a string searchWord.
  //
  // Design a system that suggests at most three product names from products
  // after each character of searchWord is typed. Suggested products should have common
  // prefix with searchWord. If there are more than three products with a common
  // prefix return the three lexicographically minimums products.
  //
  // Return a list of lists of the suggested products after each character of
  // searchWord is typed.
  //
  //
  // Example 1:
  //
  //
  // Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
  // searchWord = "mouse"
  // Output: [
  // ["mobile","moneypot","monitor"],
  // ["mobile","moneypot","monitor"],
  // ["mouse","mousepad"],
  // ["mouse","mousepad"],
  // ["mouse","mousepad"]
  // ]
  // Explanation: products sorted lexicographically = ["mobile","moneypot",
  // "monitor","mouse","mousepad"]
  // After typing m and mo all products match and we show user ["mobile",
  // "moneypot","monitor"]
  // After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
  //
  //
  // Example 2:
  //
  //
  // Input: products = ["havana"], searchWord = "havana"
  // Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
  //
  //
  // Example 3:
  //
  //
  // Input: products = ["bags","baggage","banner","box","cloths"], searchWord =
  // "bags"
  // Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage",
  // "bags"],["bags"]]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= products.length <= 1000
  // 1 <= products[i].length <= 3000
  // 1 <= sum(products[i].length) <= 2 * 10⁴
  // All the strings of products are unique.
  // products[i] consists of lowercase English letters.
  // 1 <= searchWord.length <= 1000
  // searchWord consists of lowercase English letters.
  //
  // Related Topics Array String Trie 👍 3497 👎 173

  public static void main(String[] args) {
    Solution solution = new SearchSuggestionsSystem().new Solution();
    String[] data = """
          ["mobile","mouse","moneypot","monitor","mousepad"]
      "mouse"
      ["havana"]
      "havana"
      ["bags","baggage","banner","box","cloths"]
      "bags"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<String>> q = solution.suggestedProducts((String[])params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Arrays.sort(products, (s1, s2) -> {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
          if (s1.charAt(i) != s2.charAt(i)) {
            return s1.charAt(i) - s2.charAt(i);
          }
        }
        return s1.length() - s2.length();
      });
      List<List<String>> res = new ArrayList<>();
      int n = searchWord.length();
      String prefix = "";
      for (int i = 0; i < n; i++) {
        prefix += searchWord.charAt(i);
        List<String> list = new ArrayList<>();
        for (String product : products) {
          if (product.startsWith(prefix)) {
            list.add(product);
            if (list.size() == 3) {
              break;
            }
          }
        }
        if (list.isEmpty()) {
          break;
        }
        res.add(list);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
