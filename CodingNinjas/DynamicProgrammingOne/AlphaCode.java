package CodingNinjas.DynamicProgrammingOne;

import java.util.Arrays;
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

  public static int alphaCodeRecursiveMemoized(String s, int[] cache) {
    long count = 0;
    if(s.length() != 0 && s.charAt(0) == '0') return 0;
    // if(s.length() == 0 || s.length() == 1) return 1;
    cache[0] = 1;
    cache[1] = 1;
    if(cache[s.length()] > 0) return cache[s.length()];
    count = alphaCodeRecursiveMemoized(s.substring(1), cache);
    if((Character.getNumericValue(s.charAt(0)) * 10) + Character.getNumericValue(s.charAt(1)) <= 26)
      count += alphaCodeRecursiveMemoized(s.substring(2), cache);
    cache[s.length()] = (int) (count % M);
    return cache[s.length()];
  }

  public static int alphaCodeIterative (String s) {
    int length = s.length();
    int[] counts = new int[length + 1];
    counts[0] = 1;
    counts[1] = 1;
    for(int i = 2; i <= length; i++) {
      counts[i] = counts[i - 1];
      if(s.charAt(i - 1) == '0') {
        counts[i] = 0;
      }
      int alphabetIndex = Character.getNumericValue(s.charAt(i - 2)) * 10 + Character.getNumericValue(s.charAt(i - 1));
      if(alphabetIndex >= 10 && alphabetIndex <= 26)
        counts[i] = (counts[i] % M + counts[i - 2] % M) % M;
    }
    return counts[length] % M;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while(true) {
      String s = in.next();
      if(s.length() == 1 && s.charAt(0) == '0') break;
      int[] arr = new int[s.length() + 1];
      System.out.println(alphaCodeRecursiveMemoized(s, arr));
      System.out.println(Arrays.toString(arr));
      System.out.println(alphaCodeIterative(s));
    }
    in.close();
  }
}
