package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MyCalendarIIIWrapper {
  // 732
  // A k-booking happens when k events have some non-empty intersection (i.e.,
  // there is some time that is common to all k events.)
  //
  // You are given some events [startTime, endTime), after each given event,
  // return an integer k representing the maximum k-booking between all the previous
  // events.
  //
  // Implement the MyCalendarThree class:
  //
  //
  // MyCalendarThree() Initializes the object.
  // int book(int startTime, int endTime) Returns an integer k representing the
  // largest integer such that there exists a k-booking in the calendar.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
  // [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
  // Output
  // [null, 1, 1, 2, 3, 3, 3]
  //
  // Explanation
  // MyCalendarThree myCalendarThree = new MyCalendarThree();
  // myCalendarThree.book(10, 20); // return 1
  // myCalendarThree.book(50, 60); // return 1
  // myCalendarThree.book(10, 40); // return 2
  // myCalendarThree.book(5, 15); // return 3
  // myCalendarThree.book(5, 10); // return 3
  // myCalendarThree.book(25, 55); // return 3
  //
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= startTime < endTime <= 10⁹
  // At most 400 calls will be made to book.
  //
  //
  // Related Topics Binary Search Design Segment Tree Ordered Set 👍 1774 👎 248

  public static void main(String[] args) {
    MyCalendarThree instance = new MyCalendarIIIWrapper().new MyCalendarThree();
    int value0 = instance.book(10, 20);
    int value1 = instance.book(50, 60);
    int value2 = instance.book(10, 40);
    int value3 = instance.book(5, 15);
    int value4 = instance.book(5, 10);
    int value5 = instance.book(25, 55);

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    System.out.println(value4);
    System.out.println(value5);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
      map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
      map.put(startTime, map.getOrDefault(startTime, 0) + 1);
      map.put(endTime, map.getOrDefault(endTime, 0) - 1);
      int res = 0, cur = 0;
      for (int delta : map.values()) {
        cur += delta;
        res = Math.max(res, cur);
      }
      return res;
    }
  }

  /**
   * Your MyCalendarThree object will be instantiated and called as such: MyCalendarThree obj = new MyCalendarThree();
   * int param_1 = obj.book(startTime,endTime);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
