package edu.neu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author arronshentu
 */
public class InputUtil {

  public static void main(String[] args) {
    int[][] ints = stringToArrays("[[1,2]]");
    System.out.println(Arrays.deepToString(ints));
  }

  public static int[] stringToArray(String s) {
    if (s.startsWith("[")) {
      s = s.substring(1, s.length() - 1);
    }
    String[] split = s.split(",");
    return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
  }

  public static int[][] stringToArrays(String s) {
    // [[1,2],[1,2],[1,2]]
    if (s.startsWith("[[")) {
      s = s.substring(2, s.length() - 2);
    }
    String[] split = s.split("],\\[");
    List<int[]> res = new ArrayList<>();
    for (String s1 : split) {
      res.add(stringToArray(s1));
    }

    return res.toArray(new int[0][]);
  }
}
