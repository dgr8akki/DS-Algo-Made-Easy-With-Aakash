import java.util.Scanner;

/**
 * CircularListOfStudents
 */
public class CircularListOfStudents {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
		int t = in.nextInt();
      	while(t-- > 0) {
          int i = in.nextInt();
          int p = in.nextInt();
          System.out.println((p + i) % 12);
        }
  }
}
