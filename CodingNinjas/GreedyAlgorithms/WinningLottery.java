package CodingNinjas.GreedyAlgorithms;

import java.util.Scanner;

/**
 * WinningLottery
 */
public class WinningLottery {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int d = in.nextInt();
    in.close();
    int[] arr = new int[d];
    arr[0] = 1; s--;
    int i = d - 1;
    while(s > 0 && i > 0) {
      if(s <= 9) {
        arr[i] = s;
        break;
      } else {
        arr[i] = 9;
        s -= 9;
      }
      i--;
    }

    for(int a : arr) {
      System.out.print(a);
    }
  }
}