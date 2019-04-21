class WordDictionary {
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
    return search(s, root);
  }

  public boolean search(String s, TrieNode root) {
    TrieNode current = root;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != '.') {
        if (current.children[c - 'a'] == null) {
          return false;
        } else {
          current = current.children[c - 'a'];
        }
      } else {
        boolean res = false;
        for (int j = 0; j < 26; j++) {
          if (current.children[i] != null) {
            res = search(s.substring(i + 1), current.children[i]);
          }
        }

        return res;
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

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    insert(word);
  }
}
