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

  public int backPackIII(int[] sizes, int[] values, int m) {
    int n = sizes.length;
    int[] f = new int[m + 1];
    for (int i = 0; i < n; ++i) {
      for (int k = 1; k * sizes[i] <= m; ++k) {
        for (int j = m; j >= sizes[i]; --j) {
          f[j] = Math.max(f[j], f[j - sizes[i]] + values[i]);
        }
      }
    }
    return f[m];
  }

  int sec() {
    int res = 0;
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new int[] {kb.nextInt(), 1});
      list.add(new int[] {kb.nextInt(), -1});
    }
    list.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o2[1] - o1[1];
      }
      return o1[0] - o2[0];
    });
    int pre = 0, preState = 0;
    for (int[] ints : list) {
    }
    return res;
  }

  int backpack() {
    int res = 0;
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] nums = new int[] {10, 30, 50};
    // 共三种面值
    // 一共可使用n次
    // 问有多少种方案能凑出m
    int[][] dp = new int[m + 1][n + 1];
    // dp[i][j]: 表示共j张k，和为i
    // dp[i + num][j + 1] += dp[i][j]
    Arrays.fill(dp[0], 1);
    for (int i = 0; i <= m; i++) {
      for (int num : nums) {
        if (i + num <= m) {
          for (int j = 0; j <= n - 1; j++) {
            dp[i + num][j + 1] += dp[i][j];
          }
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[m][n];
  }

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    // i <= j, nums[i] + nums[j] 完全平方数
    // -1, 1
    // -1, 26
    // 1, 24
    // 1, 15
    // 18, 18
    int backpack = solution.backpack();
    System.out.println(backpack);
    // int[] nums = {-1, 18, 1, 15, 24, 26};
    // int solution1 = solution.solution(nums);
    // System.out.println(solution1);
    // System.out.println(solution.solution2(nums));
    // DoesNotSumToFortyTwoCaseInsensitive
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

  int solution2(int[] nums) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        for (int k = 0; k <= 200; k++) {
          if (nums[i] + nums[j] == k * k) {
            res++;
            break;
          }
        }
      }
    }
    return res;
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

  int solution(int[] nums) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      for (int c = 0; c <= 200; c++) {
        res += map.getOrDefault(c * c - num, 0);
      }
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
