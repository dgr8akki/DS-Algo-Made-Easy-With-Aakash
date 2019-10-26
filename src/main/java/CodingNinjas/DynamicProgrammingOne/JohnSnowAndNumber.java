package CodingNinjas.DynamicProgrammingOne;

import java.util.Scanner;

public class JohnSnowAndNumber {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int x = in.nextInt();
    int[] arr = new int[1024];
    for (int i = 0; i < n; i++)
      arr[in.nextInt()]++;
    in.close();
    for (int index = 0; index < k; index++) {
      int[] temp = new int[1024];
      int count = 0;

      for (int i = 0; i < 1024; i++) {
        if (arr[i] == 0)
          continue;
        if ((arr[i] & 1) == 0) {
          temp[i] += arr[i] / 2;
          temp[x ^ i] += arr[i] / 2;
        } else {
          if ((count & 1) == 0) {
            temp[x ^ i] += ((arr[i] / 2) + 1);
            temp[i] += arr[i] / 2;
          } else {
            temp[i] += ((arr[i] / 2) + 1);
            temp[x ^ i] += arr[i] / 2;
          }
          count += arr[i];
        }
      }
      for (int j = 0; j < 1024; j++)
        arr[j] = temp[j];
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < 1024; i++) {
      if (arr[i] != 0) {
        min = i;
        break;
      }
    }
    for (int i = 1023; i >= 0; i--) {
      if (arr[i] != 0) {
        max = i;
        break;
      }
    }
    System.out.println(max + " " + min);
  }
}
