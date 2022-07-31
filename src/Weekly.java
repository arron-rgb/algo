import edu.neu.util.InputUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author arronshentu
 */
public class Weekly {

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    String[] data = """
      [2,2,3,-1]
      0
          1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[],int,int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
  }

  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int n1 = node1, n2 = node2;
    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    while (true) {
      int ans = -1;
      if (n1 == -1 && n2 == -1) {
        break;
      }
      if (n1 != -1) {
        if (s2.contains(n1)) {
          ans = n1;
        }
        if (!s1.add(n1)) {
          n1 = -1;
          continue;
        }
        n1 = edges[n1];
      }
      if (n2 != -1) {
        if (s1.contains(n2)) {
          ans = ans >= 0 ? Math.min(n2, ans) : n2;
        }
        if (!s2.add(n2)) {
          n2 = -1;
          continue;
        }
        n2 = edges[n2];
      }
      if (ans != -1) {
        return ans;
      }
    }
    return -1;
  }

  public int longestCycle(int[] e) {
    int n = e.length, ans = -1;
    int[] v = new int[n];
    for (int i = 0; i < n; ++i) {
      Map<Integer, Integer> map = new HashMap<>();
      ans = Math.max(bfs(e, v, i, map, 0), ans);
    }
    return ans;
  }

  int bfs(int[] e, int[] v, int idx, Map<Integer, Integer> map, int level) {
    if (idx == -1) {
      return -1;
    }
    if (v[idx] == 0) {
      v[idx] = 1;
      map.put(idx, level);
      return bfs(e, v, e[idx], map, 1 + level);
    } else {
      if (map.containsKey(idx)) {
        return level - map.get(idx);
      } else {
        return -1;
      }
    }
  }
}

// class NumArray {
//
// public NumArray(int[] nums) {
//
// }
//
// public void update(int index, int val) {
//
// }
//
// public int sumRange(int left, int right) {
//
// }
//
// int lowbit(int n) {
// return n & -n;
// }
//
// class Array {
// int n;
// int[] tree;
// int[] nums;
//
// public Array(int[] nums) {
// this.n = nums.length;
// this.tree = new int[n + 1];
// this.nums = nums;
// for (int i = 0; i < n; i++) {
// add(i + 1, nums[i]);
// }
// }
//
// void add(int index, int value) {
// for (int i = 0; i < n; i += lowbit(i)) {
// tree[i] += value;
// }
// }
//
// int query(int x) {
// int tmp = 0;
// for (int i = x; i >= 0; i -= lowbit(i)) {
// tmp += tree[i];
// }
// return tmp;
// }
//
// void update(int index, int value) {
// add(index + 1, value - nums[i]);
// nums[i] = value;
// }
// }
// }
