package basic.thread;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author arronshentu
 */
public class FutureDemo {
  public static void main(String[] args) {
    // Future
    // Callable
    // CompletableFuture
    int[] sorted = new int[] {1, 3, 5, 6, 7, 7};
    // 如果结果 < 0
    // -结果-1 就是第一个 >= 它的数
    // 如果结果 > 0
    // 就是它在数组中出现的第一个数
    System.out.println(Arrays.binarySearch(sorted, 1));
    System.out.println(Arrays.binarySearch(sorted, 2));
    System.out.println(Arrays.binarySearch(sorted, 7));
    System.out.println(Arrays.binarySearch(sorted, 8));
    System.out.println(Arrays.binarySearch(sorted, 6));
    System.out.println(Arrays.binarySearch(sorted, 0));
    System.out.println(binarySearch(sorted, 1));
    System.out.println(binarySearch(sorted, 2));
    System.out.println(binarySearch(sorted, 7));
    System.out.println(binarySearch(sorted, 8));
    System.out.println(binarySearch(sorted, 6));
    System.out.println(binarySearch(sorted, 0));

  }

  private static int binarySearch(int[] nums, int target) {
    // 找到大于target的第一个数
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
