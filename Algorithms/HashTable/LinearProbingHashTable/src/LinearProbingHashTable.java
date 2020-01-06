package Algorithms.HashTable.LinearProbingHashTable.src;

class LinearProbingHashTable {
  private HashItem[] map;

  LinearProbingHashTable() {
    map = new HashItem[Constants.CAPACITY];
  }

  private int hash(int key) {
    if (key > -1)
      return key % Constants.CAPACITY;
    return 0;
  }

  void put(int key, int val) {
    int hashedKeyIndex = hash(key);
    if (map[hashedKeyIndex] == null) {
      map[hashedKeyIndex] = new HashItem(key, val);
      System.out.println("Inserted value : " + val + " at index: " + hashedKeyIndex);
      return;
    }
    int generatedIndex = (hashedKeyIndex + 1) % Constants.CAPACITY;
    while (generatedIndex != hashedKeyIndex && map[generatedIndex] != null) {
      generatedIndex = (generatedIndex + 1) % Constants.CAPACITY;
    }
    if (generatedIndex == hashedKeyIndex) {
      System.out.println("Not able to insert");
      return;
    }
    map[generatedIndex] = new HashItem(key, val);
    System.out.println("Inserted value : " + val + " at index: " + generatedIndex);
  }

  int get(int key) {
    int hashedKeyIndex = hash(key);
    if (map[hashedKeyIndex] == null)
      return -1;
    if (map[hashedKeyIndex].getKey() == key)
      return map[hashedKeyIndex].getValue();
    int generatedIndex = (hashedKeyIndex + 1) % Constants.CAPACITY;
    while (map[generatedIndex].getKey() != key) {
      generatedIndex = (generatedIndex + 1) % Constants.CAPACITY;
    }
    if (generatedIndex == hashedKeyIndex) {
      return -1;
    }
    return map[generatedIndex].getValue();
  }
}
