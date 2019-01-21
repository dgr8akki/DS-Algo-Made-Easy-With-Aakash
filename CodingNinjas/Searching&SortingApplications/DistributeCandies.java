import java.util.Scanner;
public class DistributeCandies {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCaseCount = in.nextInt();
    while(testCaseCount-- > 0) {
      int totalNumberOfBoxes = in.nextInt();
      int children = in.nextInt();
      int[] boxes = new int[totalNumberOfBoxes];

      for(int i = 0; i < totalNumberOfBoxes; i++)
        boxes[i] = in.nextInt();

      System.out.println(solve(boxes, totalNumberOfBoxes, children));
    }
    in.close();
  }

  private static long solve(int[] boxes, int totalNumberOfBoxes, int children) {
    return solve(boxes, totalNumberOfBoxes, children, 0, getMax(boxes));
  }

  private static int getMax(int[] arr) {
    int max = arr[0];
    for(int el : arr)
      max = Math.max(el, max);
    return max;
  }

  private static long solve(int[] arr, int n, int children, long min, long max) {
    long maxCandies = 0;
    while (min <= max) {
      long mid = min + (max - min) / 2;
      if (isSolvable(arr, n, mid, children)) {
        maxCandies = mid;
        min = mid + 1;
      } else
        max = mid - 1;
    }
    return maxCandies;
  }

  private static boolean isSolvable(int[] arr, int n, long candies, int children) {
    if(candies == 0) return true;
    long count = 0;
    for (int i = 0; i < n; i++) {
      count += (arr[i] / candies);
      if (count >= children)
        return true;
    }
    return false;
  }
}
