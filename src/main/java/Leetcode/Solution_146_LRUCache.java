package Leetcode;

import java.util.LinkedHashMap;

class LRUCache {
  public int cap;
  private LinkedHashMap<Integer, Integer> lru;

  public LRUCache(int capacity) {
    this.lru = new LinkedHashMap<Integer, Integer>();
    cap = capacity;
  }

  public int get(int key) {
    if (lru.containsKey(key)) {
      int new_value = lru.get(key);
      lru.remove(key);
      lru.put(key, new_value);
      return new_value;
    } else
      return -1;
  }

  public void put(int key, int value) {
    if (lru.containsKey(key))
      lru.remove(key);

    else if (lru.size() >= cap) {
      for (int k : lru.keySet()) {
        lru.remove(k);
        break;
      }
    }
    lru.put(key, value);
  }
}
