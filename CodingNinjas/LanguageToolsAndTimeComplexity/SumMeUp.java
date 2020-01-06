package CodingNinjas.LanguageToolsAndTimeComplexity;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      long number = in.nextLong();
      System.out.println(digitSum(number));
    }
    in.close();
  }

  private static int digitSum(long number) {
    int sum = 0;
    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }
}
