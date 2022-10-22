package edu.neu.basic;

/**
 * @author arronshentu
 */
public class BinarySearch {
  class Solution {
    public int[] searchRange(int[] nums, int target) {
      if (nums.length == 0) {
        return new int[] {-1, -1};
      }
      int left = leftBound(nums, target);
      if (left == -1) {
        return new int[] {-1, -1};
      }
      int right = leftBound(nums, target + 1);
      if (right == -1) {
        return new int[] {left, nums.length - 1};
      }
      System.out.println(right);
      return new int[] {left, right - 1};
    }

    int leftBound(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return nums[left] == target ? left : -1;
    }
  }

  public static void main(String[] args) {
    Solution solution = new BinarySearch().new Solution();
    solution.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
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
