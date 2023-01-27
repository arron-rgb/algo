package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class ValidateIPAddress {
  // 468
  // Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6"
  // if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
  //
  //
  // A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255
  // and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0
  // " are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.
  // 1" are invalid IPv4 addresses.
  //
  // A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
  //
  //
  // 1 <= xi.length <= 4
  // xi is a hexadecimal string which may contain digits, lowercase English
  // letter ('a' to 'f') and upper-case English letters ('A' to 'F').
  // Leading zeros are allowed in xi.
  //
  //
  // For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0
  // :8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334
  // " and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
  //
  //
  // Example 1:
  //
  //
  // Input: queryIP = "172.16.254.1"
  // Output: "IPv4"
  // Explanation: This is a valid IPv4 address, return "IPv4".
  //
  //
  // Example 2:
  //
  //
  // Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
  // Output: "IPv6"
  // Explanation: This is a valid IPv6 address, return "IPv6".
  //
  //
  // Example 3:
  //
  //
  // Input: queryIP = "256.256.256.256"
  // Output: "Neither"
  // Explanation: This is neither a IPv4 address nor a IPv6 address.
  //
  //
  //
  // Constraints:
  //
  //
  // queryIP consists only of English letters, digits and the characters '.' and
  // ':'.
  //
  //
  // Related Topics String 👍 811 👎 2557

  public static void main(String[] args) {
    Solution solution = new ValidateIPAddress().new Solution();
    String[] data = """
                  "2001:0db8:85a3:0:0:8A2E:0370:7334:"
                  "172.16.254.1"
      "2001:0db8:85a3:0:0:8A2E:0370:7334"
      "256.256.256.256"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.validIPAddress((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String validIPAddress(String queryIP) {
      int n = queryIP.length();
      boolean ipv6Possible = false;
      for (int i = 0; i < n; i++) {
        if (Character.isLetter(queryIP.charAt(i))) {
          ipv6Possible = true;
          break;
        }
      }
      if (ipv6Possible) {
        int count = 0;
        for (int i = 0; i < n; i++) {
          if (queryIP.charAt(i) == ':') {
            count++;
          }
        }
        if (count != 7) {
          return "Neither";
        }
        return checkIPv6(queryIP);
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (queryIP.charAt(i) == '.') {
          count++;
        }
      }
      if (count != 3) {
        return "Neither";
      }
      return checkIPv4(queryIP);
    }

    String checkIPv6(String s) {
      String[] split = s.split(":");
      if (split.length != 8) {
        return "Neither";
      }
      for (String s1 : split) {
        if (!(s1.length() >= 1 && s1.length() <= 4)) {
          return "Neither";
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
          char c = s1.charAt(i);
          if (Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
            continue;
          }
          return "Neither";
        }
      }
      return "IPv6";
    }

    String checkIPv4(String s) {
      String[] split = s.split("\\.");
      if (split.length != 4) {
        return "Neither";
      }
      for (String s1 : split) {
        try {
          int i = Integer.parseInt(s1);
          if (i >= 0 && i <= 255 && String.valueOf(i).equals(s1)) {
            continue;
          }
          return "Neither";
        } catch (Exception e) {
          return "Neither";
        }
      }
      return "IPv4";
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
