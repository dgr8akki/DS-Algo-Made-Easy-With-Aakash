package Leetcode;

class Solution {
  public TrieNode root = new TrieNode();

  public class TrieNode {
    public String word;
    public TrieNode[] children;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }

  public void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (cur.children[idx] == null)
        cur.children[idx] = new TrieNode();
      cur = cur.children[idx];
    }

    cur.word = word;
  }

  public String search(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (cur.children[idx] == null)
        return word;
      cur = cur.children[idx];
      if (cur.word != null)
        return cur.word;
    }

    return word;
  }

  public String replaceWords(List<String> dict, String sentence) {
    for (String word : dict)
      insert(word);
    StringBuilder res = new StringBuilder();
    String[] words = sentence.split(" ");
    for (String word : words) {
      res.append(search(word)).append(" ");
    }

    res.deleteCharAt(res.length() - 1);
    return res.toString();
  }
}
