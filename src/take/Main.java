package take;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author arronshentu
 */
public class Main {
  private static final String path = "/Users/arronshentu/Downloads/ProgrammingTest/InputFiles";
  private static final String outPath = "/Users/arronshentu/Downloads/ProgrammingTest/OutputFiles";

  public static void main(String[] args) throws IOException {
    List<LetterComparator> comparators = new ArrayList<>();
    LastLetter e = new LastLetter();
    comparators.add(e);

    String a = "Isaac";
    String b = "Mac";
    String c = "Issac";
    System.out.println(e.compare("Zachary", "Mary"));
    List<String> strs = new ArrayList<>(Arrays.asList(a, b, c));
    bubbleSort(strs, e);
    System.out.println(strs);
    // System.out.println(e.compare(a, b));// expected 1
    test(readStrings(), List.of(e));
    // System.out.println(words.size());
  }

  private static void test(List<List<String>> collect, List<LetterComparator> comparators) {
    for (LetterComparator comparator : comparators) {
      long start = System.currentTimeMillis();
      List<String> words = new ArrayList<>(collect.stream().flatMap(Collection::stream).toList());
      long end = System.currentTimeMillis();
      bubbleSort(words, comparator);
      // words.sort(comparator);
      System.out.print(comparator.getName() + ": " + (end - start));
      generateOutput(comparator, words);
    }
  }

  private static void bubbleSort(List<String> list, LetterComparator comparator) {
    int n = list.size();
    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < n - i - 1; j++)
        if (comparator.compare(list.get(i), list.get(j)) > 0) {
          String s = list.get(j);
          list.set(j, list.get(j + 1));;
          list.set(j + 1, s);
        }
  }

  private static List<List<String>> readStrings() throws IOException {
    Path p = Path.of(path);
    List<Path> inputs = Files.list(p).toList();
    List<List<String>> collect = inputs.stream().<List<String>>map(t -> {
      if (Files.isRegularFile(t)) {
        try {
          return Files.readAllLines(t);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return List.of();
    }).toList();
    return collect;
  }

  private static void generateOutput(LetterComparator comparator, List<String> words) {
    String output = outPath + "/" + comparator.getName() + "Output.txt";
    Path dir = Path.of(outPath + "/");
    Path p = Path.of(output);

    try {
      Files.deleteIfExists(p);
      if (!Files.exists(dir)) {
        Files.createDirectory(dir);
      }
      Files.createFile(p);
      Files.writeString(p, words.stream().reduce("", (origin, t) -> origin + "\n" + t));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static abstract class LetterComparator implements Comparator<String> {
    String getName() {
      return "";
    };
  }

  private static class LastLetter extends LetterComparator {
    public LastLetter() {}

    String getName() {
      return "LastLetter";
    };

    @Override
    public int compare(String first, String second) {
      int i = first.length() - 1;
      int j = second.length() - 1;
      while (i >= 0 && j >= 0) {
        // char t = Character.toLowerCase(o1.charAt(i));
        // char p = Character.toLowerCase(o2.charAt(j));
        char t = first.charAt(i);
        char p = second.charAt(j);
        if (t < p) {
          return -1;
        } else if (t > p) {
          return 1;
        }
        i--;
        j--;
      }
      return -i + j;
    }
  }
}
