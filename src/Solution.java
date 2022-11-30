import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author arronshentu
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 17), LocalDate.now()));

  }

  public int minimizeTheDifference(int[][] mat, int target) {

    int m = mat.length;
    int n = mat[0].length;

    int max = 4905;
    boolean[][] dp = new boolean[n][max];
    int res = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      dp[0][mat[0][i]] = true;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < max; j++) {
        for (int k = 0; k < n; k++) {
          if (j - mat[i][k] >= 0 && dp[i - 1][j - mat[i][k]]) {
            dp[i][j] = true;
            break;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (dp[m - 1][i])
        res = Math.min(res, Math.abs(i - target));
    }
    return res;
  }

  class FreqStack {

    Map<Integer, Deque<Integer>> stack;
    Map<Integer, Integer> count;
    Deque<Integer> empty = new ArrayDeque<>();

    public FreqStack() {
      stack = new HashMap<>();
      count = new HashMap<>();
    }

    public void push(int val) {
      int old = count.getOrDefault(val, 0);
      if (stack.getOrDefault(old, empty).contains(val)) {
        stack.get(old).remove(val);
      }
      stack.computeIfAbsent(old + 1, t -> new ArrayDeque<>()).addFirst(val);
      count.put(val, count.getOrDefault(val, 0) + 1);
    }

    public int pop() {
      List<Integer> keys = new ArrayList<>(stack.keySet());
      Collections.sort(keys);
      int n = keys.size();
      int val = stack.get(keys.get(n - 1)).pollFirst();
      if (stack.get(keys.get(n - 1)).isEmpty()) {
        stack.remove(keys.get(n - 1));
      }
      int value = count.getOrDefault(val, 0) - 1;
      count.put(val, value);
      if (value == 0) {
        count.remove(val);
      }
      return val;
    }
  }

}
