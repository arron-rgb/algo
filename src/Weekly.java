import edu.neu.util.InputUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author arronshentu
 */
public class Weekly {
  public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    return null;
  }

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    String[] data = """
      [229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.smallestTrimmedNumbers((String[])params[1 - 1 + i * paramTypes.length],
        (int[][])params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  static int solve(String str) {
    String programmer = "programmer";

    String head = programmer;

    int i = 0;
    // programmer
    for (; i < str.length(); i++) {
      int pIndex = head.indexOf(str.charAt(i));
      if (pIndex != -1) {
        head = head.substring(0, pIndex).concat(head.substring(pIndex + 1));
        System.out.println(head);
      }

      if (head.length() == 0) {
        i++;
        break;
      }
    }

    String tail = programmer;

    int j = str.length() - 1;
    // programmer
    for (; j >= 0; j--) {
      int pIndex = tail.indexOf(str.charAt(j));
      if (pIndex != -1) {
        tail = tail.substring(0, pIndex).concat(tail.substring(pIndex + 1));
        // System.out.println(tail);
      }

      if (tail.length() == 0) {
        j--;
        break;
      }
    }

    // System.out.println(head);
    // System.out.println(tail);
    // System.out.println(i);
    // System.out.println(j);

    return j - i + 1;
  }

  public static String gamingArray(List<Integer> arr) {
    int count = 0;
    int max = 0;
    for (int number : arr) {
      if (max < number) {
        max = number;
        count++;
      }
    }
    return count % 2 == 0 ? "ANDY" : "BOB";
  }

  long mod = 1000000007L;
  int[] di = {0, 1, 0, -1};
  int[] dj = {1, 0, -1, 0};

  public int countPaths(int[][] grid) {
    long[][] cnt = new long[grid.length][grid[0].length];
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        queue.add(new Pair(i, j, grid[i][j]));
        cnt[i][j] = 1;
      }
    }
    long ans = 0;
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      ans += cnt[p.i][p.j];

      for (int k = 0; k < 4; ++k) {
        int i2 = di[k] + p.i;
        int j2 = dj[k] + p.j;
        if (i2 >= 0 && i2 < cnt.length && j2 >= 0 && j2 < cnt[0].length && grid[i2][j2] > p.v) {
          cnt[i2][j2] += cnt[p.i][p.j];
          cnt[i2][j2] %= mod;
        }
      }
    }
    return (int)(ans % mod);
  }

  static class Pair implements Comparable<Pair> {
    int i, j;
    int v;

    public Pair(int ii, int jj, int vv) {
      i = ii;
      j = jj;
      v = vv;
    }

    public int compareTo(Pair p) {
      return v - p.v;
    }
  }

  // int mod = (int)(1e9 + 7);

  public int peopleAwareOfSecret(int n, int delay, int forget) {
    long[] anew = new long[n];
    anew[0] = 1;
    long[] cum = new long[n + 1];
    cum[1] = 1;
    for (int i = 1; i < n; i++) {
      anew[i] = cum[Math.max(0, i - delay + 1)] - cum[Math.max(0, i - forget + 1)] + mod;
      anew[i] %= mod;
      cum[i + 1] = cum[i] + anew[i];
      cum[i + 1] %= mod;
    }
    long ans = (cum[n] - cum[Math.max(0, n - forget)] + mod) % mod;
    return (int)ans;
  }

  public int peopleAwareOfSecret2(int n, int delay, int forget) {
    long[] dp = new long[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
      long sum = 0;
      int start = Math.max(i - forget + 1, 0);
      int end = Math.max(i - delay + 1, 0);
      for (int j = start; j < end; ++j) {
        sum += dp[j];
      }
      dp[i] = sum % mod;
    }
    System.out.println(Arrays.toString(dp));
    long ans = IntStream.rangeClosed(Math.max(n - forget + 1, 0), n).mapToLong(i -> dp[i]).sum();
    return (int)(ans % mod);
  }

  int minimumNumbers(int num, int k) {
    int i;
    if (num == 0) {
      return 0;
    }
    for (i = 1; i <= 10; i++) {
      if ((num >= i * k) && ((num - i * k) % 10 == 0)) {
        return i;
      }
    }
    return -1;
  }

  public int longestSubsequence(String s, int k) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    int[] z = new int[n + 1];
    for (int i = 0; i < n; i++) {
      z[i + 1] = z[i] + (chars[i] == '0' ? 1 : 0);
    }
    int ans = z[n];
    char[] h = Integer.toBinaryString(k).toCharArray();
    int m = h.length;
    for (int i = 0; i < n; i++) {
      if (chars[i] == '1') {
        ans = Math.max(ans, z[i] + Math.min(m - 1, n - i));
        int p = 0;
        for (int j = i; j < n && p < m; j++) {
          if (h[p] == '1' && chars[j] == '0') {
            p = Math.min(m, p + (n - j));
            break;
          }
          if (h[p] == '0' && chars[j] == '1') {
          } else {
            p++;
          }
        }
        ans = Math.max(ans, z[i] + p);
      }
    }
    return ans;
  }

  public long sellingWood(int m, int n, int[][] prices) {
    int[][] ps = new int[201][201];
    for (int[] p : prices) {
      ps[p[0]][p[1]] = p[2];
    }

    long[][] dp = new long[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = ps[i][j];
        for (int k = 1; k < i; k++) {
          dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
        }
        for (int k = 1; k < j; k++) {
          dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
        }
      }
    }
    return dp[m][n];
  }

  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> queMax = new LinkedList<>();
    Deque<Integer> queMin = new LinkedList<>();
    int n = nums.length;
    int left = 0, right = 0;
    int ret = 0;
    while (right < n) {
      while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
        queMax.pollLast();
      }
      while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
        queMin.pollLast();
      }
      queMax.offerLast(nums[right]);
      queMin.offerLast(nums[right]);
      while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
        if (nums[left] == queMin.peekFirst()) {
          queMin.pollFirst();
        }
        if (nums[left] == queMax.peekFirst()) {
          queMax.pollFirst();
        }
        left++;
      }
      ret = Math.max(ret, right - left + 1);
      right++;
    }
    return ret;
  }

}
