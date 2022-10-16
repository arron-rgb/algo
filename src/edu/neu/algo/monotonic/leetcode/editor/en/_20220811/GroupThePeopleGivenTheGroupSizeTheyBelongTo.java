package edu.neu.algo.monotonic.leetcode.editor.en._20220811;

import java.util.*;
import edu.neu.util.InputUtil;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
  // 1282
  // There are n people that are split into some unknown number of groups. Each
  // person is labeled with a unique ID from 0 to n - 1.
  //
  // You are given an integer array groupSizes, where groupSizes[i] is the size
  // of the group that person i is in. For example, if groupSizes[1] = 3, then person 1
  // must be in a group of size 3.
  //
  // Return a list of groups such that each person i is in a group of size
  // groupSizes[i].
  //
  // Each person should appear in exactly one group, and every person must be in
  // a group. If there are multiple answers, return any of them. It is guaranteed
  // that there will be at least one valid solution for the given input.
  //
  //
  // Example 1:
  //
  //
  // Input: groupSizes = [3,3,3,3,3,1,3]
  // Output: [[5],[0,1,2],[3,4,6]]
  // Explanation:
  // The first group is [5]. The size is 1, and groupSizes[5] = 1.
  // The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1]
  // = groupSizes[2] = 3.
  // The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] =
  // groupSizes[6] = 3.
  // Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
  //
  //
  // Example 2:
  //
  //
  // Input: groupSizes = [2,1,3,3,3,2]
  // Output: [[1],[0,5],[2,3,4]]
  //
  //
  //
  // Constraints:
  //
  //
  // groupSizes.length == n
  // 1 <= n <= 500
  // 1 <= groupSizes[i] <= n
  //
  // Related Topics Array Hash Table 👍 1162 👎 489

  public static void main(String[] args) {
    Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo().new Solution();
    String[] data = """
          [3,3,3,3,3,1,3]
      [2,1,3,3,3,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.groupThePeople((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
      List<List<Integer>> ans = new ArrayList<>();
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < groupSizes.length; i++) {
        map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
      }
      map.forEach((k, v) -> {
        // groupSize -> ids
        List<Integer> temp = new ArrayList<>();
        for (int item : v) {
          temp.add(item);
          if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            temp.clear();
          }
        }
      });
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      count.put(p.charAt(i), count.getOrDefault(p.charAt(i), 0) + 1);
    }
    int n = p.length();
    int m = s.length();
    Map<Character, Integer> window = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int left = 0, right = 0;
    while (right < m) {
      if (right - left < n) {
        right++;
        window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
      } else {
        window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
        if (window.get(s.charAt(left)) == 0) {
          window.remove(s.charAt(left));
        }
        left++;
        right++;
        window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
      }
      if (window.equals(count)) {
        list.add(left);
      }
    }
    return list;
  }

}
