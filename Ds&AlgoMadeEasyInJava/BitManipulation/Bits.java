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
  }
}