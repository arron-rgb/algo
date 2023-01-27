package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class RestoreIPAddresses {
  // 93
  // A valid IP address consists of exactly four integers separated by single dots.
  // Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
  //
  //
  // For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
  // .255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
  //
  //
  // Given a string s containing only digits, return all possible valid IP
  // addresses that can be formed by inserting dots into s. You are not allowed to reorder
  // or remove any digits in s. You may return the valid IP addresses in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "25525511135"
  // Output: ["255.255.11.135","255.255.111.35"]
  //
  //
  // Example 2:
  //
  //
  // Input: s = "0000"
  // Output: ["0.0.0.0"]
  //
  //
  // Example 3:
  //
  //
  // Input: s = "101023"
  // Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 20
  // s consists of digits only.
  //
  //
  // Related Topics String Backtracking 👍 4525 👎 739

  public static void main(String[] args) {
    Solution solution = new RestoreIPAddresses().new Solution();
    String[] data = """
                  "25525511135"
      "0000"
      "101023"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.restoreIpAddresses((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans;
    int[] segments;

    public List<String> restoreIpAddresses(String s) {
      ans = new ArrayList<>();
      segments = new int[SEG_COUNT];
      dfs(s, 0, 0);
      return ans;
    }

    public void dfs(String s, int segId, int segStart) {
      // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
      if (segId == SEG_COUNT) {
        if (segStart == s.length()) {
          StringBuilder ipAddr = new StringBuilder();
          for (int i = 0; i < SEG_COUNT; ++i) {
            ipAddr.append(segments[i]);
            if (i != SEG_COUNT - 1) {
              ipAddr.append('.');
            }
          }
          ans.add(ipAddr.toString());
        }
        return;
      }

      // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
      if (segStart == s.length()) {
        return;
      }

      // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
      if (s.charAt(segStart) == '0') {
        segments[segId] = 0;
        dfs(s, segId + 1, segStart + 1);
      }

      // 一般情况，枚举每一种可能性并递归
      int addr = 0;
      for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
        addr = addr * 10 + (s.charAt(segEnd) - '0');
        if (addr > 0 && addr <= 255) {
          segments[segId] = addr;
          dfs(s, segId + 1, segEnd + 1);
        } else {
          break;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
