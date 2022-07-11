package edu.neu;

import edu.neu.util.InputUtil;

import java.util.*;

public class Zhihu {

  public static void main(String[] args) {
    Zhihu zhihu = new Zhihu();
    String[] data = """
      "_L__R__R_"
      "L______RR"
      "R_L_"
      "__LR"
      "_R"
      "R_"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // boolean q =
      // zhihu.canChange((String)params[1 - 1 + i * paramTypes.length], (String)params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
    }
  }

  public boolean canChange(String start, String end) {
    if (!start.replace("_", "").equals(end.replace("_", ""))) {
      return false;
    }

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

  class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
      map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
      Integer pre = map.floorKey(start), next = map.ceilingKey(start);
      if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
        map.put(start, end);
        return true;
      }
      return false;
    }
  }

}
