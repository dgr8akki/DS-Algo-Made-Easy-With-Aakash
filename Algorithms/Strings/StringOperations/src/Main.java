public class Main {
  public static void main(String[] args) {
    StringOperations operations = new StringOperations();
    String actualString = "Hello World!!!";
    System.out.println(operations.reverse(actualString));

    for (String suffix: operations.getAllSuffix(actualString))
      System.out.println(suffix);

    for (String prefix: operations.getAllPrefix(actualString))
      System.out.println(prefix);
  }
}
