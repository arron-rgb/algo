import edu.neu.util.InputUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author arronshentu
 */
public class Main6 {
  public static void main(String[] args) {
    doTest();
  }

  private static void doTest() {
    double l;
    long start = System.currentTimeMillis();
    for (int i = 0; i < 50; i++) {
      fibImpl(i);
    }
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  private static double fibImpl(int n) {
    if (n == 0)
      return 0.0d;
    if (n == 1)
      return 1d;
    double d = fibImpl(n - 2) + fibImpl(n - 1);
    if (Double.isInfinite(d))
      throw new ArithmeticException("Overflow");
    return d;
  }

  private static int solution(int[] nums, int k) {
    // 给一个数组
    // 选了i就不能选i+1
    // 可以违反k次
    // nums 2e3
    // k 1e3
    int n = nums.length;
    // dp[i][k]: 到第i个的时候 用了k次
    int[][][] dp = new int[n + 1][k + 1][2];
    int res = 0;
    // O(kn)
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
        dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][0] + nums[i - 1]);
        if (j > 0) {
          dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][1] + nums[i - 1]);
        }
        res = Math.max(res, dp[i][j][0]);
        res = Math.max(res, dp[i][j][1]);
      }
    }
    return res;
  }

}
