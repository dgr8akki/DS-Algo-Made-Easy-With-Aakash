import java.util.Scanner;

/**
 * AlphaCode
 */
public class AlphaCode {
  final static int M = 1_000_000_000 + 7;
  public static int alphaCodeRecursive(String s) {
    long count = 0;
    if(s.length() == 0 || s.length() == 1)
      return 1;
    count = alphaCodeRecursive(s.substring(1));

    if((Character.getNumericValue(s.charAt(0)) * 10) + Character.getNumericValue(s.charAt(1)) <= 26)
      count += alphaCodeRecursive(s.substring(2));

    return (int) (count % M);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while(true) {
      String s = in.next();
      if(s.length() == 1 && s.charAt(0) == '0') break;
      System.out.println(alphaCodeRecursive(s));
    }
    in.close();
  }
}
