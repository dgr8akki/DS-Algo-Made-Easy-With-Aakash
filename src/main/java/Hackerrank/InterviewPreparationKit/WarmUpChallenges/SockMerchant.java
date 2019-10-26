package Hackerrank.InterviewPreparationKit.WarmUpChallenges;

import java.util.Scanner;

public class SockMerchant {

  private static int sockMerchant(int n, int[] ar) {
    int result = 0;
    int[] temp = new int[101];
    for (int i : ar) {
      if (temp[i] == 0) {
        temp[i] = 1;
      } else {
        temp[i]--;
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    in.close();
    int result = sockMerchant(n, ar);
    System.out.println(result);
  }
}
