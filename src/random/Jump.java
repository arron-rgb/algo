package random;

import edu.neu.util.InputUtil;

/**
 * @author arronshentu
 */
public class Jump {
  public static void main(String[] args) {
    Solution solution = new Jump().new Solution();
    String[] data = """
      [2,3,1,1,4]
      [2,3,0,1,4]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int jump = solution.jump((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(jump);
    }
  }

  class Solution {
    public int jump(int[] nums) {
      int count = 0;
      // 每轮开始的位置
      int start = 0;
      int end = 0;
      int max;
      int n = nums.length;
      while (true) {
        if (end >= n - 1) {
          break;
        }
        max = 0;
        // 尝试从start出发, 到这轮最远能到的位置
        for (int i = start; i < end + 1; i++) {
          max = Math.max(max, nums[i] + i);
        }
        // 下一轮
        start = end + 1;
        end = max;
        count++;
      }
      return count;
    }
  }
}
