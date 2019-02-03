import java.util.Scanner;

public class LightUpBulbs {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long x = in.nextLong();
    long y = in.nextLong();
    String bulbs = in.next();
    in.close();
    long cost = 0;
    int groups = 0;
    if (bulbs.charAt(0) == '0')
      groups++;
    for (int i = 0; i < n - 1; i++) {
      if (bulbs.charAt(i) == '1' && bulbs.charAt(i + 1) == '0')
        groups++;
    }
    if (groups == 0) {
      System.out.println("0");
      return;
    }
    cost = ((groups - 1) * Math.min(x, y)) + y;
    System.out.println(cost);
  }
}
