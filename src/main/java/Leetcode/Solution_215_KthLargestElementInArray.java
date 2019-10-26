package Leetcode;

class Solution {
  public int findKthLargest(int[] arr, int k) {
    return select(arr.length - k, 0, arr.length - 1, arr);
  }

  private int partition(int start, int end, int[] arr) {
    int pivot = new Random().nextInt(end - start + 1) + start;
    swap(pivot, end, arr);

    for (int i = start; i < end; i++) {
      if (arr[i] < arr[end]) {
        swap(start, i, arr);
        start++;
      }
    }
    swap(start, end, arr);
    return start;
  }

  private void swap(int start, int end, int[] arr) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }

  private int select(int k, int start, int end, int[] arr) {
    int pivot = partition(start, end, arr);
    if (pivot > k)
      return select(k, start, pivot - 1, arr);
    else if (pivot < k)
      return select(k, pivot + 1, end, arr);

    return arr[k];
  }
}
