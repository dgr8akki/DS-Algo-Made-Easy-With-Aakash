import java.util.Scanner;

public class InterestingSequence {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int l = in.nextInt();
    int[] arr = new int[n];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      if (min > arr[i])
        min = arr[i];
      if (max < arr[i])
        max = arr[i];
    }
    in.close();
    for (int i = min; i <= max; i++) {
      int cost = 0;
      int inc = 0, dec = 0;
      for (int el : arr) {
        if (el > i)
          dec += (el - i);
        else
          inc += (i - el);
      }
      if (inc >= dec) {
        cost += (dec * k);
        cost += (inc - dec) * l;
        if (cost < minCost)
          minCost = cost;
      }
    }

    System.out.println(minCost);
  }
}
