package edu.neu.basic;

import java.util.Stack;

/**
 * @author arronshentu
 */
public class Combination {

  private static Stack<Integer> s = new Stack<>();
  private static int case0 = 0;

  /**
   * 袋子里有1, 2, ..., m个球。从袋子中每次取出一个，再放回，取n次。有几种可能
   *
   * @param min
   *          1
   * @param max
   *          m
   * @param cur
   *          几个球里
   * @param num
   *          取n次
   */
  private static void case0(int min, int max, int cur, int num) {
    if (cur == num) {
      case0++;
      System.out.println(s);
      return;
    }

    for (int i = min; i <= max; i++) {
      s.push(i);
      case0(min, max, cur + 1, num);
      s.pop();
    }
  }

  /**
   * 袋子里有1, 2, ..., m个球。从袋子中每次取出1个，不放回，取n次。有几种可能
   *
   * @param min
   * @param max
   * @param cur
   * @param num
   */
  private static void case1(int min, int max, int cur, int num, boolean[] visited) {
    if (cur == num) {
      case0++;
      System.out.println(s);
      return;
    }

    for (int i = min; i <= max; i++) {
      if (!visited[i]) {
        s.push(i);
        visited[i] = true;
        case1(min, max, cur + 1, num, visited);
        s.pop();
        visited[i] = false;
      }
    }
  }

  /**
   * 袋子里有1, 2, ..., m个球。从袋子中一次取出n个。有几种可能
   *
   * @param min
   * @param max
   * @param cur
   *          几个球里
   * @param num
   *          抓几个球
   */
  private static void case2(int max, int cur, int num, int curMax) {
    if (cur == num) {
      case0++;
      System.out.println(s);
      return;
    }
    for (int i = curMax + 1; i <= max; i++) {
      s.push(i);
      case2(max, cur + 1, num, i);
      s.pop();
    }
  }

  public static void main(String[] args) {
    // case0(1, 3, 0, 4);
    int min = 1;
    int max = 8;
    int num = 4;
    // case1(min, max, 0, num, new boolean[max + 1]);
    case2(max, 0, num, 0);
    System.out.println(case0);
  }
}
