class ChainingHashTable {
  private HashItem[] map;

  ChainingHashTable() {
    map = new HashItem[Constants.CAPACITY];
  }

  private int hash(int key) {
    if(key > -1)
      return key % Constants.CAPACITY;
    return 0;
  }

  void put(int key, int val) {
    int hashedKeyIndex = hash(key);
    if(map[hashedKeyIndex] == null) {
      map[hashedKeyIndex] = new HashItem(key, val);
    } else {
      HashItem temp = map[hashedKeyIndex];
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(new HashItem(key, val));
    }
  }

  int get(int key) {
    int hashedKeyIndex = hash(key);
    if(map[hashedKeyIndex] == null)
      return -1;
    HashItem temp = map[hashedKeyIndex];
    while (temp != null) {
      if(temp.getKey() == key)
        return temp.getValue();
      temp = temp.getNext();
    }
    return -1;
  }
}
