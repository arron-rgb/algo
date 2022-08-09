package edu.neu.algo.monotonic.leetcode.editor.en._20220731;

import java.util.*;

import edu.neu.util.InputUtil;

public class RangeSumQueryMutable {
  // 307
  // Given an integer array nums, handle multiple queries of the following types:
  //
  //
  // Update the value of an element in nums.
  // Calculate the sum of the elements of nums between indices left and right
  // inclusive where left <= right.
  //
  //
  // Implement the NumArray class:
  //
  //
  // NumArray(int[] nums) Initializes the object with the integer array nums.
  // void update(int index, int val) Updates the value of nums[index] to be val.
  // int sumRange(int left, int right) Returns the sum of the elements of nums
  // between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
  // nums[right]).
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["NumArray", "sumRange", "update", "sumRange"]
  // [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
  // Output
  // [null, 9, null, 8]
  //
  // Explanation
  // NumArray numArray = new NumArray([1, 3, 5]);
  // numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
  // numArray.update(1, 2); // nums = [1, 2, 5]
  // numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 3 * 10⁴
  // -100 <= nums[i] <= 100
  // 0 <= index < nums.length
  // -100 <= val <= 100
  // 0 <= left <= right < nums.length
  // At most 3 * 10⁴ calls will be made to update and sumRange.
  //
  // Related Topics Array Design Binary Indexed Tree Segment Tree 👍 3184 👎 160

  public static void main(String[] args) {

    String[] data = """
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // }
    NumArray solution = new RangeSumQueryMutable().new NumArray(new int[] {1, 3, 5});
    System.out.println(Arrays.toString(solution.tree));
    System.out.println(solution.sumRange(0, 2));
    solution.update(1, 2);
    System.out.println(solution.sumRange(0, 2));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class NumArray {
    int[] tree;

    int lowbit(int x) {
      return x & -x;
    }

    int query(int x) {
      int ans = 0;
      for (int i = x; i > 0; i -= lowbit(i))
        ans += tree[i];
      return ans;
    }

    void add(int x, int u) {
      for (int i = x; i <= n; i += lowbit(i))
        tree[i] += u;
    }

    int[] nums;
    int n;

    public NumArray(int[] _nums) {
      nums = _nums;
      n = nums.length;
      tree = new int[n + 1];
      for (int i = 0; i < n; i++)
        add(i + 1, nums[i]);
    }

    public void update(int i, int val) {
      add(i + 1, val - nums[i]);
      nums[i] = val;
    }

    public int sumRange(int l, int r) {
      return query(r + 1) - query(l);
    }
  }

  /**
   * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
   * obj.update(index,val); int param_2 = obj.sumRange(left,right);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
