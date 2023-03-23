import edu.neu.algo.leetcode.editor.en._20220707.ShuffleTheArray;
import edu.neu.algo.monotonic.leetcode.editor.en._20220812.FindAllAnagramsInAString;
import edu.neu.base.ListNode;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {

  class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
      int n = nums.length;
      int res = 0;
      Arrays.sort(nums);
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for (int i = n - 1; i >= 0 && res < n; i--) {
        int k = nums[i];
        Integer v = map.get(k);
        if (v == null) {
          continue;
        }
        Map.Entry<Integer, Integer> entry = map.floorEntry(nums[i] / 2);
        if (entry == null) {
          continue;
        }
        if (entry.getValue() > 1) {
          map.put(entry.getKey(), entry.getValue() - 1);
        } else {
          map.remove(entry.getKey());
        }
        if (v > 1) {
          map.put(nums[i], v - 1);
        } else {
          map.remove(nums[i]);
        }
        res += 2;
      }
      return res;
    }

  }

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    Solution s = solution.new Solution();
    int i = s.maxNumOfMarkedIndices(new int[] {1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47,
      56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78,
      39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10});
    System.out.println(i);
    // [9,2,5,4]
    // [7,6,8]
    // System.out.println(s.maxNumOfMarkedIndices(new int[] {3, 5, 2, 4}));
    // System.out.println(s.maxNumOfMarkedIndices(new int[] {7, 6, 8}));
    // System.out.println(s.maxNumOfMarkedIndices(new int[] {9, 2, 5, 4}));
    // String[] data = """
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // // solution
    // // int[] q =
    // // solution.shuffle((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
    // // System.out.println(q);
    // }
    // int[] ints = solution.answerQueries(new int[] {4, 5, 2, 1}, new int[] {3, 10, 21});
    // System.out.println(Arrays.toString(ints));

  }

  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[][] res = new int[k][k];
    int[] row = help(k, rowConditions);
    int[] col = help(k, colConditions);
    if (row.length == 0 || col.length == 0) {
      return res;
    }
    for (int i = 1; i <= k; i++) {
      res[row[i]][col[i]] = i;
    }
    return res;
  }

  int[] help(int k, int[][] conditions) {
    int[] res = new int[k + 1];
    Arrays.fill(res, -1);
    int[] out = new int[k + 1];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : conditions) {
      out[edge[1]]++;
      graph.computeIfAbsent(edge[0], t -> new ArrayList<>()).add(edge[1]);
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 1; i <= k; i++) {
      if (out[i] == 0) {
        deque.add(i);
      }
    }
    int ind = 0;
    while (!deque.isEmpty()) {
      int cur = deque.remove();
      res[cur] = ind++;
      List<Integer> list = graph.getOrDefault(cur, List.of());
      for (int i : list) {
        out[i]--;
        if (out[i] == 0) {
          deque.add(i);
        }
      }
    }
    for (int i = 1; i <= k; i++) {
      if (res[i] == -1) {
        return new int[0];
      }
    }
    return res;
  }

}
