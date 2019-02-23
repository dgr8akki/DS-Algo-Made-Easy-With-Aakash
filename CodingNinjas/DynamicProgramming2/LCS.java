/**
 * LCS
 */
public class LCS {
  public static int lcs(String s1, String s2) {
    return lcsRecursive(s1, s2);
	}

  private static int lcsRecursive(String s1, String s2) {
    if(s1.length() == 0 || s2.length() == 0) return 0;
    if(s1.charAt(0) == s2.charAt(0))
      return 1 + lcsRecursive(s1.substring(1), s2.substring(1));
    return Math.max(lcsRecursive(s1.substring(1), s2), lcsRecursive(s1, s2.substring(1)));
  }

  public static void main(String[] args) {
    String s1 = "My Name is Aakash.";
    String s2 = "Tasmekh";
    System.out.println(lcs(s1, s2));
  }
}
