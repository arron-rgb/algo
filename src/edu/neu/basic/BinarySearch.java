package edu.neu.basic;

/**
 * @author arronshentu
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3, 3, 4, 5, 6, 7};
    System.out.println("------binary search [right boundary]------");
    System.out.println(rightBoundary(nums, 1));
    System.out.println(rightBoundary(nums, 2));
    System.out.println(rightBoundary(nums, 3));
    System.out.println(rightBoundary(nums, 4));
    System.out.println(rightBoundary(nums, 7));
    System.out.println("------binary search [left boundary]------");
    System.out.println(leftBoundary(nums, 1));
    System.out.println(leftBoundary(nums, 2));
    System.out.println(leftBoundary(nums, 3));
    System.out.println(leftBoundary(nums, 4));
    System.out.println(leftBoundary(nums, 7));
    System.out.println("------binary search------");
    System.out.println(binarySearch(nums, 1));
    System.out.println(binarySearch(nums, 3));
    System.out.println(binarySearch(nums, 7));
  }

  /**
   * 寻找 nums中值为target的最左边的元素
   *
   * @param nums
   *          数组
   * @param target
   *          寻找的值
   * @return 最左的索引
   */
  private static int leftBoundary(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (target > nums[mid]) {
        left = mid + 1;
      } else if (target <= nums[mid]) {
        right = mid;
      }
    }
    return nums[left] == target ? left : -1;
  }

  private static int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      // 找左边界，假设target属于 [a1, b1]
      // 则mid必在[a1,b1]中，所以范围缩小至[a1, mid]
      if (target > nums[mid]) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  private static int rightBoundary(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      // 取右界的时候mid要注意+1
      int mid = left + (right - left + 1) / 2;
      // int mid = left + ((right - left) >> 1) + 1;
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return nums[right] == target ? right : -1;
  }

}
