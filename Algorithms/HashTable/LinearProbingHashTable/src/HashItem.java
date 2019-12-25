package Algorithms.HashTable.LinearProbingHashTable.src;

public class HashItem {

  private int key;
  private int value;

  public HashItem(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }
}
