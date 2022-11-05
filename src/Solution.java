import edu.neu.base.TreeNode;
import edu.neu.util.InputUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/** * @author arronshentu */
public class Solution {
  public static void main(String[] args) {
    System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 17), LocalDate.now()));
  }

}
