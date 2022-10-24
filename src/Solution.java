import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author arronshentu
 */
public class Solution {
  public static void main(String[] args) {
    long between = ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 17), LocalDate.now());
    System.out.println(between);

    // System.out.println(.minus());
  }

}
