package Algorithms.DataCompression.HuffmanEncoding.src;

import java.util.PriorityQueue;

class HuffmanCode {
  static HuffmanTree buildTree(int[] charSequence) {
    PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();
    for (int currentCharacterIndex = 0;
        currentCharacterIndex < charSequence.length;
        currentCharacterIndex++) {
      if (charSequence[currentCharacterIndex] > 0) {
        queue.add(
          new HuffmanLeaf((char) currentCharacterIndex, charSequence[currentCharacterIndex]));
      }
    }

    while (queue.size() > 1) {
      queue.add(new HuffmanNode(queue.poll(), queue.poll()));
    }

    return queue.poll();
  }

  static void printCodes(HuffmanTree tree, StringBuilder prefix) {

    if (tree instanceof HuffmanLeaf) {
      HuffmanLeaf leaf = (HuffmanLeaf) tree;
      System.out.println(leaf.getValue() + "\t" + leaf.getFrequency() + "\t" + prefix);
    } else if (tree instanceof HuffmanNode) {
      HuffmanNode node = (HuffmanNode) tree;
      // travel left
      prefix.append("0");
      printCodes(node.getLeftTree(), prefix);
      prefix.deleteCharAt(prefix.length() - 1);

      // travel right
      prefix.append("1");
      printCodes(node.getRightTree(), prefix);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
}
