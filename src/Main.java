import edu.neu.util.InputUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.countGood(new int[] {3, 1, 4, 3, 2, 2, 4}, 2));
    long l = main.countGood(new int[] {1, 1, 1, 1, 1}, 10);
    System.out.println(l);
  }

  public long countGood(int[] nums, int k) {
    long res = 0;
    long cur = 0;
    Map<Integer, Integer> count = new HashMap<>();
    int n = nums.length;
    for (int i = 0, j = 0; i < n; i++) {
      while (j < n && cur < k) {
        int t = count.getOrDefault(nums[j], 0);
        cur += t;
        count.put(nums[j], t + 1);
        j++;
      }
      if (cur >= k) {
        res += n - j + 1;
      }
      cur -= count.get(nums[i]) - 1;
      count.put(nums[i], count.get(nums[i]) - 1);
    }
    return res;
  }

}
