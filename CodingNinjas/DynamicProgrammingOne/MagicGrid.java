package CodingNinjas.DynamicProgrammingOne;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MagicGrid
 */
public class MagicGrid {

  public static long getMinHealth(short[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
    // long[][] store = new long[m][n];
    // for(int i = 0; i < m; i++)
    //   for(int j = 0; j < n; j++)
    //     store[i][j] = Long.MAX_VALUE;
    // return getMinCostRecursive(arr, 0, 0, m - 1, n - 1);
    // getMinCostMemoized(arr, 0, 0, m - 1, n - 1,store);
    // for(int i = 0; i < m; i++)
    //   System.out.println(Arrays.toString(store[i]));
    return getMinCostIterative(arr, m, n);
  }


  public static long getMinCostRecursive(short[][] arr, int startingX, int startingY, int endingX, int endingY) {
    if(startingX == endingX && startingY == endingY)
      return 1;
    if(startingX > endingX || startingY > endingY)
      return Long.MAX_VALUE;
    long firstOption = Long.MAX_VALUE, secondOption = Long.MAX_VALUE;
    if(startingX + 1 <= endingX && startingY <= endingY) {
      firstOption = getMinCostRecursive(arr, startingX + 1, startingY, endingX, endingY) - arr[startingX + 1][startingY];
      if(firstOption < 0) firstOption = 1;
      System.out.println("FirstOpt: " + firstOption);
    }
    if(startingX <= endingX && startingY + 1 <= endingY){
      secondOption = getMinCostRecursive(arr, startingX, startingY + 1, endingX, endingY) - arr[startingX][startingY + 1];
      if(secondOption < 0) secondOption = 1;
    }
    long power = Math.min(
        firstOption,
        secondOption
      );
    return power == 0 ? 1 : power;
  }

  public static long getMinCostMemoized(short[][] arr, int startingX, int startingY, int endingX, int endingY, long[][] store) {
    if(startingX == endingX && startingY == endingY) {
      store[startingX][startingY] = 1;
      return store[startingX][startingY];
    }
    if(startingX > endingX || startingY > endingY)
      return Long.MAX_VALUE;
    if(store[startingX][startingY] != Long.MAX_VALUE)
      return store[startingX][startingY];
    long firstOption = Long.MAX_VALUE, secondOption = Long.MAX_VALUE;
    if(startingX + 1 <= endingX && startingY <= endingY) {
      firstOption = getMinCostMemoized(arr, startingX + 1, startingY, endingX, endingY, store) - arr[startingX + 1][startingY];
      if(firstOption < 0) firstOption = 1;
    }
    if(startingX <= endingX && startingY + 1 <= endingY){
      secondOption = getMinCostMemoized(arr, startingX, startingY + 1, endingX, endingY, store) - arr[startingX][startingY + 1];
      if(secondOption < 0) secondOption = 1;
    }
    long power = Math.min(
        firstOption,
        secondOption
      );
    store[startingX][startingY] = power == 0 ? 1 : power;
    return store[startingX][startingY];
  }

  public static long getMinCostIterative(short[][] arr, int m, int n) {
    long[][] dp = new long[m][n];
    dp[m - 1][n - 1] = 1;
    dp[m - 2][n - 1] = 1;
    dp[m - 1][n - 2] = 1;
    for(int i = m - 3; i >= 0; i--) {
      dp[i][n - 1] = dp[i + 1][n - 1] - arr[i + 1][n - 1];
    }

    for(int j = n - 3; j >= 0; j--) {
      dp[m - 1][j] = dp[m - 1][j + 1] - arr[m - 1][j + 1];
    }

    for(int i = m - 2; i >= 0; i--) {
      for(int j = n - 2; j >= 0; j--) {
        dp[i][j] = Math.min(dp[i + 1][j] - arr[i + 1][j], dp[i][j + 1] - arr[i][j + 1]);
        dp[i][j] = dp[i][j] < 0 ? 1 : dp[i][j];
      }
    }
    System.out.println();
    for(int i = 0; i < m; i++)
      System.out.println(Arrays.toString(dp[i]));

    return dp[0][0];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    byte t = in.nextByte();
    while(t-- > 0) {
      short r = in.nextShort();
      short c = in.nextShort();
      short[][] magrid = new short[r][c];
      for(short i = 0; i < r; i++)
        for(short j = 0; j < c; j++)
          magrid[i][j] = in.nextShort();
      System.out.println(getMinHealth(magrid));
    }
    in.close();
  }
}
