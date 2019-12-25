package com.trijs.ch7;

import java.util.Arrays;

public class SelectionSort {
  int[] sort(int[] arr) {
    for(int i = 0; i< arr.length; i++) {
      int minIndex = getIndexWithMinimumElement(arr, i);
      if (i != minIndex)
        swap(arr, i, minIndex);
    }
    return arr;
  }

  private int getIndexWithMinimumElement(int[] arr, int startingIndex) {
    int minIndex = startingIndex;
    for (int i = minIndex; i< arr.length; i++)
      if(arr[minIndex] > arr[i])
        minIndex = i;
    return minIndex;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    int[] arr = {5,4,1,9,8,6,7};
    System.out.println("Array Before Sort: " + Arrays.toString(arr));
    System.out.println("Array After Sort: " + Arrays.toString(selectionSort.sort(Arrays.copyOf(arr, arr.length))));
  }
}
