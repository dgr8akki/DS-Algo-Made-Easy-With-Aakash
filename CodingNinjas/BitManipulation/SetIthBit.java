import java.util.Scanner;

public class SetIthBit {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int i = in.nextInt();
    System.out.println(n | (1 << i));
    in.close();
  }
}
