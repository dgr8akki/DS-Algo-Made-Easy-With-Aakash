package Algorithms.DataCompression.HuffmanEncoding.src;

public class HuffmanTree implements Comparable<HuffmanTree> {
  private int frequency;

  HuffmanTree(int frequency) {
    setFrequency(frequency);
  }

  int getFrequency() {
    return frequency;
  }

  private void setFrequency(int frequency) {
    this.frequency = frequency;
  }

  @Override
  public int compareTo(HuffmanTree anotherTree) {
    return Integer.compare(getFrequency(), anotherTree.getFrequency());
  }
}
