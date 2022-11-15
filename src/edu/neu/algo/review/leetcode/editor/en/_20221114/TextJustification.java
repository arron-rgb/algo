package edu.neu.algo.review.leetcode.editor.en._20221114;

import edu.neu.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

  // Given an array of strings words and a width maxWidth, format the text such
  // that each line has exactly maxWidth characters and is fully (left and right)
  // justified.
  //
  // You should pack your words in a greedy approach; that is, pack as many words
  // as you can in each line. Pad extra spaces ' ' when necessary so that each line
  // has exactly maxWidth characters.
  //
  // Extra spaces between words should be distributed as evenly as possible. If
  // the number of spaces on a line does not divide evenly between words, the empty
  // slots on the left will be assigned more spaces than the slots on the right.
  //
  // For the last line of text, it should be left-justified, and no extra space
  // is inserted between words.
  //
  // Note:
  //
  //
  // A word is defined as a character sequence consisting of non-space characters
  // only.
  // Each word's length is guaranteed to be greater than 0 and not exceed
  // maxWidth.
  // The input array words contains at least one word.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
  // , maxWidth = 16
  // Output:
  // [
  //    "This    is    an",
  //    "example  of text",
  //    "justification.  "
  // ]
  //
  // Example 2:
  //
  //
  // Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
  // 16
  // Output:
  // [
  //   "What   must   be",
  //   "acknowledgment  ",
  //   "shall be        "
  // ]
  // Explanation: Note that the last line is "shall be " instead of "shall
  // be", because the last line must be left-justified instead of fully-justified.
  // Note that the second line is also left-justified because it contains only one
  // word.
  //
  // Example 3:
  //
  //
  // Input: words = ["Science","is","what","we","understand","well","enough","to",
  // "explain","to","a","computer.","Art","is","everything","else","we","do"],
  // maxWidth = 20
  // Output:
  // [
  //   "Science  is  what we",
  // "understand      well",
  //   "enough to explain to",
  //   "a  computer.  Art is",
  //   "everything  else  we",
  //   "do                  "
  // ]
  //
  //
  // Constraints:
  //
  //
  // 1 <= words.length <= 300
  // 1 <= words[i].length <= 20
  // words[i] consists of only English letters and symbols.
  // 1 <= maxWidth <= 100
  // words[i].length <= maxWidth
  //
  // Related Topics Array String Simulation 👍 2124 👎 3324

  public static void main(String[] args) {
    Solution solution = new TextJustification().new Solution();
    String[] data = """
      ["ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"]
      16
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.fullJustify((String[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      List<List<String>> lists = groupWords(words, maxWidth);
      List<String> res = new ArrayList<>();
      for (int j = 0; j < lists.size(); j++) {
        List<String> list = lists.get(j);
        StringBuilder stringBuilder = new StringBuilder();
        int totalLen = list.stream().mapToInt(String::length).sum();
        int count = list.size();
        int spaces = maxWidth - totalLen;
        if (count == 1) {
          StringBuilder sb = new StringBuilder(list.get(0));
          sb.append(" ".repeat(maxWidth - sb.length()));
          res.add(sb.toString());
          continue;
        }

        int per = spaces / (count - 1);

        if (j == lists.size() - 1) {
          per = 1;
        }
        for (int i = 0, sum = 0; i < count; i++) {
          String s = list.get(i);
          stringBuilder.append(s);
          int remain = count - i - 1 - 1;
          if (count - 1 != i) {
            stringBuilder.append(" ".repeat(per));
            sum += per;
            if (remain * per + sum < maxWidth) {
              stringBuilder.append(" ");
              sum++;
            }
          }
          spaces -= per;
        }
        if (stringBuilder.length() < maxWidth) {
          stringBuilder.append(" ".repeat(maxWidth - stringBuilder.length()));
        }
        res.add(stringBuilder.toString());
      }
      // 最后一行
      return res;
    }

    List<List<String>> groupWords(String[] words, int maxWidth) {
      int c = 0;
      List<List<String>> res = new ArrayList<>();
      List<String> tmp = new ArrayList<>();
      for (String word : words) {
        if (word.length() + c + tmp.size() - 1 >= maxWidth) {
          res.add(new ArrayList<>(tmp));
          tmp.clear();
          c = 0;
        }
        tmp.add(word);
        c += word.length();
      }
      res.add(tmp);
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
