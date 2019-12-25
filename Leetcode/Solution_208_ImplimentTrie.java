package Leetcode;

class Trie {
  static TrieNode root;

  static class TrieNode {
    private static final int ALPHABET_SIZE = 26;

    char val;

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    boolean isEndOfWord;

    int wordsUnderThisCharacter;

    TrieNode() {
      isEndOfWord = false;
      wordsUnderThisCharacter = 0;
      for (int i = 0; i < ALPHABET_SIZE; i++)
        children[i] = null;
    }

    TrieNode(char c) {
      isEndOfWord = false;
      wordsUnderThisCharacter = 0;
      for (int i = 0; i < ALPHABET_SIZE; i++)
        children[i] = null;
      this.val = c;
    }
  }

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String string) {
    int lengthOfString = string.length();
    int index;

    TrieNode currentNode = root;
    for (int level = 0; level < lengthOfString; level++) {
      index = string.charAt(level) - 'a';

      if (currentNode.children[index] == null) {
        currentNode.children[index] = new TrieNode(string.charAt(level));
      }
      currentNode = currentNode.children[index];
      currentNode.wordsUnderThisCharacter++;

    }
    currentNode.isEndOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String s) {
    TrieNode current = root;

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);

      if (current.children[c - 'a'] == null) {
        return false;
      } else {
        current = current.children[c - 'a'];
      }
    }
    return current.isEndOfWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String s) {
    TrieNode current = root;

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);

      if (current.children[c - 'a'] == null) {
        return false;
      } else {
        current = current.children[c - 'a'];
      }
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
