import java.util.Arrays;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) {
    Weekly weekly = new Weekly();
    // []
    // 13
    // 46
  }

  public int countPrefixes(String[] words, String s) {
    return (int)Arrays.stream(words).filter(s::startsWith).count();
  }
}
