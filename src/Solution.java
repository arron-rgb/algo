import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/** * @author arronshentu */
public class Solution {
  public static void main(String[] args) {
    System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 17), LocalDate.now()));
    Solution solution = new Solution();
    // solution.solution(new int[] {25, 35, 872, 228, 53, 278, 872});
    // solution.letterCasePermutation("1a2b");
    Codec codec = solution.new Codec();
    String serialize = codec.serialize(InputUtil.stringToTree("[1,2,3,null,null,4,5,6,7]"));
    System.out.println(serialize);
    TreeNode deserialize = codec.deserialize(serialize);
    System.out.println(deserialize);
  }

  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder s = new StringBuilder();
      dfs(s, root);
      return s.substring(0, s.length() - 1);
    }

    private void dfs(StringBuilder s, TreeNode root) {
      if (root == null) {
        s.append("null").append(",");
        return;
      }
      s.append(root.val).append(",");
      dfs(s, root.left);
      dfs(s, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      // 1,2,null,null,3,4,null,null,5,null,null
      String[] split = data.split(",");
      return deserialize(split, 0);
    }

    private TreeNode deserialize(String[] value, int mid) {
      if (mid >= value.length || "null".equals(value[mid])) {
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(value[mid]));
      root.left = deserialize(value, mid * 2 + 1);
      root.right = deserialize(value, mid * 2 + 2);
      return root;
    }
  }

  long solution(int[] a) {
    long res = 0;
    HashMap<String, Long> hm = new HashMap<>();
    for (int i : a) {
      String s = String.valueOf(i);
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String sorted = new String(c);
      hm.put(sorted, hm.getOrDefault(sorted, 0L) + 1);
    }
    for (long k : hm.values()) {
      long nCr = k * (k - 1) / 2;
      res += nCr;
    }
    return res;
  }

  public int minimumCost(int n, int[][] connections) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    Set<Integer> set = new HashSet<>();
    int costs = 0;
    for (int[] edge : connections) {
      int x = edge[0], y = edge[1], cost = edge[2];
      map.computeIfAbsent(x, t -> new ArrayList<>()).add(new int[] {y, cost});
      map.computeIfAbsent(y, t -> new ArrayList<>()).add(new int[] {x, cost});
    }
    queue.add(new int[] {1, 1, 0});
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0], y = cur[1], cost = cur[2];
      if (set.add(y)) {
        costs += cost;
        for (int[] ints : map.get(y)) {
          queue.add(new int[] {y, ints[0], ints[1]});
        }
      }
    }
    return set.size() == n ? costs : -1;
  }
}
