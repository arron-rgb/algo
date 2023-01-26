package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.util.InputUtil;

import java.util.Arrays;

public class FloodFill {

  // An image is represented by an m x n integer grid image where image[i][j]
  // represents the pixel value of the image.
  //
  // You are also given three integers sr, sc, and color. You should perform a
  // flood fill on the image starting from the pixel image[sr][sc].
  //
  // To perform a flood fill, consider the starting pixel, plus any pixels
  // connected 4-directionally to the starting pixel of the same color as the starting
  // pixel, plus any pixels connected 4-directionally to those pixels (also with the same
  // color), and so on. Replace the color of all of the aforementioned pixels with
  // color.
  //
  // Return the modified image after performing the flood fill.
  //
  //
  // Example 1:
  //
  //
  // Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
  // Output: [[2,2,2],[2,2,0],[2,0,1]]
  // Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
  // e., the red pixel), all pixels connected by a path of the same color as the
  // starting pixel (i.e., the blue pixels) are colored with the new color.
  // Note the bottom corner is not colored 2, because it is not 4-directionally
  // connected to the starting pixel.
  //
  //
  // Example 2:
  //
  //
  // Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
  // Output: [[0,0,0],[0,0,0]]
  // Explanation: The starting pixel is already colored 0, so no changes are made
  // to the image.
  //
  //
  //
  // Constraints:
  //
  //
  // m == image.length
  // n == image[i].length
  // 1 <= m, n <= 50
  // 0 <= image[i][j], color < 2¹⁶
  // 0 <= sr < m
  // 0 <= sc < n
  //
  // Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 6133 ?
  // ? 588

  public static void main(String[] args) {
    Solution solution = new FloodFill().new Solution();
    String[] data = """
                  [[1,1,1],[1,1,0],[1,0,1]]
      1
      1
      2
      [[0,0,0],[0,0,0]]
      0
      0
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q =
        solution.floodFill((int[][])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length],
          (int)params[3 - 1 + i * paramTypes.length], (int)params[4 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      boolean[][] visited = new boolean[image.length][image[0].length];
      if (image[sr][sc] == color) {
        return image;
      }
      dfs(image, sr, sc, color, image[sr][sc], visited);
      return image;
    }

    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    void dfs(int[][] images, int sr, int sc, int color, int origin, boolean[][] visited) {
      if (sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length || visited[sr][sc]
        || images[sr][sc] != origin) {
        return;
      }
      images[sr][sc] = color;
      visited[sr][sc] = true;
      for (int[] direction : directions) {
        dfs(images, sr + direction[0], sc + direction[1], color, origin, visited);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
