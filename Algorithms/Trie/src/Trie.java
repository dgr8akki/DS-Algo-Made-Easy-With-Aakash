import java.util.ArrayList;
import java.util.List;

public class Trie {
  private Node root;

  Trie() {
    this.root = new Node("");
  }

  public void insert(String word) {
    Node temp = root;
    for(char currentCharacterOfGivenWord : word.toLowerCase().toCharArray()) {
      int asciiIndex = currentCharacterOfGivenWord - 'a';
      if(temp.getChild(asciiIndex) == null) {
        Node node = new Node(String.valueOf(currentCharacterOfGivenWord));
        temp.addChild(asciiIndex, node);
        temp = node;
      } else
        temp = temp.getChild(asciiIndex);
    }

    temp.setLeaf(true);
  }

  public boolean search(String word) {
    Node temp = root;
    for(char currentCharacterOfGivenWord : word.toLowerCase().toCharArray()) {
      int asciiIndex = currentCharacterOfGivenWord - 'a';
      if(temp.getChild(asciiIndex) == null) {
        return false;
      } else
        temp = temp.getChild(asciiIndex);
    }
    return true;
  }

  public List<String> allWordsWithPrefix(String prefix) {
    List<String> wordList = new ArrayList<>();
    Node temp = root;
    for(char currentCharacterOfGivenPrefix : prefix.toLowerCase().toCharArray())
      temp = temp.getChild(currentCharacterOfGivenPrefix - 'a');

    collectWords(temp, prefix, wordList);
    return wordList;
  }

  private void collectWords(Node node, String prefix, List<String> wordList) {
    if (node == null) return;

    if (node.isLeaf())
      wordList.add(prefix);

    for(Node child: node.getChildren()) {
      if(child == null) continue;
      collectWords(child, prefix + child.getCharacter(), wordList);
    }
  }
}
