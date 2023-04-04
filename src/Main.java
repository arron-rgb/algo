import java.util.*;

/**
 * @author arronshentu
 */
public class Main {

  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    long N = kb.nextLong();
    long M = kb.nextLong();

    long MAX = Math.round(Math.sqrt(M) + 10);

    MAX = Math.min(MAX, N);
    long X = Long.MAX_VALUE;
    for (long a = 1; a <= MAX; a++) {
      long b = (M - 1) / a + 1;
      b = Math.min(b, N);
      if (a * b >= M) {
        X = Math.min(X, a * b);
      }
    }
    if (X == Long.MAX_VALUE) {
      X = -1;
    }
    System.out.println(X);
  }
}
