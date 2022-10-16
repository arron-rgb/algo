import edu.neu.algo.leetcode.editor.en._20220707.ShuffleTheArray;
import edu.neu.algo.monotonic.leetcode.editor.en._20220812.FindAllAnagramsInAString;
import edu.neu.base.ListNode;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {

  public static void main(String[] args) throws IOException {
    Weekly solution = new Weekly();
    // String[] data = """
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // // solution
    // // int[] q =
    // // solution.shuffle((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
    // // System.out.println(q);
    // }
    // int[] ints = solution.answerQueries(new int[] {4, 5, 2, 1}, new int[] {3, 10, 21});
    // System.out.println(Arrays.toString(ints));

  }

  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[][] res = new int[k][k];
    int[] row = help(k, rowConditions);
    int[] col = help(k, colConditions);
    if (row.length == 0 || col.length == 0) {
      return res;
    }
    for (int i = 1; i <= k; i++) {
      res[row[i]][col[i]] = i;
    }
    return res;
  }

  int[] help(int k, int[][] conditions) {
    int[] res = new int[k + 1];
    Arrays.fill(res, -1);
    int[] out = new int[k + 1];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : conditions) {
      out[edge[1]]++;
      graph.computeIfAbsent(edge[0], t -> new ArrayList<>()).add(edge[1]);
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 1; i <= k; i++) {
      if (out[i] == 0) {
        deque.add(i);
      }
    }
    int ind = 0;
    while (!deque.isEmpty()) {
      int cur = deque.remove();
      res[cur] = ind++;
      List<Integer> list = graph.getOrDefault(cur, List.of());
      for (int i : list) {
        out[i]--;
        if (out[i] == 0) {
          deque.add(i);
        }
      }
    }
    for (int i = 1; i <= k; i++) {
      if (res[i] == -1) {
        return new int[0];
      }
    }
    return res;
  }

}
