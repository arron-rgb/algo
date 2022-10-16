package edu.neu.algo.monotonic.leetcode.editor.en._20220824;

import java.util.*;
import edu.neu.util.InputUtil;

public class SnapshotArrayOuter {
  // 1146
  // Implement a SnapshotArray that supports the following interface:
  //
  //
  // SnapshotArray(int length) initializes an array-like data structure with the
  // given length. Initially, each element equals 0.
  // void set(index, val) sets the element at the given index to be equal to val.
  //
  // int snap() takes a snapshot of the array and returns the snap_id: the total
  // number of times we called snap() minus 1.
  // int get(index, snap_id) returns the value at the given index, at the time we
  // took the snapshot with the given snap_id
  //
  //
  //
  // Example 1:
  //
  //
  // Input: ["SnapshotArray","set","snap","set","get"]
  // [[3],[0,5],[],[0,6],[0,0]]
  // Output: [null,null,0,null,5]
  // Explanation:
  // SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
  // snapshotArr.set(0,5); // Set array[0] = 5
  // snapshotArr.snap(); // Take a snapshot, return snap_id = 0
  // snapshotArr.set(0,6);
  // snapshotArr.get(0,0); // Get the value of array[0] with snap_id = 0, return 5
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= length <= 5 * 10⁴
  // 0 <= index < length
  // 0 <= val <= 10⁹
  // 0 <= snap_id < (the total number of times we call snap())
  // At most 5 * 10⁴ calls will be made to set, snap, and get.
  //
  // Related Topics Array Hash Table Binary Search Design 👍 1892 👎 277

  public static void main(String[] args) {
    SnapshotArray solution = new SnapshotArrayOuter().new SnapshotArray(5);
    String[] data = """
          ["SnapshotArray","set","snap","set","get"]
      [[3],[0,5],[],[0,6],[0,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    int loop = data.length / paramTypes.length;
    solution.set(0, 5);
    solution.snap();
    solution.set(0, 6);
    solution.get(0, 0);
    solution.set(1, 5);
    solution.snap();
    int i = solution.get(1, 1);
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class SnapshotArray {
    private Node[] rawArr = new Node[50001];
    private int[] snapshotIndex = new int[50001];
    private int snapshotVersion;
    private int rawIndex;

    public SnapshotArray(int length) {}

    public void set(int index, int val) {
      rawArr[rawIndex++] = new Node(index, val);
    }

    public int snap() {
      snapshotIndex[snapshotVersion] = rawIndex;
      return snapshotVersion++;
    }

    public int get(int index, int snap_id) {
      int i = snapshotIndex[snap_id] - 1;
      for (; i >= 0; i--) {
        if (rawArr[i].index == index) {
          return rawArr[i].val;
        }
      }
      return 0;
    }

    class Node {
      int index;
      int val;

      public Node(int index, int val) {
        this.index = index;
        this.val = val;
      }
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
