package edu.neu;

import java.util.*;

/**
 * @author arronshentu
 */
public class LCP03 {
  class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
      int sx = 0;
      int sy = 0;
      for (char c : command.toCharArray()) {
        if (c == 'U') {
          sy++;
        } else {
          sx++;
        }
      }
      if (!canReach(command, x, y, sx, sy)) {
        return false;
      }
      for (int[] obstacle : obstacles) {
        if (obstacle[0] > x || obstacle[1] > y) {
          continue;
        }
        if (canReach(command, obstacle[0], obstacle[1], sx, sy)) {
          return false;
        }
      }
      return true;
    }

    public boolean canReach(String command, int tx, int ty, int x, int y) {
      int round = Math.min(tx / x, ty / y);
      int nx = round * x;
      int ny = round * y;
      if (nx == tx && ny == ty) {
        return true;
      }

      for (char c : command.toCharArray()) {
        if (c == 'U') {
          ny++;
        } else {
          nx++;
        }

        if (nx > tx || ny > ty) {
          return false;
        }
        if (nx == tx && ny == ty) {
          return true;
        }
      }
      return true;
    }
  }

  class Heap {
    List<Item> list;
    int sum;

    public Heap(List<Item> list) {
      this.list = list;
      sum = 0;
      for (Item item : list) {
        sum += item.weight;
      }
    }

    Heap[] remove(int id) {
      int index = -1;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).id == id) {
          index = i;
          break;
        }
      }
      if (index == 0 || index == list.size() - 1) {
        sum -= list.get(index).weight;
        list.remove(index);
        return new Heap[] {this};
      }
      return new Heap[] {new Heap(list.subList(0, index)), new Heap(list.subList(index + 1, list.size()))};
    }
  }

  // class Item {
  // int id;
  // int weight;
  // }
  record Item(int id, int weight) {
  }

  void solve() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // int[] weights = new int[n];
    List<Item> weights = new ArrayList<>();
    // 拆分完以后 怎么根据
    for (int i = 0; i < n; i++) {
      // weights[i] = scanner.nextInt();
      Item item = new Item(i, scanner.nextInt());
      weights.add(item);
    }
    PriorityQueue<Heap> queue = new PriorityQueue<>(Comparator.comparingInt(q -> q.sum));
    queue.add(new Heap(weights));
    for (int i = 0; i < n; i++) {
      Heap tmp = queue.poll();
      Heap[] heaps = tmp.remove(scanner.nextInt());
      Collections.addAll(queue, heaps);
    }
  }

}
