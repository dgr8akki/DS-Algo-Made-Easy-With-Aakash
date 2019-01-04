public class QuickSort extends Sorter {
  QuickSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    sort(this.getArr(), 0, this.getArr().length - 1);
    printResult();
  }

  private void sort(int[] arr, int low, int high) {
    if(low >= high) return;
    int pivot = partition(arr, low, high);
    sort(arr, low, pivot - 1);
    sort(arr, pivot + 1, high);
  }

  private int partition(int[] arr, int low, int high) {
    swap(arr, (low + high) / 2, high);
    int i = low;
    for (int j = low; j < high; j++) {
      if(arr[j] <= arr[high]) {
        swap(arr, j, i);
        i++;
      }
    }
    swap(arr, i, high);
    return i;
  }
}
