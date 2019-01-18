import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    int aCount = 0, sCount = 0, pCount = 0;
    for (int i = 0; i < n; i++) {
      switch (s.charAt(i)) {
      case 'a':
        aCount++;
        break;
      case 's':
        sCount++;
        break;
      case 'p':
        pCount++;
        break;
      }
    }
    System.out.println(aCount + " " + sCount + " " + pCount);
    in.close();
  }
}
