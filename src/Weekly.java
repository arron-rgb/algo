import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) {
    Weekly weekly = new Weekly();
    boolean b = weekly.hasValidPath(new char[][] {{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}});
    System.out.println(b);
  }

  int m;
  int n;

  Set<String> fault = new HashSet<>();

  public boolean hasValidPath(char[][] grid) {
    m = grid.length;
    n = grid[0].length;
    StringBuilder stringBuilder = new StringBuilder();
    return dfs(grid, 0, 0, stringBuilder);
  }

  boolean dfs(char[][] grid, int i, int j, StringBuilder stringBuilder) {
    if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
      return false;
    }
    if (i == m - 1 && j == n - 1) {
      StringBuilder builder = stringBuilder.append(grid[i][j]);
      boolean rest = isValid(builder.toString());
      builder.deleteCharAt(builder.length() - 1);
      return rest;
    }
    stringBuilder.append(grid[i][j]);
    boolean down = dfs(grid, i + 1, j, stringBuilder);
    boolean right = dfs(grid, i, j + 1, stringBuilder);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    return down || right;
  }

  boolean isValid(String tmp) {
    if (fault.contains(tmp)) {
      return false;
    }
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : tmp.toCharArray()) {
      if (deque.isEmpty() && c == ')') {
        return false;
      }
      if (!deque.isEmpty() && deque.peekLast() == '(' && c == ')') {
        deque.poll();
      } else {
        deque.offerLast(c);
      }
    }
    if (!deque.isEmpty()) {
      fault.add(tmp);
      return false;
    }
    return true;
  }

  long mod = (long)(10e9 + 7);
  int[] values = new int[] {1, 2, 4, 7};
  // 7,9 可以取到第四个位置

  public int countTexts(String pressedKeys) {
    long res = 0;
    int i = 0;
    while (i < pressedKeys.length()) {
      char cur = pressedKeys.charAt(i);

      while (i < pressedKeys.length() - 1 && cur == pressedKeys.charAt(i + 1)) {
        i++;
      }

      i++;
    }

    return (int)(res % mod);
  }
}
