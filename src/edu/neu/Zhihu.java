package edu.neu;

import edu.neu.util.InputUtil;

import java.util.*;

public class Zhihu {

  public static void main(String[] args) {
    Zhihu zhihu = new Zhihu();
    String[] data = """
      [4,3,-2,9,-4,2,7]
      6
      [5,-7,8,-6,4,1,-9,5]
      5
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = zhihu.solve((int[])params[i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  int solve(int[] nums, int k) {
    int n = nums.length;
    int[] prefix = new int[n + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    int res = Integer.MIN_VALUE;
    deque.add(0);
    for (int i = 0; i < n; i++) {
      prefix[i + 1] += prefix[i] + nums[i];
      int max = prefix[deque.peekFirst()];
      if (res < prefix[i + 1] - max) {
        res = prefix[i + 1] - max;
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, deque.peekFirst(), i + 1)));
      }
      while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i + 1]) {
        deque.pollLast();
      }
      deque.add(i + 1);
      if (i - (deque.peekFirst() - 1) + 1 > k) {
        deque.pollFirst();
      }
    }
    return res;
  }

  public int numSubmatrixSumTarget(int[][] A, int target) {
    int res = 0, m = A.length, n = A[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 1; j < n; j++) {
        A[i][j] += A[i][j - 1];
      }
    }
    Map<Integer, Integer> counter = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        counter.clear();
        counter.put(0, 1);
        int cur = 0;
        for (int k = 0; k < m; k++) {
          cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
          res += counter.getOrDefault(cur - target, 0);
          counter.put(cur, counter.getOrDefault(cur, 0) + 1);
        }
      }
    }
    return res;
  }

  public boolean canChange(String start, String end) {
    int t = 0;
    for (int i = 0; i < start.length(); ++i) {
      if (start.charAt(i) == 'L') {
        while (end.charAt(t) != 'L') {
          t++;
        }
        if (i < t++) {
          return false;
        }
      }
    }

    t = 0;
    for (int i = 0; i < start.length(); ++i) {
      if (start.charAt(i) == 'R') {
        while (end.charAt(t) != 'R') {
          t++;
        }
        if (i > t++) {
          return false;
        }
      }
    }

    return true;
  }

  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    int res = 10;
    int count = 9;
    for (int i = 2; i <= n && i <= 10; i++) {
      count *= (11 - i);
      res += count;
    }
    return res;
  }

  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int total = m * n;
    // The key point is to find out the first position after the move
    int start = total - k % total;
    List<List<Integer>> res = new ArrayList<>();
    for (int index = start; index < total + start; index++) {
      int i = (index % total) / n, j = (index % total) % n;
      // Each column has n elements
      if ((index - start) % n == 0) {
        res.add(new ArrayList<>());
      }
      res.get(res.size() - 1).add(grid[i][j]);
    }
    return res;
  }

  public int calPoints(String[] ops) {
    List<Integer> list = new ArrayList<>();
    for (String op : ops) {
      if ("C".equals(op)) {
        list.remove(list.size() - 1);
      } else if ("D".equals(op)) {
        int tmp = list.get(list.size() - 1);;
        list.add(tmp * 2);
      } else if ("+".equals(op)) {
        int tmp = list.get(list.size() - 1) + list.get(list.size() - 2);
        list.set(list.size() - 1, tmp);
      } else {
        list.add(Integer.parseInt(op));
      }
    }
    int sum = 0;
    for (Integer integer : list) {
      sum += integer;
    }
    return sum;
  }

  public String minimizeResult(String expression) {
    String result = "";
    String[] split = expression.split("\\+");

    for (int i = 0, min = Integer.MAX_VALUE; i < split[0].length(); i++) {
      for (int j = 1; j <= split[1].length(); j++) {
        int curr = (i > 0 ? Integer.parseInt(split[0].substring(0, i)) : 1)
          * (Integer.parseInt(split[0].substring(i)) + Integer.parseInt(split[1].substring(0, j)))
          * (j < split[1].length() ? Integer.parseInt(split[1].substring(j)) : 1);
        if (curr < min) {
          min = curr;
          result = split[0].substring(0, i) + '(' + split[0].substring(i) + '+' + split[1].substring(0, j) + ')'
            + split[1].substring(j);
        }
      }
    }
    return result;
  }

  public long maximumBeauty(int[] flowers, long newFlowers, int target, long full, int partial) {
    Arrays.sort(flowers);
    long n = flowers.length;
    if (flowers[0] >= target) {
      return n * full; // 剪枝，此时所有花园都是完善的
    }

    var leftFlowers = newFlowers - target * n;// 填充后缀后，剩余可以种植的花
    for (var i = 0; i < n; ++i) {
      flowers[i] = Math.min(flowers[i], target);
      leftFlowers += flowers[i];
    }

    var ans = 0L;
    var sumFlowers = 0L;
    for (int i = 0, x = 0; i <= n; ++i) { // 枚举后缀长度 n-i
      if (leftFlowers >= 0) {
        // 计算最长前缀的长度
        while (x < i && (long)flowers[x] * x - sumFlowers <= leftFlowers) {
          sumFlowers += flowers[x++]; // 注意 x 只增不减，这部分的时间复杂度为 O(n)
        }
        var beauty = (n - i) * full; // 计算总美丽值
        if (x > 0) {
          beauty += Math.min((leftFlowers + sumFlowers) / x, (long)target - 1) * partial;
        }
        ans = Math.max(ans, beauty);
      }
      if (i < n) {
        leftFlowers += target - flowers[i];
      }
    }
    return ans;

  }

  public int largestInteger(int num) {
    PriorityQueue<Integer> odd = new PriorityQueue<>(), even = new PriorityQueue<>();
    for (char c : ("" + num).toCharArray()) {
      (c % 2 > 0 ? odd : even).offer('0' - c);
    }
    int result = 0;
    for (char c : ("" + num).toCharArray()) {
      result = result * 10 - (c % 2 > 0 ? odd : even).poll();
    }
    return result;
  }

  public int maximumProduct(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int num : nums) {
      queue.offer(num);
    }
    for (int i = 0; i < k; i++) {
      queue.offer(queue.poll() + 1);
    }
    long prod = 1;
    for (int num : queue) {
      prod = prod * num % 1000000007;
    }
    return (int)prod;
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
