import java.util.Arrays;

public class Kadene {

  // Maximum sum of sub-array in an array.

  public static int maxSumSubArray (int[] arr) {
    int maxSumGlobal = 0, localSum = 0;
    for(int element: arr) {
      localSum += element;
      maxSumGlobal = Math.max(maxSumGlobal, localSum);
      if(localSum < 0) localSum = 0;
    }
    return maxSumGlobal;
  }

  public static void main(String[] args) {
    int[] arr = {1,-2,3,4,5,0,-4,-3,10,12,9,-5,-4,9};
    System.out.println("Maximum sum subarray in array: " + Arrays.toString(arr) + " is: " + maxSumSubArray(arr));
  }
}
