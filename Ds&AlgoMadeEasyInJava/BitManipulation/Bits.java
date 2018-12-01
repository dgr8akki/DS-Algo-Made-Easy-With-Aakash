public class Bits {

  private void printInBinary(int value) {
    System.out.println(Integer.toBinaryString(value) + " <= " + value);
  }

  public void bitwiseAnd (int first, int second) {
    printInBinary(first);
    printInBinary(second);
    System.out.println("Bitwise ANDing results in:");
    printInBinary(first & second);
    System.out.println("--------------------------------------");
  }

  public void bitwiseLeftShift (int number, int numberOfShifts) {
    printInBinary(number);
    System.out.println("Bitwise Left Shifting of "+ number +" by " + numberOfShifts + " bits, results in:");
    printInBinary(number << numberOfShifts);
    System.out.println("--------------------------------------");
  }

  public void bitwiseRightShift (int number, int numberOfShifts) {
    printInBinary(number);
    System.out.println("Bitwise Right Shifting of "+ number +" by " + numberOfShifts + " bits, results in:");
    printInBinary(number >> numberOfShifts);
    System.out.println("--------------------------------------");
  }

  public void bitwiseXor (int first, int second) {
    printInBinary(first);
    printInBinary(second);
    System.out.println("Bitwise XORing results in:");
    printInBinary(first ^ second);
    System.out.println("--------------------------------------");
  }

  public void bitwiseCompliment (int number) {
    printInBinary(number);
    System.out.println("Bitwise Compliment results in:");
    printInBinary(~number);
    System.out.println("--------------------------------------");
  }

  public void bitwiseTwosCompliment (int number) {
    printInBinary(number);
    System.out.println("Bitwise Two's Compliment results in:");
    printInBinary(~number + 1);
    System.out.println("--------------------------------------");
  }

  public void bitwiseOr (int first, int second) {
    printInBinary(first);
    printInBinary(second);
    System.out.println("Bitwise ORing results in:");
    printInBinary(first | second);
    System.out.println("--------------------------------------");
  }

  public void isKthBitSet (int number, int k) {
    printInBinary(number);
    System.out.println("Is bit number "+ k +" of "+ number +", is set(Set means bit is 1)?");
    /**
     * Checking is Kth Bit set
     *
     * Algorithm:
     * Step 1. Left shift 1 by k-1 bits
     * Step 2. AND the above result by original number.
     *
     * Pseudo code:
     * number & (1 << k - 1)
     */
    System.out.println((number & (1 << (k - 1))) != 0);
    // printInBinary(number & (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

  public void setKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After setting bit number "+ k +" of "+ number +", It becomes:");
    /**
     * Setting Kth Bit of number
     *
     * Algorithm:
     * Step 1. Left shift 1 by k-1 bits
     * Step 2. OR the above result by original number.
     *
     * Pseudo code:
     * number & (1 << k - 1)
     */
    printInBinary(number | (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

  public void clearKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After clearing bit number "+ k +" of "+ number +", It becomes:");
    /**
     * Clearing Kth Bit of number
     *
     * Algorithm:
     * Step 1. Left shift 1 by k-1 bits
     * Step 2. Negate or compliment the above result.
     * Step 3. AND the above result by original number.
     *
     * Pseudo code:
     * number & ~(1 << k - 1)
     */
    printInBinary(number & ~(1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

  public void toggleKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After toggling bit number "+ k +" of "+ number +", It becomes:");
    /**
     * Toggling Kth Bit of number
     *
     * Algorithm:
     * Step 1. Left shift 1 by k-1 bits
     * Step 2. XOR the above result by original number.
     *
     * Pseudo code:
     * number ^ (1 << k - 1)
     */
    printInBinary(number ^ (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

  public static void main(String[] args) {
    Bits bits = new Bits();
    int first = 125;
    int second = 7;
    int k  = 2;
    bits.bitwiseAnd(first, second);
    bits.bitwiseOr(first, second);
    bits.bitwiseXor(first, second);
    bits.bitwiseLeftShift(first, k);
    bits.bitwiseRightShift(first, k);
    bits.bitwiseCompliment(first);
    bits.bitwiseTwosCompliment(first);
    bits.isKthBitSet(first, 2);
    bits.isKthBitSet(first, 4);
    bits.setKthBit(first, k);
    bits.clearKthBit(first, 4);
    bits.toggleKthBit(first, k);
  }
}