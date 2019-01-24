import java.util.Arrays;

/**
 * BinarySearch
 */
public class BinarySearch {

  public static int searchIterative(int[] arr, int key) {
    if(arr.length == 0) return -1;
    int start = 0, end = arr.length - 1;
    while(start <= end) {
      int mid = start + (end - start)/2;
      if(arr[mid] == key) return mid;
      if(key < arr[mid]) end = mid - 1;
      else start = mid + 1;
    }
    return -1;
  }

  public static int searchRecursive(int[] arr, int key) {
    if(arr.length == 0)
      return-1;

    return searchRecursiveUtil(arr, key, 0, arr.length - 1);
  }

  private static int searchRecursiveUtil(int[] arr, int key, int start, int end) {
    if(start > end) return -1;
    int mid = start + (end - start)/2;
    if(arr[mid] == key) return mid;
    if(key < arr[mid])
      return searchRecursiveUtil(arr, key, start, mid - 1);
    else return searchRecursiveUtil(arr, key, mid + 1, end);
  }
  public static void main(String[] args) {
    int[] arr = {2,3,4,7,8,9,10,12,13,42};
    int[] keys = {1,2,3,4,7,8,9,10,11,12,13,42,43};
    for(int key: keys) {
      System.out.println("Searching for key: " + key + " in array: " + Arrays.toString(arr));
      System.out.println("Iterative Search result: " + searchIterative(arr, key));
      System.out.println("Recursive Search result: " + searchRecursive(arr, key));
      System.out.println();
      System.out.println();
    }
  }
}
