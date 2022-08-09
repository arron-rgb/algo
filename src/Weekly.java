import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.io.IOException;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {

  public int longestIdealString(String s, int k) {
    int[] count = new int[26];
    int max = 0;
    for (char c : s.toCharArray()) {
      for (int i = Math.max('a', c - k) - 'a'; i <= Math.min('z', c + k - 'a'); i++) {
        count[c - 'a'] = Math.max(count[c - 'a'], count[i]);
      }
      max = Math.max(max, ++count[c - 'a']);
    }
    System.out.println(Arrays.toString(count));
    return max;
  }

  public boolean validPartition(int[] nums) {
    int n = nums.length;
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    dp[2] = nums[0] == nums[1];
    for (int i = 2; i < n; i++) {
      dp[i + 1] =
        (nums[i] == nums[i - 1] && dp[i - 1]) || (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && dp[i - 2])
          || (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && dp[i - 2]);
    }
    return dp[n];
  }

  public long minimumReplacement(int[] nums) {
    int n = nums.length;
    int min = nums[n - 1];
    long count = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] <= min) {
        min = nums[i];
      } else {
        int div = (nums[i] + min - 1) / min;
        count += div - 1;
        min = nums[i] / div;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    String[] data = """
      10
      [[4,1],[1,3],[1,5],[0,5],[3,6],[8,4],[5,7],[6,9],[3,2]]
      [2,7]
           """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int,int[][],int[]]");
    Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // int q = solution.solve((int[])params[i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
    }
  }

}
