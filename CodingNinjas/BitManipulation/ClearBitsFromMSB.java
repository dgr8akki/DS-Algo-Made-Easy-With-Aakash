import java.util.Scanner;

public class ClearBitsFromMSB {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int i = in.nextInt();
    System.out.println(clearAllBitsFromMSB(n, i));
    in.close();
  }

  private static int clearAllBitsFromMSB(int num, int i) {
    int mask = (1 << i) - 1;
    return num & mask;
  }
}
