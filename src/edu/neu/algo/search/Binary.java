package edu.neu.algo.search;

import java.util.Arrays;

/**
 * @author arronshentu
 */
public class Binary {

  public int binarySearch(int[] nums, int target) {
    Arrays.sort(nums);
    // left right的取值
    int left = 0, right = nums.length;
    if (nums[left] > target) {
      return -1;
    }
    if (nums[right - 1] < target) {
      return -1;
    }
    // while里的循环停止条件
    while (left < right) {
      int mid = (left + right) / 2;
      if (target < nums[mid]) {
        // 更新left与right的值
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    // 最后的返回结果
    return left;
  }
}

// 二分的关键
// 1. left right的取值
// 2. while里的循环停止条件
// 3. 更新left与right的值
// 4. 最后的返回结果
// 一种是指向要查找数组的右边界元素的后一个元素（常规解法 1）， 一种就是指向要查找的数组的右边界元素（常规解法 2），
// 每次循环中 l 和 r 共同约束了本次查找的范围，
// 要让本次循环与上一次循环查找的范围既不重复(重复了会引起死循环)， 也不遗漏，
// 并且要让 l 和 r 共同约束的查找的范围变得无意义时不再进行查找（即跳出 while）(否则会导致访问越界)， 这其实就是所谓的循环不变量。
