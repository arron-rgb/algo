import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/** * @author arronshentu */
public class Solution {
  public static void main(String[] args) {
    // System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 17), LocalDate.now()));
    Solution solution = new Solution();
    solution.solution(new int[] {25, 35, 872, 228, 53, 278, 872});
    solution.letterCasePermutation("1a2b");
  }

  public List<String> letterCasePermutation(String s) {
    List<String> res = new ArrayList<>();
    dfs(res, s.toCharArray(), 0);
    return res;
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), nums, 0);
    return res;
  }

  void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int i) {
    if (tmp.size() == nums.length) {
      return;
    }
    for (int j = i + 1, n = nums.length; j < n; j++) {
      tmp.add(nums[j]);
      // 要
      dfs(res, tmp, nums, j);
      tmp.remove(nums[j]);
      // 不要
      dfs(res, tmp, nums, j);
    }
  }

  void dfs(List<String> res, char[] chars, int i) {
    if (i >= chars.length) {
      res.add(new String(chars));
      return;
    }
    if (Character.isLetter(chars[i])) {
      chars[i] ^= 1 << 5;
      dfs(res, chars, i + 1);
    }
    chars[i] ^= 1 << 5;
    dfs(res, chars, i + 1);
  }

  long solution(int[] a) {
    long res = 0;
    HashMap<String, Long> hm = new HashMap<>();
    for (int i : a) {
      String s = String.valueOf(i);
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String sorted = new String(c);
      hm.put(sorted, hm.getOrDefault(sorted, 0L) + 1);
    }
    for (long k : hm.values()) {
      long nCr = k * (k - 1) / 2;
      res += nCr;
    }
    return res;
  }

  int solve(int[][] matrix, int length, int breath) {
    int maxSum = 0;
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[x].length; y++) {
        int sum = 0;
        boolean canBeRectangle = true;
        for (int lengthMoves = 0; lengthMoves < length && canBeRectangle; lengthMoves++) {
          // -- Both increase by one
          // each time.
          int columnNoOfStartingPointOfDiagonal = x + lengthMoves;
          int rowNoOfStartingPointOfDiagonal = y + lengthMoves;
          for (int breathMoves = 0; breathMoves < breath && canBeRectangle; breathMoves++) {
            if (columnNoOfStartingPointOfDiagonal - breathMoves >= 0
              && columnNoOfStartingPointOfDiagonal - breathMoves < matrix[0].length
              && rowNoOfStartingPointOfDiagonal + breathMoves < matrix.length) {
              sum +=
                matrix[rowNoOfStartingPointOfDiagonal + breathMoves][columnNoOfStartingPointOfDiagonal - breathMoves];
            } else {
              canBeRectangle = false;
            }
          }
          if (lengthMoves < length - 1) {
            columnNoOfStartingPointOfDiagonal = x + lengthMoves;
            rowNoOfStartingPointOfDiagonal = y + lengthMoves + 1;
            for (int breathMoves = 0; breathMoves < breath - 1 && canBeRectangle; breathMoves++) {
              if (columnNoOfStartingPointOfDiagonal - breathMoves >= 0
                && rowNoOfStartingPointOfDiagonal + breathMoves < matrix.length) {
                sum +=
                  matrix[rowNoOfStartingPointOfDiagonal + breathMoves][columnNoOfStartingPointOfDiagonal - breathMoves];
              } else {
                canBeRectangle = false;
              }
            }
          }
        }
        if (canBeRectangle) {
          maxSum = Math.max(maxSum, sum);
        }
      }
    }
    return maxSum;
  }

  class MaxStack {
    Deque<Integer> deque;
    Deque<Integer> max;

    public MaxStack() {
      max = new ArrayDeque<>();
      deque = new ArrayDeque<>();
    }

    public void push(int x) { // [1,4,2,5,5] // [1,4,4,5,5]
      deque.addLast(x);
      int maxValue = max.isEmpty() ? x : Math.max(max.peekLast(), x);
      max.addLast(maxValue);
    }

    public int pop() {
      max.pollLast();
      return deque.pollLast();
    }

    public int top() {
      return deque.peekLast();
    }

    public int peekMax() {
      return max.peekLast();
    }

    public int popMax() {
      Deque<Integer> helper = new ArrayDeque<>();
      int res = max.peekLast();
      if (Objects.equals(res, deque.peekLast())) {
        max.pollLast();
        return deque.pollLast();
      }
      while (!deque.isEmpty() && !Objects.equals(res, deque.peekLast())) {
        Integer integer = deque.pollLast();
        max.pollLast();
        helper.addLast(integer);
      }
      pop();
      while (!helper.isEmpty()) {
        push(helper.pollLast());
      }
      return res;
    }
  }

  public int minimumCost(int n, int[][] connections) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    Set<Integer> set = new HashSet<>();
    int costs = 0;
    for (int[] edge : connections) {
      int x = edge[0], y = edge[1], cost = edge[2];
      map.computeIfAbsent(x, t -> new ArrayList<>()).add(new int[] {y, cost});
      map.computeIfAbsent(y, t -> new ArrayList<>()).add(new int[] {x, cost});
    }
    queue.add(new int[] {1, 1, 0});
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0], y = cur[1], cost = cur[2];
      if (set.add(y)) {
        costs += cost;
        for (int[] ints : map.get(y)) {
          queue.add(new int[] {y, ints[0], ints[1]});
        }
      }
    }
    return set.size() == n ? costs : -1;
  }
}
