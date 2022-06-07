package edu.neu.algo.leetcode.editor.en._20220528;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateIPAddress {

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
  // Related Topics String 👍 677 👎 2373

  public static void main(String[] args) {
    Solution solution = new ValidateIPAddress().new Solution();
    solution.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5});
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int n = nums.length;
      int[] prefix = new int[n + 1];
      for (int i = 1; i < prefix.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
      }
      int res = n + 1;
      for (int i = 0; i < prefix.length; i++) {
        for (int j = i + 1; j < prefix.length; j++) {
          if (prefix[j] - prefix[i] == target) {
            res = Math.min(res, j - i);
          }
        }
      }
      return res == n + 1 ? 0 : res;

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Deque<int[]> queue = new ArrayDeque<>();
    int fresh = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[] {i, j});
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }
    if (fresh == 0) {
      return 0;
    }
    int res = 0;
    while (!queue.isEmpty()) {
      ++res;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] tmp = queue.poll();
        for (int[] dir : directions) {
          int x = tmp[0] + dir[0];
          int y = tmp[1] + dir[1];
          if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) {
            continue;
          }
          grid[x][y] = 2;
          queue.offer(new int[] {x, y});
          fresh--;
        }
      }
    }
    return fresh == 0 ? res - 1 : -1;
  }
}
