import java.util.*;

import edu.neu.base.TreeNode;

public class GFG {

  public static void main(String[] args) {
    GFG gfg = new GFG();
    // String s1 = gfg.longestDupSubstring(s);
    // System.out.println(s1);
  }

  public boolean isEvenOddTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean isOdd = true;
    int prev;
    while (!queue.isEmpty()) {
      int size = queue.size();
      prev = -1;
      for (int i = 0; i < size; i++) {
        TreeNode poll = queue.poll();
        if (isOdd && ((poll.val & 1) == 0)) {
          return false;
        } else if (!isOdd && ((poll.val) & 1) == 1) {
          return false;
        }
        if (poll.val < prev) {
          return false;
        }
        prev = poll.val;
      }
      isOdd = !isOdd;
    }
    return true;
  }

  static void findMaxMatrixSize(int[][] arr, int max) {
    int i, j;
    // N size of rows and M size of cols
    int n = arr.length;
    int m = arr[0].length;

    // To store the prefix sum of matrix
    int[][] sum = new int[n + 1][m + 1];
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= m; j++) {
        sum[i][j] = arr[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
      }
    }
    int ans = 0;
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= m; j++) {
        if (i + ans - 1 > n || j + ans - 1 > m) {
          break;
        }
        int mid, lo = ans;
        int hi = Math.min(n - i + 1, m - j + 1);

        while (lo < hi) {
          mid = (hi + lo + 1) / 2;
          if (sum[i + mid - 1][j + mid - 1] + sum[i - 1][j - 1] - sum[i + mid - 1][j - 1]
            - sum[i - 1][j + mid - 1] <= max) {
            lo = mid;
          } else {
            hi = mid - 1;
          }
        }
        ans = Math.max(ans, lo);
      }
    }

    // Print the final answer
    System.out.print(ans + "\n");
  }

  int a = 26;
  int n;
  long mod = (long)Math.pow(2, 32);

  String longestDupSubstring(String s) {
    n = s.length();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = s.charAt(i) - 'a';
    }
    int left = 1, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int startIndex = search(s, mid, nums);
      if (startIndex == -1) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    int startIndex = search(s, right, nums);
    return startIndex == -1 ? "" : s.substring(startIndex, startIndex + right);
  }

  int search(String s, int l, int[] nums) {
    long h = 0, aL = 1;
    for (int i = 0; i < l; i++) {
      h = (h * a + nums[i]) % mod;
    }
    for (int i = 1; i <= l; i++) {
      aL = (aL * a) % mod;
    }
    Map<Long, List<Integer>> map = new HashMap<>();
    map.computeIfAbsent(h, t -> new ArrayList<>()).add(0);
    for (int i = 1; i < n - l + 1; i++) {
      h *= a;
      h = (h - nums[i - 1] * aL % mod + mod) % mod;
      h = (h + nums[i + l - 1]) % mod;
      if (map.containsKey(h)) {
        for (int tmp : map.get(h)) {
          if (s.substring(tmp, tmp + l).equals(s.substring(i, i + l))) {
            return tmp;
          }
        }
      }
      map.computeIfAbsent(h, t -> new ArrayList<>()).add(i);
    }
    return -1;
  }
  // // Driver Code
  // public static void main(String[] args) throws IOException {
  // // int[][] arr = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
  // List<String> strings = Files.readAllLines(Paths.get("/Users/arronshentu/Downloads/input003.txt"));
  // int[][] arr = new int[100][100];
  // for (int i = 0; i < 100; i++) {
  // String s = strings.get(i + 2);
  // arr[i] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  // }
  // // Given target sum
  // // int K = 4;
  //
  // // Function Call
  // findMaxMatrixSize(arr, 7888);
  // }
}

// This code is contributed by 29AjayKumar
