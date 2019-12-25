package Algorithms.DataCompression.HuffmanEncoding.src;

public class HuffmanNode extends HuffmanTree {
  private HuffmanTree leftTree;
  private HuffmanTree rightTree;

  HuffmanNode(HuffmanTree leftTree, HuffmanTree rightTree) {
    super(leftTree.getFrequency() + rightTree.getFrequency());
    this.leftTree = leftTree;
    this.rightTree = rightTree;
  }

  HuffmanTree getLeftTree() {
    return leftTree;
  }

  public void setLeftTree(HuffmanTree leftTree) {
    this.leftTree = leftTree;
  }

  HuffmanTree getRightTree() {
    return rightTree;
  }

  public void setRightTree(HuffmanTree rightTree) {
    this.rightTree = rightTree;
  }
}
