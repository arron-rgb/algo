package edu.neu.algo.leetcode.editor.en._20220707;

import java.util.*;

import edu.neu.util.InputUtil;

public class WordLadder {
  // 127
  // A transformation sequence from word beginWord to word endWord using a
  // dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
  //
  //
  //
  // Every adjacent pair of words differs by a single letter.
  // Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
  // to be in wordList.
  // sk == endWord
  //
  //
  // Given two words, beginWord and endWord, and a dictionary wordList, return
  // the number of words in the shortest transformation sequence from beginWord to
  // endWord, or 0 if no such sequence exists.
  //
  //
  // Example 1:
  //
  //
  // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
  // "lot","log","cog"]
  // Output: 5
  // Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
  // > "dog" -> cog", which is 5 words long.
  //
  //
  // Example 2:
  //
  //
  // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
  // "lot","log"]
  // Output: 0
  // Explanation: The endWord "cog" is not in wordList, therefore there is no
  // valid transformation sequence.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= beginWord.length <= 10
  // endWord.length == beginWord.length
  // 1 <= wordList.length <= 5000
  // wordList[i].length == beginWord.length
  // beginWord, endWord, and wordList[i] consist of lowercase English letters.
  // beginWord != endWord
  // All the words in wordList are unique.
  //
  // Related Topics Hash Table String Breadth-First Search 👍 8293 👎 1667

  public static void main(String[] args) {
    Solution solution = new WordLadder().new Solution();
    String[] data = """
          "hit"
      "cog"
      ["hot","dot","dog","lot","log","cog"]
      "hit"
      "cog"
      ["hot","dot","dog","lot","log"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String, list<String>]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.ladderLength((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length], (List<String>)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      // hit -> *it
      // -> h*t -> hot -> *ot -> dot -> do* -> dog -> *og -> cog
      // -> hi*
      Set<String> words = new HashSet<>(wordList);
      if (!words.contains(endWord)) {
        return 0;
      }
      Set<String> visited = new HashSet<>();
      visited.add(beginWord);
      Deque<String> deque = new ArrayDeque<>();
      deque.offerLast(beginWord);
      int count = 1;
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          String s = deque.pollFirst();
          if (changeWordEveryOneLetter(s, endWord, deque, visited, words)) {
            return count + 1;
          }
        }
        count++;
      }

      return 0;
    }

    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue,
      Set<String> visited, Set<String> wordSet) {
      char[] charArray = currentWord.toCharArray();
      for (int i = 0; i < endWord.length(); i++) {
        // 先保存，然后恢复
        char originChar = charArray[i];
        for (char k = 'a'; k <= 'z'; k++) {
          if (k == originChar) {
            continue;
          }
          charArray[i] = k;
          String nextWord = String.valueOf(charArray);
          if (wordSet.contains(nextWord)) {
            if (nextWord.equals(endWord)) {
              return true;
            }
            if (!visited.contains(nextWord)) {
              queue.add(nextWord);
              // 注意：添加到队列以后，必须马上标记为已经访问
              visited.add(nextWord);
            }
          }
        }
        // 恢复
        charArray[i] = originChar;
      }
      return false;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

  class MapSolution {
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      for (String word : wordList) {
        addEdge(word);
      }
      addEdge(beginWord);
      if (!wordId.containsKey(endWord)) {
        return 0;
      }
      int[] dis = new int[nodeNum];
      Arrays.fill(dis, Integer.MAX_VALUE);
      int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
      dis[beginId] = 0;

      Queue<Integer> que = new LinkedList<>();
      que.offer(beginId);
      while (!que.isEmpty()) {
        int x = que.poll();
        if (x == endId) {
          return dis[endId] / 2 + 1;
        }
        for (int it : edge.get(x)) {
          if (dis[it] == Integer.MAX_VALUE) {
            dis[it] = dis[x] + 1;
            que.offer(it);
          }
        }
      }
      return 0;
    }

    public void addEdge(String word) {
      addWord(word);
      int id1 = wordId.get(word);
      char[] array = word.toCharArray();
      int length = array.length;
      for (int i = 0; i < length; ++i) {
        char tmp = array[i];
        array[i] = '*';
        String newWord = new String(array);
        addWord(newWord);
        int id2 = wordId.get(newWord);
        edge.get(id1).add(id2);
        edge.get(id2).add(id1);
        array[i] = tmp;
      }
    }

    public void addWord(String word) {
      if (!wordId.containsKey(word)) {
        wordId.put(word, nodeNum++);
        edge.add(new ArrayList<>());
      }
    }
  }

}
