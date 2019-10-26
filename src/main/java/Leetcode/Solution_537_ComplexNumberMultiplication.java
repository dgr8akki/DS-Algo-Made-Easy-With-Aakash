package Leetcode;

import java.util.Arrays;

/**
 * #537 ComplexNumberMultiplication
 */
class ComplexNumberMultiplication {
  public static String complexNumberMultiply(String a1, String b1) {
    String[] A = a1.split("\\+", 2);
    String[] B = b1.split("\\+", 2);
    int a = Integer.parseInt(A[0]);
    int b = Integer.parseInt(A[1].substring(0, A[1].length() - 1));
    int c = Integer.parseInt(B[0]);
    int d = Integer.parseInt(B[1].substring(0, B[1].length() - 1));

    int realValue = (a * c) - (b * d);
    int complexValue = (a * d) + (b * c);
    return realValue + "+" + complexValue + "i";
  }

  public static void main(String[] args) {
    String a = "1+-1i";
    String b = "1+1i";
    System.out.println(complexNumberMultiply(a, b));
  }
}
