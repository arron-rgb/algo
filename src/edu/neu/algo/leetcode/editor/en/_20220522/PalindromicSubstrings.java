package edu.neu.algo.leetcode.editor.en._20220522;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import edu.neu.base.TreeNode;

public class PalindromicSubstrings {

  // Given a string s, return the number of palindromic substrings in it.
  //
  // A string is a palindrome when it reads the same backward as forward.
  //
  // A substring is a contiguous sequence of characters within the string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abc"
  // Output: 3
  // Explanation: Three palindromic strings: "a", "b", "c".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "aaa"
  // Output: 6
  // Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consists of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 6879 👎 158

  public static void main(String[] args) {
    Solution solution = new PalindromicSubstrings().new Solution();
    PalindromicSubstrings p = new PalindromicSubstrings();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left = new TreeNode(3);
    int i = p.deepestLeavesSum(root);
    System.out.println(i);
  }

  List<List<Integer>> ans;

  public List<List<Integer>> combinationSum3(int k, int n) {
    ans = new ArrayList<>();
    dfs(new ArrayList<>(), k, 1, n);
    return ans;
  }

  void dfs(List<Integer> tmp, int k, int num, int n) {
    if (tmp.size() == k && n == 0) {
      ans.add(new ArrayList<>(tmp));
      return;
    }

    for (int i = num; i < 10; i++) {
      tmp.add(i);
      dfs(tmp, k, i + 1, n - i);
      tmp.remove(tmp.size() - 1);
    }
  }

  public int deepestLeavesSum(TreeNode root) {
    int res = 0;
    if (root == null) {
      return res;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        if (node.left != null) {
          deque.add(node.left);
        }
        if (node.right != null) {
          deque.add(node.right);
        }
      }
      int tmp = 0;
      for (TreeNode node : deque) {
        tmp += node.val;
      }
      res = tmp;
    }
    return res;
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int res = 0;

    public int countSubstrings(String s) {
      if (s == null || s.length() < 1) {
        return res;
      }
      for (int i = 0; i < s.length(); i++) {
        extend(s, i, i);
        extend(s, i, i + 1);
      }
      return res;
    }

    void extend(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        res++;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
