package Leetcode;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    TrieNode head = new TrieNode('$');
    preprocess(wordDict, head);

    return formSentences(s, 0, head, new HashMap<Integer, List<String>>());
  }

  List<String> formSentences(String s, int index, TrieNode head, Map<Integer, List<String>> memo) {
    if (memo.containsKey(index))
      return memo.get(index);

    List<String> res = new ArrayList<>();

    TrieNode temp = head;
    for (int i = index; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (temp.trieNodes.containsKey(ch))
        temp = temp.trieNodes.get(ch);
      else
        break;

      if (temp.endWord) {
        if (i == s.length() - 1)
          res.add(temp.word);
        else {
          List<String> nextRunData = formSentences(s, i + 1, head, memo);
          for (String str : nextRunData) {
            res.add(temp.word + " " + str);
          }
        }
      }
    }

    memo.put(index, res);

    return res;
  }

  void preprocess(List<String> wordDict, TrieNode head) {
    for (String word : wordDict) {
      TrieNode temp = head;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (!temp.trieNodes.containsKey(ch)) {
          temp.trieNodes.put(ch, new TrieNode(ch));
        }

        temp = temp.trieNodes.get(ch);
      }

      temp.endWord = true;
      temp.word = word;
    }
  }

  class TrieNode {
    Character ch;
    Map<Character, TrieNode> trieNodes;
    boolean endWord;
    String word;

    public TrieNode(Character ch) {
      this.ch = ch;
      trieNodes = new HashMap<Character, TrieNode>();
      endWord = false;
      word = "";
    }
  }
}
