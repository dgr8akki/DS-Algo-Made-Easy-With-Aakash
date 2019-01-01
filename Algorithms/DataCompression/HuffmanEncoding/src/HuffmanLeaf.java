public class HuffmanLeaf extends HuffmanTree {
  private char value;

  char getValue() {
    return value;
  }

  void setValue(char value) {
    this.value = value;
  }

  HuffmanLeaf(int frequency) {
    super(frequency);
  }

  HuffmanLeaf(char value, int frequency) {
    super(frequency);
    this.setValue(value);
  }
}
