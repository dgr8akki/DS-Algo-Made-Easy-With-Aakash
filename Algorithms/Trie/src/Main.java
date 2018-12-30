import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("she");
    trie.insert("shell");
    trie.insert("sheshore");
//    trie.insert("he");

    System.out.println(trie.allWordsWithPrefix("sh"));
    System.out.println(trie.getLongestCommonPrefix());
  }
}
