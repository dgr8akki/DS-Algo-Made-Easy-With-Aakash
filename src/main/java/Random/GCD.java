package Random;

public class GCD {

  public int calculateRecursive(int first, int second) {
    if(first == 0) return second;
    if(second == 0) return first;
    return calculateRecursive(second, first % second);
  }

  public int calculateIterative(int first, int second) {
    while(second != 0) {
      int temp = second;
      second = first % second;
      first = temp;
    }
    return first;
  }
  public static void main(String[] args) {
    GCD gcd = new GCD();
    System.out.println(gcd.calculateRecursive(40, 100));
    System.out.println(gcd.calculateIterative(100, 40));
  }
}