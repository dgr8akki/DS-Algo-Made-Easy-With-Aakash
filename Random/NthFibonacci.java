public class NthFibonacci {

  public static double find(int n) {
    final double oneByRootfive = 1 / (Math.sqrt(5));
    final double onePlusRootfiveByTwo = (1 + (Math.sqrt(5))) / 2;
    return Math.floor(Math.pow(onePlusRootfiveByTwo, n) * oneByRootfive);
  }
  public static void main(String[] args) {
    // System.out.print(find(2) + " ");
    for(int i = 0; i < 10; i++)
      System.out.print(find(i) + " ");
  }
}
