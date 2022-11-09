package edu.neu.algo.review.leetcode.editor.en._20221109;

import edu.neu.util.InputUtil;

public class OnlineStockSpanWrapper {

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
  // Related Topics Stack Design Monotonic Stack Data Stream 👍 3892 👎 259

  public static void main(String[] args) {
    StockSpanner instance = new OnlineStockSpanWrapper().new StockSpanner();
    int value0 = instance.next(100);
    int value1 = instance.next(80);
    int value2 = instance.next(60);
    int value3 = instance.next(70);
    int value4 = instance.next(60);
    int value5 = instance.next(75);
    int value6 = instance.next(85);

    System.out.println(value0);
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    System.out.println(value4);
    System.out.println(value5);
    System.out.println(value6);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class StockSpanner {

    public StockSpanner() {

    }

    public int next(int price) {
      return 0;
    }
  }

  /**
   * Your StockSpanner object will be instantiated and called as such: StockSpanner obj = new StockSpanner(); int
   * param_1 = obj.next(price);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
