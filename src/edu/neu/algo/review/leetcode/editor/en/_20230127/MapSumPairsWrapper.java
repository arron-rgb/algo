package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MapSumPairsWrapper {
  // 677
  // Design a map that allows you to do the following:
  //
  //
  // Maps a string key to a given value.
  // Returns the sum of the values that have a key with a prefix equal to a given
  // string.
  //
  //
  // Implement the MapSum class:
  //
  //
  // MapSum() Initializes the MapSum object.
  // void insert(String key, int val) Inserts the key-val pair into the map. If
  // the key already existed, the original key-value pair will be overridden to the
  // new one.
  // int sum(string prefix) Returns the sum of all the pairs' value whose key
  // starts with the prefix.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["MapSum", "insert", "sum", "insert", "sum"]
  // [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
  // Output
  // [null, null, 3, null, 5]
  //
  // Explanation
  // MapSum mapSum = new MapSum();
  // mapSum.insert("apple", 3);
  // mapSum.sum("ap"); // return 3 (apple = 3)
  // mapSum.insert("app", 2);
  // mapSum.sum("ap"); // return 5 (apple + app = 3 + 2 = 5)
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= key.length, prefix.length <= 50
  // key and prefix consist of only lowercase English letters.
  // 1 <= val <= 1000
  // At most 50 calls will be made to insert and sum.
  //
  //
  // Related Topics Hash Table String Design Trie 👍 1439 👎 138

  public static void main(String[] args) {
    MapSum instance = new MapSumPairsWrapper().new MapSum();
    instance.insert("apple", 3);
    int value0 = instance.sum("ap");
    instance.insert("app", 2);
    int value1 = instance.sum("ap");

    System.out.println(value0);
    System.out.println(value1);

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class MapSum {
    Trie root;
    Map<String, Integer> map;

    public MapSum() {
      root = new Trie();
      map = new HashMap<>();
    }

    public void insert(String key, int val) {
      int delta = val - map.getOrDefault(key, 0);
      map.put(key, val);
      root.insert(key, delta);
    }

    public int sum(String prefix) {
      return root.sum(prefix);
    }
  }

  class Trie {
    Trie[] children;
    boolean isEnd;
    int val;

    void insert(String s, int v) {
      int n = s.length();
      Trie root = this;
      for (int i = 0; i < n; i++) {
        if (root.children == null) {
          root.children = new Trie[26];
        }
        int index = s.charAt(i) - 'a';
        if (root.children[index] == null) {
          root.children[index] = new Trie();
        }
        root.children[index].val += v;
        root = root.children[index];
      }
      root.isEnd = true;
    }

    int sum(String s) {
      int n = s.length();
      Trie root = this;
      for (int i = 0; i < n; i++) {
        int index = s.charAt(i) - 'a';
        if (root == null || root.children == null || root.children[index] == null) {
          return 0;
        }
        root = root.children[index];
      }
      return root.val;
    }
  }
  // runtime:12 ms
  // memory:42.2 MB

  /**
   * Your MapSum object will be instantiated and called as such: MapSum obj = new MapSum(); obj.insert(key,val); int
   * param_2 = obj.sum(prefix);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
