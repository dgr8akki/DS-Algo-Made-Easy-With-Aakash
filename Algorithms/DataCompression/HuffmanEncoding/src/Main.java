public class Main {
  public static void main(String[] args) {

    String text = "My name is Akku!";

    int[] charFrequencies = new int[256];

    for (char c : text.toCharArray())
      ++charFrequencies[c];

    HuffmanCode huffmanCode = new HuffmanCode();

    HuffmanTree huffmanTree = huffmanCode.buildTree(charFrequencies);

    huffmanCode.printCodes(huffmanTree, new StringBuilder());

  }
}
