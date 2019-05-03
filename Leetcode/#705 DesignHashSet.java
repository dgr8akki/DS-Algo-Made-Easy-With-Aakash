class MyHashSet {

  /** Initialize your data structure here. */
  BitSet bSet;

  public MyHashSet() {
    bSet = new BitSet(1000001);
  }

  public void add(int key) {
    bSet.set(key);
  }

  public void remove(int key) {
    bSet.clear(key);
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    return bSet.get(key);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
