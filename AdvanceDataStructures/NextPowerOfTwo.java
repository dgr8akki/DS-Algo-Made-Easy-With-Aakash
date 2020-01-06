package AdvanceDataStructures;

public class NextPowerOfTwo {

  static int nextPowerOf2(int num) {
    if (num == 0) {
      return 1;
    }
    if (num > 0 && (num & (num - 1)) == 0) {
      return num;
    }
    return (int) Math.pow(2, Integer.toBinaryString(num).length());
  }

  public static void main(String[] args) {
    NextPowerOfTwo np = new NextPowerOfTwo();
    System.out.println(nextPowerOf2(2_000_000_00));
  }
}
