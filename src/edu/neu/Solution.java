package edu.neu;

import java.util.*;

import edu.neu.base.Node;

public class Solution {

  public static void main(String[] args) {

    compare("abc", "pad");
    compare("abc", "dcb");
    compare("abc", "abcc");
    compare("abc", "aabc");
  }

  private static void compare(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 && j >= 0) {
      if (a.charAt(i) > b.charAt(j)) {
        System.out.println(b);
        return;
      } else if (a.charAt(i) < b.charAt(j)) {
        System.out.println(a);
        return;
      }
      i--;
      j--;
    }
    if (i >= 0) {
      System.out.println(b);
    } else {
      System.out.println(a);
    }
  }

  public List<Integer> cheapestJump(int[] coins, int maxJump) {
    int[] next = new int[coins.length];
    Arrays.fill(next, -1);
    long[] memo = new long[coins.length];
    jump(coins, maxJump, 0, next, memo);
    List<Integer> res = new ArrayList<>();
    int i;
    for (i = 0; i < coins.length && next[i] > 0; i = next[i])
      res.add(i + 1);
    if (i != coins.length - 1 || coins[i] < 0) {
      return new ArrayList<>();
    }
    res.add(coins.length);
    return res;
  }

  public long jump(int[] coins, int maxJump, int i, int[] next, long[] memo) {
    if (memo[i] > 0)
      return memo[i];
    if (i == coins.length - 1 && coins[i] >= 0)
      return coins[i];
    long minCost = Integer.MAX_VALUE;
    for (int j = i + 1; j <= i + maxJump && j < coins.length; j++) {
      if (coins[j] >= 0) {
        long cost = coins[i] + jump(coins, maxJump, j, next, memo);
        if (cost < minCost) {
          minCost = cost;
          next[i] = j;
        }
      }
    }
    memo[i] = minCost;
    return minCost;
  }

  int minimumTime(String s) {
    int n = s.length();
    int rse = Integer.MAX_VALUE;
    int presum = 0, prebest = 0;
    for (int j = 0; j < n; j++) {
      presum = Math.min(presum, j - presum * 2);
      presum += s.charAt(j);
      prebest = Math.min(prebest, 2 * presum - j);
    }
    return Math.min(n, rse + n - 1);
  }

  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    int res = 0;
    int i = 0, j = 1;
    while (i < nums.length && j < nums.length) {
      int dif = nums[j] - nums[i];
      if (i == j || dif < k) {
        j++;
      } else if (dif > k) {
        i++;
      } else {
        res++;
        i++;
        while (i < nums.length && nums[i] == nums[i - 1]) {
          i++;
        }
      }
    }
    return res;
  }

  public int sumOddLengthSubarrays(int[] arr) {
    int[] preSum = getPreSum(arr);

    int sum = 0;
    int n = arr.length;
    for (int start = 0; start < n; start++) {
      for (int length = 1; start + length <= n; length += 2) {
        int end = start + length - 1;
        sum += preSum[end + 1] - preSum[start];
      }
    }
    return sum;
  }

  public int minSumOfLengths(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int sum = 0, length = arr.length, ans = 100002;
    // dp存的是当前坐标之前的最短长度
    int[] dp = new int[length + 1];
    Arrays.fill(dp, 100007);
    for (int i = 1; i <= length; ++i) {
      sum += arr[i - 1];
      int fg = sum - target;
      dp[i] = dp[i - 1];
      if (map.containsKey(fg)) {
        int pos = map.get(fg);
        int curr = i - pos;
        dp[i] = Math.min(dp[i], curr);
        // ans = 之前的最短长度 + 当前最短长度
        ans = Math.min(ans, curr + dp[pos]);
      }
      map.put(sum, i);
    }
    return ans == 100002 ? -1 : ans;
  }

  public int maxSubArrayLen(int[] nums, int k) {
    int preSum = 0, res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      preSum += nums[i];
      map.putIfAbsent(preSum, i);
      if (map.containsKey(preSum - k)) {
        res = Math.max(res, i - map.get(preSum - k));
      }
    }
    return res;
  }

  private int[] getPreSum(int[] arr) {
    int[] preSum = new int[arr.length + 1];
    preSum[0] = arr[0];
    for (int j = 0; j < arr.length; j++) {
      preSum[j] = preSum[j] + arr[j];
    }
    return preSum;
  }

  public int numberOfSubarrays(int[] nums, int k) {
    int[] odds = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      odds[i + 1] = nums[i] % 2 + odds[i];
    }
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 1; i <= nums.length; i++) {
      if (map.containsKey(odds[i] - k)) {
        count += map.get(odds[i] - k);
      }
      map.put(odds[i], map.getOrDefault(odds[i], 0) + 1);
    }
    return count;
  }

  public int subarraysDivByK(int[] nums, int k) {
    int preSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    map.put(0, -1);
    for (int num : nums) {
      preSum += num;
      int mod = (preSum % k + k) % k;
      if (map.containsKey(mod)) {
        count += map.get(mod);
      }
      map.put(mod, map.getOrDefault(mod, 0) + 1);
    }
    return count;
  }

  public int[][] buildMatrix(int[][] matrix) {
    int[][] sum;
    if (matrix.length == 0 || matrix[0].length == 0)
      return null;
    sum = new int[matrix.length + 1][matrix[0].length + 1];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] + matrix[i][j] - sum[i][j];
      }
    }
    return sum;
  }

  public int sumRegion(int row1, int col1, int row2, int col2, int[][] sum) {
    return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
  }

  public int findMaxLength(int[] nums) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();

    int preSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      preSum += (num == 1 ? 1 : -1);
      map.putIfAbsent(preSum, i);
      if (map.containsKey(preSum)) {
        res = Math.max(res, i - map.get(preSum));
      }
    }
    return res;
  }

  public String smallestSubsequence(String s) {
    boolean[] vis = new boolean[26];
    int[] num = new int[26];
    for (int i = 0; i < s.length(); i++) {
      num[s.charAt(i) - 'a']++;
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!vis[ch - 'a']) {
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
          if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
            vis[sb.charAt(sb.length() - 1) - 'a'] = false;
            sb.deleteCharAt(sb.length() - 1);
          } else {
            break;
          }
        }
        vis[ch - 'a'] = true;
        sb.append(ch);
      }
      num[ch - 'a'] -= 1;
    }
    return sb.toString();
  }

  public String removeKdigits(String num, int k) {
    Deque<Character> deque = new ArrayDeque<>();
    int length = num.length();
    for (int i = 0; i < length; ++i) {
      char digit = num.charAt(i);
      while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
        deque.pollLast();
        k--;
      }
      deque.offerLast(digit);
    }

    for (int i = 0; i < k; ++i) {
      deque.pollLast();
    }

    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    while (!deque.isEmpty()) {
      char digit = deque.pollFirst();
      if (leadingZero && digit == '0') {
        continue;
      }
      leadingZero = false;
      ret.append(digit);
    }
    return ret.length() == 0 ? "0" : ret.toString();
  }

  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int res = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0) {
        res += customers[i];
        customers[i] = 0;
      }
    }

    int tmp = 0;
    int max = 0;
    for (int i = 0; i < customers.length; i++) {
      tmp += customers[i];
      if (i >= minutes) {
        tmp -= customers[i - minutes];
      }
      max = Math.max(max, tmp);
    }
    return res + max;
  }

  public int subarraysWithKDistinct(int[] A, int K) {
    return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
  }

  /**
   * @param A
   * @param K
   * @return 最多包含 K 个不同整数的子区间的个数
   */
  private int atMostKDistinct(int[] A, int K) {
    int len = A.length;
    int[] freq = new int[len + 1];

    int left = 0;
    int right = 0;
    // [left, right) 里不同整数的个数
    int count = 0;
    int res = 0;
    // [left, right) 包含不同整数的个数小于等于 K
    while (right < len) {
      if (freq[A[right]] == 0) {
        count++;
      }
      freq[A[right]]++;
      right++;

      while (count > K) {
        freq[A[left]]--;
        if (freq[A[left]] == 0) {
          count--;
        }
        left++;
      }
      // [left, right) 区间的长度就是对结果的贡献
      res += right - left;
    }
    return res;
  }

  public int characterReplacement(String s, int k) {
    char[] chars = s.toCharArray();
    int[] count = new int[26];
    int res = 0;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      count[chars[right] - 'A']++;
      while (!check(count, k)) {
        count[chars[left++] - 'A']--;
      }
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }

  boolean check(int[] cnt, int k) {
    int max = 0, sum = 0;
    for (int i = 0; i < 26; i++) {
      max = Math.max(max, cnt[i]);
      sum += cnt[i];
    }
    return sum - max <= k;
  }

}
