public class Main {

  public static void main(String[] args) {
    ChainingHashTable hashTable = new ChainingHashTable();
    hashTable.put(13,2);
    hashTable.put(23,2);
    hashTable.put(3,2);
    hashTable.put(43,2);
    System.out.println(hashTable.get(3));
  }
}
