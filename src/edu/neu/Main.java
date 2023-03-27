package edu.neu;

import javax.swing.table.TableRowSorter;
import java.util.*;

/**
 * @author arronshentu
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Main().new Solution();
    boolean t = s.primeSubOperation(new int[] {4, 9, 6, 10});
    System.out.println(t);
  }

  class Solution {
    public boolean primeSubOperation(int[] nums) {
      int n = nums.length;
      int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
        89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
        211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337,
        347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
        467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613,
        617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757,
        761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911,
        919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
      // n-1不变小
      // 从n-2开始变小
      if (n == 1) {
        return true;
      }
      for (int i = n - 2; i >= 0; i--) {
        // 从primes里面选一个最小的数 使得nums[i]<nums[i+1]
        // 但可以减多个2
        int min = nums[i];
        for (int j = 0; nums[j] < min && nums[i] < primes[j]; j++) {
          if (nums[i] - primes[j] < nums[i + 1]) {
            nums[i] -= primes[j];
            break;
          }
        }
      }
      for (int i = 0; i < n - 1; i++) {
        if (nums[i] >= nums[i + 1]) {
          return false;
        }
      }
      return true;
    }
  }

  public List<Long> minOperations(int[] nums, int[] queries) {
    List<Long> res = new ArrayList<>();
    long sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int n = nums.length;
    for (int query : queries) {
      long tmp = (long)query * n;
      res.add(Math.abs(tmp - sum));
    }
    return res;
  }

}
