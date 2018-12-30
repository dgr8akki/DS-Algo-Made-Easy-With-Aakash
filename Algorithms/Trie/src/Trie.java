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
}
