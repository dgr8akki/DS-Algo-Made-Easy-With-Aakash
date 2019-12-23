class CombinationIterator {

  Queue<String> qu = new LinkedList();
  String orig = "";

  public CombinationIterator(String characters, int combinationLength) {
    orig = characters;
    find("", 0, combinationLength);
  }

  void find(String str, int index, int len) {
    if (len == 0) {
      qu.add(str);
      return;
    }
    for (int i = index; i < orig.length(); i++) {
      char ch = orig.charAt(i);
      find(str + ch, i + 1, len - 1);
    }

  }

  public String next() {
    if (!qu.isEmpty()) {
      return qu.poll();
    }
    return "";
  }

  public boolean hasNext() {
    return !qu.isEmpty();
  }
}
