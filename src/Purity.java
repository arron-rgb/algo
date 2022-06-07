import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import edu.neu.base.TreeNode;

public class Purity {
  static String path = "/Users/arronshentu/Project/21FALL/algo/src/submit.txt";
  static DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
  static DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMdd");

  public static void main(String[] args) throws IOException {
    Purity purity = new Purity();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(5);

    // solve();
  }

  private static void solve() throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    String content = new String(bytes);
    Set<String> problems = new HashSet<>();
    String[] lines = content.split("\n");
    Map<String, String> problemDay = new HashMap<>();

    TreeMap<String, String[]> daily = new TreeMap<>();
    for (String line : lines) {
      line = line.substring(0, line.length() - 1);
      String[] singleDay = line.split(":");

      String[] questions = singleDay[2].split(",");

      String[] copy = new String[questions.length];
      for (int i = 0; i < questions.length; i++) {
        String question = questions[i];
        if (problems.contains(question)) {
          copy[i] = "[复习][" + problemDay.get(question) + "]" + question;
        } else {
          problems.add(question);
          LocalDate date = LocalDate.parse(singleDay[0], inputFormatter);
          problemDay.put(question, date.format(outputFormatter));
          copy[i] = question;
        }
      }
      Arrays.sort(copy, (o1, o2) -> {
        if (o1.contains("[复习]")) {
          return 1;
        }
        return o2.contains("[复习]") ? -1 : o1.compareTo(o2);
      });
      daily.put(singleDay[0], copy);
    }

    daily.forEach((k, v) -> {
      String s = Arrays.toString(v);
      s = s.replaceAll("\\[ ", "[");
      s = s.replaceAll(", {2}", ", ");
      System.out.println(k + ": " + s);
    });

    Purity purity = new Purity();
    String reformat = purity.reformat("test.email+alex@leetcode.com");
    System.out.println(reformat);
  }

  String reformat(String email) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] strings = email.split("@");
    // test.email+alex@leetcode.com
    int index = strings[0].indexOf('+');
    if (index != -1) {
      strings[0] = strings[0].substring(0, index);

    }
    stringBuilder.append(strings[0].replaceAll("\\.", ""));
    stringBuilder.append("@");
    stringBuilder.append(strings[1]);
    return stringBuilder.toString();
  }

  // public static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  //
  // public int minimumEffortPath(int[][] heights) {
  // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
  // int n = heights.length;
  // int m = heights[0].length;
  // Integer[][] minDist = new Integer[n][m];
  // minDist[0][0] = 0;
  // pq.offer(new int[] {0, 0, 0});
  // while (!pq.isEmpty()) {
  // int[] cur = pq.poll();
  // if (cur[0] == n - 1 && cur[1] == m - 1) {
  // System.out.println(Arrays.deepToString(minDist));
  // return cur[2];
  // }
  // for (int[] dir : DIRECTIONS) {
  // int nx = cur[0] + dir[0];
  // int ny = cur[1] + dir[1];
  // if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
  // continue;
  // }
  // int effort = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nx][ny]));
  // if (minDist[nx][ny] == null || minDist[nx][ny] > effort) {
  // minDist[nx][ny] = effort;
  // pq.offer(new int[] {nx, ny, minDist[nx][ny]});
  // }
  // }
  // }
  //
  // return -1;
  //
  // }

  private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    boolean[][] visited = new boolean[m][n];
    // 优先队列保证每次出来的都是目前差值最小的 <[x, y, 到达heights[x][y]最大路径高度差值]>
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    // 加入起点，起点就是终点的话差值就是0
    minHeap.add(new int[] {0, 0, 0});
    while (!minHeap.isEmpty()) {
      int[] cur = minHeap.poll();
      int x = cur[0], y = cur[1], maxValue = cur[2];
      // 如果当前节点被访问过就不能继续，避免死循环
      if (visited[x][y])
        continue;
      // System.out.printf("(%d, %d, %d) start\n", x, y, maxValue);
      // 优先队列根据最大路径差值进行poll，poll出来的如果是终点，就说明已经找到了最小体力消耗的路径，结果就是最小路径上的最大路径高度差值
      if (x == m - 1 && y == n - 1)
        return maxValue;
      visited[x][y] = true;
      for (int[] dir : dirs) {
        int x1 = x + dir[0], y1 = y + dir[1];
        // 邻节点的边界处理
        if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n)
          continue;
        // 到达邻接点的最大路径高度差值只依赖了当前节点和邻节点的高度差，也就是heights[x][y]-heights[x1][y1]，而maxValue为到达(x, y)的最大路径高度差值，
        // maxValue在到达(x1, y1)之前已经计算过。根据题目要求，每一个邻接点都需要更新到达邻接点的最大路径高度差值，取最大值
        minHeap.add(new int[] {x1, y1, Math.max(Math.abs(heights[x][y] - heights[x1][y1]), maxValue)});
        // System.out.printf("(%d, %d, %d)\n", x1, y1, Math.max(Math.abs(heights[x][y] - heights[x1][y1]), maxValue));
      }
    }
    return 0;
  }

}
