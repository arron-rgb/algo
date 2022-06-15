import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) throws IOException {
    Weekly weekly = new Weekly();

  }

  public int[][] merge(int[][] intervals) {
    List<int[]> res = new ArrayList<>();
    for (int[] interval : intervals) {
      int left = interval[0], right = interval[1];
      if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
        res.add(new int[] {left, right});
      } else {
        res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
      }
    }
    return res.toArray(new int[0][]);
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
