package edu.neu.algo.dp.leetcode.editor.en._20220705;

import java.util.*;

import edu.neu.util.InputUtil;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
  // 1239
  // You are given an array of strings arr. A string s is formed by the
  // concatenation of a subsequence of arr that has unique characters.
  //
  // Return the maximum possible length of s.
  //
  // A subsequence is an array that can be derived from another array by deleting
  // some or no elements without changing the order of the remaining elements.
  //
  //
  // Example 1:
  //
  //
  // Input: arr = ["un","iq","ue"]
  // Output: 4
  // Explanation: All the valid concatenations are:
  // - ""
  // - "un"
  // - "iq"
  // - "ue"
  // - "uniq" ("un" + "iq")
  // - "ique" ("iq" + "ue")
  // Maximum length is 4.
  //
  //
  // Example 2:
  //
  //
  // Input: arr = ["cha","r","act","ers"]
  // Output: 6
  // Explanation: Possible longest valid concatenations are "chaers" ("cha" +
  // "ers") and "acters" ("act" + "ers").
  //
  //
  // Example 3:
  //
  //
  // Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
  // Output: 26
  // Explanation: The only string in arr has all 26 characters.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= arr.length <= 16
  // 1 <= arr[i].length <= 26
  // arr[i] contains only lowercase English letters.
  //
  // Related Topics Array String Backtracking Bit Manipulation 👍 1839 👎 159

  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
    String[] data = """
      ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"]
      ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String[] q = solution.trulyMostPopular((String[])params[1 - 1 + i * paramTypes.length],
        (String[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
      parent = new HashMap<>();
      init(synonyms);
      count = new HashMap<>();
      for (String name : names) {
        String[] split = name.split("\\(");
        String number = split[1].substring(0, split[1].length() - 1);
        String p = getParent(name);
        count.put(p, count.getOrDefault(p, 0) + Integer.parseInt(number));
      }
      final String[] res = new String[count.size()];
      int i = 0;
      for (Map.Entry<String, Integer> entry : count.entrySet()) {
        String k = entry.getKey();
        Integer v = entry.getValue();
        String stringBuilder = k + "(" + v + ")";
        res[i++] = stringBuilder;
      }
      return res;
    }

    Map<String, Integer> count;
    Map<String, String> parent;

    void init(String[] synonyms) {
      for (String s : synonyms) {
        s = s.substring(1, s.length() - 1);
        String[] names = s.split(",");
        union(names[0], names[1]);
      }
    }

    String getParent(String child) {
      String p = parent.getOrDefault(child, child);
      while (!p.equals(parent.getOrDefault(p, p))) {
        // 最后结果是p==child
        p = parent.getOrDefault(p, p);
      }
      return p;
    }

    void union(String c, String b) {
      String smaller = c.compareTo(b) > 0 ? b : c;
      String bigger = b.equals(smaller) ? c : b;
      parent.put(getParent(bigger), getParent(smaller));
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}

class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int right = binarySearch(arr, x);
    int left = right - 1;
    while (k-- > 0) {
      if (left < 0) {
        right++;
      } else if (right >= arr.length) {
        left--;
      } else if (x - arr[left] <= arr[right] - x) {
        left--;
      } else {
        right++;
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = left + 1; i < right; i++) {
      ans.add(arr[i]);
    }
    return ans;
  }

  public int binarySearch(int[] arr, int x) {
    return -1;
  }
}
