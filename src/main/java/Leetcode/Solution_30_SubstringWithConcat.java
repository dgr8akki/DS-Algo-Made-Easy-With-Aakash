package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_30_SubstringWithConcat {
  public static List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new ArrayList<>();
    if (S == null || L == null || L.length == 0) {
      return res;
    }
    int len = L[0].length();

    Map<String, Integer> map = new HashMap<>();
    for (String w : L) {
      map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
    }

    for (int i = 0; i <= S.length() - len * L.length; i++) {
      Map<String, Integer> copy = new HashMap<>(map);
      for (int j = 0; j < L.length; j++) {
        String str = S.substring(i + j * len, i + j * len + len);
        if (copy.containsKey(str)) {
          int count = copy.get(str);
          if (count == 1) {
            copy.remove(str);
          } else {
            copy.put(str, count - 1);
          }
          if (copy.isEmpty()) {
            res.add(i);
            break;
          }
        } else {
          break;
        }
      }
    }
    return res;
  }
}
