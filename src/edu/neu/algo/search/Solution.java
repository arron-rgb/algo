package edu.neu.algo.search;

/**
 * @author arronshentu
 */
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int t = Integer.parseInt(kb.nextLine().trim());
    for (int i = 0; i < t; i++) {
      String s = kb.nextLine().trim();
      if (flag(s)) {
        System.out.println("Accept");
      } else {
        System.out.println("Wrong");
      }
    }
  }

  static boolean flag(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }
    if (!Character.isLetter(s.charAt(0))) {
      return false;
    }
    boolean hasNumber = false;
    for (char tmp : s.toCharArray()) {
      if (Character.isDigit(tmp)) {
        hasNumber = true;
      }
      if (!Character.isLetterOrDigit(tmp)) {
        return false;
      }
    }
    return hasNumber;
  }
}
