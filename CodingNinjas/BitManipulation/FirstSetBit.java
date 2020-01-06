package CodingNinjas.BitManipulation;

import java.util.Scanner;

public class FirstSetBit {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(firstBitSet(n));
    in.close();
  }

  private static int firstBitSet(int n) {
    int res = 1;
    while ((n & 1) == 0) {
      res = res << 1;
      n = (n >> 1);
    }
    return res;
  }
}