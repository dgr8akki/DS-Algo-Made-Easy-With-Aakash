package Algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

  private int[] arr;
  public QuickSelect(int[] arr) {
    this.arr = arr;
  }

  public void printKthSmallestNumber(int k) {
    System.out.println(k + "th smallest number in array " + Arrays.toString(arr) + " is: " + select(k - 1, 0, arr.length - 1));
  }

  private int partition(int start, int end) {
    // System.out.println(start + ", " + end);
    int pivot = new Random().nextInt(end - start + 1) + start;
    swap(pivot, end);

    for(int i = start; i < end; i++) {
      if(arr[i] < arr[end]) {
        swap(start, i);
        start++;
      }
    }
    swap(start, end);
    return start;
  }

  private void swap(int start, int end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }

  private int select(int k, int start, int end) {
    int pivot = partition(start, end);
    if(pivot > k)
      return select(k, start, pivot - 1);
    else if(pivot < k)
      return select(k, pivot + 1, end);

    return arr[k];
  }
  public static void main(String[] args) {
    int[] arr = {3, 5, 7, 1, 10, 0, 1};
    // Sorted = 0,1,3,5,7,10,11
    QuickSelect quickSelect = new QuickSelect(arr);
    quickSelect.printKthSmallestNumber(1);
    quickSelect.printKthSmallestNumber(2);
    quickSelect.printKthSmallestNumber(3);
    quickSelect.printKthSmallestNumber(4);
    quickSelect.printKthSmallestNumber(5);
  }
}
