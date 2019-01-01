public class Main {
  public static void main(String[] args) {
    String text = "The quick brown fox, jumps over the little lazy dog.";
    String pattern = "over";
    BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
    System.out.println(boyerMoore.search());
  }
}
