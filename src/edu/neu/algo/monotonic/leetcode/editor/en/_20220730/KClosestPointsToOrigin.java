package edu.neu.algo.monotonic.leetcode.editor.en._20220730;

import java.util.*;
import java.util.stream.Collectors;

import edu.neu.util.InputUtil;

public class KClosestPointsToOrigin {
  // 973
  // Given an array of points where points[i] = [xi, yi] represents a point on the
  // X-Y plane and an integer k, return the k closest points to the origin (0, 0).
  //
  // The distance between two points on the X-Y plane is the Euclidean distance (
  // i.e., √(x1 - x2)² + (y1 - y2)²).
  //
  // You may return the answer in any order. The answer is guaranteed to be
  // unique (except for the order that it is in).
  //
  //
  // Example 1:
  //
  //
  // Input: points = [[1,3],[-2,2]], k = 1
  // Output: [[-2,2]]
  // Explanation:
  // The distance between (1, 3) and the origin is sqrt(10).
  // The distance between (-2, 2) and the origin is sqrt(8).
  // Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
  // We only want the closest k = 1 points from the origin, so the answer is just [
  // [-2,2]].
  //
  //
  // Example 2:
  //
  //
  // Input: points = [[3,3],[5,-1],[-2,4]], k = 2
  // Output: [[3,3],[-2,4]]
  // Explanation: The answer [[-2,4],[3,3]] would also be accepted.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= points.length <= 10⁴
  // -10⁴ < xi, yi < 10⁴
  //
  // Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority
  // Queue) Quickselect 👍 6135 👎 219

  public static void main(String[] args) {
    Solution solution = new KClosestPointsToOrigin().new Solution();
    String[] data = """
          [[1,3],[-2,2]]
      1
      [[3,3],[5,-1],[-2,4]]
      2
      [[1,3],[-2,2],[2,-2]]
      2
      [[-5,4],[-6,-5],[4,6]]
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q =
        solution.kClosest((int[][])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> getDistance(p2).compareTo(getDistance(p1)));
      for (int[] point : points) {
        queue.add(point);
        if (queue.size() > k) {
          queue.poll();
        }
      }
      return queue.stream().toList().toArray(new int[0][]);
    }

    Double getDistance(int[] points) {
      return Math.pow(points[0], 2) + Math.pow(points[1], 2);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
