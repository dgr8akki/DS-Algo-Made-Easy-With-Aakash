package CodingNinjas.Tries;

import java.util.Scanner;

/**
 * SearchEngine
 */
public class SearchEngine {
  static class TrieNode {
    int w = 0;
    TrieNode[] childNodes = new TrieNode[26];

    public TrieNode() {

    }

    public TrieNode(int w) {
      this.w = w;
    }
  }

  static TrieNode root = new TrieNode();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    for (int i = 0; i < n; i++) {
      String s = in.next();
      int w = in.nextInt();
      insert(s, w);
    }
    while (q-- > 0) {
      System.out.println(query(in.next()));
    }
    in.close();
  }

  private static int query(String s) {
    TrieNode current = root;

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);

      if (current.childNodes[c - 'a'] == null) {
        return -1;
      } else {
        current = current.childNodes[c - 'a'];
      }
    }
    return current.w;
  }

  private static void insert(String s, int weight) {
    TrieNode current = root;

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);

      if (current.childNodes[c - 'a'] == null) {
        current.childNodes[c - 'a'] = new TrieNode(weight);
      } else {
        current.childNodes[c - 'a'].w = Math.max(current.childNodes[c - 'a'].w, weight);
      }

      current = current.childNodes[c - 'a'];
    }
  }
}
