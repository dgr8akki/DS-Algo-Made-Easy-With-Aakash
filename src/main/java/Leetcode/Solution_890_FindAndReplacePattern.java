package Leetcode;

class Solution {

  private String hash(String s) {
    StringBuilder sb = new StringBuilder();
    int[] hash = new int[256];
    Arrays.fill(hash, 0);
    int nextHashTag = 1;
    for (char c : s.toCharArray()) {
      if (0 == hash[c - 'a']) {
        hash[c - 'a'] = nextHashTag;
        nextHashTag++;
      }
      sb.append(hash[c - 'a']);
    }
    return sb.toString();

  }

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    String patternHash = hash(pattern);
    ArrayList<String> result = new ArrayList<>();
    for (String word : words) {
      if (patternHash.equals(hash(word))) {
        result.add(word);
      }
    }

    return result;
  }
}
