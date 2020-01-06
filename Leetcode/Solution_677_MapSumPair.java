package Leetcode;

class MapSum {

  Map<String, Integer> map;
  Map<String, Integer> original;

  public MapSum() {
    map = new HashMap<>();
    original = new HashMap<>();
  }

  public void insert(String key, int val) {
    val -= original.getOrDefault(key, 0);
    String s = "";
    for (char c : key.toCharArray()) {
      s += c;
      map.put(s, map.getOrDefault(s, 0) + val);
    }
    original.put(key, original.getOrDefault(key, 0) + val);
  }

  public int sum(String prefix) {
    return map.getOrDefault(prefix, 0);
  }
}
