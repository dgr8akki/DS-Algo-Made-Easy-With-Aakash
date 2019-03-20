class Solution {
  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    return countSetBits(xor);

    // int count = 0;
    // String numberXInBinary = Integer.toBinaryString(x);
    // String numberYInBinary = Integer.toBinaryString(y);
    // int minNumberLength = Math.min(numberXInBinary.length(), numberYInBinary.length());
    // for (int i = 0; i < minNumberLength; i++)
    //   if (numberXInBinary.charAt(i) != numberYInBinary.charAt(i)) count++;
    //     return count;
  }

  private int countSetBits(int n) {
    // int count = 0;
    // String numberInBinary = Integer.toBinaryString(n);
    // System.out.println(numberInBinary);
    // for (int i = 0; i < numberInBinary.length(); i++)
    //   if (numberInBinary.charAt(i) == '1') count++;
    //     return count;
    int count = 0; 
        while (n > 0) 
        { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
  }

  public static void main(String[] args) {
    Solution solve = new Solution();
    System.out.print(solve.hammingDistance(1, 4));
  }
}