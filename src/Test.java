import java.util.*;

import edu.neu.base.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
class Solution {

  public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    Arrays.sort(flowers, Comparator.comparingInt(o -> o[0]));
    Integer[] index = new Integer[persons.length];
    for (int i = 0; i < persons.length; i++) {
      index[i] = i;
    }
    Arrays.sort(index, Comparator.comparingInt(o -> persons[o]));
    int[] result = new int[persons.length];
    for (int i = 0, j = 0; i < persons.length; i++) {
      for (; j < flowers.length && flowers[j][0] <= persons[index[i]]; j++) {
        queue.offer(flowers[j][1]);
      }
      while (!queue.isEmpty() && queue.peek() < persons[index[i]]) {
        queue.poll();
      }
      result[index[i]] = queue.size();
    }
    return result;
  }

  public int[] countRectangles(int[][] rectangles, int[][] points) {
    int n = rectangles.length, Q = points.length;
    int[][] es = new int[n + Q][];
    System.arraycopy(rectangles, 0, es, 0, n);
    for (int i = 0; i < Q; i++) {
      es[n + i] = new int[] {points[i][0], points[i][1], i};
    }
    Arrays.sort(es, (x, y) -> {
      if (x[0] != y[0]) {
        return -(x[0] - y[0]);
      }
      return x.length - y.length;
    });

    int[] ct = new int[101];
    int[] ans = new int[Q];
    for (int[] e : es) {
      if (e.length == 2) {
        for (int i = 0; i <= e[1]; i++) {
          ct[i]++;
        }
      } else {
        ans[e[2]] = ct[e[1]];
      }
    }
    return ans;

  }

  int getCount(int[] point, int[][] rectangles) {
    int x = point[0];
    int y = point[1];
    int count = 0;
    for (int[] rectangle : rectangles) {
      if (x > rectangle[0] && y > rectangle[1]) {
        break;
      }
      if (x > rectangle[0]) {
        continue;
      }
      if (y > rectangle[1]) {
        continue;
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution test = new Solution();
    int[][] rec = new int[][] {{1, 2}, {3, 4}, {2, 5}};
    Arrays.sort(rec, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o2[1] - o1[1];
      }
      return o2[0] - o1[0];
    });
    System.out.println(Arrays.deepToString(rec));
  }

  int res = 0;

  class Node {
    char val;
    List<Node> child;

    public Node(char val) {
      this.val = val;
      child = new ArrayList<>();
    }
  }

  public int longestPath(int[] parent, String s) {
    int n = s.length();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(s.charAt(i));
    }
    for (int i = 0; i < n; i++) {
      if (parent[i] != -1) {
        nodes[parent[i]].child.add(nodes[i]);
      }
    }
    dfs(nodes[0]);
    return res + 1;
  }

  private int dfs(Node cur) {
    int max = 0;
    for (Node next : cur.child) {
      int len = dfs(next);
      if (next.val != cur.val) {
        res = Math.max(res, max + len + 1);
        max = Math.max(max, len + 1);
      }
    }
    return max;
  }

  int[][] num5;

  public int maxTrailingZeros(int[][] grid) {
    process(grid);
    Map<Integer, Integer> map = new HashMap<>();
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < m; i++) {
      int tmp = 0;
      for (int j = 0; j < n; j++) {
        tmp += num5[j][i];
      }
      map.put(i, tmp);
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

      }
    }
    return max;
  }

  void process(int[][] grid) {
    this.num5 = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int tmp = grid[i][j];
        int count = 0;
        while (tmp > 0 && tmp % 5 == 0) {
          tmp /= 5;
          count++;
        }
        this.num5[i][j] = count;
      }
    }
  }

  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();
    Collections.addAll(bannedSet, banned);
    int maxFrequency = 0;
    Map<String, Integer> frequencies = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int length = paragraph.length();
    for (int i = 0; i <= length; i++) {
      if (i < length && Character.isLetter(paragraph.charAt(i))) {
        sb.append(Character.toLowerCase(paragraph.charAt(i)));
      } else if (sb.length() > 0) {
        String word = sb.toString();
        if (!bannedSet.contains(word)) {
          int frequency = frequencies.getOrDefault(word, 0) + 1;
          frequencies.put(word, frequency);
          maxFrequency = Math.max(maxFrequency, frequency);
        }
        sb.setLength(0);
      }
    }
    String mostCommon = "";
    Set<Map.Entry<String, Integer>> entries = frequencies.entrySet();
    for (Map.Entry<String, Integer> entry : entries) {
      String word = entry.getKey();
      int frequency = entry.getValue();
      if (frequency == maxFrequency) {
        mostCommon = word;
        break;
      }
    }
    return mostCommon;
  }

  public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
    int ans = -1;
    int n = cookbooks.length;
    for (int comb = 0; comb < (1 << n); comb++) {
      int[] cnt = new int[5];
      int x = 0, y = 0;
      for (int i = 0, bit = 1; i < n; i++, bit <<= 1)
        if ((comb & bit) > 0) {
          for (int j = 0; j < 5; j++)
            cnt[j] += cookbooks[i][j];
          x += attribute[i][0];
          y += attribute[i][1];
        }
      boolean good = true;
      for (int i = 0; i < 5 && good; i++)
        if (cnt[i] > materials[i])
          good = false;
      if (good && y >= limit)
        ans = Math.max(ans, x);
    }
    return ans;
  }

  ArrayList<Integer> arr = new ArrayList<>();

  void dfs(TreeNode node) {
    if (node == null)
      return;
    dfs(node.left);
    arr.add(node.val);
    dfs(node.right);
  }

  public int getNumber(TreeNode root, int[][] ops) {
    dfs(root);
    int n = ops.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
    for (int i = 0; i < n; i++) {
      pq.add(new int[] {1, i, ops[i][1]});
      pq.add(new int[] {2, i, ops[i][2] + 1});
    }
    int ans = 0;
    TreeSet<Integer> ts = new TreeSet<>();
    for (int x : arr) {
      while (!pq.isEmpty() && pq.peek()[2] <= x) {
        int[] e = pq.poll();
        int type = e[0], idx = e[1];
        if (type == 1)
          ts.add(idx);
        else
          ts.remove(idx);
      }
      if (!ts.isEmpty()) {
        int idx = ts.last();
        if (ops[idx][0] == 1)
          ans++;
      }
    }
    return ans;
  }

  public int findClosestNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.compute(i, (k, v) -> v == null ? 1 : v + 1);
    }
    int max = 100001;
    int res = -1;
    for (int x : nums) {
      if (Math.abs(x) < max) {
        max = Math.abs(x);
        res = x;
      } else if (Math.abs(x) == max) {
        if (x > res) {
          res = x;
        }
      }
    }
    return res;
  }

  long waysToBuyPensPencils(int total, int cost1, int cost2) {
    long sum = 0;
    long cost1Num = total / cost1;
    for (int i = 0; i <= cost1Num; i++) {
      int max = 1;
      if (total - cost1 * i >= cost2) {
        max += (total - cost1 * i) / cost2;
      }
      sum += max;
    }
    return sum;
  }
}
