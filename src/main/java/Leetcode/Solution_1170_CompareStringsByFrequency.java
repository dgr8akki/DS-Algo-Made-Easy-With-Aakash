package Leetcode;

class Solution {
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int fw[] = new int[words.length];
    int ans[] = new int[queries.length];
    int ind = 0;
    for (String word : words)
      fw[ind++] = smallestCount(word);

    ind = 0;
    for (String q : queries) {
      int query = smallestCount(q);
      for (int word : fw)
        if (query < word)
          ans[ind]++;
      ind++;
    }
    return ans;
  }

  public int smallestCount(String word) {
    int min = 'z' + 1;
    int count = 0;
    for (char c : word.toCharArray()) {
      if (min > c) {
        min = c;
        count = 0;
      } else if (min == c)
        count++;
    }
    return count;
  }
}
