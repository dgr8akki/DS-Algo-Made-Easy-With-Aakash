package DsAlgoMadeEasyInJava.Reccursion;

import java.util.Arrays;

public class BinaryString {

  private int[] A;

  private BinaryString(int n) {
    A = new int[n];
  }

  public static void main(String[] args) {
    BinaryString binaryString = new BinaryString(3);
    binaryString.printNBitString(2);
  }

  private void printNBitString(int n) {
    if (n < 1) {
      System.out.println(Arrays.toString(A));
    } else {
      A[n - 1] = 0;
      printNBitString(n - 1);
      A[n - 1] = 1;
      printNBitString(n - 1);
    }
  }
}
