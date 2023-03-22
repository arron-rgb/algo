package edu.neu.algo.review.leetcode.editor.en._20230130;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class NumberOfOrdersInTheBacklog {
  // 1801
  // You are given a 2D integer array orders, where each orders[i] = [pricei,
  // amounti, orderTypei] denotes that amounti orders have been placed of type orderTypei
  // at the price pricei. The orderTypei is:
  //
  //
  // 0 if it is a batch of buy orders, or
  // 1 if it is a batch of sell orders.
  //
  //
  // Note that orders[i] represents a batch of amounti independent orders with
  // the same price and order type. All orders represented by orders[i] will be placed
  // before all orders represented by orders[i+1] for all valid i.
  //
  // There is a backlog that consists of orders that have not been executed. The
  // backlog is initially empty. When an order is placed, the following happens:
  //
  //
  // If the order is a buy order, you look at the sell order with the smallest
  // price in the backlog. If that sell order's price is smaller than or equal to the
  // current buy order's price, they will match and be executed, and that sell order
  // will be removed from the backlog. Else, the buy order is added to the backlog.
  // Vice versa, if the order is a sell order, you look at the buy order with the
  // largest price in the backlog. If that buy order's price is larger than or equal
  // to the current sell order's price, they will match and be executed, and that
  // buy order will be removed from the backlog. Else, the sell order is added to the
  // backlog.
  //
  //
  // Return the total amount of orders in the backlog after placing all the
  // orders from the input. Since this number can be large, return it modulo 10⁹ + 7.
  //
  //
  // Example 1:
  //
  //
  // Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
  // Output: 6
  // Explanation: Here is what happens with the orders:
  // - 5 orders of type buy with price 10 are placed. There are no sell orders, so
  // the 5 orders are added to the backlog.
  // - 2 orders of type sell with price 15 are placed. There are no buy orders
  // with prices larger than or equal to 15, so the 2 orders are added to the backlog.
  // - 1 order of type sell with price 25 is placed. There are no buy orders with
  // prices larger than or equal to 25 in the backlog, so this order is added to the
  // backlog.
  // - 4 orders of type buy with price 30 are placed. The first 2 orders are
  // matched with the 2 sell orders of the least price, which is 15 and these 2 sell
  // orders are removed from the backlog. The 3ʳᵈ order is matched with the sell order of
  // the least price, which is 25 and this sell order is removed from the backlog.
  // Then, there are no more sell orders in the backlog, so the 4ᵗʰ order is added to
  // the backlog.
  // Finally, the backlog has 5 buy orders with price 10, and 1 buy order with
  // price 30. So the total number of orders in the backlog is 6.
  //
  //
  // Example 2:
  //
  //
  // Input: orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
  // Output: 999999984
  // Explanation: Here is what happens with the orders:
  // - 10⁹ orders of type sell with price 7 are placed. There are no buy orders,
  // so the 10⁹ orders are added to the backlog.
  // - 3 orders of type buy with price 15 are placed. They are matched with the 3
  // sell orders with the least price which is 7, and those 3 sell orders are removed
  // from the backlog.
  // - 999999995 orders of type buy with price 5 are placed. The least price of a
  // sell order is 7, so the 999999995 orders are added to the backlog.
  // - 1 order of type sell with price 5 is placed. It is matched with the buy
  // order of the highest price, which is 5, and that buy order is removed from the
  // backlog.
  // Finally, the backlog has (1000000000-3) sell orders with price 7, and (9999999
  // 95-1) buy orders with price 5. So the total number of orders = 1999999991,
  // which is equal to 999999984 % (10⁹ + 7).
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= orders.length <= 10⁵
  // orders[i].length == 3
  // 1 <= pricei, amounti <= 10⁹
  // orderTypei is either 0 or 1.
  //
  //
  // Related Topics Array Heap (Priority Queue) Simulation 👍 231 👎 208

  public static void main(String[] args) {
    Solution solution = new NumberOfOrdersInTheBacklog().new Solution();
    String[] data = """
                  [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
      [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.getNumberOfBacklogOrders((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
      PriorityQueue<int[]> sellers = new PriorityQueue<>(Comparator.comparingInt(t -> t[0]));
      PriorityQueue<int[]> buyers = new PriorityQueue<>(Comparator.comparingInt(t -> -t[0]));
      int res = 0;
      int mod = (int)(1e9 + 7);
      for (int[] order : orders) {
        // buy
        int price = order[0], amount = order[1], orderType = order[2];
        if (order[2] == 0) {
          while (amount > 0 && !sellers.isEmpty() && sellers.peek()[0] <= price) {
            int[] sellOrder = sellers.poll();
            int sellAmount = Math.min(amount, sellOrder[1]);
            amount -= sellAmount;
            sellOrder[1] -= sellAmount;
            if (sellOrder[1] > 0) {
              sellers.offer(sellOrder);
            }
          }
          if (amount > 0) {
            buyers.offer(new int[] {price, amount});
          }
        } else {
          while (amount > 0 && !buyers.isEmpty() && buyers.peek()[0] >= price) {
            int[] buyOrder = buyers.poll();
            int buyAmount = Math.min(amount, buyOrder[1]);
            amount -= buyAmount;
            buyOrder[1] -= buyAmount;
            if (buyOrder[1] > 0) {
              buyers.offer(buyOrder);
            }
          }
          if (amount > 0) {
            sellers.offer(new int[] {price, amount});
          }
        }
      }

      for (PriorityQueue<int[]> queue : Arrays.asList(sellers, buyers)) {
        while (!queue.isEmpty()) {
          res = (res + queue.poll()[1]) % mod;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
