class Solution {
  public String[] findOcurrences(String text, String first, String second) {
    String[] words = text.split(" ");
    List<String> list = new ArrayList<>();
    for (int i = 2; i < words.length; i++) {
      if (words[i - 2].equals(first) && second.equals(words[i - 1]))
        list.add(words[i]);
    }
    return list.stream().toArray(n -> new String[n]);
  }
}
