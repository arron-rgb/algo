import java.io.IOException;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) throws IOException {
    Weekly weekly = new Weekly();
    int i = weekly.longestSubsequence("1001010", 5);
    System.out.println(i);
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

  public void duplicateZeros(int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int i : arr) {
      list.add(i);
      if (i == 0) {
        list.add(i);
      }
    }
    System.out.println(list);
    arr = list.stream().limit(arr.length).mapToInt(t -> t).toArray();
    System.out.println(Arrays.toString(arr));
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
