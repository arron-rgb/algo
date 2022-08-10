package edu.neu.basic;

import java.util.Arrays;

/**
 * @author arronshentu
 */
public class Bag {
  public static void main(String[] args) {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int size = 4;
    int bag = bag(weight, value, size);
    System.out.println(bag);
  }

  public static int bag(int[] weights, int[] values, int size) {
    int n = weights.length;
    // 定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
    int[][] dp = new int[n + 1][size + 1];
    // 初始化：背包容量为0时，能获得的价值都为0
    // for (int i = 0; i <= n; i++) {
    // dp[i][0] = value0;
    // }
    // 遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= size; j++) {
        if (j < weights[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[n - 1][size];
  }

  public static int testWeightBagProblem(int[] weights, int[] values, int size) {
    int n = weights.length;
    // 定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
    int[] dp = new int[size + 1];
    // 遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 0; i < n; i++) {
      // 倒序遍历是为了保证物品i只被放入一次！但如果一旦正序遍历了，那么物品0就会被重复加入多次！
      for (int j = size; j >= weights[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
      }
    }
    // 打印dp数组
    System.out.println(Arrays.toString(dp));
    return dp[size];
  }

}
