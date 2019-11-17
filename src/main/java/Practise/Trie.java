import java.util.*;

/**
 * Trie
 */
public class Trie {

  /**
   * TrieNode
   */
  public class TrieNode {
    char value;
    boolean isEndOfWord;
    TrieNode[] children;
    int freq;

    TrieNode() {
      this.value = '0';
      this.isEndOfWord = false;
      this.children = new TrieNode[26];
      for (int i = 0; i < 26; i++) {
        this.children[i] = null;
      }
    }

    TrieNode(char value) {
      super();
      this.value = value;
    }

    @Override
    public String toString() {
      return "Value: " + this.value + ", isEndOfWord: " + this.isEndOfWord + ", freq: " + this.freq;
    }
  }

  TrieNode root = new TrieNode();

  public void insertAll(List<String> values) {
    for (String val : values)
      insert(val.toLowerCase());
  }

  public void insert(String value) {
    TrieNode current = root;
    value = value.toLowerCase();
    for (char c : value.toCharArray()) {
      if (!Character.isAlphabetic(c))
        continue;
      if (current.children[c - 'a'] == null)
        current.children[c - 'a'] = new TrieNode();
      current = current.children[c - 'a'];
      current.value = c;
    }

    current.isEndOfWord = true;
    current.freq++;
  }

  public int contains(String value) {
    TrieNode current = root;
    value = value.toLowerCase();

    for (char c : value.toCharArray()) {
      if (!Character.isAlphabetic(c))
        continue;
      if (current.children[c - 'a'] == null)
        return 0;
      current = current.children[c - 'a'];
    }

    return current.freq;
  }

  public List<String> getAllValuesStartingWith(String prefix) {
    String value = prefix.toLowerCase();
    List<String> results = new ArrayList<>();

    TrieNode current = root;

    for (char c : value.toCharArray()) {
      if (!Character.isAlphabetic(c))
        continue;
      if (current.children[c - 'a'] == null)
        return new ArrayList<>();
      current = current.children[c - 'a'];
    }

    dfsUtil(current, results, new StringBuilder(prefix));

    return results;
  }

  private void dfsUtil(TrieNode current, List<String> results, StringBuilder currentString) {
    if (current == null)
      return;
    if (current.isEndOfWord) {
      results.add(currentString.toString());
    }

    for (int i = 0; i < 26; i++) {
      if (current.children[i] != null)
        dfsUtil(current.children[i], results, currentString.append(current.children[i].value));
    }
    currentString.deleteCharAt(currentString.length() - 1);
  }

  public void printAllValuesStartingWith(String pref) {
    List<String> res = getAllValuesStartingWith(pref);
    for (String s : res)
      System.out.println(s);
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    FileIO fileIO = new FileIO();
    String path = "data.txt";
    fileIO.read(path);
    trie.insertAll(fileIO.read(path));
    System.out.println(trie.contains("decision"));
    trie.printAllValuesStartingWith("de");
  }
}
