import java.io.IOException;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) throws IOException {
    Weekly weekly = new Weekly();
  }

  public void duplicateZeros(int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int i : arr) {
      list.add(i);
      if (i == 0) {
        list.add(i);
      }
    }
    System.out.println(list);
    arr = list.stream().limit(arr.length).mapToInt(t -> t).toArray();
    System.out.println(Arrays.toString(arr));
  }

  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> queMax = new LinkedList<>();
    Deque<Integer> queMin = new LinkedList<>();
    int n = nums.length;
    int left = 0, right = 0;
    int ret = 0;
    while (right < n) {
      while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
        queMax.pollLast();
      }
      while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
        queMin.pollLast();
      }
      queMax.offerLast(nums[right]);
      queMin.offerLast(nums[right]);
      while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
        if (nums[left] == queMin.peekFirst()) {
          queMin.pollFirst();
        }
        if (nums[left] == queMax.peekFirst()) {
          queMax.pollFirst();
        }
        left++;
      }
      ret = Math.max(ret, right - left + 1);
      right++;
    }
    return ret;
  }

}
