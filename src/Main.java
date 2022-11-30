import edu.neu.util.InputUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.test(new int[] {3, 1, 2});
    main.test(new int[] {1, 2, 4, 3});
  }

  void test(int[] nums) {
    int n = nums.length;
    int[] sorted = Arrays.copyOf(nums, n);
    Arrays.sort(sorted);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      // 把排序后的数字对应的位置存入map
      map.put(sorted[i], i);
    }
    int loops = 0;
    // 数所在的位置是否已在排序后的位置上
    boolean[] flags = new boolean[n];
    for (int i = 0; i < n; i++) {
      // 遍历未排序的数组
      if (!flags[i]) {
        // 如果当前数与其排序后的位置不符合
        int j = i;
        //
        while (!flags[j]) {
          flags[j] = true;
          j = map.get(nums[j]);
        }
        // 有多少个环 or 有多少个单元
        // 如果某个数组已经有序，则应有n个单元。环中每多一个数，相应的环的数量就会-1
        // 需要交换的数量就会+1
        // 所以可以通过 应有的n个环 - 实际出现的环的个数 = 交换的次数
        loops++;
      }
    }

    System.out.println(n - loops);
  }
}
