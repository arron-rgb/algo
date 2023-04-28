import java.util.List;

public class Solution {
  public List<Long> minOperations(int[] nums, int[] queries) {
    // 把数组中的数变成 query
    // 需要多少次操作

    // 求 <=query 及 >= query的数
    // 也是 count query

    // 排序后二分就可以获得数量
    return List.of();
  }

  public int countAnagrams(String s) {
    int mod = 1000000007;
    long[] fact = new long[s.length() + 1];
    long[] inv = new long[s.length() + 1];
    fact[0] = 1;
    inv[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      fact[i] = fact[i - 1] * i % mod;
      inv[i] = inv((int)fact[i], mod);
    }
    long res = 1;
    for (String t : s.split(" ")) {
      int[] freq = new int[26];
      for (char c : t.toCharArray()) {
        freq[c - 'a']++;
      }
      long r = fact[t.length()];
      for (int i : freq) {
        r *= inv[i];
        r %= mod;
      }
      res *= r;
      res %= mod;
    }
    return (int)res;
  }

  public int inv(int n, int m) {
    return pow(n, m - 2, m);
  }

  public int pow(int n, int p, int mod) {
    int res = 1, pow = n;
    while (p > 0) {
      if (p % 2 == 1) {
        res = (int)((long)res * pow % mod);
      }
      pow = (int)((long)pow * pow % mod);
      p >>= 1;
    }
    return res;
  }
}
