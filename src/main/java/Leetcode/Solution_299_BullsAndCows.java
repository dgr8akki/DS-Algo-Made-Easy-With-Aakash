package Leetcode;

class Solution {
  public String getHint(String secret, String guess) {
    int[] count = new int[10];
    int bull = 0, cow = 0;
    for (int i = 0; i < secret.length(); i++) {
      count[secret.charAt(i) - '0']++;
    }
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
        if (count[secret.charAt(i) - '0']-- <= 0)
          cow--;
      } else if (count[guess.charAt(i) - '0'] > 0) {
        cow++;
        count[guess.charAt(i) - '0']--;
      }
    }
    return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
  }
}
