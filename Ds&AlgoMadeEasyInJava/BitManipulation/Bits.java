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
  public void isKthBitSet (int number, int k) {
    printInBinary(number);
    System.out.println("Is bit number "+ k +" of "+ number +", is set(Set means bit is 1)?");
    System.out.println((number & (1 << (k - 1))) != 0);
    // printInBinary(number & (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

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
  public void setKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After setting bit number "+ k +" of "+ number +", It becomes:");
    printInBinary(number | (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

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
  public void clearKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After clearing bit number "+ k +" of "+ number +", It becomes:");
    printInBinary(number & ~(1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

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
  public void toggleKthBit (int number, int k) {
    printInBinary(number);
    System.out.println("After toggling bit number "+ k +" of "+ number +", It becomes:");
    printInBinary(number ^ (1 << (k - 1)));
    System.out.println("--------------------------------------");
  }

  /**
   * Toggling Rightmost one Bit of number
   * It will toggle the first 1 from right most
   * eg. 1111100 => 1111000 (Rightmost 1 is at 3rd bit from last)
   *
   * Algorithm:
   * Step 1. AND actual number with one less of the same number
   *
   * Pseudo code:
   * number & (number - 1)
   */
  public void toggleRightmostOneBit (int number) {
    printInBinary(number);
    System.out.println("After toggling rightmost one bit of "+ number +", It becomes:");
    printInBinary(number & (number - 1));
    System.out.println("--------------------------------------");
  }

  /**
   * Isolating Rightmost one Bit of number
   * It will isolate the first 1 from right most means it will preserve last 1 from right and clear all bits.
   *
   * Algorithm:
   * Step 1. Negate or two's compliment the original number
   * Step 2. AND above result original number
   *
   * Pseudo code:
   * (number) & (~number + 1)
   */
  public void isolateRightmostOneBit (int number) {
    printInBinary(number);
    System.out.println("After isolating rightmost one bit of "+ number +", It becomes:");
    printInBinary(number & ((~ number) + 1));
    System.out.println("--------------------------------------");
  }

  /**
   * Isolating Rightmost Zero Bit of number
   * It will isolate the first 0 from right most means it will preserve last 0 from right and clear all bits after it.
   *
   * Algorithm:
   * Step 1. Negate or two's compliment the original number
   * Step 2. AND above result with actual number plus one
   *
   * Pseudo code:
   * (number + 1) & (~number + 1)
   */
  public void isolateRightmostZeroBit (int number) {
    printInBinary(number);
    System.out.println("After isolating rightmost Zero bit of "+ number +", It becomes:");
    printInBinary((number + 1) & ((~ number) + 1));
    System.out.println("--------------------------------------");
  }

  /**
   * Checking number is a power of 2
   *
   * Algorithm:
   * Step 1. AND actual number with actual number minus one
   * Step 2. Check whether the result is 0
   *
   * Pseudo code:
   * number & (number - 1) == 0
   */
  public void isNumberAPowerOf2 (int number) {
    printInBinary(number);
    System.out.println("Is "+ number +"is a perfect power of 2?");
    System.out.print("number & (number - 1) is : ");
    printInBinary(number & (number - 1));
    System.out.println((number & (number - 1)) == 0);
    System.out.println("--------------------------------------");
  }

  /**
   * Multiplying a number with 2, k times
   *
   * Algorithm:
   * Step 1. Left shift the number k times
   *
   * Pseudo code:
   * number << k
   */
  public void multiplyNumberByPowerOf2 (int number, int k) {
    printInBinary(number);
    System.out.println("Multiplying 2, "+ k +" times with " + number + " results in:");
    printInBinary(number << k);
    System.out.println("--------------------------------------");
  }

  /**
   * Dividing a number with 2, k times
   *
   * Algorithm:
   * Step 1. Right shift the number k times
   *
   * Pseudo code:
   * number >> k
   */
  public void divideANumberByPowerOf2 (int number, int k) {
    printInBinary(number);
    System.out.println("Dividing 2, "+ k +" times with " + number + " results in:");
    printInBinary(number >> k);
    System.out.println("--------------------------------------");
  }

  /**
   * Modulo a number k given that k is an exact power of 2
   *
   * Algorithm:
   * Step 1. AND the number with (k - 1)
   *
   * Pseudo code :
   * number & (k-1)
   */
  public void moduloWhenSmallerNumberIsExactPowerOf2 (int number, int k) {
    printInBinary(number);
    System.out.println("Modulo " + number + " with " + k + " results in:");

    System.out.println((number) & (k - 1));
    System.out.println("--------------------------------------");
  }

  /**
   * Reversing bits of a number
   *
   * Algorithm:
   * Step 1. AND the number with (k - 1)
   *
   * Pseudo code :
   * number & (k-1)
   */
  public void reverse (int number) {
    printInBinary(number);
    System.out.println("Reversing bits of  " + number + " results in:");
    printInBinary(number);
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
    bits.toggleRightmostOneBit(124);
    bits.isolateRightmostOneBit(first);
    bits.isolateRightmostOneBit(124);
    bits.isolateRightmostZeroBit(first);
    bits.isolateRightmostZeroBit(11);
    bits.isNumberAPowerOf2(124);
    bits.isNumberAPowerOf2(256);
    bits.multiplyNumberByPowerOf2(first, k);
    bits.divideANumberByPowerOf2(first, k);
    bits.moduloWhenSmallerNumberIsExactPowerOf2(first, 8);
    bits.moduloWhenSmallerNumberIsExactPowerOf2(152, 16);
    bits.reverse(first);
  }
}
