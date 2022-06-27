package edu.neu.algo.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class ZigzagConversion {

  // The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
  // of rows like this: (you may want to display this pattern in a fixed font for
  // better legibility)
  //
  //
  // P A H N
  // A P L S I I G
  // Y I R
  //
  //
  // And then read line by line: "PAHNAPLSIIGYIR"
  //
  // Write the code that will take a string and make this conversion given a
  // number of rows:
  //
  //
  // string convert(string s, int numRows);
  //
  //
  //
  // Example 1:
  //
  //
  // Input: s = "PAYPALISHIRING", numRows = 3
  // Output: "PAHNAPLSIIGYIR"
  //
  //
  // Example 2:
  //
  //
  // Input: s = "PAYPALISHIRING", numRows = 4
  // Output: "PINALSIGYAHRPI"
  // Explanation:
  // P I N
  // A L S I G
  // Y A H R
  // P I
  //
  //
  // Example 3:
  //
  //
  // Input: s = "A", numRows = 1
  // Output: "A"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consists of English letters (lower-case and upper-case), ',' and '.'.
  // 1 <= numRows <= 1000
  //
  // Related Topics String 👍 3874 👎 8820

  public static void main(String[] args) {
    Solution solution = new ZigzagConversion().new Solution();
    String[] data = """
          "PAYPALISHIRING"
      3
      "PAYPALISHIRING"
      4
      "A"
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q =
        solution.convert((String)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 1}};

    public String convert(String s, int numRows) {
      if (numRows == 1) {
        return s;
      }
      int n = s.length();
      int t = numRows * 2 - 2;
      int col = (n + t - 1) / t * (numRows - 1);
      char[][] tmp = new char[numRows][col];
      int i = 0, j = 0;
      int nextI, nextJ;
      int direction = 0;
      for (int k = 0; k < n; k++) {
        tmp[i][j] = s.charAt(k);
        nextI = i + directions[direction][0];
        nextJ = j + directions[direction][1];
        if (nextI < 0 || nextJ < 0 || nextI >= numRows || nextJ >= col) {
          direction = (direction + 1) % directions.length;
        }
        i += directions[direction][0];
        j += directions[direction][1];
      }
      StringBuilder stringBuilder = new StringBuilder();
      for (char[] chars : tmp) {
        for (char a : chars) {
          if (a != '\u0000') {
            stringBuilder.append(a);
          }
        }
      }
      return stringBuilder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
