package Algorithms.DataCompression.HuffmanEncoding.src;

class HuffmanLeaf extends HuffmanTree {
  private char value;

  HuffmanLeaf(int frequency) {
    super(frequency);
  }

  HuffmanLeaf(char value, int frequency) {
    super(frequency);
    setValue(value);
  }

  char getValue() {
    return value;
  }

  private void setValue(char value) {
    this.value = value;
  }
}
