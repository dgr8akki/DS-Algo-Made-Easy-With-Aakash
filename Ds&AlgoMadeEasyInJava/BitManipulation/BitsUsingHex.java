public class BitsUsingHex {

  public void printInBinary(byte value) {
    System.out.println(Byte.toBinaryString(value) + " <= " + value);
  }

  public void printInHex(int value) {
    System.out.println("0x" + Integer.toHexString(value) + " <= " + value);
  }
  public static void main(String[] args) {
    BitsUsingHex bits = new BitsUsingHex();
    bits.printInHex(63);
  }
}