package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SingleThreadedCPU {
  // 1834
  // You are given n tasks labeled from 0 to n - 1 represented by a 2D integer
  // array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the ith
  // task will be available to process at enqueueTimei and will take processingTimei to
  // finish processing.
  //
  // You have a single-threaded CPU that can process at most one task at a time
  // and will act in the following way:
  //
  //
  // If the CPU is idle and there are no available tasks to process, the CPU
  // remains idle.
  // If the CPU is idle and there are available tasks, the CPU will choose the
  // one with the shortest processing time. If multiple tasks have the same shortest
  // processing time, it will choose the task with the smallest index.
  // Once a task is started, the CPU will process the entire task without
  // stopping.
  // The CPU can finish a task then start a new one instantly.
  //
  //
  // Return the order in which the CPU will process the tasks.
  //
  //
  // Example 1:
  //
  //
  // Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
  // Output: [0,2,3,1]
  // Explanation: The events go as follows:
  // - At time = 1, task 0 is available to process. Available tasks = {0}.
  // - Also at time = 1, the idle CPU starts processing task 0. Available tasks = {
  // }.
  // - At time = 2, task 1 is available to process. Available tasks = {1}.
  // - At time = 3, task 2 is available to process. Available tasks = {1, 2}.
  // - Also at time = 3, the CPU finishes task 0 and starts processing task 2 as
  // it is the shortest. Available tasks = {1}.
  // - At time = 4, task 3 is available to process. Available tasks = {1, 3}.
  // - At time = 5, the CPU finishes task 2 and starts processing task 3 as it is
  // the shortest. Available tasks = {1}.
  // - At time = 6, the CPU finishes task 3 and starts processing task 1.
  // Available tasks = {}.
  // - At time = 10, the CPU finishes task 1 and becomes idle.
  //
  //
  // Example 2:
  //
  //
  // Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
  // Output: [4,3,2,0,1]
  // Explanation: The events go as follows:
  // - At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
  // - Also at time = 7, the idle CPU starts processing task 4. Available tasks = {
  // 0,1,2,3}.
  // - At time = 9, the CPU finishes task 4 and starts processing task 3.
  // Available tasks = {0,1,2}.
  // - At time = 13, the CPU finishes task 3 and starts processing task 2.
  // Available tasks = {0,1}.
  // - At time = 18, the CPU finishes task 2 and starts processing task 0.
  // Available tasks = {1}.
  // - At time = 28, the CPU finishes task 0 and starts processing task 1.
  // Available tasks = {}.
  // - At time = 40, the CPU finishes task 1 and becomes idle.
  //
  //
  //
  // Constraints:
  //
  //
  // tasks.length == n
  // 1 <= n <= 10⁵
  // 1 <= enqueueTimei, processingTimei <= 10⁹
  //
  //
  // Related Topics Array Sorting Heap (Priority Queue) 👍 2678 👎 229

  public static void main(String[] args) {
    Solution solution = new SingleThreadedCPU().new Solution();
    String[] data = """
                  [[1,2],[2,4],[3,2],[4,1]]
      [[7,10],[7,12],[7,5],[7,4],[7,2]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.getOrder((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] getOrder(int[][] tasks) {
      int n = tasks.length;

      List<Integer> idx = new ArrayList<>();
      for (int i = 0; i < n; i++)
        idx.add(i);
      idx.sort(Comparator.comparingInt(o -> tasks[o][0]));

      Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
        // cpu取task的策略：1. 创建早 2. 耗时短
        // heap里放processingTime和idx
        // processingTime小/ id小优先
        if (o1[0] != o2[0])
          return Integer.compare(o1[0], o2[0]);
        return Integer.compare(o1[1], o2[1]);
      });
      // 先按startTime排序
      // 然后再在堆中取
      int[] res = new int[n];
      int k = 0, time = 0;
      // k是已入队的task数量

      // i拿来填充res数组
      for (int i = 0; i < n; i++) {
        if (heap.isEmpty())
          time = Math.max(time, tasks[idx.get(k)][0]);
        // 只要k < n并且 第k个耗费时间短的task的入队时间 <= time
        // 就把它放入队列
        while (k < n && tasks[idx.get(k)][0] <= time) {
          heap.offer(new int[] {tasks[idx.get(k)][1], idx.get(k)});
          k++;
        }

        int[] t = heap.poll();
        time += t[0];
        res[i] = t[1];
      }

      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
