package Leetcode;

class Solution {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    Map<String, String> wordMap = new HashMap<>();
    Map<String, String> wordPatternMap = new HashMap<>();
    for (String word : wordlist) {
      wordMap.put(word, word);
      wordPatternMap.putIfAbsent(word.toLowerCase(), word);
      wordPatternMap.putIfAbsent(wordPattern(word), word);
    }
    for (int i = 0; i < queries.length; i++) {
      if (wordMap.containsKey(queries[i])) {
        queries[i] = wordMap.get(queries[i]);
        continue;
      }
      String wordPattern = queries[i].toLowerCase();
      if (wordPatternMap.containsKey(wordPattern)) {
        queries[i] = wordPatternMap.get(wordPattern);
        continue;
      }
      wordPattern = wordPattern(queries[i]);
      if (wordPatternMap.containsKey(wordPattern)) {
        queries[i] = wordPatternMap.get(wordPattern);
        continue;
      }
      queries[i] = "";
    }
    return queries;
  }

  private String wordPattern(String word) {
    char[] letters = word.toLowerCase().toCharArray();
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') {
        letters[i] = '*';
      }
    }
    return new String(letters);
  }
}
