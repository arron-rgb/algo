package edu.neu.algo.dp.leetcode.editor.en._20220714;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import edu.neu.util.InputUtil;

public class ShortestSubarrayWithSumAtLeastK {

  public static void main(String[] args) {

    List<String> data3 = Arrays.asList(
      "AQAAALB7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6Imdvb2RfdGlsX2RheSIsInJlcGxhY2VkIjpmYWxzZSwicmVkdWNlX29ubHkiOmZhbHNlLCJwcm9maXRfbG9zcyI6MCwicHJpY2UiOjAuMDAxLCJwb3N0X29ubHkiOmZhbHNlLA==",
      "AAAAAFwib3JkZXJfdHlwZSI6ImxpbWl0Iiwib3JkZXJfc3RhdGUiOiJjYW5jZWxsZWQiLCJvcmRlcl9pZCI6IkVUSC0xOTYwNzUxNjIwOCIsIm1heF9zaG93Ijo0MjR9fQ==",
      "AQAAAJl7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImVfaW5fZm9yY2UiOiJnb29kX3RpbF9kYXkiLCJyZXBsYWNlZCI6ZmFsc2UsInJlZHVjZV9vbmx5IjpmYWxzZSwicHJvZml0X2xvc3MiOjAsInByaWNlIjowLjAwMSwicG9zdF9vbmx5IjpmYWxzZSw=",
      "Af///5xub3RlOiB0aGlzIGlzIGFuIGludmFsaWQgaW50ZXJtZWRpYXRlIHBhY2tldA==",
      "AAAAAEwiaXQiLCJvcmRlcl9zdGF0ZSI6ImNhbmNlbGxlZCIsIm9yZGVyX2lkIjoiRVRILTE5NjA3NTE2MjA4IiwibWF4X3Nob3ciOjQyNH19");
    List<String> data4 = List.of(
      "AQAAALB7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6Imdvb2RfdGlsX2RheSIsInJlcGxhY2VkIjpmYWxzZSwicmVkdWNlX29ubHkiOmZhbHNlLCJwcm9maXRfbG9zcyI6MCwicHJpY2UiOjAuMDAxLCJwb3N0X29ubHkiOmZhbHNlLAECAwQFBgcICQo=",
      "AAAAAFwib3JkZXJfdHlwZSI6ImxpbWl0Iiwib3JkZXJfc3RhdGUiOiJjYW5jZWxsZWQiLCJvcmRlcl9pZCI6IkVUSC0xOTYwNzUxNjIwOCIsIm1heF9zaG93Ijo0MjR9fQ==",
      "AQAAALB7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6Imdvb2RfdGlsX2RheSIsInJlcGxhY2VkIjpmYWxzZSwicmVkdWNlX29ubHkiOmZhbHNlLCJwcm9maXRfbG9zcyI6MCwicHJpY2UiOjAuMDAxLCJwb3N0X29ubHkiOmZhbHNlLA==",
      "AAAAAFwib3JkZXJfdHlwZSI6ImxpbWl0Iiwib3JkZXJfc3RhdGUiOiJjYW5jZWxsZWQiLCJvcmRlcl9pZCI6IkVUSC0xOTYwNzUxNjIwOCIsIm1heF9zaG93Ijo0MjR9fQECAwQFBgcICQo=");
    List<String> data7 = List.of("Af////9ub3RlOiB0aGlzIGlzIGFuIGludmFsaWQgcGFja2V0",
      "AP////9ub3RlOiB0aGlzIGlzIGFuIGludmFsaWQgcGFja2V0",
      "AQAAALB7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6Imdvb2RfdGlsX2RheSIsInJlcGxhY2VkIjpmYWxzZSwicmVkdWNlX29ubHkiOmZhbHNlLCJwcm9maXRfbG9zcyI6MCwicHJpY2UiOjAuMDAxLCJwb3N0X29ubHkiOmZhbHNlLA==",
      "AAAAAFwib3JkZXJfdHlwZSI6ImxpbWl0Iiwib3JkZXJfc3RhdGUiOiJjYW5jZWxsZWQiLCJvcmRlcl9pZCI6IkVUSC0xOTYwNzUxNjIwOCIsIm1heF9zaG93Ijo0MjR9fQ==",
      "AQAAAJl7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImVfaW5fZm9yY2UiOiJnb29kX3RpbF9kYXkiLCJyZXBsYWNlZCI6ZmFsc2UsInJlZHVjZV9vbmx5IjpmYWxzZSwicHJvZml0X2xvc3MiOjAsInByaWNlIjowLjAwMSwicG9zdF9vbmx5IjpmYWxzZSw=",
      "Af///5xub3RlOiB0aGlzIGlzIGFuIGludmFsaWQgaW50ZXJtZWRpYXRlIHBhY2tldA==",
      "AAAAAEwiaXQiLCJvcmRlcl9zdGF0ZSI6ImNhbmNlbGxlZCIsIm9yZGVyX2lkIjoiRVRILTE5NjA3NTE2MjA4IiwibWF4X3Nob3ciOjQyNH19",
      "AQAAALB7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uRVRILnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6Imdvb2RfdGlsX2RheSIsInJlcGxhY2VkIjpmYWxzZSwicmVkdWNlX29ubHkiOmZhbHNlLCJwcm9maXRfbG9zcyI6MCwicHJpY2UiOjAuMDAxLCJwb3N0X29ubHkiOmZhbHNlLA==",
      "AAAAAFwib3JkZXJfdHlwZSI6ImxpbWl0Iiwib3JkZXJfc3RhdGUiOiJjYW5jZWxsZWQiLCJvcmRlcl9pZCI6IkVUSC0xOTYwNzUxNjIwOCIsIm1heF9zaG93Ijo0MjR9fQECAwQFBgcICQo=",
      "AAAAABR7ImhlYXJ0YmVhdCI6InBpbmcifQ==", "AAAAAGQiIm5vdGU6IHRoaXMgaXMgYW4gaW52YWxpZCBwYWNrZXQ=",
      "AAAAABR7ImhlYXJ0YmVhdCI6InBvbmcifQ==");

    List<String> example = List.of(
      "AAAAAHR7ImNoYW5uZWwiOiJ1c2VyLm9yZGVycy5vcHRpb24uQlRDLnJhdyIsImRhdGEiOnsid2ViIjpmYWxzZSwidGltZV9pbl9mb3JjZSI6ImltbWVkaWF0ZV9vcl9jYW5jZWwiLCJyZXBsYWNlZCI6ZmFsc2V9fQ==");
    // List.of(example).forEach(data -> {
    List.of(data3, data4, data7).forEach(data -> {
      List<byte[]> input = data.stream().map(e -> Base64.getDecoder().decode(e)).collect(Collectors.toList());
      parseFrame(input).forEach(System.out::println);
      System.out.println("-----");
    });
  }

  public static List<String> parseFrame(List<byte[]> packets) {
    List<String> res = new ArrayList<>();
    final StringBuilder[] frame = {new StringBuilder()};
    // 1: continued
    // 0: last
    final Boolean[] error = {null};
    packets.forEach(packet -> {
      if ((packet[0] == 0) || (packet[0] == 1)) {
        if (Boolean.TRUE.equals(error[0])) {
          if (packet[0] == 1) {
            // error[0] = true;
          } else if (packet[0] == 0) {
            error[0] = null;
          }
          return;
        }
        byte[] lenBytes = new byte[4];
        System.arraycopy(packet, 1, lenBytes, 0, lenBytes.length);
        int length = byteArrayToInt(lenBytes);
        // check length
        if (length <= 0) {
          System.err.println("Negative size: " + length);
          frame[0] = new StringBuilder();
          error[0] = true;
          return;
        }
        byte[] content = new byte[length];
        if (length > packet.length) {
          System.err.println("Expected length: " + length + " Actual has: " + packet.length);
          frame[0] = new StringBuilder();
          error[0] = true;
          return;
        } else {
          System.arraycopy(packet, 5, content, 0, length);
        }
        String body = new String(content);
        // System.err.println(packet[0] + ": " + body);
        if (packet[0] == 0) {
          frame[0].append(body);
          res.add(frame[0].toString());
          frame[0] = new StringBuilder();
        } else {
          frame[0].append(body);
        }
      } else {
        System.err.println("Invalid magic value: " + packet[0]);
      }
    });
    return res;
  }

  public static int byteArrayToInt(byte[] bytes) {
    int value = 0;
    for (int i = 0; i < bytes.length; i++) {
      int shift = (4 - 1 - i) * 8;
      value += (bytes[i] & 0x000000FF) << shift;
    }
    return value;
  }
}
