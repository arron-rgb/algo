import edu.neu.util.InputUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author arronshentu
 */
public class Weekly {

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    String[] data = """
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // int[] q = solution.smallestTrimmedNumbers((String[])params[i * paramTypes.length],
      // (int[][])params[2 - 1 + i * paramTypes.length]);
      // System.out.println(Arrays.toString(q));
    }
  }

  static int solve(String str) {
    String programmer = "programmer";
    String head = programmer;
    int i = 0;
    for (; i < str.length(); i++) {
      int pIndex = head.indexOf(str.charAt(i));
      if (pIndex != -1) {
        head = head.substring(0, pIndex).concat(head.substring(pIndex + 1));
      }

      if (head.length() == 0) {
        i++;
        break;
      }
    }

    String tail = programmer;

    int j = str.length() - 1;
    for (; j >= 0; j--) {
      int pIndex = tail.indexOf(str.charAt(j));
      if (pIndex != -1) {
        tail = tail.substring(0, pIndex).concat(tail.substring(pIndex + 1));
      }

      if (tail.length() == 0) {
        j--;
        break;
      }
    }

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

}
