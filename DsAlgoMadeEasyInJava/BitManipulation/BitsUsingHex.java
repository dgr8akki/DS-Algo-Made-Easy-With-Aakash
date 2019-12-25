package DsAlgoMadeEasyInJava.BitManipulation;

public class BitsUsingHex {

  public static void main(String[] args) {
    BitsUsingHex bits = new BitsUsingHex();
    BitsUsingHex.printInHex(63);
  }

  public static void printInBinary(byte value) {
    System.out.println(Byte.toBinaryString(value) + " <= " + value);
  }

  private static void printInHex(int value) {
    System.out.println("0x" + Integer.toHexString(value) + " <= " + value);
  }
}
