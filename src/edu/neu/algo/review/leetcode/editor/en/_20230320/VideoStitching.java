package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class VideoStitching {
  // 1024
  // You are given a series of video clips from a sporting event that lasted time
  // seconds. These video clips can be overlapping with each other and have varying
  // lengths.
  //
  // Each video clip is described by an array clips where clips[i] = [starti,
  // endi] indicates that the ith clip started at starti and ended at endi.
  //
  // We can cut these clips into segments freely.
  //
  //
  // For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
  //
  //
  //
  // Return the minimum number of clips needed so that we can cut the clips into
  // segments that cover the entire sporting event [0, time]. If the task is
  // impossible, return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
  // Output: 3
  // Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
  // Then, we can reconstruct the sporting event as follows:
  // We cut [1,9] into segments [1,2] + [2,8] + [8,9].
  // Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0,
  // 10].
  //
  //
  // Example 2:
  //
  //
  // Input: clips = [[0,1],[1,2]], time = 5
  // Output: -1
  // Explanation: We cannot cover [0,5] with only [0,1] and [1,2].
  //
  //
  // Example 3:
  //
  //
  // Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2
  // ,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
  // Output: 3
  // Explanation: We can take clips [0,4], [4,7], and [6,9].
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= clips.length <= 100
  // 0 <= starti <= endi <= 100
  // 1 <= time <= 100
  //
  //
  // Related Topics Array Dynamic Programming Greedy 👍 1489 👎 52

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
      10
      [[0,1],[1,2]]
      5
      [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]
      9
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.videoStitching((int[][])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int videoStitching(int[][] clips, int time) {
      int[] maxn = new int[time];
      int last = 0, ret = 0, pre = 0;
      for (int[] clip : clips) {
        if (clip[0] < time) {
          maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
        }
      }
      for (int i = 0; i < time; i++) {
        last = Math.max(last, maxn[i]);
        if (i == last) {
          return -1;
        }
        if (i == pre) {
          ret++;
          pre = last;
        }
      }
      return ret;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
