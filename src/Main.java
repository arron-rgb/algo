// import java.util.Arrays;
//
// class Solution {
// int[][] dp;
// int n;
//
// public int maxProfit(int[] prices, int fee) {
// n = prices.length;
// dp = new int[n][2];
// for (int i = 0; i < n; i++) {
// Arrays.fill(dp[i], Integer.MIN_VALUE);
// }
// return dfs(prices, 0, 1, fee);
// }
//
// private int dfs(int[] prices, int i, int buying, int fee) {
// if (i >= n) {
// return 0;
// }
// if (dp[i][buying] != Integer.MIN_VALUE) {
// return dp[i][buying];
// }
//
// int doNothing = dfs(prices, i + 1, buying, fee);
// if (buying == 1) {
// // buy
// int buy = dfs(prices, i + 1, 0, fee) - prices[i];
// dp[i][buying] = Math.max(buy, doNothing);
// // do nothing
// } else {
// // sell
// int sell = dfs(prices, i + 1, 1, fee) + prices[i] - fee;
// dp[i][buying] = Math.max(sell, doNothing);
// // do nothing
// }
// return dp[i][buying];
// }
//
// public void nextPermutation(int[] nums) {
// if (nums.length <= 1) {
// return;
// }
// // I need to check the breakpoint
// int i = nums.length - 2;
// while (i >= 0 && nums[i] >= nums[i + 1]) {
// i--;
// }
// // if and only if I found the break point
// if (i >= 0) {
// int j = nums.length - 1;
// // loop around till I found the greater value than the breakpoint value
// while (nums[j] <= nums[i]) {
// j--;
// }
// swapNxtP(nums, i, j);
// }
// reverse(nums, i + 1, nums.length - 1);
// }
//
// public static void swapNxtP(int[] nums, int i, int j) {
// int temp = nums[i];
// nums[i] = nums[j];
// nums[j] = temp;
// }
//
// public static void reverse(int[] nums, int index1, int index2) {
//
// while (index1 < index2) {
// swapNxtP(nums, index1++, index2--);
// }
// }
//
// public int firstMissingPositive(int[] nums) {
// int n = nums.length;
// // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
// // (we can ignore those because if all number are > n then we'll simply return 1)
// for (int i = 0; i < n; i++) {
// if (nums[i] <= 0 || nums[i] > n) {
// nums[i] = n + 1;
// }
// }
// // note: all number in the array are now positive, and on the range 1..n+1
// // 2. mark each cell appearing in the array, by converting the index for that number to negative
// for (int i = 0; i < n; i++) {
// int num = Math.abs(nums[i]);
// if (num > n) {
// continue;
// }
// num--; // -1 for zero index based array (so the number 1 will be at pos 0)
// if (nums[num] > 0) { // prevents double negative operations
// nums[num] = -1 * nums[num];
// }
// }
// // 3. dfs the first cell which isn't negative (doesn't appear in the array)
// for (int i = 0; i < n; i++) {
// if (nums[i] >= 0) {
// return i + 1;
// }
// }
// // 4. no positive numbers were found, which means the array contains all numbers 1..n
// return n + 1;
// }
//
// }
