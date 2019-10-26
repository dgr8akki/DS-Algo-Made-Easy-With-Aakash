package Leetcode;

class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list1.length; i++)
      map.put(list1[i], i);
    for (int i = 0; i < list2.length; i++) {
      if (map.containsKey(list2[i])) {
        int index = map.get(list2[i]);
        map.put(list2[i], index + i + 200001);
        min = Math.min(index + i + 200001, min);
      }
    }
    for (String key : map.keySet()) {
      int val = map.get(key);
      if (val < 200000)
        continue;
      if (val == min)
        res.add(key);
    }
    String[] arr = new String[res.size()];
    int i = 0;
    for (String el : res) {
      arr[i] = el;
      i++;
    }
    return arr;
  }
}
