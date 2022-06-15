import java.util.HashMap;
import java.util.Map;

/**
 * @author arronshentu
 */
class LRUCache {

  Node head, tail;
  int capacity;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node();
    tail = new Node();
    // cmd + delete
    // option + delete
    head.tail = tail;
    tail.head = head;
    map = new HashMap<>(capacity);
  }

  public int get(int key) {
    // 把该node移到head
    int res = -1;
    if (map.containsKey(key)) {
      Node node = map.get(key);
      moveToHead(node);
      res = node.value;
    }
    System.out.println(res);
    return res;
  }
  // 如果存在key, 更新value，放到头
  // 如果不存在，添加node，放到头

  // 如果更新后超过capacity，删除末尾的元素
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;

      moveToHead(node);
    } else {
      Node insert = new Node();
      insert.value = value;
      insert.key = key;
      moveToHead(insert);
      // put的时候先把尾部删除
      if (map.size() == this.capacity) {
        // System.out.println(tail.head.value);
        map.remove(tail.head.key);
        removeNode(tail.head);
      }
      map.put(key, insert);
    }
  }

  void moveToHead(Node newHead) {
    removeNode(newHead);
    newHead.head = head;
    newHead.tail = head.tail;
    head.tail.head = newHead;
    head.tail = newHead;
  }

  void removeNode(Node deleted) {
    if (deleted.tail != null) {
      // tmp
      // head <-> 1 <-> deleted <-> tail
      // head <-> 1 <-> tail
      Node tmp = deleted.head;
      tmp.tail = deleted.tail;
      deleted.tail.head = tmp;
    }

  }

  class Node {
    Node head, tail;
    int key, value;
  }

  int vowelsubstring(String s) {
    // aaeiouxa 2: aaeiou aeiou
    // axyzaeiou 1: axyzaeiou
    int count = 0;
    return count;
  }

  static int MOD = 1000000007;

  public static int solve(char[] s, int n, int x, int y) {
    int[] prevSame = new int[s.length];
    int idxL = -1;
    int idxR = -1;
    for (int i = 0; i < prevSame.length; i++) {
      if (s[i] == 'l') {
        prevSame[i] = idxL;
        idxL = i;
      } else {
        prevSame[i] = idxR;
        idxR = i;
      }
    }

    // dp[i][j] is number of distinct subsequnces of length i to end up at j
    long[][] dp = new long[s.length + 1][n + 1];
    dp[0][x] = 1;
    for (int i = 1; i <= s.length; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = dp[i - 1][j];
        if (s[i - 1] == 'l') {
          if (j + 1 <= n) {
            dp[i][j] += dp[i - 1][j + 1];
          }
          if (j + 1 <= n && prevSame[i - 1] >= 0) {
            dp[i][j] -= dp[prevSame[i - 1] + 1 - 1][j + 1];
          }
        } else {
          if (j - 1 >= 0) {
            dp[i][j] += dp[i - 1][j - 1];
          }
          if (j - 1 >= 0 && prevSame[i - 1] >= 0) {
            dp[i][j] -= dp[prevSame[i - 1] + 1 - 1][j - 1];
          }
        }
        dp[i][j] = (dp[i][j] + MOD) % MOD;
      }
    }
    return (int)dp[s.length][y];
  }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */
