package Leetcode;

class Solution_290_WordPattern {
  public boolean wordPattern(String pattern, String str) {
    int pLen = pattern.length();
    String[] list = str.split(" ");
    if (pLen != list.length)
      return false;

    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < pLen; i++) {
      if (map.containsKey(pattern.charAt(i))) {
        if (!map.get(pattern.charAt(i)).equals(list[i]))
          return false;
      } else {
        if (map.containsValue(list[i]))
          return false;
        map.put(pattern.charAt(i), list[i]);
      }
    }

    return true;
  }
}
