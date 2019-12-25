package Leetcode;

class StreamChecker {

  class Trie {
    char val;
    String word;
    Trie[] children;

    Trie(char val) {
      this.val = val;
      this.children = new Trie[26];
    }
  }

  private Trie root;
  private Set<Character> charSet;
  private int maxLen = Integer.MIN_VALUE;
  private String list = "";

  public StreamChecker(String[] words) {
    this.root = new Trie('*');
    this.charSet = new HashSet<>();
    for (String w : words) {
      Trie runner = this.root;
      if (build(w, runner)) {
        this.maxLen = Math.max(this.maxLen, w.length());
      }
    }
  }

  private boolean build(String w, Trie runner) {
    if (w == null || w.length() == 0)
      return false;
    for (int i = w.length() - 1; i >= 0; i--) {
      char cur = w.charAt(i);
      this.charSet.add(cur);
      if (runner.children[cur - 'a'] == null)
        runner.children[cur - 'a'] = new Trie(cur);
      runner = runner.children[cur - 'a'];
      if (i >= 0 && runner.word == w)
        return false;
      if (i == 0)
        runner.word = w;
    }
    return true;
  }

  public boolean query(char letter) {

    if (!this.charSet.contains(letter)) {
      this.list = "";
      return false;
    }

    this.list = this.list + letter;
    if (this.list.length() > this.maxLen)
      this.list = this.list.substring(this.list.length() - maxLen);

    Trie runner = this.root;
    return contain(runner);

  }

  private boolean contain(Trie runner) {

    for (int i = this.list.length() - 1; i >= 0; i--) {
      char cur = this.list.charAt(i);
      if (runner.children[cur - 'a'] == null)
        return false;
      runner = runner.children[cur - 'a'];
      if (runner.word != null)
        return true;
    }
    return false;
  }
}
