/**
 * @author arronshentu
 */
public class Main6 {

  public static void main(String[] args) {
    // "".lines()
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
