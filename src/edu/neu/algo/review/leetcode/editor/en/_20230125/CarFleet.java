package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CarFleet {
  // 853
  // There are n cars going to the same destination along a one-lane road. The
  // destination is target miles away.
  //
  // You are given two integer array position and speed, both of length n, where
  // position[i] is the position of the iᵗʰ car and speed[i] is the speed of the iᵗʰ
  // car (in miles per hour).
  //
  // A car can never pass another car ahead of it, but it can catch up to it and
  // drive bumper to bumper at the same speed. The faster car will slow down to match
  // the slower car's speed. The distance between these two cars is ignored (i.e.,
  // they are assumed to have the same position).
  //
  // A car fleet is some non-empty set of cars driving at the same position and
  // same speed. Note that a single car is also a car fleet.
  //
  // If a car catches up to a car fleet right at the destination point, it will
  // still be considered as one car fleet.
  //
  // Return the number of car fleets that will arrive at the destination.
  //
  //
  // Example 1:
  //
  //
  // Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
  // Output: 3
  // Explanation:
  // The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting
  // each other at 12.
  // The car starting at 0 does not catch up to any other car, so it is a fleet by
  // itself.
  // The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each
  // other at 6. The fleet moves at speed 1 until it reaches target.
  // Note that no other cars meet these fleets before the destination, so the
  // answer is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: target = 10, position = [3], speed = [3]
  // Output: 1
  // Explanation: There is only one car, hence there is only one fleet.
  //
  //
  // Example 3:
  //
  //
  // Input: target = 100, position = [0,2,4], speed = [4,2,1]
  // Output: 1
  // Explanation:
  // The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each
  // other at 4. The fleet moves at speed 2.
  // Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one
  // fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
  //
  //
  //
  // Constraints:
  //
  //
  // n == position.length == speed.length
  // 1 <= n <= 10⁵
  // 0 < target <= 10⁶
  // 0 <= position[i] < target
  // All the values of position are unique.
  // 0 < speed[i] <= 10⁶
  //
  //
  // Related Topics Array Stack Sorting Monotonic Stack 👍 2169 👎 536

  public static void main(String[] args) {
    Solution solution = new CarFleet().new Solution();
    String[] data = """
                  12
      [10,8,0,5,3]
      [2,4,1,1,3]
      10
      [3]
      [3]
      100
      [0,2,4]
      [4,2,1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.carFleet((int)params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length], (int[])params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      int N = position.length;
      Car[] cars = new Car[N];
      for (int i = 0; i < N; ++i)
        cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
      Arrays.sort(cars, Comparator.comparingInt(a -> a.position));

      int ans = 0, t = N;
      while (--t > 0) {
        if (cars[t].time < cars[t - 1].time)
          ans++; // if cars[t] arrives sooner, it can't be caught
        else
          cars[t - 1] = cars[t]; // else, cars[t-1] arrives at same time as cars[t]
      }

      return ans + (t == 0 ? 1 : 0); // lone car is fleet (if it exists)
    }
  }

  class Car {
    int position;
    double time;

    Car(int p, double t) {
      position = p;
      time = t;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
