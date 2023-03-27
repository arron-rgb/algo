import edu.neu.algo.leetcode.editor.en._20220707.ShuffleTheArray;
import edu.neu.algo.monotonic.leetcode.editor.en._20220812.FindAllAnagramsInAString;
import edu.neu.base.ListNode;
import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

/**
 * @author arronshentu
 */
public class Weekly {

  public static void main(String[] args) throws IOException {
    // Solution solution = new Weekly().new Solution();

    String[] data = """
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // solution
      // List<Long> q = solution.minOperations((int[])params[1 - 1 + i * paramTypes.length],
      // (int[])params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
    }

  }

}
