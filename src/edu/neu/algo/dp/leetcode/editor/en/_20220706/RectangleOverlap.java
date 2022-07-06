package edu.neu.algo.dp.leetcode.editor.en._20220706;

import java.util.*;
import edu.neu.util.InputUtil;

public class RectangleOverlap{
  // 836
  //An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1
//, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the 
//coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, 
//and its left and right edges are parallel to the Y-axis. 
//
// Two rectangles overlap if the area of their intersection is positive. To be 
//clear, two rectangles that only touch at the corner or edges do not overlap. 
//
// Given two axis-aligned rectangles rec1 and rec2, return true if they overlap,
// otherwise return false. 
//
// 
// Example 1: 
// Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//Output: true
// Example 2: 
// Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//Output: false
// Example 3: 
// Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
//Output: false
// 
// 
// Constraints: 
//
// 
// rec1.length == 4 
// rec2.length == 4 
// -10⁹ <= rec1[i], rec2[i] <= 10⁹ 
// rec1 and rec2 represent a valid rectangle with a non-zero area. 
// 
// Related Topics Math Geometry 👍 1448 👎 393

  public static void main(String[] args) {
    Solution solution = new RectangleOverlap().new Solution();
    String[] data = """
    [0,0,2,2]
[1,1,3,3]
[0,0,1,1]
[1,0,2,1]
[0,0,1,1]
[2,2,3,3]
    """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
            boolean q =
       solution.isRectangleOverlap(
            (int[])params[1 -1 + i * paramTypes.length] 
       ,
                  (int[])params[2 -1 + i * paramTypes.length] 
                  );
            System.out.println(q);
          }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}