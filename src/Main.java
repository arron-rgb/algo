import java.util.*;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    // Solution solution = main.new Solution();
    // int abcabcbb = main.lengthOfLongestSubstring("abcabcbb");
    // System.out.println(abcabcbb);
    // List<String> strs =
    // Arrays.asList("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat");
    // main.findAllConcatenatedWordsInADict(strs.toArray(new String[0]));
  }

  class Trie {
    boolean isEnd;
    Trie[] children;
    int len;

    public Trie(boolean isEnd, Trie[] children) {
      this.isEnd = isEnd;
      this.children = children;
      this.len = 0;
    }

    public Trie() {
      this.len = 0;
      this.isEnd = false;
      this.children = new Trie[26];
    }

    void addWord(String word) {
      char[] charArray = word.toCharArray();
      Trie root = this;
      int len = -1;
      for (char c : charArray) {
        if (root.children[c - 'a'] == null) {
          root.children[c - 'a'] = new Trie();
          root.len = ++len;
        } else {
          len = root.len;
        }
        root = root.children[c - 'a'];
      }
      root.len = ++len;
      root.isEnd = true;
    }

    boolean search(String word, int i) {
      if (i == word.length()) {
        return true;
      }
      Trie node = this;
      while (i < word.length()) {
        // 如果不存在，返回false
        if (node.children[word.charAt(i) - 'a'] == null) {
          return false;
        }
        node = node.children[word.charAt(i) - 'a'];
        // 如果形成了一个完整的单词，深入下一层
        if (node.isEnd && search(word, i + 1)) {
          return true;
        }
        i++;
      }
      return false;
    }
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Trie root = new Trie();
    Arrays.sort(words, Comparator.comparingInt(String::length));
    List<String> res = new ArrayList<>();
    for (String word : words) {
      if ("".equals(word)) {
        continue;
      }
      if (root.search(word, 0)) {
        res.add(word);
      }
      root.addWord(word);
    }
    return res;
  }

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    Deque<Integer> res = new ArrayDeque<>();
    int rank = 1;
    int rankScore = ranked.get(0);
    for (int a = player.size() - 1, s = 0; a >= 0; a--) {
      if (player.get(a) < rankScore) {
        for (; s < ranked.size(); s++) {
          if (ranked.get(s) < rankScore) {
            rank++;
            rankScore = ranked.get(s);
          }
          if (player.get(a) >= ranked.get(s)) {
            break;
          }
        }
      }
      res.offerFirst(s == ranked.size() ? rank + 1 : rank);
    }
    return res.stream().toList();
  }

  /**
   * The idea is to use a hash set to track the longest substring without repeating characters so far, use a fast
   * pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j forward
   * and update the max length, otherwise, delete from the head by using a slow pointer i until we can put character j
   * to the hash set.
   *
   * By the way, update the result when the character j is not in the hashset, otherwise, we have to check the longest
   * length when the pointer j arrives the last index of string s
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    // Once we've landed on a character we've seen before, we want to move the left pointer of our window to the index
    // after the last occurrence of that character.
    // our nextIndex[] array functions as both a hashset and a way to keep track of indexes. In particular, our array is
    // storing the index AFTER the last occurrence of any character. That way, our left pointer can move directly there.

    int res = 0;
    int left = 0, right = 0;
    int[] index = new int[128];

    while (right < s.length()) {
      char cur = s.charAt(right);
      left = Math.max(left, index[cur]);
      res = Math.max(res, right - left + 1);
      index[cur] = right + 1;

      right++;
    }

    return res;
  }

  public int countBinarySubstrings(String s) {
    int res = 0;
    char last = '*';
    int pre = 0;
    int cur = 0;
    for (char c : s.toCharArray()) {
      if (last != c) {
        last = c;
        res += Math.min(pre, cur);
        pre = cur;
        cur = 0;
      }
      cur++;
    }
    return res;
  }

  public int heightChecker(int[] heights) {
    int[] count = new int[101];
    for (int height : heights) {
      count[height]++;
    }
    int res = 0;
    int index = 0;
    // int[] copy = new int[heights.length];
    for (int i = 1; i < count.length; i++) {
      // 值为i的数有多少个
      // index++表示 copy[index++] = count[i]
      // heights[index] != i
      for (int j = 1; j <= count[i]; j++) {
        if (heights[index] != i) {
          res++;
        }
        index++;
      }
    }
    return res;
  }

}
