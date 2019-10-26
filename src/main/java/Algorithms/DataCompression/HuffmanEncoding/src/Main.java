package Algorithms.DataCompression.HuffmanEncoding.src;

public class Main {
  public static void main(String[] args) {

    String text = "My name is Akku!";

    int[] charFrequencies = new int[256];

    for (char c : text.toCharArray()) {
      ++charFrequencies[c];
    }

    HuffmanCode huffmanCode = new HuffmanCode();

    HuffmanTree huffmanTree = HuffmanCode.buildTree(charFrequencies);

    HuffmanCode.printCodes(huffmanTree, new StringBuilder());
  }
}
