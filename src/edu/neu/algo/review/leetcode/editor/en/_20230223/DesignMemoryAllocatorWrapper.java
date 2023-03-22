package edu.neu.algo.review.leetcode.editor.en._20230223;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class DesignMemoryAllocatorWrapper {
  // 2502
  // You are given an integer n representing the size of a 0-indexed memory array.
  // All memory units are initially free.
  //
  // You have a memory allocator with the following functionalities:
  //
  //
  // Allocate a block of size consecutive free memory units and assign it the id
  // mID.
  // Free all memory units with the given id mID.
  //
  //
  // Note that:
  //
  //
  // Multiple blocks can be allocated to the same mID.
  // You should free all the memory units with mID, even if they were allocated
  // in different blocks.
  //
  //
  // Implement the Allocator class:
  //
  //
  // Allocator(int n) Initializes an Allocator object with a memory array of size
  // n.
  // int allocate(int size, int mID) Find the leftmost block of size consecutive
  // free memory units and allocate it with the id mID. Return the block's first
  // index. If such a block does not exist, return -1.
  // int free(int mID) Free all memory units with the id mID. Return the number
  // of memory units you have freed.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["Allocator", "allocate", "allocate", "allocate", "free", "allocate",
  // "allocate", "allocate", "free", "allocate", "free"]
  // [[10], [1, 1], [1, 2], [1, 3], [2], [3, 4], [1, 1], [1, 1], [1], [10, 2], [7]]
  //
  // Output
  // [null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0]
  //
  // Explanation
  // Allocator loc = new Allocator(10); // Initialize a memory array of size 10.
  // All memory units are initially free.
  // loc.allocate(1, 1); // The leftmost block's first index is 0. The memory
  // array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
  // loc.allocate(1, 2); // The leftmost block's first index is 1. The memory
  // array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
  // loc.allocate(1, 3); // The leftmost block's first index is 2. The memory
  // array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
  // loc.free(2); // Free all memory units with mID 2. The memory array becomes [1,
  // _, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
  // loc.allocate(3, 4); // The leftmost block's first index is 3. The memory
  // array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
  // loc.allocate(1, 1); // The leftmost block's first index is 1. The memory
  // array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
  // loc.allocate(1, 1); // The leftmost block's first index is 6. The memory
  // array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
  // loc.free(1); // Free all memory units with mID 1. The memory array becomes [_,
  // _,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
  // loc.allocate(10, 2); // We can not find any free block with 10 consecutive
  // free memory units, so we return -1.
  // loc.free(7); // Free all memory units with mID 7. The memory array remains
  // the same since there is no memory unit with mID 7. We return 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n, size, mID <= 1000
  // At most 1000 calls will be made to allocate and free.
  //
  //
  // Related Topics Array Hash Table Design Simulation 👍 186 👎 66

  public static void main(String[] args) {
    Allocator instance = new DesignMemoryAllocatorWrapper().new Allocator(10);
    int value0 = instance.allocate(1, 1);
    int value1 = instance.allocate(1, 2);
    int value2 = instance.allocate(1, 3);
    int value3 = instance.free(2);
    int value4 = instance.allocate(3, 4);
    int value5 = instance.allocate(1, 1);
    int value6 = instance.allocate(1, 1);
    int value7 = instance.free(1);
    int value8 = instance.allocate(10, 2);
    int value9 = instance.free(7);

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    System.out.println(value4);
    System.out.println(value5);
    System.out.println(value6);
    System.out.println(value7);
    System.out.println(value8);
    System.out.println(value9);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Allocator {

    TreeSet<Integer> set;
    int[] arr;

    public Allocator(int n) {
      arr = new int[n];
      set = new TreeSet<>();
    }

    public int allocate(int size, int mID) {
      for (int i = 0; i <= arr.length - size; i++) {
        if (arr[i] != 0)
          continue;

        Integer next = set.ceiling(i);
        if (next == null || next - i >= size) {
          set.add(i);
          for (int j = i; j < i + size; j++) {
            arr[j] = mID;
          }
          return i;
        }
      }
      return -1;
    }

    public int free(int mID) {
      int ans = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == mID) {
          arr[i] = 0;
          set.remove(i);
          ans++;
        }
      }
      return ans;
    }
  }

  /**
   * Your Allocator object will be instantiated and called as such: Allocator obj = new Allocator(n); int param_1 =
   * obj.allocate(size,mID); int param_2 = obj.free(mID);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
