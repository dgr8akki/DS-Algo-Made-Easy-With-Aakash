class Solution {
  public String reverseVowels(String s) {
    List<Character> vowels = new ArrayList<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('A');
    vowels.add('E');
    vowels.add('I');
    vowels.add('O');
    vowels.add('U');
    int leftRunner = 0, rightRunner = s.length() - 1;
    StringBuilder builder = new StringBuilder();
    while (leftRunner < s.length()) {
      if (vowels.contains(s.charAt(leftRunner))) {
        while (rightRunner >= 0 && !vowels.contains(s.charAt(rightRunner)))
          rightRunner--;
        builder.append(s.charAt(rightRunner--));
      } else {
        builder.append(s.charAt(leftRunner));
      }
      leftRunner++;
    }
    return builder.toString();
  }
}
