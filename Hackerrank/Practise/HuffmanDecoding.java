package Hackerrank.Practise;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

abstract class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
  private int frequency; // the frequency of this tree
  public char data;
  public Node left, right;

  public HuffmanCodeNode(int freq) {
      frequency = freq;
  }

  // compares on the frequency
  public int compareTo(Node tree) {
    return frequency - tree.frequency;
  }
}

class HuffmanLeaf extends Node {
  HuffmanLeaf(int freq, char val) {
    super(freq);
      data = val;
  }
}

class HuffmanNode extends Node {

  HuffmanNode(Node l, Node r) {
    super(l.frequency + r.frequency);
      left = l;
      right = r;
  }
}

class Decoding {
  /*
  	class Node
  		public  int frequency; // the frequency of this tree
      	public  char data;
      	public  Node left, right;

  */

  static void decode(String s, Node root) {
    Node current = root;
    for (int i = 0; i < s.length(); i++) {
      current = s.charAt(i) == '1' ? current.right : current.left;
      if (current.left == null && current.right == null) {
        System.out.print(current.data);
        current = root;
      }
    }
  }
}

class HuffmanDecoding {

  private static Map<Character, String> mapA = new HashMap<>();

  // input is an array of frequencies, indexed by character code
  public static Node buildTree(int[] charFreqs) {

    PriorityQueue<Node> trees = new PriorityQueue<>();
    // initially, we have a forest of leaves
    // one for each non-empty character
    for (int i = 0; i < charFreqs.length; i++) {
        if (charFreqs[i] > 0) {
            trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
        }
    }

    assert trees.size() > 0;

    // loop until there is only one tree left
    while (trees.size() > 1) {
      // two trees with least frequency
      Node a = trees.poll();
      Node b = trees.poll();

      // put into new node and re-insert into queue
      trees.offer(new HuffmanNode(a, b));
    }

    return trees.poll();
  }

  private static void printCodes(Node tree, StringBuffer prefix) {

    assert tree != null;

    if (tree instanceof HuffmanLeaf) {
      HuffmanLeaf leaf = (HuffmanLeaf) tree;

      // print out character, frequency, and code for this leaf (which is just the prefix)
      // System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
        HuffmanDecoding.mapA.put(leaf.data, prefix.toString());

    } else if (tree instanceof HuffmanNode) {
      HuffmanNode node = (HuffmanNode) tree;

      // traverse left
      prefix.append('0');
        HuffmanDecoding.printCodes(node.left, prefix);
      prefix.deleteCharAt(prefix.length() - 1);

      // traverse right
      prefix.append('1');
        HuffmanDecoding.printCodes(node.right, prefix);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String test = input.next();

    // we will assume that all our characters will have
    // code less than 256, for simplicity
    int[] charFreqs = new int[256];

    // read each character and record the frequencies
    for (char c : test.toCharArray()) {
        charFreqs[c]++;
    }

    // build tree
    Node tree = HuffmanDecoding.buildTree(charFreqs);

    // print out results
      HuffmanDecoding.printCodes(tree, new StringBuffer());
    StringBuffer s = new StringBuffer();

    for (int i = 0; i < test.length(); i++) {
      char c = test.charAt(i);
      s.append(HuffmanDecoding.mapA.get(c));
    }

    // System.out.println(s);
    Decoding d = new Decoding();
    Decoding.decode(s.toString(), tree);
  }
}
