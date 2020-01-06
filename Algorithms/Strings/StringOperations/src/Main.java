package Algorithms.Strings.StringOperations.src;

public class Main {
  public static void main(String[] args) {
    StringOperations operations = new StringOperations();
    String actualString = "Hello World!!!Hello World!!H";
    String actualString2 = "Hello!";
    System.out.println(operations.reverse(actualString));

    for (String suffix: operations.getAllSuffix(actualString))
      System.out.println(suffix);

    for (String prefix: operations.getAllPrefix(actualString))
      System.out.println(prefix);

    System.out.println(operations.longestCommonPrefix(actualString, actualString2));

    System.out.println(operations.longestRepeatedSubstring(actualString));
  }
}
