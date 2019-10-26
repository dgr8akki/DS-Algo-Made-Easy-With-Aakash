package Leetcode;

import java.util.Arrays;
class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] characterSet = new int[128];
        int count = 0;
        for(char c : S.toCharArray()) {
            System.out.println((int)c);
            characterSet[(int)c]++;
        }
        for(char c : J.toCharArray())
            count+=characterSet[(int)c];
        System.out.println(Arrays.toString(characterSet));
        return count;
    }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.print(sol.numJewelsInStones("aA", "aAAbbb"));
  }
}
