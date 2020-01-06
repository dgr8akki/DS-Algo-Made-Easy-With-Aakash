package CodingNinjas.BitManipulation;

import java.util.Scanner;

public class TurnOffFirstSetBit {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(turnOffFirstBitSet(n));
    in.close();
  }

  private static int turnOffFirstBitSet(int number) {
    int n = number;
    int firstSetBit = 0;
    while ((n & 1) == 0) {
      firstSetBit++;
      n = (n >> 1);
    }
    return (number ^ (1 << firstSetBit));
  }
}
