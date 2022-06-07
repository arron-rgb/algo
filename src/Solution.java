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
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */
