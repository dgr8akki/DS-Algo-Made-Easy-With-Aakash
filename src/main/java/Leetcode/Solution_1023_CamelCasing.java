package Leetcode;

class Solution_1023_CamelCasing {
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> res = new ArrayList<>();

    char[] patternArr = pattern.toCharArray();
    for (String query : queries) {
      boolean isMatch = match(query.toCharArray(), patternArr);
      res.add(isMatch);
    }

    return res;
  }

  private boolean match(char[] queryArr, char[] patternArr) {
    int j = 0;
    for (int i = 0; i < queryArr.length; i++) {
      if (j < patternArr.length && queryArr[i] == patternArr[j]) {
        j++;
      } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {
        return false;
      }
    }

    return j == patternArr.length;
  }
}
