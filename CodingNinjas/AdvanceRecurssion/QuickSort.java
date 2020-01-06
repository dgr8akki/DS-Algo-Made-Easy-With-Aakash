package CodingNinjas.AdvanceRecurssion;

public class QuickSort {

  public static void quickSort(int[] input) {
    quickSort(input, 0, input.length - 1);
  }

  private static void quickSort(int[] input, int start, int end) {
    if (start < end) {
      int pivot = partition(input, start, end);
      quickSort(input, start, pivot - 1);
      quickSort(input, pivot + 1, end);
    }
  }

  private static int partition(int[] input, int start, int end) {
    int count = 0;
    for (int i = start; i < end; i++)
      if (input[i] < input[end])
        count++;
    int pivotIndex = start + count;
    if (pivotIndex != end)
      swap(input, pivotIndex, end);
    while (start != pivotIndex || end != pivotIndex) {
      if (input[start] < input[pivotIndex])
        start++;
      else if (input[end] >= input[pivotIndex])
        end--;
      else
        swap(input, start, end);
    }
    return pivotIndex;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
