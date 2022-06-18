package random;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author arronshentu
 */
public class Photos {
  String path = "/Users/arronshentu/Downloads/Photos";
  private static String yearlyPath = "/Users/arronshentu/Downloads/YearlyPhotos/";
  private static String output = "/Users/arronshentu/Project/21FALL/algo/photos.csv";
  private static String databaseOutput = "/Users/arronshentu/Project/21FALL/algo/bills_photos.csv";
  private static int count = 0;
  // errors
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_7800.JPG
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_7899.JPG
  /// Users/arronshentu/Downloads/Photos/10/Photos/IMG_2771.MOV
  /// Users/arronshentu/Downloads/Photos/12/Photos/IMG_2913.MOV
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_5795.HEIC
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_1307.HEIC
  /// Users/arronshentu/Downloads/Photos/3/Photos/IMG_1255.JPG
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_2230.HEIC
  /// Users/arronshentu/Downloads/Photos/1/Photos/IMG_2825.HEIC
  /// Users/arronshentu/Downloads/Photos/3/Photos/IMG_38641.JPG

  public static void main(String[] args) throws IOException {
    Photos photos = new Photos();
    photos.dateformat();
    // String demo = "/Users/arronshentu/Downloads/Photos/20/Photos/Photo Details.csv";
    // Files.deleteIfExists(Path.of(output));
    // Files.createFile(Path.of(output));
    // readDetails(Path.of(demo));
    // core();
    List<String> strings = Files.readAllLines(Path.of(output));
    for (String string : strings) {
      String[] split = string.split(",");
      String path = split[2];
      Path source = Path.of(path);
      // System.out.println(source.getFileName());
      LocalDateTime dateTime = LocalDateTime.parse(split[1], DateTimeFormatter.ISO_DATE_TIME);

      Path target = Path.of(yearlyPath + dateTime.getYear() + File.separator + dateTime.getMonthValue() + File.separator
        + source.getFileName());
      if (Files.notExists(target)) {
        Files.createDirectories(target.getParent());
      }
      try {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
        System.err.println(source);
        // throw new RuntimeException(e);
      }
    }
  }

  private static Map<String, Long> reverse = new HashMap<>();

  void dateformat() {
    Map<Long, String> monthOfYear = new HashMap<>();
    monthOfYear.put(1L, "January");
    monthOfYear.put(2L, "February");
    monthOfYear.put(3L, "March");
    monthOfYear.put(4L, "April");
    monthOfYear.put(5L, "May");
    monthOfYear.put(6L, "June");
    monthOfYear.put(7L, "July");
    monthOfYear.put(8L, "August");
    monthOfYear.put(9L, "September");
    monthOfYear.put(10L, "October");
    monthOfYear.put(11L, "November");
    monthOfYear.put(12L, "December");
    monthOfYear.forEach((k, v) -> reverse.put(v, k));
  }

  private static void core() throws IOException {
    Photos photos = new Photos();
    List<Path> paths = Files.list(Paths.get(photos.path)).toList();

    paths.forEach(path -> {
      Path details = Paths.get(path + File.separator + "Photos" + File.separator + "Photo Details.csv");
      if (Files.exists(details)) {
        try {
          List<String[]> strings = readDetails(details);
          System.out.println("[Processing]: " + details);
          strings.forEach(string -> {
            try {
              Files.writeString(Path.of(output), string[0] + "," + string[1] + "," + string[2] + "\n",
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
              System.err.println(details);
              throw new RuntimeException(e);
            }
          });
          System.out.println("[Done]: " + details);
          count += strings.size();
        } catch (IOException e) {
          System.err.println(details);
        }
      }
    });
    System.out.println("[" + count + "] jobs are done!");
  }

  private static List<String[]> readDetails(Path detailPath) throws IOException {
    List<String> allLines = Files.readAllLines(detailPath, StandardCharsets.UTF_8);
    Path parent = detailPath.getParent();
    String parentPath = parent + File.separator;
    List<String[]> names = allLines.stream().skip(1L).map(line -> {
      int i = line.indexOf(',');
      if (i == -1) {
        System.err.println(detailPath + ": " + line);
        return null;
      }
      String name = line.substring(0, i);
      return new String[] {name, line.substring(i + 2, line.length() - 1), parentPath + name};
    }).filter(Objects::nonNull).toList();
    names.forEach(e -> {
      StringBuilder time = parseTime(e);
      e[1] = time.toString();
    });
    // names.forEach(e -> System.out.println(Arrays.toString(e)));
    return names;
  }

  private static StringBuilder parseTime(String[] e) {
    int space = e[1].indexOf(' ');
    e[1] = e[1].substring(space + 1, e[1].length() - 4);
    space = e[1].indexOf(' ');
    Long month = reverse.get(e[1].substring(0, space));
    StringBuilder res = new StringBuilder();
    e[1] = e[1].substring(space);
    String day = e[1].substring(1, e[1].indexOf(','));
    if (day.length() < 2) {
      day = "0" + day;
    }
    res.append(e[1], e[1].indexOf(',') + 1, e[1].indexOf(',') + 5);
    res.append('-');
    if (month < 10) {
      res.append(0);
    }
    res.append(month);
    res.append("-");
    res.append(day);
    String time = e[1].substring(e[1].indexOf(',') + 6);
    // System.out.println(time);
    // 11:00 PM
    boolean isAm = "AM".equals(time.substring(time.length() - 2));
    time = time.split(" ")[0];
    String[] strings = time.split(":");
    if (!isAm && !"12".equals(strings[0])) {
      strings[0] = String.valueOf(Integer.parseInt(strings[0]) + 12);
    }
    if (strings[0].length() < 2) {
      strings[0] = "0" + strings[0];
    }
    // System.out.println(time.substring(time.length() - 2));
    res.append("T").append(strings[0]).append(":").append(strings[1]);
    return res;
  }
}
