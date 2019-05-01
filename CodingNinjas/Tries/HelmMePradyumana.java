import java.util.*;
import java.io.*;

/**
 * HelmMePradyumana
 */
public class HelmMePradyumana {

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

  static TrieNode root = new TrieNode();

  public static void insert(String string) {
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

  private static List<String> find(String string) {
    int index;
    int lengthOfString = string.length();
    TrieNode currentNode = root;
    List<String> res = new ArrayList<>();

    for (int level = 0; level < lengthOfString; level++) {
      index = string.charAt(level) - 'a';
      if (currentNode == null)
        break;
      currentNode = currentNode.children[index];
    }

    dfs(currentNode, res, string);

    return res;
  }

  private static void dfs(TrieNode current, List<String> res, String prefix) {
    if (isNull(current))
      return;
    if (current.isEndOfWord)
      res.add(prefix);

    for (int i = 0; i < 26; i++) {
      TrieNode node = current.children[i];
      if (isNull(node))
        continue;
      dfs(node, res, prefix + node.val);
    }
  }

  private static boolean isNull(TrieNode node) {
    return node == null;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    for (int i = 0; i < n; i++) {
      String s = in.next();
      insert(s);
    }

    int q = in.nextInt();
    while (q-- > 0) {
      String s = in.next();
      List<String> res = find(s);
      if (res == null || res.size() == 0) {
        System.out.println("No suggestions");
        insert(s);
      } else {
        for (String r : res)
          System.out.println(r);
      }
    }
  }
}
