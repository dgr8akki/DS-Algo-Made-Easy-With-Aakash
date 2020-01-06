package CodingNinjas.Prerequisites;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    int[] solution = solve(arr);
    for (int el : solution)
      System.out.print(el + " ");
  }

  private static int[] solve(int[] arr) {
    int[] res = new int[2];
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0 && arr[i] % 2 == 0)
        res[0] += arr[i];
      else if (i % 2 == 1 && arr[i] % 2 == 1)
        res[1] += arr[i];
    }
    return res;
  }
}
