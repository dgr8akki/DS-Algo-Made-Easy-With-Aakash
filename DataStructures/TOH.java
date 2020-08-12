/**
 * TOH
 */
public class TOH {

  private static void printTOH(int n, String from, String aux, String to) {
    if (n == 0)
      return;
    printTOH(n - 1, from, to, aux);
    System.out.println("Move Disc no. " + n + " from " + from + " to " + to + " with the help of " + aux);
    printTOH(n - 1, aux, from, to);
  }

  public static void printTOH(int discs) {
    System.out.println("----------------------------------------------");
    printTOH(discs, "FROM", "AUX", "TO");
  }

  public static void main(String[] args) {
    printTOH(3);
    printTOH(4);
  }
}
