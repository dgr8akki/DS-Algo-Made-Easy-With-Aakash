package Leetcode;

class Solution {
  public String[] uncommonFromSentences(String A, String B) {
    List<String> list = new ArrayList<>();
    String[] aWords = A.split(" ");
    String[] bWords = B.split(" ");
    Map<String, Integer> map = new HashMap<>();
    for (String word : aWords) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    for (String word : bWords) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for (String word : map.keySet()) {
      if (map.get(word) == 1)
        list.add(word);
    }
    String[] stockArr = new String[list.size()];
    stockArr = list.toArray(stockArr);
    return stockArr;
  }
}
