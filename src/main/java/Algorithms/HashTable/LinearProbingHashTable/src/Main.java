package Algorithms.HashTable.LinearProbingHashTable.src;

public class Main {

  public static void main(String[] args) {
    LinearProbingHashTable hashTable = new LinearProbingHashTable();
    hashTable.put(13,12);
    hashTable.put(23,22);
    hashTable.put(3,24);
    hashTable.put(43,25);
    System.out.println(hashTable.get(3));
    System.out.println(hashTable.get(13));
  }
}
