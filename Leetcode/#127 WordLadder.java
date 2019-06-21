class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord))
      return 0;

    int result = 1;
    int len = beginWord.length();
    List<Set<Character>> charList = new ArrayList<>();
    for (int i = 0; i < len; i++)
      charList.add(new HashSet<>());
    for (String s : wordList)
      for (int i = 0; i < len; i++)
        charList.get(i).add(s.charAt(i));
    if (wordList.contains(beginWord))
      wordList.remove(beginWord);
    if (wordList.contains(endWord))
      wordList.remove(endWord);
    Set<String> startSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> tmp = null;
    startSet.add(beginWord);
    endSet.add(endWord);

    while (!startSet.isEmpty() && !endSet.isEmpty()) {
      result++;
      if (startSet.size() > endSet.size()) {
        tmp = startSet;
        startSet = endSet;
        endSet = tmp;
      }

      tmp = new HashSet<>();
      for (String s : startSet) {
        char[] word = s.toCharArray();
        for (int i = 0; i < len; i++) {
          char old = word[i];
          for (char c : charList.get(i)) {
            word[i] = c;
            String newWord = String.valueOf(word);
            if (endSet.contains(newWord))
              return result;
            if (!wordList.contains(newWord))
              continue;
            tmp.add(newWord);
            wordList.remove(newWord);
          }
          word[i] = old;
        }
      }
      startSet = tmp;
    }
    return 0;
  }
}
