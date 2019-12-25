package CodingNinjas.Prerequisites;

import java.util.Scanner;

public class ChakriPrice {
	public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = 1;
      // int[] seq = {62};
      int[] seq = {62,63,70,66,64,68,61};
      // int[] seq = {62,63,70,66,64,68,61};
      // int[] seq = {62,63,70,66,64,68,61};
      // for(int i = 0; i < n; i++)
      //   seq[i] = in.nextInt();
      
      System.out.println(solve(seq));
	}
  
  private static int solve(int[] arr) {
    int min = arr[0], max = arr[0], profit = 0;
    for(int currentPrice : arr) {
      if(min > currentPrice) {
        min = currentPrice;
        max = currentPrice;
      } else if(max < currentPrice) {
        max = currentPrice;
        int localDiff = max - min;
        if(localDiff > profit)
          profit = localDiff;
      }
    }
    return profit;
  }
}