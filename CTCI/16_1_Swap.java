package CTCI;

import java.util.Arrays;

class Swap {
  public static void swap(int [] arr, int first, int second) {
    arr[first] += arr[second];
    arr[second] = arr[first] - arr[second];
    arr[first] -= arr[second];
  }
  public static void main(String[] args) {
    int[] a = {1,3};
    System.out.println("Before swap : a = " + Arrays.toString(a));
    swap(a, 0, 1);
    System.out.println("After swap : a = " + Arrays.toString(a));
  }
}
