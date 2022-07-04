package edu.neu.algo.dp.leetcode.editor.en._20220703;

import java.util.TreeMap;

import edu.neu.util.InputUtil;

public class MyCalendarI {
  // 729
  // You are implementing a program to use as your calendar. We can add a new
  // event if adding the event will not cause a double booking.
  //
  // A double booking happens when two events have some non-empty intersection (i.
  // e., some moment is common to both events.).
  //
  // The event can be represented as a pair of integers start and end that
  // represents a booking on the half-open interval [start, end), the range of real numbers
  // x such that start <= x < end.
  //
  // Implement the MyCalendar class:
  //
  //
  // MyCalendar() Initializes the calendar object.
  // boolean book(int start, int end) Returns true if the event can be added to
  // the calendar successfully without causing a double booking. Otherwise, return
  // false and do not add the event to the calendar.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["MyCalendar", "book", "book", "book"]
  // [[], [10, 20], [15, 25], [20, 30]]
  // Output
  // [null, true, false, true]
  //
  // Explanation
  // MyCalendar myCalendar = new MyCalendar();
  // myCalendar.book(10, 20); // return True
  // myCalendar.book(15, 25); // return False, It can not be booked because time 15
  // is already booked by another event.
  // myCalendar.book(20, 30); // return True, The event can be booked, as the
  // first event takes every time less than 20, but not including 20.
  //
  //
  // Constraints:
  //
  //
  // 0 <= start < end <= 10⁹
  // At most 1000 calls will be made to book.
  //
  // Related Topics Binary Search Design Segment Tree Ordered Set 👍 2029 👎 61

  public static void main(String[] args) {
    MyCalendar solution = new MyCalendarI().new MyCalendar();
    String[] data = """
          ["MyCalendar","book","book","book"]
      [[],[10,20],[15,25],[20,30]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {

    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
      map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
      Integer pre = map.floorKey(start), next = map.ceilingKey(start);
      if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
        map.put(start, end);
        return true;
      }
      return false;
    }
  }

  /**
   * Your MyCalendar object will be instantiated and called as such: MyCalendar obj = new MyCalendar(); boolean param_1
   * = obj.book(start,end);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
