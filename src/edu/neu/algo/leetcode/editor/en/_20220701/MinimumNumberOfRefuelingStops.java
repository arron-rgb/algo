package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.*;
import edu.neu.util.InputUtil;

public class MinimumNumberOfRefuelingStops{
  // 871
  //A car travels from a starting position to a destination which is target miles 
//east of the starting position. 
//
// There are gas stations along the way. The gas stations are represented as an 
//array stations where stations[i] = [positioni, fueli] indicates that the iᵗʰ 
//gas station is positioni miles east of the starting position and has fueli liters 
//of gas. 
//
// The car starts with an infinite tank of gas, which initially has startFuel 
//liters of fuel in it. It uses one liter of gas per one mile that it drives. When 
//the car reaches a gas station, it may stop and refuel, transferring all the gas 
//from the station into the car. 
//
// Return the minimum number of refueling stops the car must make in order to 
//reach its destination. If it cannot reach the destination, return -1. 
//
// Note that if the car reaches a gas station with 0 fuel left, the car can 
//still refuel there. If the car reaches the destination with 0 fuel left, it is 
//still considered to have arrived. 
//
// 
// Example 1: 
//
// 
//Input: target = 1, startFuel = 1, stations = []
//Output: 0
//Explanation: We can reach the target without refueling.
// 
//
// Example 2: 
//
// 
//Input: target = 100, startFuel = 1, stations = [[10,100]]
//Output: -1
//Explanation: We can not reach the target (or even the first gas station).
// 
//
// Example 3: 
//
// 
//Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,4
//0]]
//Output: 2
//Explanation: We start with 10 liters of fuel.
//We drive to position 10, expending 10 liters of fuel.  We refuel from 0 
//liters to 60 liters of gas.
//Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//and refuel from 10 liters to 50 liters of gas.  We then drive to and reach 
//the target.
//We made 2 refueling stops along the way, so we return 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= target, startFuel <= 10⁹ 
// 0 <= stations.length <= 500 
// 0 <= positioni <= positioni+1 < target 
// 1 <= fueli < 10⁹ 
// 
// Related Topics Array Dynamic Programming Greedy Heap (Priority Queue) 👍 2590
// 👎 49

  public static void main(String[] args) {
    Solution solution = new MinimumNumberOfRefuelingStops().new Solution();
    String[] data = """
    1
1
[]
100
1
[[10,100]]
100
10
[[10,60],[20,30],[30,30],[60,40]]
    """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
            int q =
       solution.minRefuelStops(
            (int)params[1 -1 + i * paramTypes.length] 
       ,
                  (int)params[2 -1 + i * paramTypes.length] 
       ,
                  (int[][])params[3 -1 + i * paramTypes.length] 
                  );
            System.out.println(q);
          }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}