import java.util.*;

public class MarbleSum {
	public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int sum = in.nextInt();
      int[] seq = new int[n];
      for(int i = 0; i < n; i++)
        seq[i] = in.nextInt();
      
      solve(seq, n, sum);
	}
  
  	private static void	 solve(int[] seq, int n, int sum) {
      List<Integer> nos = new ArrayList<>();
      for(int i = 0; i < n; i++) {
        int sumLeft = sum, j = i;
        while(sumLeft > 0 && j < n) {
          sumLeft -= seq[j];
          nos.add(seq[j]);
          j++;
        }
        System.out.println("sumLeft: " + sumLeft);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        if(sumLeft == 0) {
          System.out.println("true");
          for(int el : nos)
            System.out.print(el + " ");
          return;
        }
        nos.clear();
      }
      
      System.out.println("false");
    }
}