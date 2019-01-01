public class HuffmanTree implements Comparable<HuffmanTree> {
  private int frequency;

  HuffmanTree(int frequency) {
    this.setFrequency(frequency);
  }

  int getFrequency() {
    return frequency;
  }

  void setFrequency(int frequency) {
    this.frequency = frequency;
  }

  @Override
  public int compareTo(HuffmanTree anotherTree) {
    return Integer.compare(this.getFrequency(), anotherTree.getFrequency());
  }
}
