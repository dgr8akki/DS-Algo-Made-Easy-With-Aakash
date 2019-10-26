package Algorithms.Strings.SubstringMatching.src;

public class Main {
  public static void main(String[] args) {
    String actual = "The Quick Brown Fox Jumps over the little lazy dog.";
    String pattern= "over";
    BruteForce bruteForce = new BruteForce();
    System.out.println(bruteForce.contains(actual, pattern));
  }
}
