package edu.neu.algo.review.leetcode.editor.en._20230120;

import edu.neu.base.Pair;
import edu.neu.util.InputUtil;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class DesignAuthenticationManager {

  // There is an authentication system that works with authentication tokens. For
  // each session, the user will receive a new authentication token that will expire
  // timeToLive seconds after the currentTime. If the token is renewed, the expiry
  // time will be extended to expire timeToLive seconds after the (potentially
  // different) currentTime.
  //
  // Implement the AuthenticationManager class:
  //
  //
  // AuthenticationManager(int timeToLive) constructs the AuthenticationManager
  // and sets the timeToLive.
  // generate(string tokenId, int currentTime) generates a new token with the
  // given tokenId at the given currentTime in seconds.
  // renew(string tokenId, int currentTime) renews the unexpired token with the
  // given tokenId at the given currentTime in seconds. If there are no unexpired
  // tokens with the given tokenId, the request is ignored, and nothing happens.
  // countUnexpiredTokens(int currentTime) returns the number of unexpired tokens
  // at the given currentTime.
  //
  //
  // Note that if a token expires at time t, and another action happens on time t
  // (renew or countUnexpiredTokens), the expiration takes place before the other
  // actions.
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens",
  // "generate", "renew", "renew", "countUnexpiredTokens"]
  // [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
  // Output
  // [null, null, null, 1, null, null, null, 0]
  //
  //
  // Explanation
  // AuthenticationManager authenticationManager = new AuthenticationManager(5); //
  // Constructs the AuthenticationManager with timeToLive = 5 seconds.
  // authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa"
  // at time 1, so nothing happens.
  // authenticationManager.generate("aaa", 2); // Generates a new token with
  // tokenId "aaa" at time 2.
  // authenticationManager.countUnexpiredTokens(6); // The token with tokenId
  // "aaa" is the only unexpired one at time 6, so return 1.
  // authenticationManager.generate("bbb", 7); // Generates a new token with
  // tokenId "bbb" at time 7.
  // authenticationManager.renew("aaa", 8); // The token with tokenId "aaa"
  // expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing
  // happens.
  // authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is
  // unexpired at time 10, so the renew request is fulfilled and now the token will
  // expire at time 15.
  // authenticationManager.countUnexpiredTokens(15); // The token with tokenId
  // "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so
  // currently no token is unexpired, so return 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= timeToLive <= 10⁸
  // 1 <= currentTime <= 10⁸
  // 1 <= tokenId.length <= 5
  // tokenId consists only of lowercase letters.
  // All calls to generate will contain unique values of tokenId.
  // The values of currentTime across all the function calls will be strictly
  // increasing.
  // At most 2000 calls will be made to all functions combined.
  //
  //
  // Related Topics Hash Table Design 👍 245 👎 37

  public static void main(String[] args) {

    DesignAuthenticationManager manager = new DesignAuthenticationManager();
    // [2,3,3,3,1,5,5,0,5,3,4,2,1,2,5,1,2,0]
    // 5
    int i1 = manager.minCost(new int[] {2, 3, 3, 3, 1, 5, 5, 0, 5, 3, 4, 2, 1, 2, 5, 1, 2, 0}, 5);
    System.out.println(i1);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class AuthenticationManager {

    int timeToLive;
    TreeSet<Integer> treeSet;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
      this.timeToLive = timeToLive;
      treeSet = new TreeSet<>();
      map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
      map.put(tokenId, currentTime + timeToLive);
      treeSet.add(currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

      Integer time = map.get(tokenId);
      // If null the token was never added, or it has expired before the renew call, which makes it invalid for renewing
      if (time == null || time <= currentTime)
        return;

      // Update the hashmap and treeSet with the new values
      map.put(tokenId, currentTime + timeToLive);
      treeSet.remove(time);
      treeSet.add(currentTime + timeToLive);

      // Clearing the treeset from already expired timestamps, it doesn't really improve the time execution, with about
      // 10% only.
      while (!treeSet.isEmpty() && treeSet.lower(currentTime) != null) {
        treeSet.remove(treeSet.lower(currentTime));
      }
    }

    // Return the number of timestamps in the treeset, which have greated expiry time than the currentTime
    public int countUnexpiredTokens(int currentTime) {
      return treeSet.tailSet(currentTime, false).size();
    }
  }

  /**
   * Your AuthenticationManager object will be instantiated and called as such: AuthenticationManager obj = new
   * AuthenticationManager(timeToLive); obj.generate(tokenId,currentTime); obj.renew(tokenId,currentTime); int param_3 =
   * obj.countUnexpiredTokens(currentTime);
   */
  // leetcode submit region end(Prohibit modification and deletion)
  public long minOperations(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int[] dels = new int[n];
    for (int i = 0; i < n; i++) {
      dels[i] = Math.abs(nums1[i] - nums2[i]);
    }
    int sum = Arrays.stream(dels).sum();
    if (sum != 0) {
      return -1L;
    }
    int pos = 0;
    for (int i : dels) {
      if (i > 0) {
        pos++;
      }
    }
    // return Math.max(pos, n - pos) <= k;
    return -1;
    // 3 0 -6 3
    // 一样的就给他
  }

  // xor: 不同为1, 其余为0
  // or: 有1, 则1
  // 想要变成0，可以通过 s[i] != s[j] xor
  // 想要变成
  public long maxScore(int[] nums1, int[] nums2, int k) {
    // nums2中的每一个数都可以作为min
    // 在它作为min的时候: 在排序的nums1中找k-1个数，满足该k-1个数在nums2中均比它大
    int n = nums1.length;
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new int[] {i, nums1[i]});
    }
    list.sort(Comparator.comparingInt(t -> t[0]));
    long res = 0;
    for (int i = 0; i < n; i++) {
      // 在nums1中找k-1个数, 满足k-1个数在nums2中比他大
      final int finalI = i;
      long sum = list.stream().filter(l -> nums2[l[0]] > nums2[finalI]).limit(k - 1).mapToLong(l -> l[1]).sum();
      res = Math.max(res, sum);
    }
    return res;
  }

  public int minCost(int[] nums, int k) {
    // 使得划分出的子数组
    // 使得一整个数组为 res: 则sum 为 k + len(trimmed(nums))
    // 如何使得sum变小？
    // 切分后
    // 只出现一次的数仍然会被移除
    // 出现多次的可以分割，且大小不影响
    // sum = 2 * k + len(trimmed(nums1)) + len(trimmed(nums2))
    // 只要切分后能够使得两个部分的trimmed和 + k <= 原先的trimmed就是划算的
    // 所以我们只需要从一开始就计算
    int n = nums.length;
    this.map = new HashMap<>();
    this.res = Math.min(k * n, k + count(nums, 0, n));
    dfs(nums, k, 0, 0, new StringBuilder());
    return res;
  }

  int res;

  void dfs(int[] nums, int k, int cost, int index, StringBuilder sb) {
    if (index + k >= nums.length) {
      res = Math.min(res, k + cost + count(nums, index, nums.length));
      System.out.println(sb);
      return;
    }
    for (int i = index + k; i < nums.length; i++) {
      // 从index划分到
      dfs(nums, k, k + cost + count(nums, index, i), i,
        sb.append("[").append(index).append(",").append(i - 1).append("]"));
    }
  }

  Map<String, Integer> map;

  int count(int[] nums, int from, int end) {
    String key = Arrays.toString(new int[] {from, end});
    if (map.containsKey(key)) {
      return map.get(key);
    }
    Map<Integer, Integer> c = new HashMap<>();
    for (int i = from; i < end; i++) {
      c.put(nums[i], c.getOrDefault(nums[i], 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
      Integer k = entry.getKey();
      Integer v = entry.getValue();
      if (v > 1) {
        count += v;
      }
    }
    map.put(key, count);
    return count;
  }
}
