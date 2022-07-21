package random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arronshentu
 */
public class Test {

  String data = """
    """;
  Map<String, String> map = new HashMap<>();

  void test() {
    String[] lines = data.split("\n");
    for (String line : lines) {
      String[] tmp = line.split("\t");
      if (map.containsKey(tmp[0])) {
        if (map.get(tmp[0]).compareTo(tmp[1]) < 0) {
          map.put(tmp[0], tmp[1]);
        }
      } else {
        map.put(tmp[0], tmp[1]);
      }
    }
    map.forEach((k, v) -> System.out.println(k + "," + v));
  }

  public static void main(String[] args) {
    Test test = new Test();
    test.test();
  }
}
