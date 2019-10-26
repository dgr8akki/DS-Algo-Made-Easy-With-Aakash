package DsAlgoMadeEasyInJava.Reccursion;

public class TowerOfHanoi {
  public static void solve(int rings) {
    solve(rings, "Source", "Aux", "Dest");
  }

  private static void solve(int rings, String start, String aux, String end) {
    if (rings == 1) {
      System.out.println("Move ring 1 from " + start + " to " + end);
      return;
    }
    solve(rings - 1, start, end, aux);
    System.out.println("Move ring " + rings + " from " + start + " to " + end);
    solve(rings - 1, aux, start, end);
  }

  public static void main(String[] args) {
    solve(3);
  }
}
