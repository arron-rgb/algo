# 基础

1. 509
2. 70 爬楼梯
3. 746
4. 62
5. 63
6. 343
7. 96

## 爬楼梯

```
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
```

### 思路

到第三个台阶，可以通过第一个台阶+2 或者 第二个台阶+1。如果有n种step，用step[i]表示其中的一种，则第n个台阶可以通过第n-step[i] + step[i]
爬上，到达第n个台阶的方法数就是之前的状态的和。并且跟顺序相关，这是排列题。

遍历所有的楼层，再遍历可以爬的step，在到达下一个台阶的时候，因为当前台阶已经遍历过所有的step，所以是有顺序的。

### 代码

```java
class Solution {
  public int climbStairs(int n) {
    if (n < 4) {
      return n;
    }
    int[] steps = new int[]{1, 2};
    int[] dp = new int[n + 1];
    for (int i = 4; i < dp.length; i++) {
      for (int step : steps) {
        if (i - step >= 0) {
          dp[i] += dp[i - step];
        }
      }
    }
    return dp[n];
  }
}
```

# 子序列

## 回文

1. 647 回文子串
2. 516 最长回文子序列

## 编辑距离

1. 392
2. 115
3. 583
4. 72

## 子序列（连续）

1. 674
2. 718
3. 53

## 子序列（不连续）

1. 300
2. 1143
3. 1035

# 股票

1. 121 买卖一次
2. 122 买卖多次
3. 123 最多买卖两次
4. 188 最多买卖k次
5. 309 买卖多次 1天冷却
6. 714 买卖多次 每次有手续费

# 打家劫舍

1. 198 数组。不能偷相邻
2. 213 环形数组。不能偷相邻，数组首尾相连
3. 337 树。不能同时偷父子

## 数组

### 思路

对于第i个房子，可以选择偷或者不偷。如果第i-1个房子偷了，那就不能偷第i个房子。所以对于到第i个房子的时候求可能的最大值应该是，没偷第i个，偷了当前这个的值 与 不偷当前这个房子的值中的最大值。

### 代码

```java
class Solution {
  public int rob(int[] houses) {
    int n = houses.length;
    if (n == 1) {
      return houses[0];
    }
    int[] dp = new int[n];
    dp[0] = houses[0];
    dp[1] = Math.max(houses[0], houses[1]);
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
    }
    return dp[n - 1];
  }
}
```

## 环形数组

### 思路

偷house[n-1]或偷house[0] 选一个即可

### 代码

```java
class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
  }

  private int rob(int[] nums, int start, int end) {
    int max = 0;
    int cur = 0, pre = 0;

    for (int i = start; i < end; i++) {
      max = Math.max(cur, pre + nums[i]);
      pre = cur;
      cur = max;
    }

    return max;
  }
}
```

## 树

### 思路

dfs, 保存2个状态，偷与不偷。root取偷当前（不偷子），不偷当前（偷两个子）

### 代码

```java
class Solution {
  public int rob(TreeNode root) {
    int[] res = robAction(root);
    return Math.max(res[0], res[1]);
  }

  int[] robAction(TreeNode root) {
    int[] res = new int[2];
    if (root == null) {
      return res;
    }

    int[] left = robAction(root.left);
    int[] right = robAction(root.right);

    // 不偷当前，下一层取大的即可
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // 偷当前，下一层只能取不偷的
    res[1] = root.val + left[0] + right[0];
    return res;
  }
}
```

# 背包

## 01

1. 416 PartitionEqualSubsetSum
2. 1049 LastStoneWeightII
3. 494 TargetSum
4. 474

01背包物品只能放一次。给定n个物品，分别有values[i]和weights[i]，放入能够容纳size的背包。先遍历物品，再倒序遍历背包容量，防止一维数组覆盖（物品重复放入）

## PartitionEqualSubsetSum

```java
// Given a non-empty array nums containing only positive integers, find if the
// array can be partitioned into two subsets such that the sum of elements in
// both
// subsets is equal.
```

### 思路

01背包问题。求数组的和，判断数组中的数能否凑出和/2，能凑出就是sum/2+sum/2。对于给定n个数能否凑出指定的和，同零钱兑换，是组合问题。定义dp[i]表示能否凑出i，i可以通过i-nums[j]到达。

### 代码

```java
class Solution {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if ((sum & 1) == 1) {
      return false;
    }
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int num : nums) {
      for (int i = sum; i >= num; i--) {
        // // i-num的范围是 从i-num都能到达i
        dp[i] = dp[i] || dp[i - num];
      }
    }
    return dp[sum];
  }
}
```

## LastStoneWeightII

```java
// You are given an array of integers stones where stones[i] is the weight of
// the iᵗʰ stone.  
// At the end of the game, there is at most one stone left.
//
// Return the smallest possible weight of the left stone. If there are no
// stones left, return 0.
```

### 思路

dp[i]表示能够容纳i重量的背包，最多可以装多少。这道题就是 最多能够装一半的容量，看看实际能够装多少。一堆的和是dp[target]，另一堆和就是sum - dp[target]。剩下的就是 sum-dp[target]*2

### 代码

```java
class Solution {
  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int stone : stones) {
      for (int j = target; j >= stone; j--) {
        // dp[i]可以通过dp[i-stone]到达
        dp[j] = Math.max(dp[j], dp[j - stone] + stone);
      }
    }
    return sum - 2 * dp[target];
  }
}
```

## TODO TargetSum

```java
// You are given an integer array nums and an integer target.
//
// You want to build an expression out of nums by adding one of the symbols '+'
// and '-' before each integer in nums and then concatenate all the integers.
//
//
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
// and concatenate them to build the expression "+2-1".
//
//
// Return the number of different expressions that you can build, which
// evaluates to target.
//
```

### 思路

对于每个数，有取正或负的选择。跟上述题目类似。定义n为给定的数个数，定义dp[n+1][2]。dp[i][0]表示第i个数取正，dp[i][1]表示第i个数取负。dp[i][0..2]表示有几种方法能够凑到target。

### 代码

```java
class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) sum += num;

    if (sum < target) return 0;
    sum -= target;
    if (sum % 2 == 1) return 0;
    int[] dp = new int[sum / 2 + 1];
    dp[0] = 1;
    for (int num : nums) {
      for (int i = sum / 2; i >= num; i--) {
        dp[i] += dp[i - num];
      }
    }
    return dp[sum / 2];
  }
}
```

## 完全

1. 518 零钱兑换2
2. 377 CombinationSumIV
3. 70
4. 322 零钱兑换
5. 279
6. 139

## 零钱兑换

```java

// You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.
//
// Return the fewest number of coins that you need to make up that amount. If
// that amount of money cannot be made up by any combination of the coins, return -1.
```

### 思路

用给定的硬币数凑指定的数额，至少需要多少枚硬币。显然是一个组合问题，对于每一个数额，需要求最小值。用dp[i]表示至少需要多少个硬币来凑出i，i可以通过i-coins[0...n]来凑到，所以dp[i] =
所有的coin对应的dp[i-coin]+1的最小值。组合问题面额在外头

### 代码

```java
import java.util.Arrays;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
}
```

## 零钱兑换2

```java
  // You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.
//
// Return the number of combinations that make up that amount. If that amount
// of money cannot be made up by any combination of the coins, return 0.
//
// You may assume that you have an infinite number of each kind of coin.
```

### 思路

用给定的硬币数凑指定的数额，能够有多少种方案。显然是一个组合问题。用dp[i]表示方案数，dp[i]可以通过[i-coin]凑得，且方案数为所有面值的方案数之和。

### 代码

```java
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i < dp.length; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }
}
```

## CombinationSumIV

```java
  // Given an array of distinct integers nums and a target integer target, return
// the number of possible combinations that add up to target.
//
// The test cases are generated so that the answer can fit in a 32-bit integer.
```

### 思路

用给定的整数凑指定的数额，能够有多少种方案。求排列。用dp[i]表示方案数，dp[i]可以通过[i-coin]凑得，且方案数为所有面值的方案数之和

### 代码

```java
class Solution {
  public int combinationSum4(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] += dp[i - coin];
        }
      }
    }
    return dp[amount];
  }
}
```
