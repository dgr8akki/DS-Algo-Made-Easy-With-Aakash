package Leetcode;

class Solution_212_WordSearch2 {
  private final int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

  class TrieNode {
    private Map<Character, TrieNode> next;
    boolean isWord;

    public TrieNode() {
      next = new HashMap<>();
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    if (board == null || board.length == 0 || board[0].length == 0) {
      return res;
    }
    TrieNode root = new TrieNode();
    for (String word : words) {
      buildTrie(root, word);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, res, root.next.get(board[i][j]), new StringBuilder());
      }
    }
    return res;
  }

  // i, j is the current node pos
  private void dfs(char[][] board, int i, int j, List<String> res, TrieNode node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    sb.append(board[i][j]);
    board[i][j] ^= 255;
    if (node.isWord) {
      res.add(sb.toString());
      node.isWord = false;
    }
    for (int[] direct : direction) {
      int x = i + direct[0], y = j + direct[1];
      if (0 <= x && x < board.length && 0 <= y && y < board[0].length && board[x][y] >= 'a' && board[x][y] <= 'z') {
        dfs(board, x, y, res, node.next.get(board[x][y]), sb);
      }
    }
    board[i][j] ^= 255;
    sb.deleteCharAt(sb.length() - 1);
  }

  private void buildTrie(TrieNode root, String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      node.next.putIfAbsent(word.charAt(i), new TrieNode());
      node = node.next.get(word.charAt(i));
    }
    node.isWord = true;
  }
}
