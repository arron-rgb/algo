package edu.neu.algo.leetcode.editor.en._20220621;

import edu.neu.util.InputUtil;

public class DefangingAnIPAddress {

  // Given a valid (IPv4) IP address, return a defanged version of that IP address.
  //
  //
  // A defanged IP address replaces every period "." with "[.]".
  //
  //
  // Example 1:
  // Input: address = "1.1.1.1"
  // Output: "1[.]1[.]1[.]1"
  // Example 2:
  // Input: address = "255.100.50.0"
  // Output: "255[.]100[.]50[.]0"
  //
  //
  // Constraints:
  //
  //
  // The given address is a valid IPv4 address.
  // Related Topics String 👍 1149 👎 1495

  public static void main(String[] args) {
    Solution solution = new DefangingAnIPAddress().new Solution();
    String[] data = """
          "1.1.1.1"
      "255.100.50.0\"""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.defangIPaddr((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String defangIPaddr(String address) {
      return address.replaceAll("\\.", "[.]");
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
