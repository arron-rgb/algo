package edu.neu.algo.monotonic.leetcode.editor.en._20220724;

import java.util.*;
import edu.neu.util.InputUtil;

public class OnlineStockSpan {
  // 901
  // Design an algorithm that collects daily price quotes for some stock and
  // returns the span of that stock's price for the current day.
  //
  // The span of the stock's price today is defined as the maximum number of
  // consecutive days (starting from today and going backward) for which the stock price
  // was less than or equal to today's price.
  //
  //
  // For example, if the price of a stock over the next 7 days were [100,80,60,70,
  // 60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
  //
  //
  // Implement the StockSpanner class:
  //
  //
  // StockSpanner() Initializes the object of the class.
  // int next(int price) Returns the span of the stock's price given that today's
  // price is price.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
  // [[], [100], [80], [60], [70], [60], [75], [85]]
  // Output
  // [null, 1, 1, 1, 2, 1, 4, 6]
  //
  // Explanation
  // StockSpanner stockSpanner = new StockSpanner();
  // stockSpanner.next(100); // return 1
  // stockSpanner.next(80); // return 1
  // stockSpanner.next(60); // return 1
  // stockSpanner.next(70); // return 2
  // stockSpanner.next(60); // return 1
  // stockSpanner.next(75); // return 4, because the last 4 prices (including
  // today's price of 75) were less than or equal to today's price.
  // stockSpanner.next(85); // return 6
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= price <= 10⁵
  // At most 10⁴ calls will be made to next.
  //
  // Related Topics Stack Design Monotonic Stack Data Stream 👍 3066 👎 226

  public static void main(String[] args) {
    StockSpanner solution = new OnlineStockSpan().new StockSpanner();
    String[] data = """
          ["StockSpanner","next","next","next","next","next","next","next"]
      [[],[100],[80],[60],[70],[60],[75],[85]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    System.out.println(solution.next(100));
    System.out.println(solution.next(80));
    System.out.println(solution.next(60));
    System.out.println(solution.next(70));
    System.out.println(solution.next(60));
    System.out.println(solution.next(75));
    System.out.println(solution.next(85));

  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class StockSpanner {

    public StockSpanner() {

    }

    public int next(int price) {
      return -1;
    }
  }

  /**
   * Your StockSpanner object will be instantiated and called as such: StockSpanner obj = new StockSpanner(); int
   * param_1 = obj.next(price);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
